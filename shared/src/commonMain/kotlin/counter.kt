import hu.simplexion.adaptive.foundation.Adaptive
import hu.simplexion.adaptive.foundation.producer.poll
import hu.simplexion.adaptive.service.getService
import hu.simplexion.adaptive.ui.common.fragment.text
import kotlinx.datetime.Clock
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.Duration.Companion.seconds


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