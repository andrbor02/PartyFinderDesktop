package feature_authorization.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow

class LoginInteractor {
    private val scope = CoroutineScope(Job())

    val isSignedIn = MutableStateFlow<Boolean>(false)

    fun login(email: String, password: String) {
//        scope.launch {
//            if (email.isBlank())
//
//        }
    }
}