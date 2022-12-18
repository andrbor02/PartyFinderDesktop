package core_data.feature_add

//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import core_ui.components.MyOutlinedTextField
//import feature_authorization.presentation.AuthorizationScreenState
//import feature_authorization.presentation.SingInSingUpFields
//
//@Composable
//fun AddEventScreen(
//
//) {
//    var email by rememberSaveable { mutableStateOf("") }
//    var password by rememberSaveable { mutableStateOf("") }
//    var screenState by rememberSaveable { mutableStateOf(AuthorizationScreenState.SIGN_UP) }
//
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
//    MyOutlinedTextField(
//
//    )
//}