package `in`.kay.dynamicsurveykitapp


import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.theme.colorBlue
import `in`.kay.dsk.utils.Utils.toHex
import `in`.kay.dsk.widgets.ProgressBarWidget
import `in`.kay.dsk.widgets.ProgressBarWidgetConfig

@Composable
@Preview
fun ProgressBarWidgetImpl() {
    val config = ProgressBarWidgetConfig(
        progressColor = colorBlue.toHex(),
        bgColor = Color.LightGray.toHex(),
        widgetDimens = WidgetDimens(
            "match_parent",
            14
        ),
        topPadding = 100,
        bottomPadding = 100
    )
    ProgressBarWidget(progress = { 0.5f }, config = config)
}