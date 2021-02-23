package com.example.sugarsyntaxkotlin.reified

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


inline fun <reified T : ViewModel> FragmentActivity.getViewModelUsingReified(string: String): T {
    return ViewModelProvider(this, MyCustomViewModelFactory(string)).get(T::class.java)
}

fun <T: ViewModel> FragmentActivity.getViewModel(string: String, viewModelClass: Class<T>): T {
    return ViewModelProvider(this, MyCustomViewModelFactory(string)).get(viewModelClass)
}