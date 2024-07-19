/*
 * Copyright © 2020-2024, Simplexion, Hungary and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

import hu.simplexion.adaptive.lib.sandbox.ui.mobile.goodMorning
import hu.simplexion.adaptive.lib.sandbox.ui.mobile.mobileExample
import hu.simplexion.adaptive.lib.sandbox.ui.withSandbox
import hu.simplexion.adaptive.ui.common.browser
import hu.simplexion.adaptive.ui.common.platform.withJsResources
import hu.simplexion.adaptive.wireformat.withJson

fun main() {

    withJson()
    withJsResources()

    browser {
        withSandbox(it) // to set default font name
        mobileExample { goodMorning() }
    }

}