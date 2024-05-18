/*
 * Copyright © 2020-2024, Simplexion, Hungary and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

import hu.simplexion.adaptive.ktor.withWebSocketTransport
import hu.simplexion.adaptive.ui.adapter.ios
import hu.simplexion.adaptive.ui.basic.text
import hu.simplexion.adaptive.wireformat.withJson
import platform.UIKit.UIView

fun main(rootView : UIView, trace : Boolean) {

    try {
//        withJson()
//        withWebSocketTransport()

        ios(rootView, ExampleExports, trace = trace) {
            text("Hello Adaptive 2!")
            // counter()
        }
    } catch (e : Exception) {
        e.printStackTrace()
    }

}