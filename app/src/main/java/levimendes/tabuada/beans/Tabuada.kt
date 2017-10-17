package levimendes.tabuada.beans

/**
 * Created by levimendes on 13/10/2017.
 *
 * Multiplicador é aquele que multiplica algum número
 * e Multiplicando é aquele q é multiplicado
 * ex: 3x2=6 3=multiplicador, 2= multiplicando e 6= produto
 */

class Tabuada (private val multiplicador: Int, private var multiplicando: Int) {

   override fun toString(): String {
      var res = multiplicando * multiplicador
      return "$multiplicando X $multiplicador = $res"
   }
}