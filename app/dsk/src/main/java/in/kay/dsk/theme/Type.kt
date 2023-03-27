package `in`.kay.dsk.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import `in`.kay.DynamicSurveyKit.R

val Typography = Typography(
    defaultFontFamily = gilroy()
)


fun getFontStyle(color: Color, fontWeight: FontWeight, fontSize: TextUnit) = TextStyle(
    fontFamily = gilroy(),
    fontWeight = fontWeight,
    fontSize = fontSize,
    color = color
)


fun gilroy() = FontFamily(
    Font(R.font.psb, FontWeight.Bold),
    Font(R.font.psr, FontWeight.Medium),
)