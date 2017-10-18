package levimendes.tabuada.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

/**
 * Created by levimendes on 13/10/2017.
 */

fun hideKeyboard(ac: Activity) {
    val inp: InputMethodManager = ac.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inp.hideSoftInputFromWindow(ac.currentFocus.windowToken, InputMethodManager.SHOW_FORCED)
}