//> using scala 3.10.0

def sumUpTo(limit: Int, seed: Long): Long =
  var total = seed
  var value = 1
  while value <= limit do
    total += value
    value += 1
  total

val seconds = args.headOption.map(_.toInt).getOrElse(8)
val sleepMs = args.lift(1).map(_.toInt).getOrElse(30)

val start = System.nanoTime()
val end = start + seconds.toLong * 1_000_000_000L
var checksum = 0L
while System.nanoTime() < end do
  val workEnd = System.nanoTime() + 10_000_000L
  while System.nanoTime() < workEnd do
    checksum = sumUpTo(10_000, checksum)
  Thread.sleep(sleepMs)

println(s"Checksum: $checksum")
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
