# 4. Compare CPU and elapsed time

You’ll compare CPU and wall-clock profiles of the same run and see where time spent sleeping appears.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** The example alternates 10 ms of arithmetic with 30 ms of sleep. Record the same workload twice.

```bash
../../scripts/lab profile -- 8 30
../../scripts/lab profile wall,threads -- 8 30
```

2. **Look.** Find `sumUpTo` in both reports. In the wall-clock report, find `Thread.sleep` in the example’s stack. Which of those two frames is wider?
3. **Try.** Predict what will happen to the main thread’s split between summing and sleeping when the sleep drops from 30 ms to 5 ms.

```bash
../../scripts/lab profile -- 8 5
../../scripts/lab profile wall,threads -- 8 5
```

4. **Check.** Compare the waiting frame across the two wall-clock reports. Look at the CPU reports too. Where do you see additional CPU samples when the program sleeps less and fits more work into the same eight seconds?
