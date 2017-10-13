package com.example.levimendes.tabuada

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumero.setText("59")

        btOk.setOnClickListener { validar() }
    }

    fun numero() : Int = etNumero.text.toString().toInt()

    fun validar() : Boolean {

        if (etNumero.text.isEmpty()) {
            textInputLayout.error = getString(R.string.informe_um_numero)
            return false
        }

        var s = numero()
        showToast("$s é o numero")
        textInputLayout.error = null
        return true
    }

    fun showToast(s: String) = Toast.makeText(this, s, Toast.LENGTH_SHORT).show()


}
