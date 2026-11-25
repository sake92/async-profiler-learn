# 5. Find the hot method

You’ll follow a CPU stack to the method doing most of the work and see how its cost changes as the input grows.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** Check a small input, then record a profile of the larger input.

```bash
../../scripts/lab run -- 100
../../scripts/lab profile -- 150000
```

2. **Look.** Confirm the small run prints `Primes below 100: 25`. Write down the large run’s prime count and elapsed time. In its graph, find `countPrimes` and follow its stack to the method that checks divisors.
3. **Try.** Double the upper limit and capture a new report.

```bash
../../scripts/lab profile -- 300000
```

4. **Check.** Is the same method still the hotspot? Record its sample count and compare the elapsed times. Did doubling the upper limit roughly double the time, or did the time change by a different factor?
