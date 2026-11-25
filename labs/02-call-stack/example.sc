//> using scala 3.10.0

def sumUpTo(limit: Int, seed: Long): Long =
  var total = seed
  var value = 1
  while value <= limit do
    total += value
    value += 1
  total

def sumFixedRange(end: Long): Long =
  var checksum = 0L
  while System.nanoTime() < end do
    checksum = sumUpTo(1_000_000, checksum)
  checksum

def sumGrowingRanges(end: Long): Long =
  var checksum = 0L
  var limit = 100_000
  while System.nanoTime() < end do
    checksum = sumUpTo(limit, checksum)
    limit += 100_000
    if limit > 1_000_000 then limit = 100_000
  checksum

val fixedSeconds = args.headOption.map(_.toInt).getOrElse(2)
val start = System.nanoTime()
val fixedEnd = start + fixedSeconds.toLong * 1_000_000_000L
val fixedTotal = sumFixedRange(fixedEnd)

val growingSeconds = args.lift(1).map(_.toInt).getOrElse(3)
val growingEnd = System.nanoTime() + growingSeconds.toLong * 1_000_000_000L
val growingTotal = sumGrowingRanges(growingEnd)

println(s"Fixed range checksum: $fixedTotal")
println(s"Growing ranges checksum: $growingTotal")
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
