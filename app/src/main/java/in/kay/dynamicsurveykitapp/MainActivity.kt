package `in`.kay.dynamicsurveykitapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.kay.dsk.SurveyKit
import `in`.kay.dsk.models.TextConfig
import `in`.kay.dsk.models.WidgetConfig
import `in`.kay.dsk.theme.colorBlue
import `in`.kay.dsk.theme.colorUnSelectedArea
import `in`.kay.dsk.theme.colorUnSelectedText
import `in`.kay.dsk.theme.colorWhite
import `in`.kay.dsk.utils.Utils.toHex
import `in`.kay.dsk.widgets.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val widgetsList = getListFromDataSource()
            SurveyKit(widgetsList)
        }
    }

    private fun getListFromDataSource(): MutableList<List<WidgetConfig>> {
        val widgetList = mutableListOf<List<WidgetConfig>>()
        val list1 = mutableListOf<WidgetConfig>()
        val list2 = mutableListOf<WidgetConfig>()
        val list3 = mutableListOf<WidgetConfig>()
        list1.add(CurrentQuestionWidgetWidgetConfig())
        list1.add(ProgressBarWidgetConfig())
        list1.add(
            TextWidgetConfig(
                "In the above image, please tell what it is in less than 500 words?",
                modifier = Modifier.fillMaxWidth(),
                startPadding = 24,
                endPadding = 24,
                topPadding = 18
            )
        )
        list1.add(
            OptionsWidgetConfig(
                optionsList = listOf("Option 1", "Option 2", "Option 3", "Option 4"),
                multipleSelection = true,
                unSelectedButtonConfig = ButtonWidgetConfig(
                    startPadding = 24,
                    endPadding = 24,
                    topPadding = 22,
                    modifier = Modifier.fillMaxWidth(),
                    btnText = TextWidgetConfig(
                        text = "", textConfig = TextConfig(
                            colorUnSelectedText.toHex(), 16, "semiBold"
                        ),
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 4.dp)
                            .fillMaxWidth()
                    ),
                    bgColor = colorUnSelectedArea.toHex()
                ),
                selectedButtonConfig = ButtonWidgetConfig(
                    startPadding = 24,
                    endPadding = 24,
                    topPadding = 22,
                    modifier = Modifier.fillMaxWidth(),
                    btnText = TextWidgetConfig(
                        text = "", textConfig = TextConfig(
                            colorBlue.toHex(), 16, "semiBold"
                        ),
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 4.dp)
                            .fillMaxWidth()
                    ),
                    bgColor = colorWhite.toHex(),
                    borderStroke = 4,
                    borderColor = colorBlue.toHex()
                )
            )
        )
        list1.add(
            EditTextWidgetConfig(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp), startPadding = 24, endPadding = 24, topPadding = 23
            )
        )
        list1.add(
            ButtonWidgetConfig(
                startPadding = 24,
                endPadding = 24,
                topPadding = 48,
                bottomPadding = 32,
                modifier = Modifier.fillMaxWidth(),
                btnText = TextWidgetConfig(
                    text = "Next", textConfig = TextConfig(
                        colorWhite.toHex(), 16, "semiBold"
                    ),
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 4.dp)
                ),
                bgColor = colorBlue.toHex()
            )
        )
        list2.add(CurrentQuestionWidgetWidgetConfig())
        list2.add(ProgressBarWidgetConfig())
        list2.add(
            TextWidgetConfig(
                "Showing 'app' on Xiaomi 2201117PI.\n" + "Install successfully finished in 142 ms.?",
                modifier = Modifier.fillMaxWidth(),
                startPadding = 24,
                endPadding = 24,
                topPadding = 56
            )
        )
        list2.add(
            ImageWidgetConfig(
                imageUrl = "https://images.unsplash.com/photo-1574169208507-84376144848b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=879&q=80",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                startPadding = 24,
                endPadding = 24,
                topPadding = 24
            )
        )
        list2.add(
            OptionsWidgetConfig(
                optionsList = listOf("Option 1", "Option 2", "Option 3", "Option 4"),
                multipleSelection = false,
                unSelectedButtonConfig = ButtonWidgetConfig(
                    startPadding = 24,
                    endPadding = 24,
                    topPadding = 22,
                    modifier = Modifier.fillMaxWidth(),
                    btnText = TextWidgetConfig(
                        text = "", textConfig = TextConfig(
                            colorUnSelectedText.toHex(), 16, "semiBold"
                        ),
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 4.dp)
                            .fillMaxWidth()
                    ),
                    bgColor = colorUnSelectedArea.toHex()
                ),
                selectedButtonConfig = ButtonWidgetConfig(
                    startPadding = 24,
                    endPadding = 24,
                    topPadding = 22,
                    modifier = Modifier.fillMaxWidth(),
                    btnText = TextWidgetConfig(
                        text = "", textConfig = TextConfig(
                            colorBlue.toHex(), 16, "semiBold"
                        ),
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 4.dp)
                            .fillMaxWidth()
                    ),
                    bgColor = colorWhite.toHex(),
                    borderStroke = 4,
                    borderColor = colorBlue.toHex()
                )
            )
        )
        list2.add(
            ButtonWidgetConfig(
                startPadding = 24,
                endPadding = 24,
                topPadding = 48,
                bottomPadding = 48,
                modifier = Modifier.fillMaxWidth()
            )
        )


        list3.add(CurrentQuestionWidgetWidgetConfig())
        list3.add(ProgressBarWidgetConfig())
        list3.add(
            TextWidgetConfig(
                "In the above image, please tell what it is in less than 500 words?",
                modifier = Modifier.fillMaxWidth(),
                startPadding = 24,
                endPadding = 24,
                topPadding = 18
            )
        )
        list3.add(
            OptionsWidgetConfig(
                optionsList = listOf("Option 1", "Option 2", "Option 3", "Option 4"),
                multipleSelection = true,
                unSelectedButtonConfig = ButtonWidgetConfig(
                    startPadding = 24,
                    endPadding = 24,
                    topPadding = 22,
                    modifier = Modifier.fillMaxWidth(),
                    btnText = TextWidgetConfig(
                        text = "", textConfig = TextConfig(
                            colorUnSelectedText.toHex(), 16, "semiBold"
                        ),
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 4.dp)
                            .fillMaxWidth()
                    ),
                    bgColor = colorUnSelectedArea.toHex()
                ),
                selectedButtonConfig = ButtonWidgetConfig(
                    startPadding = 24,
                    endPadding = 24,
                    topPadding = 22,
                    modifier = Modifier.fillMaxWidth(),
                    btnText = TextWidgetConfig(
                        text = "", textConfig = TextConfig(
                            colorBlue.toHex(), 16, "semiBold"
                        ),
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 4.dp)
                            .fillMaxWidth()
                    ),
                    bgColor = colorWhite.toHex(),
                    borderStroke = 4,
                    borderColor = colorBlue.toHex()
                )
            )
        )
        list3.add(
            EditTextWidgetConfig(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp), startPadding = 24, endPadding = 24, topPadding = 23
            )
        )
        list3.add(
            ButtonWidgetConfig(
                startPadding = 24,
                endPadding = 24,
                topPadding = 48,
                bottomPadding = 32,
                modifier = Modifier.fillMaxWidth(),
                btnText = TextWidgetConfig(
                    text = "Next", textConfig = TextConfig(
                        colorWhite.toHex(), 16, "semiBold"
                    ),
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 4.dp)
                ),
                bgColor = colorBlue.toHex()
            )
        )
        widgetList.add(list1)
        widgetList.add(list2)
        widgetList.add(list3)
        return widgetList
    }
}
