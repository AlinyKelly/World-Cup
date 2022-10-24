package br.com.alinykelly.worldcup.base

interface BaseContract {
    interface View

    interface Presenter<T:View>{
        fun attachView(view: T)

        fun detachView()
    }
}