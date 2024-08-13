/*
 * Copyright © 2020-2024, Simplexion, Hungary and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

import `fun`.adaptive.lib.sandbox.ui.mobile.goodMorning
import `fun`.adaptive.lib.sandbox.ui.mobile.mobileExample
import `fun`.adaptive.lib.sandbox.ui.withSandbox
import `fun`.adaptive.ui.common.browser
import `fun`.adaptive.ui.common.platform.withJsResources

fun main() {

    withJsResources()

    browser {
        withSandbox(it) // to set default font name
        mobileExample { goodMorning() }
    }

}