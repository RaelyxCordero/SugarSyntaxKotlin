package com.example.sugarsyntaxkotlin.reified

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel

class MainViewModel(private val string: String): ViewModel() {
    fun usingStringInMainViewModel(context: Context){
        Toast.makeText(context,"printing the string: $string", Toast.LENGTH_SHORT).show()
    }
}
class SearchViewModel(private val string: String): ViewModel(){
    fun usingStringInSearchViewModel(context: Context){
        Toast.makeText(context,"printing the string: $string", Toast.LENGTH_SHORT).show()
    }
}
class TechSpecsViewModel(private val string: String): ViewModel(){
    fun usingStringInTechSpecsViewModel(context: Context){
        Toast.makeText(context,"printing the string: $string", Toast.LENGTH_SHORT).show()
    }
}