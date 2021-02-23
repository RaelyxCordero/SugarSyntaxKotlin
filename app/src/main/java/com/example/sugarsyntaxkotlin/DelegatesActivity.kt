package com.example.sugarsyntaxkotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import java.lang.ref.WeakReference
import kotlin.properties.Delegates

class DelegatesActivity : AppCompatActivity(), ComponentInterface {

    private val navigable: Navigable = NavigableImpl(this)

    override val onNavigationClick: ((String) -> Unit)? by ref(navigable::onNavigationClick)

    override var searchText: String by Delegates.observable("initial search") {_ ,_ , value ->
        label.text = value
    }

    private var vetoableText: String by Delegates.vetoable("vetoable") { _, _, value ->
        value.length >= 8
    }

    lateinit var label: TextView
    lateinit var vetoableLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            verticalLayout {
                setMargins(24,24,24,24)
                label = label {
                    setMargins(8,8,8,8)
                    text = searchText
                }
                vetoableLabel = label {
                    setMargins(8,8,8,8)
                    text = vetoableText
                }
                editText {
                    setMargins(8,8,8,8)
                    doAfterTextChanged {
                        it.toString().let { text ->
                            searchText = text
                            vetoableText = text
                            vetoableLabel.text = vetoableText
                        }
                    }
                }
                button {
                    setMargins(8,8,8,8)
                    text = "Navegar!"
                    onClick {
                        onNavigationClick?.invoke(searchText)
                    }
                }
            }
        )
    }

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, DelegatesActivity::class.java)
            context.startActivity(intent)
        }
    }
}

class NavigableImpl(context: Context): Navigable {
    private val weakContext: WeakReference<Context> = WeakReference(context)
    override val onNavigationClick: ((String) -> Unit)?  by lazy {
         val onClick: (String) -> Unit = {
             Toast.makeText(weakContext.get(), "Click on Navigable Impl with value : $it", Toast.LENGTH_SHORT).show()
         }
        onClick
    }
}