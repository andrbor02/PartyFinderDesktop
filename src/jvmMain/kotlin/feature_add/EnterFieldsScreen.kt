package core_data.feature_add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import core_ui.components.MyButtonWithText
import core_ui.components.MyOutlinedTextField

@Composable
fun EnterFieldsScreen(
    list: List<Pair<Comparable<*>, Comparable<*>>>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(2f)
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (element in list) {
            MyOutlinedTextField(
                value = element.second.toString(),
                label = element.first.toString(),
                onValueChange = {

                }
            )
        }

        MyButtonWithText(
            buttonText = "Add",
            onClick = {

            }
        )
    }
}