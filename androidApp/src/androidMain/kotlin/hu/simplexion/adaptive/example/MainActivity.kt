package hu.simplexion.adaptive.example

import ExampleExports
import adaptive_example.shared.generated.resources.Res
import adaptive_example.shared.generated.resources.background
import adaptive_example.shared.generated.resources.logo
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import hu.simplexion.adaptive.foundation.instruction.AdaptiveInstruction
import hu.simplexion.adaptive.foundation.instruction.Trace
import hu.simplexion.adaptive.foundation.producer.poll
import hu.simplexion.adaptive.ui.common.android.adapter.AdaptiveAndroidAdapter
import hu.simplexion.adaptive.ui.common.android.adapter.android
import hu.simplexion.adaptive.ui.common.android.resource.withAndroidResources
import hu.simplexion.adaptive.ui.common.fragment.box
import hu.simplexion.adaptive.ui.common.fragment.column
import hu.simplexion.adaptive.ui.common.fragment.grid
import hu.simplexion.adaptive.ui.common.fragment.image
import hu.simplexion.adaptive.ui.common.fragment.row
import hu.simplexion.adaptive.ui.common.fragment.text
import hu.simplexion.adaptive.ui.common.instruction.AlignItems
import hu.simplexion.adaptive.ui.common.instruction.BackgroundGradient
import hu.simplexion.adaptive.ui.common.instruction.Border
import hu.simplexion.adaptive.ui.common.instruction.BorderRadius
import hu.simplexion.adaptive.ui.common.instruction.ColTemplate
import hu.simplexion.adaptive.ui.common.instruction.Color
import hu.simplexion.adaptive.ui.common.instruction.FontSize
import hu.simplexion.adaptive.ui.common.instruction.FontWeight
import hu.simplexion.adaptive.ui.common.instruction.Frame
import hu.simplexion.adaptive.ui.common.instruction.JustifyContent
import hu.simplexion.adaptive.ui.common.instruction.LetterSpacing
import hu.simplexion.adaptive.ui.common.instruction.Padding
import hu.simplexion.adaptive.ui.common.instruction.RowTemplate
import hu.simplexion.adaptive.ui.common.instruction.Size
import hu.simplexion.adaptive.ui.common.instruction.TextWrap
import hu.simplexion.adaptive.ui.common.instruction.dp
import hu.simplexion.adaptive.ui.common.instruction.externalLink
import hu.simplexion.adaptive.ui.common.instruction.fr
import hu.simplexion.adaptive.ui.common.instruction.gridCol
import hu.simplexion.adaptive.ui.common.instruction.onClick
import kotlinx.datetime.Clock
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

val lightGreen = Color(0xA0DE6F)
val mediumGreen = Color(0x53C282)
val lightGray = Color(0xd8d8d8)
val mediumGray = Color(0x666666)
val purple = Color(0xA644FF)
val white = Color(0xffffff)

val textSmall = FontSize(13f)
val whiteBorder = Border(white)
val bold = FontWeight(700)
val smallWhiteNoWrap = arrayOf(white, textSmall, TextWrap.NoWrap)

val greenGradient = BackgroundGradient(90, lightGreen, mediumGreen)
val borderRadius = BorderRadius(8)
val traceAll = Trace(Regex(".*"))
val traceLayout = Trace(Regex("layout"), Regex("measure.*"))

val center = arrayOf<AdaptiveInstruction>(AlignItems.Center, JustifyContent.Center)

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
            adapter = android(this, rootView, ExampleExports, trace = traceLayout) {

                val time = poll(500.seconds, Clock.System.now()) { Clock.System.now() }

                box {
                    image(Res.drawable.background)

                    grid(
                        RowTemplate(260.dp, 1.fr, 100.dp, 100.dp),
                        ColTemplate(1.fr)
                    ) {
                        row(AlignItems.End, JustifyContent.Center, Padding(bottom = 30)) {
                            image(Res.drawable.logo, Size(350, 350))
                        }

                        row(AlignItems.Start, JustifyContent.Center) {
                            text("Good Morning", white, FontSize(40f), LetterSpacing(-0.02f))
                        }

                        grid(
                            RowTemplate(50.dp),
                            ColTemplate(32.dp, 1.fr, 32.dp, 1.fr, 32.dp)
                        ) {

                            row(2.gridCol, greenGradient, borderRadius, *center, /* onClick { println("Sign Up") } */) {
                                text("Sign Up", white)
                            }

                            row(4.gridCol, whiteBorder, borderRadius, *center) {
                                text("Sign In", white)
                            }

                        }

                        column(AlignItems.Center, Padding(right = 32f, left = 32f)) {
                            row {
                                text("By joining you agree to our", *smallWhiteNoWrap, Padding(right = 6f))
                                text("Terms of Service", *smallWhiteNoWrap, bold, Padding(right = 6f))
                                text("and", *smallWhiteNoWrap)
                            }
                            text("Privacy Policy", *smallWhiteNoWrap, bold)
                        }
                    }
                }
            }
        }

    }
}
