package com.sajal.weatherapp.home.view


import android.Manifest
import android.Manifest.permission
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresPermission
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sajal.weatherapp.R
import com.sajal.weatherapp.base.viewmodel.DataResponse
import com.sajal.weatherapp.databinding.FragmentSimpleWeatherBinding
import com.sajal.weatherapp.home.model.WeatherDataModel
import com.sajal.weatherapp.home.vm.SimpleWeatherViewModel
import com.sajal.weatherapp.search.view.SearchActivity

class SimpleWeatherFragment : Fragment() {
    private lateinit var binding: FragmentSimpleWeatherBinding
    private var TAG = "SimpleWeatherFragment"

    companion object {
        fun newInstance() = SimpleWeatherFragment()
    }

    lateinit var locationManager: LocationManager
    private var locationByGps: Location? = null


    private lateinit var viewModel: SimpleWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSimpleWeatherBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    @RequiresPermission(anyOf = [permission.ACCESS_COARSE_LOCATION, permission.ACCESS_FINE_LOCATION])
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SimpleWeatherViewModel::class.java)
        locationManager =
            requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        if (hasGps) {
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(requireContext(), "Oops !!", Toast.LENGTH_SHORT).show()
                requireActivity().finish()
                return
            } else {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    5000L,
                    0F
                ) {
                    locationByGps = it
                    var text =
                        locationByGps?.latitude?.toString() + "" + locationByGps?.longitude.toString()
                    //binding.textTemp.text = text
                }
            }
        }
        val lastKnownLocationByGps =
            locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        lastKnownLocationByGps?.let {
            locationByGps = lastKnownLocationByGps
            var text =
                locationByGps?.latitude?.toString() + "" + locationByGps?.longitude.toString()
            Log.d(TAG, "onViewCreated: " + text)
        }

        viewModel.weatherDataModel.observe(
            viewLifecycleOwner,
            Observer<DataResponse<WeatherDataModel>> {
                Toast.makeText(
                    requireContext(),
                    "Great Success " + it.data?.main?.temp,
                    Toast.LENGTH_LONG
                ).show()
                when (it) {
                    is DataResponse.Success -> {
                        it.data?.let {
                            binding.weatherData = it
                        }
                    }

                    is DataResponse.Error -> {

                    }

                    is DataResponse.NoInternet -> {

                    }

                    is DataResponse.Loading -> {

                    }
                }
            })
        viewModel.getData(
            locationByGps?.latitude?.toString() ?: "17.43",
            locationByGps?.longitude.toString() ?: "8.36"
        )


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> openSearchActivity()
        }
        return super.onOptionsItemSelected(item)
    }

    private var searchLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                if (result.data != null) {
//                    val filter =
//                        result.data!!.getSerializableExtra(Constants.FILTER_DATA_OUTPUT) as NseBseFilter?

//            if(filter != null) {
//                mItem?.filter?.dFilterName = filter.filter.name
//                RecosHomeFilter.dFilterName = filter.filter.name
//                RecosHomeFilter.dFilterValues = filter.filterValue?: emptyList()
//                RecosHomeFilter.dFilterType = filter.filterType?:""
//                brFilterVM.filterChange.postValue(filter)
//            }
//            Log.d(TAG, "on activity result " + filter.toString())
////                onFilterApplied(filter!!)
                }
//        else {
//            Log.d(TAG, "on activity result the data is null")
//        }
            } else {
                Log.d(TAG, "activity result is cancled")
            }
        }

    private fun openSearchActivity() {
        searchLauncher.launch(Intent(requireContext(),SearchActivity::class.java))
    }
}