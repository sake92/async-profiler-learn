# 6. Make one change and check the result

You’ll measure the effect of a faster divisor check with repeated runs and verify that both versions return the same prime count.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** Confirm the `sqrt` variant gives the same answer on the small input. Then run both variants on the same larger input.

```bash
../../scripts/lab run -- 100 sqrt
../../scripts/lab run -- 150000
../../scripts/lab run -- 150000 sqrt
```

2. **Look.** In `hasNoDivisor`, find the two values assigned to `lastDivisor`. Try candidate 49 by hand and identify the last divisor the shorter loop needs to check.
3. **Try.** Alternate the two larger commands three times. Record the elapsed time and prime count after each run. Capture the changed version as well.

```bash
../../scripts/lab profile -- 150000 sqrt
```

4. **Check.** Confirm the two counts match. Compare the reported timings and the amount of sampled work in the divisor check. The faster run may collect very few samples. Use the repeated timings to assess the change.
