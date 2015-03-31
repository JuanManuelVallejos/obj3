package ar.edu.unq.obj3.demo

import org.scalatest.FlatSpec
import juego.{EvitarProblemas, Pancho, Jugador, Tablero}

class WorldTest extends FlatSpec{

  val jugA = new Jugador
  val jugB = new Jugador
  val tablero = new Tablero(4,2,jugA,jugB)

  val persA = jugA.personajes
  val persB = jugB.personajes

  persA.apply(0).politicaDeAccion(new Pancho)
  persA.apply(0).politicaDeMovimiento(new EvitarProblemas)

  persA.apply(1).politicaDeAccion(new Pancho)


  persB.apply(0)



}
