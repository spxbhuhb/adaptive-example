/*
 * Copyright © 2020-2024, Simplexion, Hungary and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

import hu.simplexion.adaptive.ui.common.fragment.clickable
import hu.simplexion.adaptive.ui.common.fragment.pixel
import hu.simplexion.adaptive.ui.common.fragment.text
import hu.simplexion.adaptive.ui.common.instruction.BoundingRect
import hu.simplexion.adaptive.ui.common.uikit.adapter.ios
import platform.UIKit.UIView

fun main(rootView : UIView, trace : Boolean) {

    try {
        //withJson()
        //withWebSocketTransport("ws://localhost:8080/adaptive/service")

        ios(rootView, ExampleExports, trace = trace) {
            pixel {
                clickable(onClick = { println("hello") }) {
                    text("Hello Adaptive 2!", BoundingRect(20f, 100f, 200f, 20f))
                }
            }
            //counter()
        }
    } catch (e : Exception) {
        e.printStackTrace()
    }

}