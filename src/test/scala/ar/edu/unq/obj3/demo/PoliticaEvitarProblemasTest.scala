package ar.edu.unq.obj3.demo

import juego._
import org.scalatest.FlatSpec


class PoliticaEvitarProblemasTest extends FlatSpec{

  val jugador1 = new Jugador("")
  val jugador2 = new Jugador("")
  val tablero = new Tablero(4, 4, 0, jugador1, jugador2)
  tablero.initialize()

  "Evitar Problemas" should "Retorna la posicion donde la suma de potencias de enemigos es la minima, Posicion (2,1) " in {

    val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))

    personaje1.energia = 40
    val eProblemas = new EvitarProblemas()
    personaje1.politicaDeMovimiento(eProblemas)
    jugador1.agregarPersonaje(personaje1)

    tablero.celda(1, 2).agregarPersonajes(5, jugador2)
    tablero.celda(2, 1).agregarPersonajes(1, jugador2)
    tablero.celda(1, 0).agregarPersonajes(5, jugador2)
    tablero.celda(0, 1).agregarPersonajes(5, jugador2)



    assert(personaje1.posicionAMoverse == (2, 1))
  }
}
