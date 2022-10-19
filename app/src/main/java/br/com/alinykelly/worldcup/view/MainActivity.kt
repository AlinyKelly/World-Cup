package br.com.alinykelly.worldcup.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alinykelly.myfirstpokedex.R
import br.com.alinykelly.worldcup.api.JogadorRepository
import br.com.alinykelly.worldcup.domain.Jogador
import br.com.alinykelly.worldcup.domain.JogadorType

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvJogadores)

        //Criar a propria thread pra fazer a requisição
        Thread(Runnable {
            loadJogadores()
        }).start()

    }

    private fun loadJogadores() {
       val jogadoresApiResult = JogadorRepository.listJogadores()

        jogadoresApiResult?.results?.let {

            val jogadores: List<Jogador> = it.map {
                jogadorResult ->
                Jogador(
                    "",
                    1,
                    jogadorResult.name,
                    listOf(JogadorType("Fire"))
                )
            }

            val layoutManager = LinearLayoutManager(this)

            recyclerView.post {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = JogadorAdapter(jogadores)
            }
        }
    }
}