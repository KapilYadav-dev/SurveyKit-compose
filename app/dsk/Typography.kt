val Typography = Typography(
    defaultFontFamily = gilroy()
)


fun getFontStyle(color:Color,fontWeight: FontWeight,fontSize: TextUnit) = TextStyle(
    fontFamily = gilroy(),
    fontWeight = fontWeight,
    fontSize = fontSize,
    color = color
)


fun gilroy() = FontFamily(
    Font(R.font.psb, FontWeight.Bold),
    Font(R.font.psr, FontWeight.Medium),
)