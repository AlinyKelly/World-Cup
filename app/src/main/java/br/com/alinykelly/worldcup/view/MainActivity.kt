package br.com.alinykelly.worldcup.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alinykelly.myfirstpokedex.R
import br.com.alinykelly.worldcup.api.JogadorRepository
import br.com.alinykelly.worldcup.domain.Jogador
import br.com.alinykelly.worldcup.domain.JogadorType
import br.com.alinykelly.worldcup.viewmodel.JogadorViewModel
import br.com.alinykelly.worldcup.viewmodel.JogadorViewModelFactory

class MainActivity : AppCompatActivity() {
    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvJogadores)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, JogadorViewModelFactory())
            .get(JogadorViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.jogadores.observe(this, Observer {
            loadRecyclerView(it)
        })
    }

    private fun loadRecyclerView(jogadores: List<Jogador?>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = JogadorAdapter(jogadores)
    }
}