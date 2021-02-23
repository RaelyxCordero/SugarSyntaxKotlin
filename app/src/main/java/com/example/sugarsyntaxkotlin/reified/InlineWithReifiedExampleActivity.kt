package com.example.sugarsyntaxkotlin.reified

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sugarsyntaxkotlin.DslActivity
import com.example.sugarsyntaxkotlin.R
import kotlinx.android.synthetic.main.activity_inline_with_reified_example.*

class InlineWithReifiedExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inline_with_reified_example)
    }

    override fun onResume() {
        super.onResume()
        main_view_model_action.setOnClickListener { mainViewModelExample() }
        search_view_model_action.setOnClickListener { searchViewModelExample() }
        techspecs_view_model_action.setOnClickListener { techSpecsModelExample() }
    }

    private fun mainViewModelExample(){
        val string = "blablabla"

        val mainViewModel = getViewModelUsingReified<MainViewModel>(string)
        val mainViewModel2: MainViewModel = getViewModelUsingReified(string)
        val mainViewModel3 = getViewModel(string, MainViewModel::class.java)

        mainViewModel.usingStringInMainViewModel(this)
    }

    private fun searchViewModelExample(){
        val string = "blebleble"

        val searchViewModel = getViewModelUsingReified<SearchViewModel>(string)
        val searchViewModel2: SearchViewModel = getViewModelUsingReified(string)
        val searchViewModel3 = getViewModel(string, SearchViewModel::class.java)

        searchViewModel.usingStringInSearchViewModel(this)
    }

    private fun techSpecsModelExample(){
        val string = "blobloblo"

        val techSpecsViewModel = getViewModelUsingReified<TechSpecsViewModel>(string)
        val techSpecsViewModel2: TechSpecsViewModel = getViewModelUsingReified(string)
        val techSpecsViewModel3 = getViewModel(string, TechSpecsViewModel::class.java)

        techSpecsViewModel.usingStringInTechSpecsViewModel(this)
    }

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, InlineWithReifiedExampleActivity::class.java)
            context.startActivity(intent)
        }
    }
}