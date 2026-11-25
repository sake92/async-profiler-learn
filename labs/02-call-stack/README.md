# 2. Read a call stack

You’ll read which method called which in a flame graph and see how samples for the same method split across two call paths.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** Two methods call `sumUpTo`.  
`sumFixedRange` uses the same upper limit for 2 seconds.  
`sumGrowingRanges` increases its upper limit in steps for 3 seconds.

```bash
../../scripts/lab profile
```

2. **Look.** Search for `sumUpTo`. Find it under both `sumFixedRange` and `sumGrowingRanges`.  
Read down one frame from each match and compare the two paths with the calls in `example.sc`.
3. **Try.** Give the fixed range four seconds and the growing ranges one second. Predict which `sumUpTo` frame will have more samples.

```bash
../../scripts/lab profile -- 4 1
```

4. **Check.** Hover over the two `sumUpTo` frames and compare their sample counts. Did the wider frame move to the other caller?
