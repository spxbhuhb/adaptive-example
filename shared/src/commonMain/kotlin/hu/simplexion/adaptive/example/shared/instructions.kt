package hu.simplexion.adaptive.example.shared

import hu.simplexion.adaptive.foundation.instruction.AdaptiveInstruction
import hu.simplexion.adaptive.foundation.instruction.Trace
import hu.simplexion.adaptive.ui.common.instruction.AlignItems
import hu.simplexion.adaptive.ui.common.instruction.BackgroundColor
import hu.simplexion.adaptive.ui.common.instruction.BackgroundGradient
import hu.simplexion.adaptive.ui.common.instruction.Border
import hu.simplexion.adaptive.ui.common.instruction.BorderRadius
import hu.simplexion.adaptive.ui.common.instruction.Color
import hu.simplexion.adaptive.ui.common.instruction.FontSize
import hu.simplexion.adaptive.ui.common.instruction.FontWeight
import hu.simplexion.adaptive.ui.common.instruction.JustifyContent
import hu.simplexion.adaptive.ui.common.instruction.TextWrap
import hu.simplexion.adaptive.ui.common.instruction.dp
import hu.simplexion.adaptive.ui.common.instruction.sp
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


val Int.twoDigits
    get() = toString().padStart(2, '0')

val Int.threeDigits
    get() = toString().padStart(3, '0')

fun now() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

val black = Color(0x000000)
val white = Color(0xffffff)
val lightGreen = Color(0xA0DE6F)
val mediumGreen = Color(0x53C282)
val lightGray = Color(0xd8d8d8)
val mediumGray = Color(0x666666)
val purple = Color(0xA644FF)

val blackBackground = BackgroundColor(black)
val mediumGreenBackground = BackgroundColor(mediumGreen)
val greenGradient = BackgroundGradient(90, lightGreen, mediumGreen)
val borderRadius = BorderRadius(8.dp)

val textSmall = FontSize(13.sp)
val textMedium = FontSize(15.sp)
val whiteBorder = Border(white)
val bold = FontWeight(700)
val smallWhiteNoWrap = arrayOf(white, textSmall, TextWrap.NoWrap)

val center = arrayOf<AdaptiveInstruction>(AlignItems.Center, JustifyContent.Center)
val traceAll = Trace(Regex(".*"))
val traceLayout = Trace(Regex("layout.*"), Regex("measure.*"))