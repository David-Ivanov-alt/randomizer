package com.ds.randomgenerator
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val from_: EditText = findViewById(R.id.editText1)
        val to_: EditText = findViewById(R.id.editTextNumber3)
        val button: Button = findViewById(R.id.button)
        val RandomView: TextView = findViewById(R.id.textRandom)
        var randomNumber: Int
        var fromText_: Int
        var toText_: Int

        button.setOnClickListener {
            fromText_ = from_.text.toString().toIntOrNull() ?: 0
            toText_ =to_.text.toString().toIntOrNull() ?: 0
            if (fromText_ < toText_) {
                randomNumber = Random.nextInt(fromText_, toText_ + 1)
                RandomView.text = randomNumber.toString()
            }
            else {
                Toast.makeText(this, "Ошибка", Toast.LENGTH_LONG).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}