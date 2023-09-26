package com.sajal.weatherapp.search.view

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.os.IBinder
import android.os.PersistableBundle
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sajal.weatherapp.R
import com.sajal.weatherapp.base.BaseConstants
import com.sajal.weatherapp.base.viewmodel.DataResponse
import com.sajal.weatherapp.databinding.ActivitySearchBinding
import com.sajal.weatherapp.search.model.SearchModelItem
import com.sajal.weatherapp.search.vm.SearchViewModel



class SearchActivity : AppCompatActivity() {
    private lateinit var viewModel: SearchViewModel
    private  var binding: ActivitySearchBinding? = null
    private var placeList: ArrayList<SearchModelItem> = arrayListOf()
    private var arrayOfSearchText: ArrayList<String> = arrayListOf()
    private lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_search)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        arrayAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayOfSearchText)

        binding?.listView?.adapter = arrayAdapter
        binding?.listView?.setOnItemClickListener { parent, view, position, id ->
            val myResultIntent = Intent().apply {
                putExtra(BaseConstants.LAT_EXTRA, placeList.get(position).lat)
                putExtra(BaseConstants.LONG_EXTRA, placeList.get(position).lon)
            }
            setResult(RESULT_OK, myResultIntent)
            finish()
        }
        binding?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.getSearchQueryResult(query)
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("sajal", "onQueryTextChange: "+newText)
                return false
            }
        })
        viewModel.searchResult.observe(this) {
            when (it) {
                is DataResponse.Success -> {
                    it.data.let { searchModel -> arrayOfSearchText.clear()
                        placeList.clear()
                        searchModel?.map {
                            arrayOfSearchText.add(it.name!!)
                            placeList.add(it)
                        }
                        arrayAdapter.notifyDataSetChanged()
                    }
                } else -> {

                }
            }
        }
    }
    fun processResult(result: Result) {
        when (result) {
            is Result.Success -> {
                // Access the 'data' property of the Success instance
                val dataValue = result.data
                println("Success: $dataValue")
            }
            is Result.Error -> {
                // Access the 'message' property of the Error instance
                val errorMessage = result.message
                println("Error: $errorMessage")
            }
            else -> {

            }
        }
    }

    sealed class Result {
        data class Success(val data: String) : Result()
        data class Error(val message: String) : Result()

    }

    class MyService : Service() {

        private val binder = MyBinder()

        override fun onBind(intent: Intent): IBinder {
            return binder
        }

        inner class MyBinder : Binder() {
            fun getService(): MyService = this@MyService
        }
    }

}