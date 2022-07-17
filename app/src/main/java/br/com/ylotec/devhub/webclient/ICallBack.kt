package br.com.ylotec.devhub.webclient

interface ICallBack {
    fun onSucess()
    fun onError(msg : String)
    fun onReturn(any : Any)
}