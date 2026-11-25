//> using scala 3.10.0

def formatChecksum(repetitions: Int, builder: Boolean): Long =
  var checksum = 0L
  var batch = 0
  while batch < repetitions do
    val text = if builder then formatWithBuilder(batch) else concatenate(batch)
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

def formatWithBuilder(batch: Int): String =
  val text = new java.lang.StringBuilder
  var value = 0
  while value < 2000 do
    text.append(batch + value).append(',')
    value += 1
  text.toString

def format(repetitions: Int, builder: Boolean): Unit =
  println(s"Checksum: ${formatChecksum(repetitions, builder)}")

val repetitions = args.headOption.map(_.toInt).getOrElse(200)
val useBuilder = args.lift(1).contains("builder")

val start = System.nanoTime()
format(repetitions, useBuilder)
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
