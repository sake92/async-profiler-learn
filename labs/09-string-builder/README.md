# 9. Compare two implementations

You’ll compare allocation profiles for string concatenation and `StringBuilder` while checking that both versions produce the same result.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** Use the **200-string concatenation report** from [Lab 8](../08-allocation-hotspot/README.md) as your baseline. If you need a fresh baseline, run the first command below. Run the second command to build the same 200 strings with a `StringBuilder`.

```bash
../../scripts/lab profile alloc,alloc=512k,total -- 200
../../scripts/lab profile alloc,alloc=512k,total -- 200 builder
```

2. **Look.** Compare the printed checksums. Hover over `all` **in your Lab 8 baseline** and in the 200-string builder report. Compare the estimated bytes allocated. Each graph scales to its own total, so the frame percentages describe shares within each run. Search for `formatWithBuilder` in the builder report.
3. **Try.** Double the work for the builder run. If sampling was sparse in the first builder report, look again at the longer run.

```bash
../../scripts/lab profile alloc,alloc=512k,total -- 400 builder
```

4. **Check.** Find an allocation that remains in the builder version. How does doubling the work change the builder’s estimated allocation total?
