import scala.util.Random

object Main extends App{

  /*
  var tab = new Tablero(4,2,new Jugador(),new Jugador())

  tab.initialize()
  tab.imprimirPrimerasCeldas()
  var celda = new Celda()
  println(celda)


  val rnd = new scala.util.Random
  val range = 100 to 200
  println(range(rnd.nextInt(range length)))
  println(range(rnd.nextInt(range length)))
*/

  val personaje = new Personaje(new Jugador())

  println(personaje.potenciaDeAtaque())
}
