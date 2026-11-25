# 13. Find a contended monitor

You’ll use a lock profile to find where a thread had to wait to acquire a lock.

The two producers take turns updating a shared count. Suppose `PRODUCER-1` enters `synchronized` and sleeps for 5 ms while holding the lock. If `PRODUCER-2` tries to enter during that sleep, it has to wait. The lock profile records that wait on `PRODUCER-2`’s stack. On a later turn the roles can reverse, so both producers can appear in the flame graph.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** Two producers submit results to a shared collector. The `lock` event samples monitor contention. This command groups stacks by thread and weights them by wait time.

```bash
../../scripts/lab profile lock,lock=1ms,threads,total
```

2. **Look.** Confirm the program collected 600 results. In the graph, find `record` under `PRODUCER-1` or `PRODUCER-2` and hover over it. Record the wait-time units and value.
3. **Try.** Zoom into that producer’s stack and open `Collector.record`. Find `synchronized`, where it tries to acquire the lock, and `Thread.sleep(5)`, where a producer sleeps while holding it.
4. **Check.** Pick a producer in the flame graph. Which block was it trying to enter, and what was the other producer doing while it waited?
