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
import hu.simplexion.adaptive.ui.common.instruction.ColTemplate
import hu.simplexion.adaptive.ui.common.instruction.FontSize
import hu.simplexion.adaptive.ui.common.instruction.JustifyContent
import hu.simplexion.adaptive.ui.common.instruction.LetterSpacing
import hu.simplexion.adaptive.ui.common.instruction.Padding
import hu.simplexion.adaptive.ui.common.instruction.RowTemplate
import hu.simplexion.adaptive.ui.common.instruction.Size
import hu.simplexion.adaptive.ui.common.instruction.dp
import hu.simplexion.adaptive.ui.common.instruction.fr
import hu.simplexion.adaptive.ui.common.instruction.gridCol
import hu.simplexion.adaptive.ui.common.instruction.noSelect
import hu.simplexion.adaptive.ui.common.instruction.onClick
import hu.simplexion.adaptive.ui.common.instruction.sp
import kotlinx.datetime.LocalDateTime
import kotlin.time.Duration.Companion.seconds

@Adaptive
fun login() {

    var counter = 0
    val time = poll(1.seconds, now()) { now() }
    val timeText = "${time.hour.twoDigits}:${time.minute.twoDigits}:${time.second.twoDigits}"

    box { // android Pixel 3 dimensions: (Size(393.dp, (808 - 24 - 24).dp))

        image(Res.drawable.background)

        grid(
            RowTemplate(140.dp, 50.dp, 1.fr, 1.fr, 1.fr, 50.dp, 100.dp),
            ColTemplate(1.fr)
        ) {
            logo()
            title()
            time(timeText)
            progress(time)
            messages(time, counter)

            grid(
                RowTemplate(50.dp),
                ColTemplate(32.dp, 1.fr, 32.dp, 1.fr, 32.dp)
            ) {

                row(
                    2.gridCol,
                    mediumGreenBackground,
                    borderRadius,
                    *center,
                    onClick { counter++ }) {
                    text("Snooze", white, textMedium, noSelect)
                }

                row(4.gridCol, whiteBorder, borderRadius, *center) {
                    text("Sleepiness: $counter", white, textMedium)
                }
            }

            terms()
        }
    }
}

@Adaptive
private fun logo() {
    row(AlignItems.End, JustifyContent.Center, Padding(bottom = 20.dp)) {
        image(Res.drawable.logo, Size(92.dp, 92.dp))
    }
}

@Adaptive
private fun title() {
    row(AlignItems.Start, JustifyContent.Center) {
        text("Good Morning", white, FontSize(40.sp), LetterSpacing(-0.02f))
    }
}

@Adaptive
private fun time(timeText: String) {
    column(AlignItems.Center, JustifyContent.Start, Padding(top = 12.dp)) {
        text(timeText, white, FontSize(80.sp), LetterSpacing(-0.02f))
    }
}

@Adaptive
private fun progress(time: LocalDateTime) {
    row(*center) {
        for (i in 0..time.second) {
            text(if (i % 10 == 0) "|" else ".", white)
        }
    }
}

@Adaptive
private fun messages(time: LocalDateTime, counter: Int) {
    column(*center) {
        if (time.second % 2 == 1) {
            row(AlignItems.Start, JustifyContent.Center, greenGradient, borderRadius) {
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
    column(AlignItems.Center, Padding(right = 32.dp, left = 32.dp, top = 12.dp)) {
        row {
            text("By joining you agree to our", *smallWhiteNoWrap, Padding(right = 6.dp))
            text("Terms of Service", *smallWhiteNoWrap, bold, Padding(right = 6.dp))
            text("and", *smallWhiteNoWrap)
        }
        text("Privacy Policy", *smallWhiteNoWrap, bold)
    }
}