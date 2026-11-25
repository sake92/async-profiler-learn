# 16. Diagnose a slow batch processor

You’ll choose a profiling event for a slow batch processor, use its stacks to pick a change, and verify the result against a baseline.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

The program reads 400 records, parses each one, and adds up values by group. A normal run should print `400 records, 4 groups, total 2200`. The reported symptom is that processing takes several seconds.

1. **Run.** Take a baseline and write down the output and elapsed time.

```bash
../../scripts/lab run
```

2. **Try.** Choose the profiling event that could answer your first question about the slowdown. Replace the event below with `ctimer`, `wall,threads`, or `alloc,alloc=512k,total`. If that profile raises a new question, capture another one with a different event.

```bash
../../scripts/lab profile wall,threads
```

3. **Look.** Name the stack that supports your diagnosis. Find the corresponding method in `example.sc` and identify one change worth testing.
4. **Check.** Change one input or one line of the example, save any edits, and profile again using the same event. Confirm the output still matches. Write down the before and after elapsed times and the change visible in the report.

<details>
<summary>Hint if you get stuck</summary>

Use wall-clock sampling and follow the main thread into the input source. Look at how many records it returns per call. The optional argument to `batch` controls that number.

</details>
