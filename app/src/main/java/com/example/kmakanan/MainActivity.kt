package com.example.kmakanan

import android.content.Context
import android.content.Intent
import android.os.BaseBundle
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_makanan.view.*

class MainActivity : AppCompatActivity() {

    val listmakanan = ArrayList<Makanan>()
    var adapter : AdapterMakanan? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listmakanan.add(Makanan("Bakso", "Bakso adalah Makanan Khas Indonesia",
            R.drawable.bakso))
        listmakanan.add(Makanan("Ayam Geprek", "Ayam Geprek adalah Makanan Khas Indonesia",
            R.drawable.ayamgeprek))
        listmakanan.add(Makanan("Gudeg", "Gudeg adalah Makanan Khas Indonesia",
            R.drawable.gudeg))
        listmakanan.add(Makanan("MieAyam", "MieAyam adalah Makanan Khas Indonesia",
            R.drawable.mieayam))
        listmakanan.add(Makanan("Nasi Goreng", "Nasi Goreng adalah Makanan Khas Indonesia",
            R.drawable.nasigoreng))
        listmakanan.add(Makanan("Sambalado", "Sambalado adalah Makanan Khas Indonesia",
            R.drawable.sambalado))
        listmakanan.add(Makanan("Selat", "Selat adalah Makanan Khas Indonesia",
            R.drawable.selat))
        listmakanan.add(Makanan("Soto", "Soto adalah Makanan Khas Indonesia",
            R.drawable.soto))

        adapter = AdapterMakanan (this,listmakanan)
        gvListMakanan.adapter = adapter
    }
    inner class AdapterMakanan: BaseAdapter {
        var listMakanan = ArrayList<Makanan>()
        var context:Context? = null
        constructor(context: Context, listOfFood: ArrayList<Makanan>):super(){
            this.context =context
            this.listMakanan = listOfFood

        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val makanan = this.listMakanan[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.item_makanan, null)
            foodView.ivGambarMakanan.setImageResource(makanan.gambar!!)
            foodView.ivGambarMakanan.setOnClickListener {
                val intent =Intent(context, DetailMakanan::class.java)
                intent.putExtra("nama", makanan.nama!!)
                intent.putExtra("deskripsi", makanan.deskripsi!!)
                intent.putExtra("gambar", makanan.gambar!!)
                context!!.startActivity(intent)
            }
            foodView.tvNamaMakanan.text = makanan.nama!!
            return foodView
        }

        override fun getItem(p0: Int): Any {
            return listMakanan[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listMakanan.size
        }


    }


}
