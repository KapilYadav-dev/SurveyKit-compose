package `in`.kay.dsk.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import `in`.kay.dsk.models.WidgetConfig
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.utils.Utils.loadImage

@Composable
fun ImageWidget(config: ImageWidgetConfig) {
    config.loadImage()
}
data class ImageWidgetConfig(
    val modifier: Modifier = Modifier,
    val borderColor: String?=null,
    val borderRadius:Int = 20,
    val borderStroke:Int = 2,
    val imageUrl:String?=null,
    val widgetDimens: WidgetDimens = WidgetDimens(
        fillWidth = null,
        fillHeight = null,
        height = null,
        width = null
    ),
    override val widgetId: String= Widgets.ImageWidgetId.widgetName,
    override val topPadding: Int=0,
    override val bottomPadding: Int=0,
    override val startPadding: Int=0,
    override val endPadding: Int=0
): WidgetConfig