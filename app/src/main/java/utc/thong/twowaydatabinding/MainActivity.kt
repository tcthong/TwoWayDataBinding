package utc.thong.twowaydatabinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import utc.thong.twowaydatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.wantToRedirectToOneWay.observe(this, Observer { wantToRedirectToOneWay ->
            if (wantToRedirectToOneWay) {
                startActivity(Intent(this, OneWayLegalActivity::class.java))
            }
        })

        viewModel.wantToRedirectToTwoWay.observe(this, Observer { wantToRedirectToTwoWay ->
            if (wantToRedirectToTwoWay) {
                startActivity(Intent(this, TwoWayLegalActivity::class.java))
            }
        })
    }
}