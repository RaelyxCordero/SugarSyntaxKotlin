package com.example.sugarsyntaxkotlin

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

infix fun AppCompatActivity.verticalLayout(block: VerticalLayout.() -> Unit): VerticalLayout = VerticalLayout(this).apply(block)

class VerticalLayout(context: Context): LinearLayout(context) {
    init {
        layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        orientation = VERTICAL
    }

    fun setMargins(left: Int, top: Int, right: Int,bottom: Int) {
        val newLayoutParams = layoutParams.apply {
            if(this is MarginLayoutParams) {
                bottomMargin = bottom
                topMargin = top
                rightMargin = right
                leftMargin = left
            }
        }
        layoutParams = newLayoutParams
    }
}

infix fun ViewGroup.label(block: TextView.() -> Unit): TextView = TextView(context).apply(block).also {
    addView(it)
}

infix fun ViewGroup.button(block: DSLButton.() -> Unit): DSLButton = DSLButton(context).apply(block).also {
    addView(it)
}

class DSLButton(context: Context): AppCompatButton(context) {
    init {
        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    }

    infix fun onClick(block: (View) -> Unit) {
        setOnClickListener(block)
    }

    fun setMargins(left: Int, top: Int, right: Int,bottom: Int) {
        val newLayoutParams = layoutParams.apply {
            if(this is ViewGroup.MarginLayoutParams) {
                bottomMargin = bottom
                topMargin = top
                rightMargin = right
                leftMargin = left
            }
        }
        layoutParams = newLayoutParams
    }
}