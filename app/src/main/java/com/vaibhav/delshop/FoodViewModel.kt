package com.vaibhav.delshop

import Dataclasses.Hit
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaibhav.delshop.dataClasses.Recipeclasses
import kotlinx.coroutines.launch
import retrofit2.Response

enum class MarsApiStatus { LOADING, ERROR, DONE }
class FoodViewModel : ViewModel() {

    private val _photolist = MutableLiveData<Response<Recipeclasses>>()
    val photolist: MutableLiveData<Response<Recipeclasses>> = _photolist
    private val _img = MutableLiveData<List<Hit>>()
    val img: MutableLiveData<List<Hit>> = _img
    private val app_key = "a7609c1788eea7eeda2a064c82b33149"
    private val app_id = "ae474d83"
    fun getPhoto(q: String) {
        viewModelScope.launch {
            val res = foodie.retrofitService.getreciepe(app_id, q, app_key)
            _photolist.value = res
            _img.value = res.body()?.hits
        }
    }
}

