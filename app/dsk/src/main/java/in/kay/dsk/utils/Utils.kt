package `in`.kay.dsk.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import `in`.kay.dsk.models.WidgetDimens
import `in`.kay.dsk.models.toFontWeight
import `in`.kay.dsk.theme.getFontStyle
import `in`.kay.dsk.widgets.ButtonWidgetConfig
import `in`.kay.dsk.widgets.ImageWidgetConfig
import `in`.kay.dsk.widgets.TextWidgetConfig

object Utils {

    @Composable
    fun TextWidgetConfig.applyText() {
        text?.let { str ->
            Text(
                text = str, modifier = modifier
                    .setWidgetDimens(widgetDimens = this.widgetDimens)
                    .padding(
                        startPadding.toDp(),
                        topPadding.toDp(),
                        endPadding.toDp(),
                        bottomPadding.toDp()
                    ), style = getFontStyle(
                    textConfig.color.toColor(),
                    textConfig.fontWeight.toFontWeight(),
                    textConfig.fontSize.toSp()
                )
            )
        }
    }

    @Composable
    fun ImageWidgetConfig.loadImage() {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(imageUrl).crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .padding(
                    startPadding.toDp(), topPadding.toDp(), endPadding.toDp(), bottomPadding.toDp()
                )
                .clip(RoundedCornerShape(borderRadius.toDp()))
                .border(
                    borderStroke.toDp(),
                    (borderColor ?: "#000000").toColor(),
                    RoundedCornerShape(borderRadius.toDp())
                )
        )
    }

    @Composable
    fun ButtonWidgetConfig.setButton(onCtaClick: () -> Unit) {
        Button(
            onClick = { onCtaClick() },
            modifier = modifier
                .setWidgetDimens(widgetDimens)
                .padding(
                    startPadding.toDp(), topPadding.toDp(), endPadding.toDp(), bottomPadding.toDp()
                )
                .border(
                    borderStroke.toDp(),
                    borderColor.toColor(),
                    RoundedCornerShape(borderRadius.toDp())
                )
                .clip(RoundedCornerShape(borderRadius.toDp())),
            colors = ButtonDefaults.buttonColors(backgroundColor = bgColor.toColor())
        ) {
            btnText.applyText()
        }
    }

    fun Modifier.setWidgetDimens(
        widgetDimens: WidgetDimens,
    ) = composed(inspectorInfo = debugInspectorInfo {
        name = "setWidgetDimens"
    }) {
        then(
            run {
                when {
                    widgetDimens.fillWidth == true -> fillMaxWidth()
                    widgetDimens.width != null -> width(widgetDimens.width.toDp())
                    else -> wrapContentWidth()
                }
            }).then(
            run {
                when {
                    widgetDimens.fillHeight == true -> fillMaxHeight()
                    widgetDimens.height != null -> height(widgetDimens.height.toDp())
                    else -> wrapContentHeight()
                }
            }
        )
    }

    @Composable
    fun Int.toDp() = Dp(this@toDp.toFloat())

    @Composable
    fun Int.toSp() = with(LocalDensity.current) { Dp(this@toSp.toFloat()).toSp() }

    fun String.toast(context: Context) {
        Toast.makeText(context, this, Toast.LENGTH_LONG).show()
    }

    fun String.toColor(): Color {
        return Color(android.graphics.Color.parseColor(this))
    }

    fun Color.toHex(): String {
        return this.toArgb().hexToString()
    }

    private fun Int.hexToString() = String.format("#%06X", 0xFFFFFF and this)

}