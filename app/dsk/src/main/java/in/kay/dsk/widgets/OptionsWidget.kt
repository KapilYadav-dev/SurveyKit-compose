package `in`.kay.dsk.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.kay.dsk.models.WidgetConfig
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.utils.Utils.setButton
import `in`.kay.dsk.utils.Utils.setWidgetDimens
import `in`.kay.dsk.utils.Utils.toDp

@Composable
fun OptionsWidget(config: OptionsWidgetConfig, selectedOptionsList: (List<String>) -> Unit) {
    // This is used to save the selected non selected items
    val optionsPairList = remember {
        mutableStateListOf<Pair<String, Boolean>>()
    }
    val localSelectedOptionList = mutableListOf<String>()
    // This is the var used to store last selectedIndex in case of single selection
    var currentSelectedIndex: Int? = null

    config.optionsList.forEach {
        optionsPairList.add(Pair(it, false))
    }
    config.apply {
        LazyColumn(
            Modifier
                .setWidgetDimens(widgetDimens)
                .padding(
                    startPadding.toDp(),
                    topPadding.toDp(),
                    endPadding.toDp(),
                    bottomPadding.toDp()
                )
        ) {
            itemsIndexed(optionsPairList) { idx, pair ->
                // Update the state based on the current option selection
                if (pair.second) {
                    // The current option is already selected
                    // Build a new button configuration with the selectedButtonConfig and set the text to the current option
                    val newTextConfig = selectedButtonConfig.btnText.copy(text = pair.first)
                    val newSelectedButtonConfig = selectedButtonConfig.copy(btnText = newTextConfig)
                    // Call setButton on the new configuration object
                    newSelectedButtonConfig.setButton {
                        // If multiple selection is allowed, unselect the current option
                        if (multipleSelection) {
                            optionsPairList[idx] = Pair(optionsPairList[idx].first, false)
                            optionsPairList.forEach {
                                if (it.second) {
                                    localSelectedOptionList.add(it.first)
                                }
                            }
                            if (localSelectedOptionList.isNotEmpty()) {
                                selectedOptionsList(localSelectedOptionList)
                                localSelectedOptionList.clear()
                            }
                        }
                    }
                } else {
                    // The current option is not selected
                    // Build a new button configuration with the unSelectedButtonConfig and set the text to the current option
                    val newTextConfig = unSelectedButtonConfig.btnText.copy(text = pair.first)
                    val newUnSelectedButtonConfig =
                        unSelectedButtonConfig.copy(btnText = newTextConfig)
                    // Call setButton on the new configuration object
                    newUnSelectedButtonConfig.setButton {
                        // If multiple selection is not allowed and there is a previously selected option, unselect it
                        if (!multipleSelection && currentSelectedIndex != null) optionsPairList[currentSelectedIndex!!] =
                            Pair(optionsPairList[currentSelectedIndex!!].first, false)
                        // Select the current option and update the currentSelectedIndex
                        optionsPairList[idx] = Pair(pair.first, true)
                        currentSelectedIndex = idx

                        optionsPairList.forEach {
                            if (it.second) {
                                localSelectedOptionList.add(it.first)
                            }
                        }
                        if (localSelectedOptionList.isNotEmpty()) {
                            selectedOptionsList(localSelectedOptionList)
                            localSelectedOptionList.clear()
                        }
                    }
                }
            }
        }
    }
}

/*
The OptionsWidgetConfig is a data class that holds configuration options for building the widget. It has the following properties:
 */
data class OptionsWidgetConfig(
    //optionsList: a list of strings representing the options that will be displayed in the buttons.
    val optionsList: List<String>,
    // selectedButtonConfig: a ButtonWidgetConfig representing the configuration for the selected state of the button.
    val selectedButtonConfig: ButtonWidgetConfig,
    // unSelectedButtonConfig: a ButtonWidgetConfig representing the configuration for the unselected state of the button.
    val unSelectedButtonConfig: ButtonWidgetConfig,
    // multipleSelection: a Boolean indicating whether multiple options can be selected at once.
    val multipleSelection: Boolean,
    //widgetId, topPadding, bottomPadding, startPadding, and endPadding are optional parameters that are used for styling the widget.
    override val widgetId: String = Widgets.OptionsWidgetId.widgetName,
    override val topPadding: Int = 0,
    override val bottomPadding: Int = 0,
    override val startPadding: Int = 0,
    override val endPadding: Int = 0,
    override val widgetDimens: WidgetDimens = WidgetDimens(
        true,
        null, null, 320
    ),
) : WidgetConfig
