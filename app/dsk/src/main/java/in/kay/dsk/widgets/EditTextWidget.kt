package `in`.kay.dsk.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import `in`.kay.dsk.models.TextConfig
import `in`.kay.dsk.models.WidgetConfig
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.theme.colorBlack
import `in`.kay.dsk.theme.colorUnSelected
import `in`.kay.dsk.theme.colorUnSelectedText
import `in`.kay.dsk.utils.Utils.applyText
import `in`.kay.dsk.utils.Utils.setWidgetDimens
import `in`.kay.dsk.utils.Utils.toColor
import `in`.kay.dsk.utils.Utils.toDp
import `in`.kay.dsk.utils.Utils.toHex

@Composable
fun EditTextWidget(
    config: EditTextWidgetConfig,
    userInput: (String) -> Unit={},
    errorString: () -> String
) {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    config.apply {
        TextField(
            value = text,
            onValueChange = {
                text = it
                userInput(it)
            },
            placeholder = {
                Box(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.align(Alignment.Center)) {
                        if(errorString().isBlank()) hintTextConfig.applyText()
                        else {
                            val textConfig = hintTextConfig.textConfig.copy(color = Color.Red.toHex())
                            val newHintConfig = hintTextConfig.copy(text = errorString(), textConfig = textConfig)
                            newHintConfig.applyText()
                        }
                    }
                }
            }, modifier = modifier
                .setWidgetDimens(widgetDimens = widgetDimens)
                .padding(
                    startPadding.toDp(), topPadding.toDp(), endPadding.toDp(), bottomPadding.toDp()
                )
                .clip(RoundedCornerShape(borderRadius.toDp()))
                .border(
                    borderStroke.toDp(),
                    color = if(errorString().isEmpty()) borderColor.toColor() else Color.Red,
                    RoundedCornerShape(borderRadius.toDp())
                ), colors = TextFieldDefaults.textFieldColors(
                textColor = textColor.toColor(),
                disabledTextColor = Color.Transparent,
                backgroundColor = bgColor.toColor(),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

data class EditTextWidgetConfig(
    val modifier: Modifier = Modifier,
    val bgColor: String = colorUnSelected.toHex(),
    val borderColor: String = colorBlack.toHex(),
    val borderStroke: Int = 2,
    val textColor: String = "#000000",
    override val widgetDimens: WidgetDimens = WidgetDimens(
        height = null,
        width = null
    ),
    val hintTextConfig: TextWidgetConfig = TextWidgetConfig(
        text = "enter your answer here...", textConfig = TextConfig(
            colorUnSelectedText.toHex(), 16, "light"
        )
    ),
    val borderRadius: Int = 16,
    override val widgetId: String = Widgets.EditTextWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0
) : WidgetConfig