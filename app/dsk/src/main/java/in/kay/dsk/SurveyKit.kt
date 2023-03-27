package `in`.kay.dsk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import `in`.kay.dsk.models.WidgetConfig
import `in`.kay.dsk.theme.colorWhite
import `in`.kay.dsk.widgets.*


@Composable
fun SurveyKit(widgetList: MutableList<List<WidgetConfig>>) {
    // currIdx is an Int representing the index of the current question in a survey.
    var currIdx by rememberSaveable {
        mutableStateOf(0)
    }
    // etInput is a String representing the user input in an EditText
    var etInput by rememberSaveable {
        mutableStateOf("")
    }
    // errorString is a String that stores any error messages generated during the user input validation process.
    var errorString by rememberSaveable {
        mutableStateOf("")
    }
    // currentQuestionNumber is an Int representing the current question number in the survey.
    var currentQuestionNumber by rememberSaveable {
        mutableStateOf(1)
    }
    LazyColumn(
        Modifier.fillMaxSize().background(colorWhite)
    ) {
        items(widgetList.getOrNull(currIdx) ?: emptyList()) { widget->
            when (widget.widgetId) {
                Widgets.CurrentQuestionWidgetId.widgetName -> CurrentQuestionWidget(
                    config = widget as CurrentQuestionWidgetWidgetConfig,
                    currentQuestion = { currentQuestionNumber },
                    totalQuestion =  widgetList.size)
                Widgets.ProgressBarWidgetId.widgetName -> ProgressBarWidget(
                    config = widget as ProgressBarWidgetConfig,
                    progress = { currentQuestionNumber/widgetList.size.toFloat() })
                Widgets.TextWidgetId.widgetName -> TextWidget(config = widget as TextWidgetConfig)
                Widgets.ImageWidgetId.widgetName -> ImageWidget(config = widget as ImageWidgetConfig)
                Widgets.EditTextWidgetId.widgetName -> EditTextWidget(
                    config = widget as EditTextWidgetConfig,
                    errorString = { errorString },
                    userInput = { str ->
                        etInput = str
                        errorString = ""
                    })
                Widgets.CtaButtonWidgetId.widgetName -> ButtonWidget(config = widget as ButtonWidgetConfig) {
                    if (etInput.isEmpty()) {
                        errorString = "Please, enter some answer"
                        return@ButtonWidget
                    }
                    etInput = ""
                    currentQuestionNumber++
                    if (currIdx != widgetList.size - 1) currIdx++
                }
                Widgets.OptionsWidgetId.widgetName -> OptionsWidget(config = widget as OptionsWidgetConfig) {

                }
            }
        }
    }
}