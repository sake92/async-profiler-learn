//> using scala 3.10.0

def sumUpTo(limit: Int, seed: Long): Long =
  var total = seed
  var value = 1
  while value <= limit do
    total += value
    value += 1
  total

val seconds = args.headOption.map(_.toInt).getOrElse(5)
val start = System.nanoTime()
val end = start + seconds.toLong * 1_000_000_000L

var checksum = 0L
while System.nanoTime() < end do
  checksum = sumUpTo(1_000_000, checksum)

println(s"Checksum: $checksum")
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
