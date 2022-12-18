package feature_authorization.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import core_ui.components.MyButtonWithText
import core_ui.components.MyClickableText
import core_ui.components.MyOutlinedTextField

@Composable
fun SingInSingUpFields(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    screenState: AuthorizationScreenState,
    onMainButtonClick: () -> Unit,
    onChangeButtonClick: () -> Unit
) {

    val (titleText, buttonText, changeScreenText) = when (screenState) {
        AuthorizationScreenState.SIGN_IN -> arrayOf("Вход", "Войти", "Нет аккаунта? Зарегистрируйтесь")
        AuthorizationScreenState.SIGN_UP -> arrayOf("Регистрация", "Зарегистрироваться", "Есть аккаунт? Войдите")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(titleText)

        MyOutlinedTextField(
            value = email,
            placeholder = "user@email.com",
            label = "email",
            onValueChange = onEmailChange,
            modifier = Modifier.focusOrder(FocusRequester.Default)
        )

        MyOutlinedTextField(
            value = password,
            placeholder = "password",
            label = "password",
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation()
        )

        MyButtonWithText(
            buttonText = buttonText,
            onClick = onMainButtonClick
        )

        MyClickableText(
            modifier = Modifier,
            text = changeScreenText,
            onClick = onChangeButtonClick
        )
    }
}