//> using scala 3.10.0

class Collector:
  var count = 0

  def record(): Unit = synchronized {
    Thread.sleep(5)
    count += 1
  }

def submitResults(collector: Collector): Unit =
  for _ <- 1 to 300 do
    collector.record()

val start = System.nanoTime()
val collector = new Collector
val first = new Thread(() => submitResults(collector), "PRODUCER-1")
val second = new Thread(() => submitResults(collector), "PRODUCER-2")
first.start()
second.start()
first.join()
second.join()
println(s"Collected ${collector.count} results")
println(f"Elapsed: ${(System.nanoTime() - start) / 1e9}%.3f s")
