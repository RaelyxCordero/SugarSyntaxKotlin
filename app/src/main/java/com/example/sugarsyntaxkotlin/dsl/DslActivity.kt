package com.example.sugarsyntaxkotlin.dsl

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class DslActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            verticalLayout {
                setMargins(24, 24,24,0)

                label {
                    text = "Hola Mundo"
                    setPadding(8,0,8,0)
                }

                button {
                    text = "Clickeame!"
                    setPadding(0,16,0,0)
                    onClick {
                        Toast.makeText(this@DslActivity, "Hola!" , Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )
    }

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, DslActivity::class.java)
            context.startActivity(intent)
        }
    }
}