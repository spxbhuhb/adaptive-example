package hu.simplexion.adaptive.example

import ExampleExports
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import hu.simplexion.adaptive.foundation.instruction.Trace
import hu.simplexion.adaptive.foundation.producer.poll
import hu.simplexion.adaptive.ui.common.android.adapter.AdaptiveAndroidAdapter
import hu.simplexion.adaptive.ui.common.android.adapter.android
import hu.simplexion.adaptive.ui.common.fragment.box
import hu.simplexion.adaptive.ui.common.fragment.text
import hu.simplexion.adaptive.ui.common.instruction.BackgroundGradient
import hu.simplexion.adaptive.ui.common.instruction.BorderRadius
import hu.simplexion.adaptive.ui.common.instruction.Color
import hu.simplexion.adaptive.ui.common.instruction.Frame
import kotlinx.datetime.Clock
import kotlin.time.Duration.Companion.milliseconds

val lightGreen = Color(0xA0DE6F)
val mediumGreen = Color(0x53C282)
val lightGray = Color(0xd8d8d8)
val mediumGray = Color(0x666666)
val purple = Color(0xA644FF)

val greenGradient = BackgroundGradient(90, lightGreen, mediumGreen)
val borderRadius = BorderRadius(8)
val trace = Trace(Regex(".*"))

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

//        withJson()
//        withWebSocketTransport("ws://10.0.2.2:8080/adaptive/service", trace = true)
//            .also {
//                (it.logger as JvmLogger).println = true
//            }

        window.decorView.post {
            adapter = android(this, rootView, ExampleExports) {

                val time = poll(50.milliseconds, Clock.System.now()) { Clock.System.now() }

                box(greenGradient, borderRadius, trace) {
                    text("Hello Adaptive 2!", Frame(200f, 200f, 300f, 100f), trace)
                    text("Now: $time", Frame(100f, 200f, 1000f, 100f), trace)
                }
            }
        }

    }
}
