package co.id.cpn.common.models

sealed class EventState<T>(val data:T?=null,val message:String?=null){
    class Loading<T>():EventState<T>()
    class Success<T>(data:T):EventState<T>(data= data)
    class Error<T>(message:String):EventState<T>(message= message)
}
