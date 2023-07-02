package `in`.kay.dsk.models


interface WidgetConfig {
    val widgetId:String
    val topPadding:Int
    val bottomPadding:Int
    val startPadding:Int
    val endPadding:Int
    val widgetDimens:WidgetDimens
}

data class WidgetDimens(
    val width : Any?,
    val height : Any?,
) {
    constructor(fillWidth: Boolean?=true,fillHeight:Boolean?=false) : this(if(fillWidth==true) "match_parent" else "wrap_content",null)
}