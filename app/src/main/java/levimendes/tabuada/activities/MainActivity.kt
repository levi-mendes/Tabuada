package levimendes.tabuada.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import levimendes.tabuada.beans.Tabuada
import kotlinx.android.synthetic.main.activity_main.*
import levimendes.tabuada.R
import levimendes.tabuada.extensions.toast
import levimendes.tabuada.utils.hideKeyboard

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        btOk.setOnClickListener { validar() }
        clMainActivity.setOnClickListener { hideKeyboard(this) }
    }

    /**
     * Adiciona a linha na tabuada ex: 1 x 1 = 1
     */
    private fun addLinha(t: Tabuada) {
        var tvLinha = TextView(this)
        tvLinha.textSize = 20f
        //tvLinha.background = ContextCompat.getDrawable(this, R.color.primary_material_light)

        //var layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        //layoutParams.gravity = Gravity.LEFT
        //tvLinha.layoutParams = layoutParams

        tvLinha.text = t.toString()
        llConteudoTabuada.addView(tvLinha)
    }

    private fun numero() : Int = etNumero.text.toString().toInt()

    private fun validar() : Boolean {

        if (etNumero.text.isEmpty()) {
            tilNumero.error = getString(R.string.informe_um_numero)
            return false
        }

        tilNumero.error = null

        montarTabuada()

        return true
    }

    private fun montarTabuada() {
        llConteudoTabuada.removeAllViews()

        val multiplicando = numero()
        var multiplicador = 0

        //adiciona uma linha para cada multiplicador
        while (multiplicador <= 10) {
            addLinha(Tabuada(multiplicador, multiplicando))
            multiplicador++
        }

        hideKeyboard(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return if (id == R.id.itemProfile) {
            toast("teste message")
            true

        } else super.onOptionsItemSelected(item)

    }
}