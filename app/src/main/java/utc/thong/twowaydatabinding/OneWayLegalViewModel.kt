package utc.thong.twowaydatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

private const val SCROLL_IS_AT_TOP = 0
class OneWayLegalViewModel : ViewModel() {
    private val _scrollY: MutableLiveData<Int> = MutableLiveData()
    val scrollY: LiveData<Int>
        get() = _scrollY

    init {
        _scrollY.postValue(SCROLL_IS_AT_TOP)
    }

    fun scrollIsAtTop(): LiveData<Boolean> {
        return Transformations.map(_scrollY) {
            it == SCROLL_IS_AT_TOP
        }
    }

    fun scrollChange(newVal: Int) {
        if (scrollY.value != newVal) {
            _scrollY.postValue(newVal)
        }
    }

    fun scrollToTop() {
        _scrollY.postValue(SCROLL_IS_AT_TOP)
    }
}