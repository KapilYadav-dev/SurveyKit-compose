package `in`.kay.dsk.models

import androidx.compose.ui.text.font.FontWeight

data class TextConfig (
    val color:String= "#000000",
    val fontSize:Int = 20,
    val fontWeight:String = "bold"
)

fun String.toFontWeight() : FontWeight {
    when(this) {
        "light"-> return FontWeight.Light
        "normal"-> return FontWeight.Normal
        "medium"-> return FontWeight.Medium
        "bold"-> return FontWeight.Bold
        "semiBold"-> return FontWeight.SemiBold
    }
    return FontWeight.Normal
}