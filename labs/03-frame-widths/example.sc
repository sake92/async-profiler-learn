//> using scala 3.10.0

def sumUpTo(limit: Int, seed: Long): Long =
  var total = seed
  var value = 1
  while value <= limit do
    total += value
    value += 1
  total

def countMultiplesOfThree(limit: Int, seed: Long): Long =
  var count = seed
  var value = 1
  while value <= limit do
    if value % 3 == 0 then count += 1
    value += 1
  count

val seconds = args.headOption.map(_.toInt).getOrElse(8)
val sumMs = args.lift(1).map(_.toInt).getOrElse(2)
val countMs = args.lift(2).map(_.toInt).getOrElse(6)

val start = System.nanoTime()
val end = start + seconds.toLong * 1_000_000_000L
var sum = 0L
var count = 0L
while System.nanoTime() < end do
  val sumEnd = System.nanoTime() + sumMs.toLong * 1_000_000L
  while System.nanoTime() < sumEnd do
    sum = sumUpTo(10_000, sum)

  val countEnd = System.nanoTime() + countMs.toLong * 1_000_000L
  while System.nanoTime() < countEnd do
    count = countMultiplesOfThree(10_000, count)

println(s"Sum: $sum")
println(s"Multiples of three counted: $count")
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
