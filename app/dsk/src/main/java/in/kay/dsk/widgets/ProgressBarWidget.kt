package `in`.kay.dsk.widgets

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.kay.dsk.models.WidgetConfig
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.theme.colorBlue
import `in`.kay.dsk.theme.colorLightBlue
import `in`.kay.dsk.utils.Utils.setWidgetDimens
import `in`.kay.dsk.utils.Utils.toColor
import `in`.kay.dsk.utils.Utils.toDp
import `in`.kay.dsk.utils.Utils.toHex

@Composable
@Preview
fun ProgressBarWidget(
    progress: () -> Float = { 0.1f },
    config: ProgressBarWidgetConfig = ProgressBarWidgetConfig(),
) {
    val animatedProgress = animateFloatAsState(
        targetValue = progress(),
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    config.apply {
        LinearProgressIndicator(
            progress = animatedProgress, modifier = Modifier
                .padding(startPadding.toDp(), topPadding.toDp(), endPadding.toDp(), bottomPadding.toDp())
                .setWidgetDimens(widgetDimens)
                .clip(
                    RoundedCornerShape(12.dp)
                ),
            color = progressColor.toColor(),
            backgroundColor = bgColor.toColor()
        )
    }
}

data class ProgressBarWidgetConfig(
    val progressColor: String = colorBlue.toHex(),
    val bgColor: String = colorLightBlue.toHex(),
    val widgetDimens: WidgetDimens = WidgetDimens(
        fillWidth = true,
        fillHeight = null,
        height = 12,
        width = null
    ),
    override val widgetId: String = Widgets.ProgressBarWidgetId.widgetName,
    override val topPadding: Int = 22,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 20,
    override val endPadding: Int = 20
) : WidgetConfig