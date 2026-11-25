# 11. Read a batch at a time

You’ll change the number of items per read and measure how batching affects waiting time while keeping the result comparable.

The example simulates a fixed delay per request. Think of fetching more rows per JDBC round trip or requesting a larger page from a slow API. You read the same data with fewer requests.

Run the commands from this lab’s folder. The source is in [example.sc](example.sc).

1. **Run.** Record the baseline with one item per read and write down its elapsed time.

```bash
../../scripts/lab profile wall,threads -- 1
```
2. **Try.** Change the number of items read per call to ten. Predict how many calls to the input source remain.

```bash
../../scripts/lab profile wall,threads -- 10
```

3. **Look.** Confirm the item count and sum match the baseline. Compare elapsed time and the absolute sample count for the sleeping stack. Observe what the percentage does as the entire run gets shorter.
4. **Check.** Try a batch size of 20. Check whether the predicted number of source calls and the elapsed time move in the same direction.

```bash
../../scripts/lab profile wall,threads -- 20
```
