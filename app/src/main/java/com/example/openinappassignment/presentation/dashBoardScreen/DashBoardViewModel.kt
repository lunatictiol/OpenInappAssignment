package com.example.openinappassignment.presentation.dashBoardScreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openinappassignment.data.remote.Link
import com.example.openinappassignment.repository.DataRepository
import com.example.openinappassignment.utils.Resource
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class DashBoardViewModel (
   private val repository: DataRepository
):ViewModel(){
   val greetings  =  mutableStateOf<String>("")
   val topClicks= mutableStateOf<String>("")
    val topLocation = mutableStateOf<String>("")
    val topSource = mutableStateOf<String>("")
    val user  = mutableStateOf<String>("Ajay Manva")
    val mapString = mutableStateOf("")

    private val _Links = MutableLiveData<List<Link>>(listOf())
    val Links: MutableLiveData<List<Link>> get() = _Links

    init {
        getData()
        getGreetingMessage()


    }
    fun changeLinkstoRecent(){
        viewModelScope.launch {
            val result  = repository.getProducts()

            if (result is Resource.Success){

                _Links.value = result.data.data.recent_links


            }

        }
    }
    fun changeLinkstoTop(){
        viewModelScope.launch {
            val result  = repository.getProducts()

            if (result is Resource.Success){

                _Links.value = result.data.data.top_links


            }

        }
    }

    fun getData(){

        viewModelScope.launch {
           val result= repository.getProducts()
           if (result is Resource.Success){
               topClicks.value = result.data.today_clicks.toString()
               topLocation.value=result.data.top_location
               topSource.value = result.data.top_source
               _Links.value = result.data.data.top_links
               mapString.value = result.data.data.overall_url_chart.toString()
               Log.e("SSSS",mapString.toString())

           }


        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getGreetingMessage() {
        val currentTime = java.time.LocalTime.now().hour
         when (currentTime) {
            in 0..11 -> greetings.value="Good morning"
            in 12..17 -> greetings.value= "Good afternoon"
            else ->  greetings.value="Good evening"
        }
    }
}