package `in`.kay.dynamicsurveykitapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import `in`.kay.dsk.models.TextConfig
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.theme.colorBlue
import `in`.kay.dsk.theme.colorWhite
import `in`.kay.dsk.utils.Utils.toHex
import `in`.kay.dsk.widgets.ButtonWidget
import `in`.kay.dsk.widgets.ButtonWidgetConfig
import `in`.kay.dsk.widgets.TextWidgetConfig

@Composable
@Preview
fun ButtonWidgetImpl() {
    val config = ButtonWidgetConfig(
        bgColor = colorBlue.toHex(),
        btnText = TextWidgetConfig(
            text = "I am a button", textConfig = TextConfig(
                colorWhite.toHex(), 16, "bold"
            ),
            topPadding = 8,
            bottomPadding = 8
        ),
        borderRadius = 12,
        borderStroke = 0,
        borderColor = colorWhite.toHex(),
        topPadding = 10,
        bottomPadding = 10,
        startPadding = 24,
        endPadding = 24,
        widgetDimens = WidgetDimens(
            "match_parent",
            100
        )
    )
    ButtonWidget(config = config, onCtaClick = {
        //Button is clicked
    })
}