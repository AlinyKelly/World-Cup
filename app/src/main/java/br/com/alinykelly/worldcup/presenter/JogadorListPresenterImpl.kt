package br.com.alinykelly.worldcup.presenter

import br.com.alinykelly.worldcup.R
import br.com.alinykelly.worldcup.model.JogadorService
import br.com.alinykelly.worldcup.base.LifecycleScope
import br.com.alinykelly.worldcup.model.NetworkModule
import kotlinx.coroutines.launch

class JogadorListPresenterImpl private constructor(private val service: JogadorService)
    : JogadorListContract.Presenter, LifecycleScope() {

        private var view: JogadorListContract.View? = null

    override fun fetchRandomRecipes() {
        launch {
            view?.displayLoading(true)
            try {
                val response = service.getJogadores()

                view?.displayLoading(false)
                view?.displayJogadores(response.jogadores)

            }catch (exception: Exception){
                view?.displayLoading(false)
                view?.showError(R.string.error_message)
            }
        }
    }

    override fun attachView(view: JogadorListContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    companion object{
        fun create(service: JogadorService = NetworkModule.createNetworkService()): JogadorListPresenterImpl {
            return JogadorListPresenterImpl(service)
        }
    }
}