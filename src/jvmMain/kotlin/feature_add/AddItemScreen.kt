package core_data.feature_add

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun AddItemScreen(

) {
    var name by rememberSaveable { mutableStateOf("name" to "") }
    var quantity by rememberSaveable { mutableStateOf("quantity" to "") }
    var costPerOne by rememberSaveable { mutableStateOf("costPerOne" to 0) }
    var currency by rememberSaveable { mutableStateOf("currency" to "") }

    val values = listOf(
        name,
        quantity,
        costPerOne,
        currency
    )


    EnterFieldsScreen(values)

//    SingInSingUpFields(
//        email,
//        password,
//        onEmailChange = { email = it },
//        onPasswordChange = { password = it },
//        screenState = screenState,
//        onMainButtonClick = {
//            loginInteractor.login(email, password)
//        },
//        onChangeButtonClick = {
//            screenState = screenState.invert()
//            email = ""
//            password = ""
//        }
//    )
}