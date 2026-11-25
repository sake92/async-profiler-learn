# 1. Take your first profile

You’ll capture a CPU profile, find a method in the flame graph, and see how the sample count changes with a longer run.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** The example repeats a sum for five seconds. The launcher samples CPU time and prints the name of the HTML report. Wait for the program to exit.

```bash
../../scripts/lab profile
```

2. **Look.** Open the HTML report in this folder. Search for `sumUpTo` using the graph’s search button. Click a matching frame, then hover over it. Write down the sample count.
3. **Try.** Give the same example more time to run.

```bash
../../scripts/lab profile -- 10
```

4. **Check.** Find the same method in the new graph. Is its sample count higher? Compare the counts before looking at percentages.
