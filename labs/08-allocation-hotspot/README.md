# 8. Find an allocation hotspot

You’ll use estimated allocation bytes to find a hotspot and compare runs. The estimate includes memory allocated for objects that become garbage during the recording.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** The formatter builds 200 strings by appending one number at a time with `+`. Record sampled allocations with a 512 KiB interval. The `total` option weights the graph by estimated allocated bytes.

```bash
../../scripts/lab profile alloc,alloc=512k,total -- 200
```

2. **Look.** Find `concatenate` and follow its allocation stacks upward. Hover over that frame and the root frame labeled `all`. Write down both byte weights.
3. **Try.** Cut the number of formatted strings in half.

```bash
../../scripts/lab profile alloc,alloc=512k,total -- 100
```

4. **Check.** Compare the absolute byte weights across reports. The widest frame may still fill the window in both. What changed in the hover values?
