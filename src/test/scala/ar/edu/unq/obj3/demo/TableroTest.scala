package ar.edu.unq.obj3.demo

import juego.{Jugador, Tablero}
import org.scalatest.FlatSpec


class TableroTest extends FlatSpec{


  val jugador1 = new Jugador
  val jugador2 = new Jugador

  val tablero = new Tablero(4,4,4,jugador1,jugador2)

  "Crear y ubicar celda" should "agregar la celda con coordenada (3,3)" in {

    tablero.crearYUbicarCelda(3,3)

    assert(tablero.mapCoord.head._1 == (3,3))
  }

}
