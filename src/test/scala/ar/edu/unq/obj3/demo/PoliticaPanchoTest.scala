package ar.edu.unq.obj3.demo

import org.scalatest.FlatSpec
import juego._

class PoliticaPanchoTest extends FlatSpec{

  val jugador1 = new Jugador()
  val jugador2 = new Jugador()
  val tablero = new Tablero(4,4,1,jugador1,jugador2)

  tablero.initialize()
  val personaje1 = new Personaje(jugador1,tablero.celda(1,1))

  val pancho = new Pancho()
  personaje1.politicaDeAccion(pancho)




  "Condicion De Movimiento" should "Retornar false" in{

    assert(personaje1.condicionDeMovimiento == false)
  }

}
