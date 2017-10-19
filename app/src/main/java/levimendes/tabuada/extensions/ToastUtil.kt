package levimendes.tabuada.extensions

import android.content.Context
import android.support.annotation.IdRes
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast.*

/**
 * Created by levimendes on 18/10/2017.
 */
fun AppCompatActivity.toast(s: String)      = makeText(this, s, LENGTH_SHORT).show()
fun AppCompatActivity.toastShort(s: String) = makeText(this, s, LENGTH_SHORT).show()
fun AppCompatActivity.toastLong(s: String)  = makeText(this, s, LENGTH_LONG).show()

// Busca um TextView e retorna seu texto
fun AppCompatActivity.getTextString(@IdRes id: Int): String = findViewById<TextView>(id).text.toString()


inline fun Context.alert(func: AlertDialog.Builder.() -> AlertDialog.Builder) {
    AlertDialog.Builder(this).func().show()
}