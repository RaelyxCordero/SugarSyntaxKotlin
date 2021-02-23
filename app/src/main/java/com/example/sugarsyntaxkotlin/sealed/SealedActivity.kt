package com.example.sugarsyntaxkotlin.sealed

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sugarsyntaxkotlin.R

class SealedActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sealed)
    }

    fun showMessageByButtonClicked(view: View){
        val message = getViewState((view as Button).text.toString()).messageByState()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, SealedActivity::class.java)
            context.startActivity(intent)
        }
    }
}