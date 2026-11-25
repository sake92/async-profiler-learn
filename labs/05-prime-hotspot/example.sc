//> using scala 3.10.0

def countPrimes(from: Int, until: Int): Int =
  var candidate = from
  var count = 0
  while candidate < until do
    if hasNoDivisor(candidate) then count += 1
    candidate += 1
  count

def hasNoDivisor(candidate: Int): Boolean =
  val lastDivisor = candidate - 1
  var divisor = 2
  while divisor <= lastDivisor do
    if candidate % divisor == 0 then return false
    divisor += 1
  true

val start = System.nanoTime()
val limit = args.headOption.map(_.toInt).getOrElse(150000)
println(s"Primes below $limit: ${countPrimes(2, limit)}")
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
