package utc.thong.twowaydatabinding

import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ScrollView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

//One way data binding
//@RequiresApi(Build.VERSION_CODES.M)
//@BindingAdapter("onScrollChange")
//fun ScrollView.setOnScrollChange(listener: View.OnScrollChangeListener?) {
//    listener?.let {
//        setOnScrollChangeListener(it)
//    }
//}

@InverseBindingAdapter(attribute = "android:scrollY")
fun ScrollView.getScrollY(): Int {
    return scrollY
}

@RequiresApi(Build.VERSION_CODES.M)
@BindingAdapter(value = ["onScrollChange", "android:scrollYAttrChanged"], requireAll = false)
fun ScrollView.setOnScrollChange(scrollChange: View.OnScrollChangeListener?, scrollYAttrChanged: InverseBindingListener?) {

    scrollYAttrChanged?.let {
        setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            scrollChange?.onScrollChange(v, scrollX, scrollY, oldScrollX, oldScrollY)
            it.onChange()
        }
    } ?: setOnScrollChangeListener(scrollChange)
}

@BindingAdapter("onTextChanged")
fun EditText.setOnTextChanged(listener: OnTextChanged?) {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            listener?.onTextChanged(s)
        }

        override fun afterTextChanged(s: Editable?) {

        }
    })
}

interface OnTextChanged {
    fun onTextChanged(s: CharSequence?)
}