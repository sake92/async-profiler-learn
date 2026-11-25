# 14. Reduce monitor wait time

You’ll move slow work outside a synchronized block and use a before-and-after lock profile to check the effect on contention.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** Record the baseline and note its elapsed time and root-frame wait weight. Find the line that moves the sleep in the supplied `outside` variant.

```bash
../../scripts/lab profile lock,lock=1ms,threads,total
```
2. **Try.** Run that variant with the same lock sampling settings.

```bash
../../scripts/lab profile lock,lock=1ms,threads,total -- outside
```

3. **Look.** Check for `Collected 600 results` again. Compare elapsed time and remaining wait weight for `PRODUCER-1` and `PRODUCER-2`. If the new report has no matching application frames, record that the profiler found none at these settings.
4. **Check.** Run the original case again to see if the wait returns.

```bash
../../scripts/lab profile lock,lock=1ms,threads,total
```
