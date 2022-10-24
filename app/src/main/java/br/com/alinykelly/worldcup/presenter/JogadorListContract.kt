package br.com.alinykelly.worldcup.presenter

import androidx.annotation.StringRes
import br.com.alinykelly.worldcup.base.BaseContract
import br.com.alinykelly.worldcup.model.PlayerDto

interface JogadorListContract : BaseContract {

    interface Presenter : BaseContract.Presenter<View>{
        fun fetchRandomRecipes()
    }

    interface View: BaseContract.View{
        fun displayJogadores(list: List<PlayerDto>)
        fun displayLoading(isLoading: Boolean)
        fun showError(@StringRes message: Int)
    }
}