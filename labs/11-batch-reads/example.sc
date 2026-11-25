//> using scala 3.10.0

class SlowSource[A](items: Vector[A], delayMs: Int):
  private var position = 0

  def hasMore: Boolean = position < items.size

  def readBatch(size: Int): Vector[A] =
    Thread.sleep(delayMs)
    val end = position + math.min(size, items.size - position)
    val batch = items.slice(position, end)
    position = end
    batch

def reader(batchSize: Int): Unit =
  val source = new SlowSource(Vector.tabulate(120)(identity), delayMs = 20)
  var count = 0
  var total = 0
  while source.hasMore do
    val batch = source.readBatch(batchSize)
    count += batch.size
    total += batch.sum
  println(s"Read $count items, total $total")

val batchSize = args.headOption.map(_.toInt).getOrElse(1)
val start = System.nanoTime()
reader(batchSize)
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
