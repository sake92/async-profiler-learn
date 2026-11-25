# 10. Find where a reader waits

You’ll use a wall-clock profile to follow a slow read to the exact call where the reader waits.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** The simulated input source waits 20 ms per read. Start with one item per read. Take both types of profiles.

```bash
../../scripts/lab profile -- 1
../../scripts/lab profile wall,threads -- 1
```

2. **Look.** Both runs should print `Read 120 items, total 7140`. Compare the main-thread stacks. Where do you see `readBatch` and the sleep it calls?
3. **Try.** Click the `readBatch` frame to zoom, then hover over the sleep frame above it. Check whether the CPU report shows the same call path prominently.
4. **Check.** Explain which graph accounts for the reader’s elapsed time. Point to the particular frame that supports your answer.
