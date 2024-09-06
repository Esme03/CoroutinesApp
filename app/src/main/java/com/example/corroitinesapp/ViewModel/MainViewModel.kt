package com.example.corroitinesapp.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    var resultState by mutableStateOf("")
     private set
    var countTime by mutableStateOf(0)
    private set
    var countTime2 by mutableStateOf(0)
    private set
     var time: Int by mutableStateOf(0)
    private set
    private var oneCount by mutableStateOf(false)

    private var job1:Job?= null
   private var job2: Job? = null
    fun fetchData (){
       val job1 = viewModelScope.launch {
            for ( i in 1.. 5 ){
                delay(1000)
                countTime =i
            }
           oneCount = true
           time =1
           fetchData2()

        }

        viewModelScope.launch {
            delay(5000)
            resultState ="Respuesta del servidor Web"
        }

    }
      fun fetchData2(){
         if (time==1){
             viewModelScope.launch {
                 for (i in 1..5){
                     delay(1000)
                     countTime2= i
                 }
                 resultState = "Respuesta del servidor Web"
             }

             }
         }
    fun cancelTimers (){
        job1?.cancel()
        job2?.cancel()

        countTime= 0
        countTime2= 0
        resultState= "Cronometros canceladaos"
    }
     }




/*
Thread trabja en el mismo contexto de la iu

    fun bloqueoApp (){
        Thread.sleep(5000)
        resultState = "Respusta del Servidor Web"
    } */
    /*
    fun fetchData(){
        viewModelScope.launch {
            delay(5000)
            resultState = "Respuesta desde el servidor web "
        }
    }

     */




