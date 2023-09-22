package com.sajal.weatherapp.base.view


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sajal.weatherapp.R
import com.sajal.weatherapp.base.viewmodel.FragmentContainerVM
import com.sajal.weatherapp.databinding.ActivityFragmentContainerBinding
import com.sajal.weatherapp.home.view.SimpleWeatherFragment


class FragmentContainerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentContainerBinding
    private val TAG = "ContainerActivity"
    private lateinit var viewModel: FragmentContainerVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_fragment_container)
        setSupportActionBar(binding.toolbar)
        launchNewsFragment()
    }

    private fun launchNewsFragment() {
        val swf = SimpleWeatherFragment.newInstance()
        val tagName = swf.javaClass.getName()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, swf, tagName)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}