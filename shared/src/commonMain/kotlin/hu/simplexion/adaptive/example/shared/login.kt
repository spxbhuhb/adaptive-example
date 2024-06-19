package hu.simplexion.adaptive.example.shared

import adaptive_example.shared.generated.resources.Res
import adaptive_example.shared.generated.resources.background
import adaptive_example.shared.generated.resources.logo
import hu.simplexion.adaptive.foundation.Adaptive
import hu.simplexion.adaptive.foundation.producer.poll
import hu.simplexion.adaptive.ui.common.fragment.box
import hu.simplexion.adaptive.ui.common.fragment.column
import hu.simplexion.adaptive.ui.common.fragment.grid
import hu.simplexion.adaptive.ui.common.fragment.image
import hu.simplexion.adaptive.ui.common.fragment.row
import hu.simplexion.adaptive.ui.common.fragment.text
import hu.simplexion.adaptive.ui.common.instruction.AlignItems
import hu.simplexion.adaptive.ui.common.instruction.FontSize
import hu.simplexion.adaptive.ui.common.instruction.Padding
import hu.simplexion.adaptive.ui.common.instruction.Size
import hu.simplexion.adaptive.ui.common.instruction.colTemplate
import hu.simplexion.adaptive.ui.common.instruction.dp
import hu.simplexion.adaptive.ui.common.instruction.fontSize
import hu.simplexion.adaptive.ui.common.instruction.fr
import hu.simplexion.adaptive.ui.common.instruction.gridCol
import hu.simplexion.adaptive.ui.common.instruction.letterSpacing
import hu.simplexion.adaptive.ui.common.instruction.noSelect
import hu.simplexion.adaptive.ui.common.instruction.onClick
import hu.simplexion.adaptive.ui.common.instruction.padding
import hu.simplexion.adaptive.ui.common.instruction.paddingBottom
import hu.simplexion.adaptive.ui.common.instruction.paddingRight
import hu.simplexion.adaptive.ui.common.instruction.paddingTop
import hu.simplexion.adaptive.ui.common.instruction.rowTemplate
import hu.simplexion.adaptive.ui.common.instruction.sp
import kotlinx.datetime.LocalDateTime
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalObjCRefinement::class)
@Adaptive
@HiddenFromObjC
fun login() {

    var counter = 0
    val time = poll(1.seconds) { now() } ?: now()
    val timeText = "${time.hour.twoDigits}:${time.minute.twoDigits}:${time.second.twoDigits}"

    box { // android Pixel 3 dimensions: (Size(393.dp, (808 - 24 - 24).dp))

        image(Res.drawable.background)

        grid {
            rowTemplate(140.dp, 50.dp, 1.fr, 1.fr, 1.fr, 50.dp, 100.dp)
            colTemplate(1.fr)

            logo()
            title()
            time(timeText)
            progress(time)
            messages(time, counter)

            grid {
                rowTemplate(50.dp)
                colTemplate(32.dp, 1.fr, 32.dp, 1.fr, 32.dp)

                row(
                    2.gridCol,
                    mediumGreenBackground,
                    borderRadius,
                    AlignItems.center,
                    onClick { counter++ }
                ) {
                    text("Snooze", white, textMedium, noSelect)
                }

                row(4.gridCol, whiteBorder, borderRadius, AlignItems.center) {
                    text("Sleepiness: $counter", white, textMedium)
                }
            }

            terms()
        }
    }
}

@Adaptive
private fun logo() {
    row(AlignItems.bottomCenter, paddingBottom(20.dp)) {
        image(Res.drawable.logo, Size(92.dp, 92.dp))
    }
}

@Adaptive
private fun title() {
    row(AlignItems.center) {
        text("Good Morning", white, FontSize(40.sp), letterSpacing(-0.02))
    }
}

@Adaptive
private fun time(timeText: String) {
    column(AlignItems.topCenter, paddingTop(12.dp)) {
        text(timeText, white, fontSize(80.sp), letterSpacing(-0.02))
    }
}

@Adaptive
private fun progress(time: LocalDateTime) {
    row(AlignItems.center) {
        for (i in 0..time.second) {
            text(if (i % 10 == 0) "|" else ".", white)
        }
    }
}

@Adaptive
private fun messages(time: LocalDateTime, counter: Int) {
    column(AlignItems.center) {
        if (time.second % 2 == 1) {
            row(AlignItems.center, greenGradient, borderRadius) {
                text("What an odd second!", white, Padding(12.dp))
            }
        }
        if (counter > 3) {
            row(greenGradient, borderRadius) {
                text("You are really sleepy today!", white, textMedium, Padding(12.dp))
            }
        }
    }
}

@Adaptive
private fun terms() {
    column(AlignItems.center, padding(right = 32.dp, left = 32.dp, top = 12.dp)) {
        row {
            text("By joining you agree to our", *smallWhiteNoWrap, paddingRight(6.dp))
            text("Terms of Service", *smallWhiteNoWrap, bold, paddingRight(6.dp))
            text("and", *smallWhiteNoWrap)
        }
        text("Privacy Policy", *smallWhiteNoWrap, bold)
    }
}