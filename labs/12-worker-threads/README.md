# 12. Compare two worker threads

You’ll group CPU samples by thread and use them to judge how evenly two workers share the work.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** Two threads count primes over separate ranges. The second argument is the percentage of candidates assigned to `LOW-RANGE`. Enter `50` for an even split. The program prints both ranges.

```bash
../../scripts/lab profile ctimer,threads -- 150000 50
```

2. **Look.** Find `LOW-RANGE` and `HIGH-RANGE`. Hover over their thread frames for CPU sample counts. Compare those counts with the number of primes printed for each range.
3. **Try.** Give `LOW-RANGE` 70% of the candidates. Predict how the CPU samples will be divided between the workers.

```bash
../../scripts/lab profile ctimer,threads -- 150000 70
```

4. **Check.** Confirm the total prime count matches the first run. Compare the thread counts and identify which split distributed CPU work more evenly on your run.
