package br.com.alinykelly.worldcup.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alinykelly.myfirstpokedex.R
import br.com.alinykelly.worldcup.domain.Jogador
import com.bumptech.glide.Glide

class JogadorAdapter(
   private val items: List<Jogador?>
) : RecyclerView.Adapter<JogadorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jogador_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Jogador?) = with(itemView) {
            val ivJogador = findViewById<ImageView>(R.id.ivJogador)
            val tvNumber = findViewById<TextView>(R.id.tvNumber)
            val tvName = findViewById<TextView>(R.id.tvName)
            val tvType1 = findViewById<TextView>(R.id.tvType1)
            val tvType2 = findViewById<TextView>(R.id.tvType2)

            item?.let {
                Glide.with(itemView.context).load(it.imageUrl).into(ivJogador)

                tvNumber.text = "Nº ${item.formattedNumber}"
                tvName.text = item.formattedName
                tvType1.text = item.types[0].name.capitalize()

                    if (item.types.size > 1) {
                        tvType2.visibility = View.VISIBLE
                        tvType2.text = item.types[1].name
                    } else {
                        tvType2.visibility = View.GONE
                    }
            }
        }
    }
}