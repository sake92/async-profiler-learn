# 7. Attach to a running JVM

You’ll find a running JVM by PID, attach async-profiler, and capture work you trigger after profiling starts.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** Leave the interactive prime counter running in your first terminal. Note its PID and check it with input `100`.

```bash
../../scripts/lab run
```

2. **Look.** Open a second terminal in this lab’s folder with `asprof` on `PATH`. Run `jps -vlm` to list the JVMs and match the first column against the PID printed by the example. Run both terminals as the same user.

```bash
jps -vlm
```

Replace `12345` with the matching PID and start the profiler.

```bash
pid=12345
asprof start -e ctimer "$pid"
asprof status "$pid"
```

3. **Try.** Enter `300000` in the first terminal and wait for its result. Stop profiling from the second terminal.

```bash
report="profile-attached-$(date -u +%Y%m%dT%H%M%S).html"
asprof stop -f "$PWD/$report" "$pid"
printf 'Report: %s\n' "$report"
```

Enter `q` in the first terminal and check that the JVM exits.

4. **Check.** Find `hasNoDivisor` in the new graph.


