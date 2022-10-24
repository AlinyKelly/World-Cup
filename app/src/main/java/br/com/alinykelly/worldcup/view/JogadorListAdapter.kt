package br.com.alinykelly.worldcup.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import br.com.alinykelly.worldcup.R
import br.com.alinykelly.worldcup.model.PlayerDto

class JogadorListAdapter() :
    ListAdapter<PlayerDto, JogadorListAdapter.JogadorViewHolder>(JogadorListAdapter) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogadorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.jogador_item, parent, false)
        return JogadorViewHolder(view)
    }

    override fun onBindViewHolder(holder: JogadorViewHolder, position: Int) {
        val jogador = getItem(position)
        holder.bind()
        holder.txtId.text = jogador.id.toString()
        holder.txtName.text = jogador.name
        holder.txtAge.text = jogador.age.toString()

        holder.imgJogador.load(jogador.photo) {
            crossfade(true)
            placeholder(R.drawable.neymar)
            transformations(RoundedCornersTransformation(topLeft = 15f, topRight = 15f))
        }
    }

    class JogadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var imgJogador: ImageView
        lateinit var txtId: TextView
        lateinit var txtName: TextView
        lateinit var txtAge: TextView

        fun bind() {
            with(itemView) {
                txtId = findViewById(R.id.tvNumber)
                txtName = findViewById(R.id.tvName)
                txtAge = findViewById(R.id.tvAge)
                imgJogador = findViewById(R.id.ivJogador)

            }
        }
    }

    private companion object : DiffUtil.ItemCallback<PlayerDto>() {
        override fun areItemsTheSame(oldItem: PlayerDto, newItem: PlayerDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PlayerDto, newItem: PlayerDto): Boolean {
            return oldItem == newItem
        }
    }
}