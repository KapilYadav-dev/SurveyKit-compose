package `in`.kay.dynamicsurveykitapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.theme.colorBlue
import `in`.kay.dsk.utils.Utils.toHex
import `in`.kay.dsk.widgets.ImageWidget
import `in`.kay.dsk.widgets.ImageWidgetConfig

@Composable
@Preview
fun ImageWidgetImpl() {
    val config = ImageWidgetConfig(
        widgetDimens = WidgetDimens(true, fillHeight = false, width = null, height = 300),
        startPadding = 24,
        endPadding = 24,
        topPadding = 10,
        bottomPadding = 10,
        borderColor = colorBlue.toHex(),
        borderStroke = 4,
        borderRadius = 20,
        imageUrl = "https://images.unsplash.com/photo-1574169208507-84376144848b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=879&q=80",
    )
    ImageWidget(config = config)
}