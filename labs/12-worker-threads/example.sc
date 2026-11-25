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

def workers(limit: Int, lowPercent: Int): Unit =
  require(limit >= 4, "The upper limit must be at least 4.")
  require(lowPercent >= 1 && lowPercent <= 99, "Use a percentage from 1 to 99 for LOW-RANGE.")
  val lowCandidates = ((limit - 2).toLong * lowPercent / 100).toInt
  require(lowCandidates > 0, "Choose a percentage that gives LOW-RANGE at least one candidate.")
  val firstHighCandidate = 2 + lowCandidates
  println(s"LOW-RANGE: 2 to ${firstHighCandidate - 1}")
  println(s"HIGH-RANGE: $firstHighCandidate to ${limit - 1}")

  var left = 0
  var right = 0
  val first = new Thread(() => left = countPrimes(2, firstHighCandidate), "LOW-RANGE")
  val second = new Thread(() => right = countPrimes(firstHighCandidate, limit), "HIGH-RANGE")
  first.start()
  second.start()
  first.join()
  second.join()
  println(s"Primes below $limit: ${left + right} ($left low, $right high)")

val limit = args.headOption.map(_.toInt).getOrElse(150000)
val lowPercent = args.lift(1).map(_.toInt).getOrElse(50)

val start = System.nanoTime()
workers(limit, lowPercent)
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
