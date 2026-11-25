# Learn async-profiler with Scala

Work through 16 ready-to-run examples, from reading your first flame graph to diagnosing a slow batch processor. Each lab has its own Scala script and instructions. You’ll run the example, find something in the report, then tweak the workload and see what changes.

## Setup

Use Linux, a HotSpot JDK 21, Bash, Scala CLI, and async-profiler 4.6. Put `scala-cli` and `asprof` on your `PATH`. The examples use Scala 3.10.0.

```bash
java -version
scala-cli version
asprof --version
```

[Scala CLI installation](https://scala-cli.virtuslab.org/install/) · [async-profiler 4.6 release](https://github.com/async-profiler/async-profiler/releases/tag/v4.6)

Start in [Lab 1](labs/01-first-profile/README.md).

```bash
cd labs/01-first-profile
../../scripts/lab profile
```

The launcher prints the automatically generated report filename. The report appears next to `example.sc` when the JVM exits. Each capture gets a new timestamped name, so you can compare runs. To run an example by itself, use `scala-cli run example.sc` from its lab directory.

## Labs

| | Lab |
| --- | --- |
| 1 | [Take your first profile](labs/01-first-profile/README.md) |
| 2 | [Read a call stack](labs/02-call-stack/README.md) |
| 3 | [Read frame widths](labs/03-frame-widths/README.md) |
| 4 | [Compare CPU and elapsed time](labs/04-cpu-and-wall/README.md) |
| 5 | [Find the hot method](labs/05-prime-hotspot/README.md) |
| 6 | [Make one change and check the result](labs/06-prime-optimization/README.md) |
| 7 | [Attach to a running JVM](labs/07-live-attach/README.md) |
| 8 | [Find an allocation hotspot](labs/08-allocation-hotspot/README.md) |
| 9 | [Compare two implementations](labs/09-string-builder/README.md) |
| 10 | [Find where a reader waits](labs/10-reader-waiting/README.md) |
| 11 | [Read a batch at a time](labs/11-batch-reads/README.md) |
| 12 | [Compare two worker threads](labs/12-worker-threads/README.md) |
| 13 | [Find a contended monitor](labs/13-monitor-contention/README.md) |
| 14 | [Reduce monitor wait time](labs/14-reduce-contention/README.md) |
| 15 | [Capture two event types in one recording](labs/15-multi-event-jfr/README.md) |
| 16 | [Diagnose a slow batch processor](labs/16-batch-processor/README.md) |
