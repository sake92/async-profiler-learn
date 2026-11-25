//> using scala 3.10.0

def countPrimes(from: Int, until: Int, sqrt: Boolean = false): Int =
  var candidate = from
  var count = 0
  while candidate < until do
    if hasNoDivisor(candidate, sqrt) then count += 1
    candidate += 1
  count

def hasNoDivisor(candidate: Int, sqrt: Boolean): Boolean =
  val lastDivisor = if sqrt then math.sqrt(candidate).toInt else candidate - 1
  var divisor = 2
  while divisor <= lastDivisor do
    if candidate % divisor == 0 then return false
    divisor += 1
  true

def run(limit: Int, sqrt: Boolean): Unit =
  println(s"Primes below $limit: ${countPrimes(2, limit, sqrt)}")

val limit = args.headOption.map(_.toInt).getOrElse(150000)
val useSquareRoot = args.lift(1).contains("sqrt")

val start = System.nanoTime()
run(limit, useSquareRoot)
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
