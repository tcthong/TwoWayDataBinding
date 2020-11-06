package utc.thong.twowaydatabinding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _password: MutableLiveData<String> = MutableLiveData()
    val password: LiveData<String>
        get() {
            Log.d("ABC", "Password val: ${_password.value}")
            return _password
        }

    private val _wantToRedirectToOneWay: MutableLiveData<Boolean> = MutableLiveData()
    val wantToRedirectToOneWay: LiveData<Boolean>
        get() = _wantToRedirectToOneWay

    private val _wantToRedirectToTwoWay: MutableLiveData<Boolean> = MutableLiveData()
    val wantToRedirectToTwoWay: LiveData<Boolean>
        get() = _wantToRedirectToTwoWay

    val passwordQuality: LiveData<String>
        get() {
            Log.d("ABC", "get password quality")
            return Transformations
                .map(password) { pw ->
                    when {
                        pw.isNullOrBlank() -> " Enter a password"
                        pw == "password" -> "Very bad"
                        pw.length < 6 -> "Short"
                        else -> "Okay"
                    }
                }
        }

    fun passwordChanged(newPassW: CharSequence) {
        if (_password.value != newPassW.toString()) {
            Log.d("ABC", newPassW.toString())
            _password.postValue(newPassW.toString())
        }
    }

    fun validPassword(): LiveData<Boolean> {
        return Transformations.map(password) { pw ->
            when {
                pw.isNullOrBlank() || pw == "password" || pw.length < 6 -> false
                else -> true
            }
        }
    }

    fun redirectToOneWayActivity() {
        _wantToRedirectToOneWay.postValue(true)
    }

    fun redirectToTwoWayActivity() {
        _wantToRedirectToTwoWay.postValue(true)
    }
}