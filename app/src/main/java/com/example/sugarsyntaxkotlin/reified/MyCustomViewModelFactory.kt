package com.example.sugarsyntaxkotlin.reified

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyCustomViewModelFactory(private val myString :String) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return when (modelClass) {
            MainViewModel::class.java -> MainViewModel(myString)
            SearchViewModel::class.java -> SearchViewModel(myString)
            TechSpecsViewModel::class.java -> TechSpecsViewModel(myString)
            else -> throw ClassNotFoundException(
                "You should register your ViewModel here so" +
                        " as to create it"
            )
        } as T
    }
}
