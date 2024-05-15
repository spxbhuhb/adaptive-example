/*
 * Copyright © 2020-2024, Simplexion, Hungary and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

import hu.simplexion.adaptive.base.Adaptive
import hu.simplexion.adaptive.base.producer.poll
import hu.simplexion.adaptive.example.api.CounterApi
import hu.simplexion.adaptive.ktor.withWebSocketTransport
import hu.simplexion.adaptive.service.defaultServiceCallTransport
import hu.simplexion.adaptive.service.getService
import hu.simplexion.adaptive.ui.basic.text
import hu.simplexion.adaptive.ui.dom.browserJs
import hu.simplexion.adaptive.wireformat.withJson
import kotlinx.datetime.Clock
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.Duration.Companion.seconds

fun main() {

    withJson()
    withWebSocketTransport()

    browserJs {
        counter()
    }

}


val counterService = getService<CounterApi>()

fun now() = Clock.System.now()

@Adaptive
fun counter() {

    val counter = poll(1.seconds, 0) { counterService.incrementAndGet() }
    val time = poll(10.milliseconds, default = now()) { now() }
    val time2 = time.minus((time.nanosecondsOfSecond % 1_000_000).nanoseconds).toString().removeSuffix("Z")

    text("$time2 $counter")

}