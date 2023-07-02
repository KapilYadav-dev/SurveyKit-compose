package `in`.kay.dsk.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import `in`.kay.dsk.models.TextConfig
import `in`.kay.dsk.models.WidgetConfig
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.theme.colorBlue
import `in`.kay.dsk.theme.colorWhite
import `in`.kay.dsk.utils.Utils.setButton
import `in`.kay.dsk.utils.Utils.toHex

@Composable
@Preview
fun ButtonWidget(config: ButtonWidgetConfig = ButtonWidgetConfig(), onCtaClick: () -> Unit = {}) {
    config.setButton(onCtaClick = onCtaClick)
}

data class ButtonWidgetConfig(
    val bgColor: String = colorBlue.toHex(),
    val borderRadius: Int = 12,
    val borderStroke: Int = 0,
    val borderColor: String = colorWhite.toHex(),
    val modifier: Modifier = Modifier,
    override val widgetDimens: WidgetDimens = WidgetDimens(
        height = null,
        width = null
    ),
    val btnText: TextWidgetConfig = TextWidgetConfig(
        text = "next", textConfig = TextConfig(
            colorWhite.toHex(), 16, "bold"
        ),
        topPadding = 8,
        bottomPadding = 8
    ),
    override val widgetId: String = Widgets.CtaButtonWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
) : WidgetConfig