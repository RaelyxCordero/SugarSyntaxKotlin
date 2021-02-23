package com.example.sugarsyntaxkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sugarsyntaxkotlin.delegates.DelegatesActivity
import com.example.sugarsyntaxkotlin.dsl.*
import com.example.sugarsyntaxkotlin.reified.InlineWithReifiedExampleActivity
import com.example.sugarsyntaxkotlin.sealed.SealedActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            verticalLayout {
                button {
                    setMargins(24, 24, 24, 0)
                    text = "Sealed Classes"
                    onClick {
                        SealedActivity.launch(this@MainActivity)
                    }
                }

                button {
                    setMargins(24, 24, 24, 0)
                    text = "Inline and Reified"
                    onClick {
                        InlineWithReifiedExampleActivity.launch(this@MainActivity)
                    }
                }

                button {
                    setMargins(24, 24, 24, 0)
                    text = "DSL"
                    onClick {
                        DslActivity.launch(this@MainActivity)
                    }
                }

                button {
                    setMargins(24, 24, 24, 0)
                    text = "Delegates"
                    onClick {
                        DelegatesActivity.launch(this@MainActivity)
                    }
                }
            })
    }
}