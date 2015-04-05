package ar.edu.unq.obj3.demo

import juego.{ReforzarAtaque, Personaje, Tablero, Jugador}
import org.scalatest.FlatSpec

class PoliticaReforzarAtaqueTest extends FlatSpec{

  val jugador1 = new Jugador("")
  val jugador2 = new Jugador("")
  val tablero = new Tablero(4, 4, 0, jugador1, jugador2)
  tablero.initialize()



  "Reforza Ataque" should "Retornar la coord donde la suma de potencias de ataque de amigos sea mayor, en este caso como no hay companieros en las celdas vecinas retorna la primer celda de la lista, la norte (1,2)" in {

    val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))


    val reforzarAtaque = new ReforzarAtaque()
    personaje1.politicaDeMovimiento(reforzarAtaque)
    jugador1.agregarPersonaje(personaje1)
    tablero.celda(1,1).agregarPersonaje(personaje1,jugador1)

    assert(personaje1.posicionAMoverse == (1,2))

  }

  "Reforza Ataque" should "Retornar la coord donde la suma de potencias de ataque de amigos sea mayor, en este caso como la suma de potencia de ataque de amigos es mayor en el este devuelve, Este (2,1)" in {

    val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))
    val personaje2 = new Personaje(jugador1, tablero.celda(2, 1))


    val reforzarAtaque = new ReforzarAtaque()
    personaje1.politicaDeMovimiento(reforzarAtaque)

    jugador1.agregarPersonaje(personaje1)
    jugador1.agregarPersonaje(personaje2)

    tablero.celda(2,1).agregarPersonaje(personaje2,jugador1)
    tablero.celda(1,1).agregarPersonaje(personaje1,jugador1)


    assert(personaje1.posicionAMoverse == (2, 1))
  }

}