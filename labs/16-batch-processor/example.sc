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

def parseRecord(record: String): (String, Int) =
  val fields = record.split(",")
  (fields(0), fields(1).toInt)

def batch(batchSize: Int): Unit =
  val records = Vector.tabulate(400)(index => s"group${index % 4},${index % 10 + 1}")
  val source = new SlowSource(records, delayMs = 8)
  val totals = scala.collection.mutable.Map.empty[String, Int]
  var count = 0
  while source.hasMore do
    for record <- source.readBatch(batchSize) do
      val (group, amount) = parseRecord(record)
      totals.update(group, totals.getOrElse(group, 0) + amount)
      count += 1
  println(s"$count records, ${totals.size} groups, total ${totals.values.sum}")

val batchSize = args.headOption.map(_.toInt).getOrElse(1)
val start = System.nanoTime()
batch(batchSize)
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
