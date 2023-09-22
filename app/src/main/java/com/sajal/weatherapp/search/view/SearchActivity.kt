package com.sajal.weatherapp.search.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sajal.weatherapp.R
import com.sajal.weatherapp.base.viewmodel.DataResponse
import com.sajal.weatherapp.databinding.ActivitySearchBinding
import com.sajal.weatherapp.search.model.SearchModelItem
import com.sajal.weatherapp.search.vm.SearchViewModel

class SearchActivity : AppCompatActivity() {
    private lateinit var viewModel: SearchViewModel
    private  var binding: ActivitySearchBinding? = null
    private var placeList: ArrayList<SearchModelItem> = arrayListOf()
    private lateinit var arrayAdapter: ArrayAdapter<SearchModelItem>


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_search)

        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        arrayAdapter =
            ArrayAdapter<SearchModelItem>(this, android.R.layout.simple_list_item_2, placeList)

        binding?.listView?.adapter = arrayAdapter
        if (arrayAdapter.isEmpty) {


        }

        binding?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.getSearchQueryResult(query)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        viewModel.searchResult.observe(this) {
            when (it) {
                is DataResponse.Success -> {
                    it.data.let { searchModel -> placeList.clear()
                        searchModel?.map {
                            placeList.add(it)
                        }
                        arrayAdapter.notifyDataSetChanged()
                    }
                }

                else -> {

                }
            }
        }
    }


//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
//
//
//    }

}