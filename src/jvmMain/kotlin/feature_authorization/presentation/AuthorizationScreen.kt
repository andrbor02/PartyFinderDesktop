package feature_authorization.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import feature_authorization.domain.LoginInteractor

@Composable
fun AuthorizationScreen(
    loginInteractor: LoginInteractor
) = MaterialTheme {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var screenState by rememberSaveable { mutableStateOf(AuthorizationScreenState.SIGN_UP) }

    SingInSingUpFields(
        email,
        password,
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        screenState = screenState,
        onMainButtonClick = {
            if (email.isBlank()) {
                //todo show error on email text field
            } else if (password.isBlank()) {
                //todo show error on password text field
            } else {
                loginInteractor.login(email, password)
            }
        },
        onChangeButtonClick = {
            screenState = screenState.invert()
            email = ""
            password = ""
        }
    )
}

enum class AuthorizationScreenState {
    SIGN_IN,
    SIGN_UP;

    fun invert(): AuthorizationScreenState {
        return if (this == SIGN_IN)
            SIGN_UP
        else if (this == SIGN_UP)
            SIGN_IN
        else
            throw IllegalStateException("No such state in AuthorizationScreenState")
    }
}