package `in`.kay.dynamicsurveykitapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.theme.colorBlue
import `in`.kay.dsk.theme.colorUnSelected
import `in`.kay.dsk.utils.Utils.toHex
import `in`.kay.dsk.widgets.EditTextWidget
import `in`.kay.dsk.widgets.EditTextWidgetConfig

@Composable
@Preview
fun EditTextWidgetImpl() {
    val config = EditTextWidgetConfig(
        widgetDimens = WidgetDimens("match_parent", height = 300),
        startPadding = 24,
        endPadding = 24,
        topPadding = 100,
        bottomPadding = 100,
        bgColor = colorUnSelected.toHex(),
        borderColor = colorBlue.toHex(),
        borderStroke = 4,
        textColor = "#000000",
    )
    EditTextWidget(config = config, errorString = {""}, userInput = {
        // Here we will get user input in this EditTextWidget
    })
}