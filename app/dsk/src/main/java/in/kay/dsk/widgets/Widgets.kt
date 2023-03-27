package `in`.kay.dsk.widgets

sealed class Widgets(val widgetName:String) {
    object CurrentQuestionWidgetId : Widgets("cqWidget")
    object ProgressBarWidgetId : Widgets("pbWidget")
    object TextWidgetId : Widgets("textWidget")
    object EditTextWidgetId : Widgets("etWidget")
    object CtaButtonWidgetId : Widgets("ctaButtonWidget")
    object ImageWidgetId : Widgets("imgWidget")
    object OptionsWidgetId : Widgets("optionsWidget")
}