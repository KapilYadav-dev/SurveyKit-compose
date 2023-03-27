package `in`.kay.dsk.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import `in`.kay.dsk.models.TextConfig
import `in`.kay.dsk.models.WidgetConfig
import `in`.kay.dsk.utils.Utils.applyText

@Composable
@Preview
fun TextWidget(config: TextWidgetConfig = TextWidgetConfig()) {
    config.applyText()
}

data class TextWidgetConfig(
    val text:String?=null,
    val textConfig: TextConfig = TextConfig(),
    val modifier: Modifier=Modifier,
    override val widgetId: String = Widgets.TextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
) : WidgetConfig