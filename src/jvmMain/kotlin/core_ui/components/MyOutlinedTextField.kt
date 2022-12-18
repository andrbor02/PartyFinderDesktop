package core_ui.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun MyOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String = "",
    label: String,
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None
) = OutlinedTextField(
        modifier = modifier,
        value = value,
        placeholder = { Text(text = placeholder) },
        label = { Text(text = label) },
        isError = isError,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,

        singleLine = true
    )