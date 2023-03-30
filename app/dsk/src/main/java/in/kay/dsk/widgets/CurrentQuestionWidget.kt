package `in`.kay.dsk.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.kay.dsk.models.TextConfig
import `in`.kay.dsk.models.WidgetConfig
import `in`.kay.dsk.theme.colorUnSelectedText
import `in`.kay.dsk.utils.Utils.applyText
import `in`.kay.dsk.utils.Utils.toDp
import `in`.kay.dsk.utils.Utils.toHex

@Composable
fun CurrentQuestionWidget(
    config: CurrentQuestionWidgetWidgetConfig,
    currentQuestion: () -> Int,
    totalQuestion:Int,
) {
    config.apply {
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(
                        start = startPadding.toDp(),
                        top = topPadding.toDp(),
                        end = endPadding.toDp(),
                        bottom = bottomPadding.toDp()
                    ),
                horizontalArrangement = Arrangement.Center
            ) {
                val prefixText = TextWidgetConfig(text = "$prefixText ${currentQuestion()}", modifier = Modifier.alignByBaseline(), textConfig = primaryTextConfig)
                val suffixText = TextWidgetConfig(text = "of ${totalQuestion}", modifier = Modifier.alignByBaseline(), textConfig = secondaryTextConfig)
                prefixText.applyText()
                Spacer(modifier = Modifier.width(5.dp))
                suffixText.applyText()
            }
        }
    }
}

data class CurrentQuestionWidgetWidgetConfig(
    val prefixText: String = "Question",
    val primaryTextConfig: TextConfig = TextConfig(),
    val secondaryTextConfig: TextConfig = TextConfig(colorUnSelectedText.toHex(),16, "light"),
    override val widgetId: String = Widgets.CurrentQuestionWidgetId.widgetName,
    override val topPadding:Int = 16,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 16,
    override val endPadding: Int = 16
) : WidgetConfig