package hu.simplexion.adaptive.example

import ExampleExports
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import hu.simplexion.adaptive.example.shared.login
import hu.simplexion.adaptive.ui.common.android.AdaptiveAndroidAdapter
import hu.simplexion.adaptive.ui.common.android.android
import hu.simplexion.adaptive.ui.common.android.resource.withAndroidResources

class MainActivity : AppCompatActivity() {

    lateinit var adapter: AdaptiveAndroidAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootView = LinearLayout(this).also {
            it.orientation = LinearLayout.VERTICAL
            it.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        setContentView(rootView)

        withAndroidResources()

//        withJson()
//        withWebSocketTransport("ws://10.0.2.2:8080/adaptive/service", trace = true)
//            .also {
//                (it.logger as JvmLogger).println = true
//            }

        window.decorView.post {
            adapter = android(this, rootView, ExampleExports) {
                // val time = poll(500.seconds, Clock.System.now()) { Clock.System.now() }
                login()
            }
        }

    }
}

