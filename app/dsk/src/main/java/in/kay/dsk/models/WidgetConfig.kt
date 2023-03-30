package `in`.kay.dsk.models


interface WidgetConfig {
    val widgetId:String
    val topPadding:Int
    val bottomPadding:Int
    val startPadding:Int
    val endPadding:Int
}

data class WidgetDimens(
    val fillWidth:Boolean?,
    val fillHeight:Boolean?,
    val width : Int?,
    val height : Int?,
) {
    constructor(fillWidth: Boolean?) : this(fillWidth,null,null,null)

}