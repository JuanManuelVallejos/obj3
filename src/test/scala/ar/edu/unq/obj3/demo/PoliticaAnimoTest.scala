package ar.edu.unq.obj3.demo

import juego.{Animo, Personaje, Tablero, Jugador}
import org.scalatest.FlatSpec


class PoliticaAnimoTest extends FlatSpec {

  val jugador1 = new Jugador("")
  val jugador2 = new Jugador("")
  val tablero = new Tablero(4, 4, 0, jugador1, jugador2)
  tablero.initialize()



  "Posicion a Moverse" should "Posicion (1,2) " in {

    val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))

    personaje1.energia = 55
    val animo = new Animo()
    personaje1.politicaDeMovimiento(animo)
    jugador1.agregarPersonaje(personaje1)

    assert(personaje1.posicionAMoverse() == (1, 2))

  }

  "Posicion a Moverse" should "Retorna la posicion donde la suma de potencias es la minima, Posicion (0,1) " in {

    val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))

    personaje1.energia = 55
    val animo = new Animo()
    personaje1.politicaDeMovimiento(animo)
    jugador1.agregarPersonaje(personaje1)

    tablero.celda(1, 2).agregarPersonajes(5, jugador2)
    tablero.celda(2, 1).agregarPersonajes(4, jugador2)
    tablero.celda(1, 0).agregarPersonajes(3, jugador2)
    tablero.celda(0, 1).agregarPersonajes(1, jugador2)


    assert(personaje1.posicionAMoverse() == (0, 1))
  }

  "Posicion a Moverse" should "Retorna la posicion donde la suma de potencias es la minima, Posicion (1,0) " in {

    val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))

    personaje1.energia = 40
    val animo = new Animo()
    personaje1.politicaDeMovimiento(animo)
    jugador1.agregarPersonaje(personaje1)

    tablero.celda(1, 2).agregarPersonajes(5, jugador2)
    tablero.celda(2, 1).agregarPersonajes(5, jugador2)
    tablero.celda(1, 0).agregarPersonajes(1, jugador2)
    tablero.celda(0, 1).agregarPersonajes(5, jugador2)


    assert(personaje1.posicionAMoverse() == (1, 0))
  }
}


