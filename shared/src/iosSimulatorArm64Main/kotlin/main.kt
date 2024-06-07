/*
 * Copyright © 2020-2024, Simplexion, Hungary and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

import hu.simplexion.adaptive.example.shared.login
import hu.simplexion.adaptive.ui.common.uikit.ios
import hu.simplexion.adaptive.ui.common.uikit.resource.withIosResources
import platform.UIKit.UIView

fun main(rootView : UIView, trace : Boolean) {

    try {
        //withJson()
        //withWebSocketTransport("ws://localhost:8080/adaptive/service")

        withIosResources()

        ios(rootView, ExampleExports) {
            login()
        }

    } catch (e : Exception) {
        e.printStackTrace()
    }

}