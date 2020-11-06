package utc.thong.twowaydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import utc.thong.twowaydatabinding.databinding.ActivityTwoWayBinding

class TwoWayLegalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityTwoWayBinding  = DataBindingUtil.setContentView(this, R.layout.activity_two_way)
        binding.viewModel = ViewModelProvider(this).get(TwoWayLegalViewModel::class.java)
        binding.lifecycleOwner = this
    }
}