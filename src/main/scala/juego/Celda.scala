package juego

import scala.collection.mutable.ListBuffer


class Celda(val x: Int, val y: Int) {

  var personajes = List[Personaje]()

  def agregarPersonajes(cantPers : Int, jugador: Jugador) {
    1 to cantPers foreach { _ =>
      var personaje = new Personaje(jugador, this)
      jugador.agregarPersonaje(personaje)
      personajes = personaje :: personajes
    }
  }

  def coordenada(): (Int,Int) ={
    (x,y)
  }

  def hayCompaniero(jugador: Jugador): Boolean = {
    personajes.exists(_.jugador.equals(jugador))
  }

  def hayEnemigo(jugador: Jugador): Boolean = {
    if(personajes.isEmpty) false
    personajes.exists(_.jugador != jugador)
  }

  def enemigos(personaje: Personaje) = personajes.filter(_.jugador != personaje.jugador)


  def sumaDePotenciasAtaqueEnemigo(aliado: Jugador): Int = {
    var potencias = 0
    personajes.filter(_.jugador != aliado).foreach(pers => potencias += pers.potenciaDeAtaque())
    potencias
  }

  def sumaDePotenciasAtaqueAmigo(aliado: Jugador): Int = {
    var potencias = 0
    personajes.filter(_.jugador == aliado).foreach(pers => potencias += pers.potenciaDeAtaque())
    potencias
  }

  def sumaDePotenciasDefensaEnemigas(aliado: Jugador): Int = {
    var potencias = 0
    personajes.filter(_.jugador != aliado).foreach(pers => potencias += pers.potenciaDeDefensa())
    potencias
  }

  def posibleCoordNorte:(Int,Int)= (x,y+1)

  def posibleCoordSur:(Int,Int)= (x,y-1)

  def posibleCoordEste:(Int,Int)= (x+1,y)

  def posibleCoordOeste:(Int,Int)= (x-1,y)

  def posiblesCoordVecinas:List[(Int,Int)] = List(posibleCoordEste, posibleCoordOeste, posibleCoordNorte, posibleCoordSur)

}
