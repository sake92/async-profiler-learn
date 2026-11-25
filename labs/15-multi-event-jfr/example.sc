//> using scala 3.10.0

def hasNoDivisor(candidate: Int): Boolean =
  var divisor = 2
  while divisor < candidate do
    if candidate % divisor == 0 then return false
    divisor += 1
  true

def concatenate(batch: Int): String =
  var text = ""
  var value = 0
  while value < 2000 do
    text = text + (batch + value) + ','
    value += 1
  text

val start = System.nanoTime()
val limit = args.headOption.map(_.toInt).getOrElse(150000)
var candidate = 2
var count = 0
while candidate < limit do
  if hasNoDivisor(candidate) then count += 1
  candidate += 1
println(s"Primes below $limit: $count")

val repetitions = args.lift(1).map(_.toInt).getOrElse(200)
var checksum = 0L
var batch = 0
while batch < repetitions do
  checksum += concatenate(batch).hashCode
  batch += 1
println(s"Checksum: $checksum")
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
