/*
 * Copyright © 2020-2024, Simplexion, Hungary and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

import hu.simplexion.adaptive.example.shared.login
import hu.simplexion.adaptive.ktor.withWebSocketTransport
import hu.simplexion.adaptive.ui.common.browser.browser
import hu.simplexion.adaptive.ui.common.browser.resource.withJsResources
import hu.simplexion.adaptive.ui.common.fragment.box
import hu.simplexion.adaptive.ui.common.instruction.Size
import hu.simplexion.adaptive.ui.common.instruction.dp
import hu.simplexion.adaptive.wireformat.withJson

fun main() {

    withJson()
    withWebSocketTransport()
    withJsResources()

    browser(ExampleExports) {
        box(Size(393.dp, (808 - 24 - 24).dp)) { // android Pixel 3 dimensions
            login()
        }
    }

}