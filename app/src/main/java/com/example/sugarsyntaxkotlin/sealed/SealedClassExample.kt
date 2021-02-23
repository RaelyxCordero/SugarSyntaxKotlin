package com.example.sugarsyntaxkotlin.sealed

sealed class ViewState{
    abstract fun messageByState(): String
}

object LoadingState: ViewState(){
    override fun messageByState() = "Is loading"
}
object ErrorState: ViewState(){
    override fun messageByState() = "there is an error"
}
object SuccessState: ViewState(){
    override fun messageByState() = "everything went well"
}
object TimeoutState: ViewState(){
    override fun messageByState() = "timeout"
}

fun getViewState(state: String) =
        when(state) {
            "error" -> ErrorState
            "success" -> SuccessState
            "loading" -> LoadingState
            else -> TimeoutState
        }