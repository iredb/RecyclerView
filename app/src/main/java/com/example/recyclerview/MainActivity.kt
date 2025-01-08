package com.example.recyclerview

import Adapter
import CellClickListener
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity(), CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val colorList = arrayListOf(
            ColorData("White", Color.WHITE),
            ColorData("Black", Color.BLACK),
            ColorData("Blue", Color.BLUE),
            ColorData("Magenta", Color.MAGENTA),
            ColorData("Red", Color.RED)
        )

        // Устанавливаем адаптер
        recyclerView.adapter = Adapter(this, colorList, this)
    }

    override fun onCellClickListener(data: ColorData) {
        Toast.makeText(this, "IT’S ${data.colorName}", Toast.LENGTH_SHORT).show()
    }
}

data class ColorData(
    val colorName: String,
    val colorHex: Int
)
