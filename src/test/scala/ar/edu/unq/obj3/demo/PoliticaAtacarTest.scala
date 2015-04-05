package ar.edu.unq.obj3.demo

import juego._
import org.scalatest.FlatSpec

class PoliticaAtacarTest extends FlatSpec {

    val jugador1 = new Jugador()
    val jugador2 = new Jugador()
    val tablero = new Tablero(4, 4, 0, jugador1, jugador2)
    tablero.initialize()



    "Posicion a Atacar sin enemigos en celdas vecinas" should "se mueve a la primera posicion de las celdas vecinas en este caso, Posicion (1,2) " in {

      val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))

      val atacar = new Atacar()
      personaje1.politicaDeMovimiento(atacar)
      jugador1.agregarPersonaje(personaje1)

      assert(personaje1.posicionAMoverse() == (1, 2))

    }

  "Posicion a Atacar con enemigos en celdas vecinas" should "se mueve a la posicion de celda vecina donde la potencia de enemigos sea el minimo, Posicion (1,0) " in {

    val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))

    val atacar = new Atacar()
    personaje1.politicaDeMovimiento(atacar)
    jugador1.agregarPersonaje(personaje1)

    tablero.celda(1, 2).agregarPersonajes(4, jugador2)
    tablero.celda(2, 1).agregarPersonajes(5, jugador2)
    tablero.celda(1, 0).agregarPersonajes(1, jugador2)
    tablero.celda(0, 1).agregarPersonajes(5, jugador2)

    assert(personaje1.posicionAMoverse() == (1, 0))

  }
}