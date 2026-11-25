# 3. Read frame widths

You’ll use frame widths to compare sampled CPU time and see how the widths change when you shift work between two methods.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** The example alternates between summing numbers for about 2 ms and counting multiples of three for about 6 ms.

```bash
../../scripts/lab profile -- 8 2 6
```

2. **Look.** Find `sumUpTo` and `countMultiplesOfThree`. Hover over both and write down their sample counts. Which accounts for more sampled CPU time?
3. **Try.** Give summing 6 ms and counting 2 ms. Predict which frame will be wider and capture a second profile.

```bash
../../scripts/lab profile -- 8 6 2
```

4. **Check.** Compare the two methods within each graph. Is the wider frame the one given more time in that run?
