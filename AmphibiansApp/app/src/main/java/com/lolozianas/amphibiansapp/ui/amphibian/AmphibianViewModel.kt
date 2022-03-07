package com.lolozianas.amphibiansapp.ui.amphibian

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lolozianas.amphibiansapp.network.Amphibian
import com.lolozianas.amphibiansapp.network.AmphibianAPI
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that attached to the [AmphibianFragment]
 * */
class AmphibianViewModel : ViewModel() {

    /**
     * Create properties to represent MutableLiveData and LiveData  for the api statue
     * */
    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    /**
     * Create properties to represent MutableLiveData and LiveData for list of amphibian objects
     * */
    private val _amphibians = MutableLiveData<List<Amphibian>>()
    val amphibians: LiveData<List<Amphibian>> = _amphibians

    /**
     * Create properties to represent MutableLiveData and LiveData for list of amphibian objects
     * */
    private val _amphibian = MutableLiveData<Amphibian>()
    val amphibian: LiveData<Amphibian> = _amphibian

    init {
        getAmphibians()
    }
    /**
     * Gets amphibians information from the Amphibian API service
     * and updates amphibians MutableLiveData list
     * */

    private fun getAmphibians() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _status.value = ApiStatus.DONE
                _amphibians.value = AmphibianAPI.retrofitService.getAmphibians()
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _amphibians.value = listOf()
            }
        }
    }

    fun onAmphibianClicked(amphibian: Amphibian) {
        // Set the amphibian object
        _amphibian.value = amphibian
    }
}