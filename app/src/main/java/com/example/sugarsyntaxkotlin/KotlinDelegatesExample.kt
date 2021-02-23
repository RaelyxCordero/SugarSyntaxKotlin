package com.example.sugarsyntaxkotlin

import kotlin.reflect.*

class ReferencedProperty<T>(private val get: () -> T) {

    operator fun getValue(thisRef: Any?,
                          property: KProperty<*>): T = get()
}

fun <T> ref(property: KProperty0<T>) = ReferencedProperty(property::get)

interface ComponentInterface {

    val onNavigationClick: ((String) -> Unit)?

    var searchText: String
}

internal interface Navigable {

    val onNavigationClick: ((String) -> Unit)?
}