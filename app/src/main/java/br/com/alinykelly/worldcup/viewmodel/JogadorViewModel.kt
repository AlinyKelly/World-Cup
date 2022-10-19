package br.com.alinykelly.worldcup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.alinykelly.worldcup.api.JogadorRepository
import br.com.alinykelly.worldcup.domain.Jogador

class JogadorViewModel : ViewModel() {
    var jogadores = MutableLiveData<List<Jogador?>>()

    init {
        Thread(Runnable {
            loadJogadores()
        }).start()
    }

    private fun loadJogadores() {
        val jogadoresApiResult = JogadorRepository.listJogadores()

        jogadoresApiResult?.results?.let {
            jogadores.postValue(it.map { jogadorResult ->
                val number = jogadorResult.url
                    .replace("https://endereco da api", "")
                    .replace("/", "").toInt()

                val jogadorApiResult = JogadorRepository.getJogador(number)

                jogadorApiResult?.let {
                    Jogador(
                        jogadorApiResult.id,
                        jogadorApiResult.name,
                        jogadorApiResult.types.map { type ->
                            type.type
                        }
                    )
                }
            })
        }
    }
}