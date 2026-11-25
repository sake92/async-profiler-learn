//> using scala 3.10.0

def formatChecksum(repetitions: Int): Long =
  var checksum = 0L
  var batch = 0
  while batch < repetitions do
    val text = concatenate(batch)
    checksum += text.hashCode
    batch += 1
  checksum

def concatenate(batch: Int): String =
  var text = ""
  var value = 0
  while value < 2000 do
    text = text + (batch + value) + ','
    value += 1
  text

val repetitions = args.headOption.map(_.toInt).getOrElse(200)
val start = System.nanoTime()
val checksum = formatChecksum(repetitions)
println(s"Checksum: $checksum")
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
