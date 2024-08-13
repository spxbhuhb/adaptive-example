package `fun`.adaptive.example.shared

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import `fun`.adaptive.lib.sandbox.ui.mobile.goodMorning
import `fun`.adaptive.ui.common.android
import `fun`.adaptive.ui.common.fragment.box
import `fun`.adaptive.ui.common.platform.withAndroidResources

fun AppCompatActivity.main(rootView: ViewGroup) {

    withAndroidResources()
//        withJson()
//        withWebSocketTransport("ws://10.0.2.2:8080/adaptive/service", trace = true)
//            .also {
//                (it.logger as JvmLogger).println = true
//            }

    window.decorView.post {
        android(this, rootView) {
            box {
                goodMorning()
            }
        }
    }
}