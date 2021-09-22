package com.example.calcuatorp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calcuatorp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var firstValue :Double = 0.0
    var operator: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
       binding.btnC.setOnClickListener {
           binding.tvPantalla.text = binding.tvPantalla.text.dropLast(1) as Editable?
           //binding.tvPantalla.setText(binding.tvPantalla.text.dropLast(1))
       }
        binding.btnBorrar.setOnClickListener {
            binding.tvPantalla.text.clear()
       }
        binding.btnIgual.setOnClickListener {
        when(operator){
           // esto no funciona  "Multiplicacion" -> {binding.tvPantalla.text = "${firstValue * binding.tvPantalla.text.toString().toDouble()}" as Editable }
           "Multiplicacion" -> {binding.tvPantalla.setText("${firstValue * binding.tvPantalla.text.toString().toDouble()}") }
            "Division" -> {binding.tvPantalla.setText("${firstValue / binding.tvPantalla.text.toString().toDouble()}") }
            "Suma" -> {binding.tvPantalla.setText("${firstValue + binding.tvPantalla.text.toString().toDouble()}") }
            "Resta" -> {binding.tvPantalla.setText("${firstValue - binding.tvPantalla.text.toString().toDouble()}") }
        }
        }
        binding.btnPorcioento.setOnClickListener {
            binding.tvPantalla.setText("${binding.tvPantalla.text.toString().toDouble() /100}")
        }

    }

    fun numbeButtonClicked(view: View){
        val button = view as Button

        when (button.id){
           // esta linea reduce codigo a una linea binding.tvPantalla.text.append(button.text)
            binding.btnPunto.id->{if(!binding.tvPantalla.text.contains(".")){
                binding.tvPantalla.text.append(".")
            }}
            binding.btnCero.id ->{binding.tvPantalla.text.append("0")}
            binding.btnUno.id ->{binding.tvPantalla.text.append("1")}
            binding.btnDos.id ->{binding.tvPantalla.text.append("2")}
            binding.btnTres.id ->{binding.tvPantalla.text.append("3")}
            binding.btnCuatro.id ->{binding.tvPantalla.text.append("4")}
            binding.btnCinco.id ->{binding.tvPantalla.text.append("5")}
            binding.btnSeis.id ->{binding.tvPantalla.text.append("6")}
            binding.btnsiete.id ->{binding.tvPantalla.text.append("7")}
            binding.btnOcho.id ->{binding.tvPantalla.text.append("8")}
            binding.btnNueve.id ->{binding.tvPantalla.text.append("9")}
            else->{Toast.makeText(this,"else",Toast.LENGTH_SHORT).show()}
        }


    }
    fun operacionclick(view:View){
        val button =view as Button
        operator = when (button.id){
            binding.btnPor.id->{"Multiplicacion"}
            binding.btnDivision.id->{"Division"}
            binding.btnmenos.id->{"Resta"}
            binding.btnMas.id->{"Suma"}
            else->{""}
        }
        firstValue = binding.tvPantalla.text.toString().toDouble()
        binding.tvPantalla.text.clear()
    }
}