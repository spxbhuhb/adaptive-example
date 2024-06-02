/*
 * Copyright © 2020-2024, Simplexion, Hungary and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

import hu.simplexion.adaptive.ui.common.fragment.box
import hu.simplexion.adaptive.ui.common.fragment.text
import hu.simplexion.adaptive.ui.common.instruction.Frame
import hu.simplexion.adaptive.ui.common.instruction.dp
import hu.simplexion.adaptive.ui.common.uikit.adapter.ios
import platform.UIKit.UIView

fun main(rootView : UIView, trace : Boolean) {

    try {
        //withJson()
        //withWebSocketTransport("ws://localhost:8080/adaptive/service")

        ios(rootView, ExampleExports) {
            box {
                text("Hello Adaptive 2!", Frame(20.dp, 100.dp, 200.dp, 20.dp))
            }
            //counter()
        }
    } catch (e : Exception) {
        e.printStackTrace()
    }

}