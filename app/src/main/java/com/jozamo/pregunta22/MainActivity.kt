package com.jozamo.pregunta22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.jozamo.pregunta22.databinding.ActivityMainBinding

data class Person(
    val firstName:String,
    val lastName: String,
    val city: String,
    val age: Int
)

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var listPerson = mutableListOf<Person>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        (getString(R.string.registros) + listPerson.size).also { binding.numRegisters.text = it }

    }

    fun onClick(view: View) {

        val firstName: String = binding.firstName.text.trim().toString()
        val lastName = binding.lastName.text.trim().toString()
        val city = binding.city.text.trim().toString()
        val age = binding.age.text.trim().toString()

        when {
            firstName.isEmpty() -> {
                Toast.makeText(this, "Nombre no puede estar vacío", Toast.LENGTH_SHORT).show()
            }
            lastName.isEmpty() -> {
                Toast.makeText(this, "Apellidos no puede estar vacío", Toast.LENGTH_SHORT).show()
            }
            city.isEmpty() -> {
                Toast.makeText(this, "Ciudad no puede estar vacío", Toast.LENGTH_SHORT).show()
            }
            age.isEmpty() -> {
                Toast.makeText(this, "Edad no puede estar vacío", Toast.LENGTH_SHORT).show()
            }
            else -> {
                val person = Person(firstName, lastName, city, age.toInt())

                listPerson.add(person)
                (getString(R.string.registros) + listPerson.size).also { binding.numRegisters.text = it }

                Snackbar.make(view, "Registro guardado", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show()

            }
        }
    }
}

