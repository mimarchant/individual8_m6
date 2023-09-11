package com.example.individual8_m6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.individual8_m6.data.local.RazaDetailEntity
import com.example.individual8_m6.databinding.ItemDetailDogBinding

class DetailAdapter: RecyclerView.Adapter<DetailAdapter.DetallePerroViewHolder>() {

    lateinit var binding: ItemDetailDogBinding
    private val listDetalleperro = mutableListOf<RazaDetailEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetallePerroViewHolder {
        binding = ItemDetailDogBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return DetallePerroViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listDetalleperro.size
    }

    override fun onBindViewHolder(holder: DetallePerroViewHolder, position: Int) {
        val perro = listDetalleperro[position]
        holder.bind(perro)
    }

    fun setDataDetalle(detalle : List<RazaDetailEntity>){
        this.listDetalleperro.clear()
        this.listDetalleperro.addAll(detalle)
        notifyDataSetChanged()
    }

    class DetallePerroViewHolder(val perrovista: ItemDetailDogBinding): RecyclerView.ViewHolder(perrovista.root){
        fun bind(detalle: RazaDetailEntity){
            perrovista.imageDogsDetail.load(detalle.url)
        }
    }
}