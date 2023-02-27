package com.example.simulasiupk_fauziatunnurulula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inputNama : EditText
    private lateinit var inputTg : EditText
    private lateinit var rblk : RadioButton
    private lateinit var rbpr : RadioButton
    private lateinit var hasil : TextView
    private lateinit var Hitung : Button
    private lateinit var simpan : Button
    private lateinit var reset : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var tBadan: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNama = findViewById(R.id.et_nama)
        inputTg = findViewById(R.id.et_tingba)
        rblk = findViewById(R.id.Rb_laki)
        rbpr = findViewById(R.id.Rb_Perem)
        hasil = findViewById(R.id.hasil)
        Hitung = findViewById(R.id.btHitung)
        simpan = findViewById(R.id.btSimpan)
        reset = findViewById(R.id.btReset)
        recyclerView = findViewById(R.id.listData)

        val data = mutableListOf<Databb>()
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerAdapter = BeratBadan_Adapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        simpan.setOnClickListener {
            val namaa = inputNama.text.toString()
            val tinng = inputTg.text.toString()
            val hasill = hasil.text.toString()

            val DataBerat = Databb(namaa, tinng, hasill)
            data.add(DataBerat)
            recyclerAdapter.notifyDataSetChanged()
        }


        Hitung.setOnClickListener {
            var tinggi = inputTg.text.toString().toInt()

            if (rblk.isChecked){
                tBadan = (tinggi - 100) - ((tinggi - 100) * 10/100)
                hasil.setText(tBadan.toString() + "kg")
            } else {
                tBadan = (tinggi - 100) - ((tinggi - 100) * 15/100)
                hasil.setText(tBadan.toString() + "kg")
            }
        }
        reset.setOnClickListener {
            hasil.text = "0"
            inputNama.text.clear()
            inputTg.text.clear()
        }
    }
}