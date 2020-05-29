package org.marproject.reusablerecyclerviewadapter.sample.noadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_negara.view.*
import org.marproject.reusablerecyclerviewadapter.interfaces.AdapterCallback
import org.marproject.reusablerecyclerviewadapter.model.Negara
import org.marproject.reusablerecyclerviewadapter.R
import org.marproject.reusablerecyclerviewadapter.ReusableAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create data
        val listNegara = listOf(
            Negara("Indonesia","jakarta"),
            Negara("Malaysia","Kuala Lumpur"),
            Negara("Thailand","Bangkok"),
            Negara("Vietnam","Hanoi"),
            Negara("Filipina","Manila")
        )

        // create adapter callback for init component
        val adapterCallback = object : AdapterCallback<Negara> {
            override fun initComponent(itemView: View, data: Negara, itemIndex: Int) {
                itemView.tv_nama_negara.text = data.nama_negara
                itemView.tv_ibukota.text = data.ibukota
            }

            override fun onItemClicked(itemView: View, data: Negara, itemIndex: Int) {
                Toast.makeText(this@MainActivity,
                    data.nama_negara, Toast.LENGTH_SHORT).show()
            }
        }

        // setup adapter
        ReusableAdapter<Negara>(this)
            .adapterCallback(adapterCallback)
            .setLayout(R.layout.item_negara)
            .isVerticalView(true)
            .addData(listNegara)
            .build(rv_negara)

    }
}
