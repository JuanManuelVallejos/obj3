package juego

/**
 * Created by musimundo on 30/03/2015.
 */
object Main extends App{

  var jugador1 = new Jugador()
  var jugador2 = new Jugador()

  var tab = new Tablero(4, 3, jugador1, jugador2)

  tab.initialize()

  jugador1.setearPolitica(0, new Pancho(), new EvitarProblemas())
  jugador1.setearPolitica(1, new Colaborador(), new EvitarProblemas())
  jugador1.setearPolitica(2, new Precavido(), new EvitarProblemas())

  println(tab)

//  println(tab.celda(0, 0).personajes.length)
//  println(tab.celda(3, 3).personajes.length)

//  var celda = new Celda()
//  println(celda)
//
//
//  val rnd = new scala.util.Random
//  val range = 100 to 200
//  println(range(rnd.nextInt(range length)))
//  println(range(rnd.nextInt(range length)))
//
//
//  val personaje = new Personaje(new Jugador())
//
//  println(personaje.potenciaDeAtaque())
}
