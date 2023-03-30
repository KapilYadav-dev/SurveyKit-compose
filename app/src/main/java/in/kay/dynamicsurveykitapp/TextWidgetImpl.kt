package `in`.kay.dynamicsurveykitapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import `in`.kay.dsk.models.TextConfig
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.theme.colorBlack
import `in`.kay.dsk.utils.Utils.toHex
import `in`.kay.dsk.widgets.TextWidget
import `in`.kay.dsk.widgets.TextWidgetConfig

@Composable
@Preview
fun TextWidgetImpl() {
    val config = TextWidgetConfig(
        text = "This is an example of TextWidgetConfig",
        topPadding = 30,
        startPadding = 30,
        textConfig = TextConfig(
            color = colorBlack.toHex(),
            fontSize = 20,
            fontWeight = "semiBold"
        ),
        widgetDimens = WidgetDimens(
            true,
            null,
            null,
            100
        )
    )
    TextWidget(config)
}