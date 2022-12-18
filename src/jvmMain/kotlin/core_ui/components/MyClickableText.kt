package core_ui.components

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyClickableText(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) = ClickableText(
    modifier = modifier.offset(x = 16.dp, y = 24.dp),
    text = AnnotatedString(text),
    style = TextStyle(fontSize = 16.sp),
    onClick = {
        onClick()
    }
)
