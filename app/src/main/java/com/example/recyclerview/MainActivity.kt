package com.example.recyclerview

import Adapter
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Инициализация RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Устанавливаем адаптер
        recyclerView.adapter = Adapter(this, fetchColorList()) { colorName ->
            // Обработка клика на ячейке
            Toast.makeText(this, "Clicked: $colorName", Toast.LENGTH_SHORT).show()
        }
    }
}

data class ColorData(
    val colorName: String,
    val colorHex: Int
)

private fun fetchColorList(): ArrayList<ColorData> {
    return arrayListOf(
        ColorData("Red", Color.RED),
        ColorData("Green", Color.GREEN),
        ColorData("Blue", Color.BLUE),
        ColorData("Yellow", Color.YELLOW),
        ColorData("Cyan", Color.CYAN),
        ColorData("Magenta", Color.MAGENTA),
        ColorData("Black", Color.BLACK),
        ColorData("White", Color.WHITE),
    )
}