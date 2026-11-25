//> using scala 3.10.0

class Collector:
  var count = 0

  def record(sleepOutside: Boolean): Unit =
    if sleepOutside then Thread.sleep(5)
    synchronized {
      if !sleepOutside then Thread.sleep(5)
      count += 1
    }

def submitResults(collector: Collector, sleepOutside: Boolean): Unit =
  for _ <- 1 to 300 do
    collector.record(sleepOutside)
    Thread.sleep(1)

def lock(sleepOutside: Boolean): Unit =
  val collector = new Collector
  val first = new Thread(() => submitResults(collector, sleepOutside), "PRODUCER-1")
  val second = new Thread(() => submitResults(collector, sleepOutside), "PRODUCER-2")
  first.start()
  second.start()
  first.join()
  second.join()
  println(s"Collected ${collector.count} results")

val start = System.nanoTime()
lock(args.headOption.contains("outside"))
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
