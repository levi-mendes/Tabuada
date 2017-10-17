package levimendes.tabuada

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import levimendes.tabuada.beans.Tabuada
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btOk.setOnClickListener { validar() }
    }

    /**
     * Adiciona a linha na tabuada ex: 1 x 1 = 1
     */
    fun addLinha(t: Tabuada) {
        var tvLinha = TextView(this)
        tvLinha.textSize

        tvLinha.text = t.toString()
        llConteudoTabuada.addView(tvLinha)
    }

    fun numero() : Int = etNumero.text.toString().toInt()

    fun validar() : Boolean {

        if (etNumero.text.isEmpty()) {
            tilNumero.error = getString(R.string.informe_um_numero)
            return false
        }

        tilNumero.error = null

        montarTabuada()

        return true
    }

    fun montarTabuada() {
        llConteudoTabuada.removeAllViews()

        val multiplicando = numero()
        var multiplicador = 0

        //adiciona uma linha para cada multiplicador
        while (multiplicador <= 10) {
            addLinha(Tabuada(multiplicador, multiplicando))
            multiplicador++
        }
    }

    fun showToast(s: String) = makeText(this, s, LENGTH_SHORT).show()
}