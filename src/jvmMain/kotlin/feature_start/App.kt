package feature_start

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import feature_authorization.domain.LoginInteractor
import feature_authorization.presentation.AuthorizationScreen

@Preview
@Composable
fun App() {
    var shouldShowStartScreen by remember { mutableStateOf(true) }

    if (shouldShowStartScreen) {
        StartScreen(onContinueClicked = { shouldShowStartScreen = false })
    } else {
        AuthorizationScreen(loginInteractor = LoginInteractor())
    }
}