//val counterService = getService<CounterApi>()
//
//fun now() = Clock.System.now()

//@Adaptive
//fun counter() {
//
//    val counter = poll(1.seconds, 0) { counterService.incrementAndGet() }
//    val time = poll(1.seconds, default = now()) { now() }
//    val time2 = time.minus((time.nanosecondsOfSecond % 1_000_000).nanoseconds).toString().removeSuffix("Z")
//
//    text("$time2 $counter")
//
//}