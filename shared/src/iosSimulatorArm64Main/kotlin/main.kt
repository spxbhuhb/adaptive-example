/*
 * Copyright © 2020-2024, Simplexion, Hungary and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

import `fun`.adaptive.lib.sandbox.ui.mobile.goodMorning
import `fun`.adaptive.ui.api.box
import `fun`.adaptive.ui.ios
import `fun`.adaptive.ui.platform.withIosResources
import platform.UIKit.UIView


fun main(rootView : UIView, trace : Boolean) {

    try {
        //withJson()
        //withWebSocketTransport("ws://localhost:8080/adaptive/service")

        withIosResources()

        ios(rootView) {
            box {
                goodMorning()
            }
        }

    } catch (e : Exception) {
        e.printStackTrace()
    }

}