package hu.simplexion.adaptive.example

import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import hu.simplexion.adaptive.example.ui.ExampleExports
import hu.simplexion.adaptive.example.ui.counter
import hu.simplexion.adaptive.ktor.withWebSocketTransport
import hu.simplexion.adaptive.log.JvmLogger
import hu.simplexion.adaptive.ui.android.adapter.AdaptiveViewAdapter
import hu.simplexion.adaptive.ui.android.adapter.android
import hu.simplexion.adaptive.wireformat.withJson

class MainActivity : AppCompatActivity() {

    lateinit var adapter: AdaptiveViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.setBackgroundColor(0xffffff)
        linearLayout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        withJson()
        withWebSocketTransport("ws://10.0.2.2:8080/adaptive/service", trace = true)
            .also {
                (it.logger as JvmLogger).println = true
            }

        adapter = android(this, linearLayout, ExampleExports) {
            counter()
        }

        // Set the TextView as the content view of the activity
        setContentView(linearLayout)
    }
}
