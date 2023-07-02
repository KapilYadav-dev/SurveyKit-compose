package `in`.kay.dynamicsurveykitapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import `in`.kay.dsk.models.TextConfig
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.theme.colorBlue
import `in`.kay.dsk.theme.colorUnSelectedArea
import `in`.kay.dsk.theme.colorUnSelectedText
import `in`.kay.dsk.theme.colorWhite
import `in`.kay.dsk.utils.Utils.toHex
import `in`.kay.dsk.widgets.ButtonWidgetConfig
import `in`.kay.dsk.widgets.OptionsWidget
import `in`.kay.dsk.widgets.OptionsWidgetConfig
import `in`.kay.dsk.widgets.TextWidgetConfig

@Composable
@Preview
fun OptionsWidgetImpl() {
    val config = OptionsWidgetConfig(
        optionsList = listOf("Option1", "Option2", "Option3"),
        unSelectedButtonConfig = ButtonWidgetConfig(
            startPadding = 24,
            endPadding = 24,
            topPadding = 22,
            widgetDimens = WidgetDimens(true),
            btnText = TextWidgetConfig(
                text = "", textConfig = TextConfig(
                    colorUnSelectedText.toHex(), 16, "semiBold"
                ),
                startPadding = 4,
                endPadding = 4,
                topPadding = 12,
                bottomPadding = 12,
                widgetDimens = WidgetDimens(true)
            ),
            bgColor = colorUnSelectedArea.toHex()
        ),
        selectedButtonConfig = ButtonWidgetConfig(
            startPadding = 24,
            endPadding = 24,
            topPadding = 22,
            widgetDimens = WidgetDimens(true),
            btnText = TextWidgetConfig(
                text = "",
                textConfig = TextConfig(
                    colorBlue.toHex(), 16, "semiBold"
                ),
                startPadding = 4,
                endPadding = 4,
                topPadding = 12,
                bottomPadding = 12,
                widgetDimens = WidgetDimens(true)
            ),
            bgColor = colorWhite.toHex(),
            borderStroke = 4,
            borderColor = colorBlue.toHex()
        ),
        widgetDimens = WidgetDimens("match_parent", height = 400),
        startPadding = 24,
        endPadding = 24,
        topPadding = 10,
        bottomPadding = 10,
        multipleSelection = true,
    )
    OptionsWidget(config = config) {
        // Here we'll get the list of string
    }
}