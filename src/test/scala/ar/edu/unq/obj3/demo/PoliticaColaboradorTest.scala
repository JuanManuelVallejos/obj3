package ar.edu.unq.obj3.demo

import juego._
import org.scalatest.FlatSpec


class PoliticaColaboradorTest extends  FlatSpec{

  val jugador1 = new Jugador()
  val jugador2 = new Jugador()
  val tablero = new Tablero(4, 4, 1, jugador1, jugador2)
  tablero.initialize()



  "Colaborador" should "Se queda en la celda, en este caso Posicion (1,1)" in {

    val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))

    val colaborador = new Colaborador()
    personaje1.politicaDeAccion(colaborador)
    jugador1.agregarPersonaje(personaje1)

    tablero.celda(1,2).agregarPersonajes(1,jugador1)
    tablero.celda(2,1).agregarPersonajes(1,jugador1)
    tablero.celda(1,0).agregarPersonajes(1,jugador1)
    tablero.celda(0,1).agregarPersonajes(1,jugador1)

    assert(personaje1.condicionDeMovimiento() == true)


  }


}
