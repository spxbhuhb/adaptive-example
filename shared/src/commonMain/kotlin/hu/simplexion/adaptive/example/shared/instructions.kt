package hu.simplexion.adaptive.example.shared

import hu.simplexion.adaptive.foundation.instruction.Trace
import hu.simplexion.adaptive.ui.common.instruction.BackgroundColor
import hu.simplexion.adaptive.ui.common.instruction.Color
import hu.simplexion.adaptive.ui.common.instruction.FontSize
import hu.simplexion.adaptive.ui.common.instruction.FontWeight
import hu.simplexion.adaptive.ui.common.instruction.TextWrap
import hu.simplexion.adaptive.ui.common.instruction.border
import hu.simplexion.adaptive.ui.common.instruction.cornerRadius
import hu.simplexion.adaptive.ui.common.instruction.dp
import hu.simplexion.adaptive.ui.common.instruction.leftToRightGradient
import hu.simplexion.adaptive.ui.common.instruction.sp
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


val Int.twoDigits
    get() = toString().padStart(2, '0')

val Int.threeDigits
    get() = toString().padStart(3, '0')

fun now() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

val black = Color(0x000000u)
val white = Color(0xffffffu)
val lightGreen = Color(0xA0DE6Fu)
val mediumGreen = Color(0x53C282u)
val lightGray = Color(0xd8d8d8u)
val mediumGray = Color(0x666666u)
val purple = Color(0xA644FFu)

val blackBackground = BackgroundColor(black)
val mediumGreenBackground = BackgroundColor(mediumGreen)
val greenGradient = leftToRightGradient(lightGreen, mediumGreen)
val borderRadius = cornerRadius(8.dp)

val textSmall = FontSize(13.sp)
val textMedium = FontSize(15.sp)
val whiteBorder = border(white)
val bold = FontWeight(700)
val smallWhiteNoWrap = arrayOf(white, textSmall, TextWrap.NoWrap)

val traceAll = Trace(Regex(".*"))
val traceLayout = Trace(Regex("layout.*"), Regex("measure.*"))