package hu.simplexion.adaptive.example

import ExampleExports
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import hu.simplexion.adaptive.foundation.producer.poll
import hu.simplexion.adaptive.ui.common.android.adapter.AdaptiveAndroidAdapter
import hu.simplexion.adaptive.ui.common.android.adapter.android
import hu.simplexion.adaptive.ui.common.fragment.pixel
import hu.simplexion.adaptive.ui.common.fragment.text
import hu.simplexion.adaptive.ui.common.instruction.BoundingRect
import kotlinx.datetime.Clock
import kotlin.time.Duration.Companion.seconds

class MainActivity : AppCompatActivity() {

    lateinit var adapter: AdaptiveAndroidAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.setBackgroundColor(0xffffff)
        linearLayout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

//        withJson()
//        withWebSocketTransport("ws://10.0.2.2:8080/adaptive/service", trace = true)
//            .also {
//                (it.logger as JvmLogger).println = true
//            }

        adapter = android(this, linearLayout, ExampleExports, trace = true) {
            val time = poll(1.seconds, Clock.System.now()) { Clock.System.now() }
            pixel {
                text("Hello Adaptive 2!", BoundingRect(200f, 100f, 300f, 100f))
                text("Now: $time", BoundingRect(200f, 200f, 1000f, 100f))
            }
        }

        // Set the TextView as the content view of the activity
        setContentView(linearLayout)
    }
}
