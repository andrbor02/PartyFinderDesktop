package core_ui.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier


@Composable
fun MyButtonWithText(
    modifier: Modifier = Modifier,
    buttonText: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = {
            var enabled by remember { mutableStateOf(true) }
            if (enabled) {
                enabled = false
            }

            onClick()
        }
    ) {
        Text(buttonText)
    }
}