package br.com.alinykelly.worldcup.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import br.com.alinykelly.worldcup.R
import br.com.alinykelly.worldcup.model.PlayerDto
import br.com.alinykelly.worldcup.presenter.JogadorListContract
import br.com.alinykelly.worldcup.presenter.JogadorListPresenterImpl

class MainActivity : AppCompatActivity(), JogadorListContract.View {
    private lateinit var progressBar: ProgressBar
    private lateinit var rvJogadorList: RecyclerView
    private val adapter by lazy {JogadorListAdapter()}

    private val presenter = JogadorListPresenterImpl.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvJogadorList = findViewById(R.id.rvJogadorList)
        progressBar = findViewById(R.id.progressBar)
        rvJogadorList.adapter = adapter

        lifecycle.addObserver(presenter)
        presenter.fetchRandomRecipes()

    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }

    override fun displayJogadores(list: List<PlayerDto>) {
        adapter.submitList(list)
    }

    override fun displayLoading(isLoading: Boolean) {
        progressBar.isVisible = isLoading
    }

    override fun showError(message: Int) {
        // txtHello.setText(message)
    }

//    private val recyclerView by lazy {
//        findViewById<RecyclerView>(R.id.rvJogadores)
//    }
//
//    private val viewModel by lazy {
//        ViewModelProvider(this, JogadorViewModelFactory())
//            .get(JogadorViewModel::class.java)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        viewModel.jogadores.observe(this, Observer {
//            loadRecyclerView(it)
//        })
//    }
//
//    private fun loadRecyclerView(jogadores: List<PlayerDto?>) {
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = JogadorAdapter(jogadores)
//    }
}