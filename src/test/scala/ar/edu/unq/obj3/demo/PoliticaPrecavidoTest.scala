package ar.edu.unq.obj3.demo

import juego.{Precavido, Personaje, Tablero, Jugador}
import org.scalatest.FlatSpec


class PoliticaPrecavidoTest extends  FlatSpec{

  val jugador1 = new Jugador("")
  val jugador2 = new Jugador("")
  val tablero = new Tablero(4, 4, 1, jugador1, jugador2)
  tablero.initialize()



  "Precavido" should "Se queda en la celda, en este caso Posicion (1,1), la condicion de movimiento es false porque en las celdas vecinas hay un enemigo con mas energia que el" in {

    val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))

    personaje1.energia = 100

    val personaje2 = new Personaje(jugador2,tablero.celda(1,2))

    personaje2.energia = 200

    val precavido = new Precavido()
    personaje1.politicaDeAccion(precavido)
    jugador1.agregarPersonaje(personaje1)
    jugador2.agregarPersonaje(personaje2)

    tablero.celda(1,2).agregarPersonaje(personaje2,jugador2)
    tablero.celda(1,1).agregarPersonaje(personaje1,jugador1)

    assert(personaje1.condicionDeMovimiento == false)


  }

  "Precavido" should "Se puede mover, porque la condicion de movimiento es true ya que en las celdas vecinas no hay enemigo con mas energia que el" in {

    val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))

    personaje1.energia = 200

    val personaje2 = new Personaje(jugador2,tablero.celda(1,2))

    personaje2.energia = 100

    val precavido = new Precavido()

    personaje1.politicaDeAccion(precavido)
    jugador1.agregarPersonaje(personaje1)
    jugador2.agregarPersonaje(personaje2)

    tablero.celda(1,1).agregarPersonaje(personaje1,jugador1)
    tablero.celda(1,2).agregarPersonaje(personaje2,jugador2)

    assert(personaje1.condicionDeMovimiento == true)


  }

}