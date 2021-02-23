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
import androidx.appcompat.widget.AppCompatEditText

class VerticalLayout(context: Context) : LinearLayout(context) {
    init {
        layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        orientation = VERTICAL
    }
}

infix fun AppCompatActivity.verticalLayout(block: VerticalLayout.() -> Unit): VerticalLayout =
    VerticalLayout(this).apply(block)

infix fun ViewGroup.label(block: TextView.() -> Unit): TextView = TextView(context)
    .apply {
        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    }
    .apply(block)
    .also { addView(it) }

infix fun ViewGroup.editText(block: AppCompatEditText.() -> Unit) = AppCompatEditText(context)
    .apply {
        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    }
    .apply(block)
    .also { addView(it) }

infix fun ViewGroup.button(block: AppCompatButton.() -> Unit): AppCompatButton =
    AppCompatButton(context)
        .apply {
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        }
        .apply(block)
        .also { addView(it) }

fun View.setMargins(left: Int, top: Int, right: Int, bottom: Int) {
    val newLayoutParams = layoutParams.apply {
        if (this is ViewGroup.MarginLayoutParams) {
            bottomMargin = bottom
            topMargin = top
            rightMargin = right
            leftMargin = left
        }
    }
    layoutParams = newLayoutParams
}

fun View.onClick(block: (View) -> Unit) = setOnClickListener(block)