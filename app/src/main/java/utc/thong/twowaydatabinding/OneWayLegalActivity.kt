package utc.thong.twowaydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import utc.thong.twowaydatabinding.databinding.ActivityOneWayBinding

class OneWayLegalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityOneWayBinding  = DataBindingUtil.setContentView(this, R.layout.activity_one_way)
        binding.legalModel = ViewModelProvider(this).get(OneWayLegalViewModel::class.java)
        binding.lifecycleOwner = this
    }
}