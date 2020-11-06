package utc.thong.twowaydatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

private const val SCROLL_IS_AT_TOP = 0
class TwoWayLegalViewModel : ViewModel() {
    val scrollY: MutableLiveData<Int> = MutableLiveData()

    init {
        scrollY.postValue(SCROLL_IS_AT_TOP)
    }

    fun scrollIsAtTop(): LiveData<Boolean> {
        return Transformations.map(scrollY) {
            it == SCROLL_IS_AT_TOP
        }
    }

    fun scrollToTop() {
        scrollY.postValue(SCROLL_IS_AT_TOP)
    }
}