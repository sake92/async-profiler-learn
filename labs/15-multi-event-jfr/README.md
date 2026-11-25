# 15. Capture two event types in one recording

Async-profiler collects CPU and allocation samples in the same run and writes them to a `.jfr` file. JFR is the recording format. You’ll use `jfrconv`, which ships with async-profiler, to turn that recording into two flame graphs. The CPU graph shows where the program spent CPU time, and the allocation graph shows where it allocated memory.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** The mixed workload counts primes and formats strings. Capture CPU and allocation events in one JFR file.

```bash
../../scripts/lab record ctimer,alloc=512k -- 150000 200
recording=$(ls -t -- profile-ctimer-*.jfr | sed -n '1p')
jfr summary "$recording"
```

2. **Look.** Find `jdk.ExecutionSample` and `jdk.ObjectAllocationInNewTLAB` in the summary. Check that both have events.
3. **Try.** Use `jfrconv`, which ships alongside `asprof`, to turn the same recording into two HTML views.

```bash
profiler_bin=$(dirname "$(realpath "$(command -v asprof)")")
"$profiler_bin/jfrconv" --cpu "$recording" "${recording%.jfr}-cpu.html"
"$profiler_bin/jfrconv" --alloc --total "$recording" "${recording%.jfr}-alloc.html"
```

4. **Check.** Find `hasNoDivisor` in the CPU view and `concatenate` in the allocation view. Pick one frame from each report and explain what its width measures.
