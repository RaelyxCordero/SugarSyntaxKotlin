package com.example.sugarsyntaxkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(verticalLayout {
            button {
                setMargins(24,24,24, 0)
                text = "Sealed Classes"
                onClick {

                }
            }

            button {
                setMargins(24,24,24, 0)
                text = "Inline and Reified"
                onClick {

                }
            }

            button {
                setMargins(24,24,24, 0)
                text = "DSL"
                onClick {
                    DslActivity.launch(this@MainActivity)
                }
            }

            button {
                setMargins(24,24,24, 0)
                text = "Delegates"
                onClick {

                }
            }
        })
    }
}