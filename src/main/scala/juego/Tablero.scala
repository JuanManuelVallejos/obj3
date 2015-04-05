package juego

import scala.collection.JavaConverters._
import scala.collection.mutable.{ListBuffer, Map}

class Tablero (dimensionX: Int, dimensionY: Int, cantPersonajes: Int, jugador1: Jugador, jugador2: Jugador){

  var mapCoord = Map[(Int,Int), Celda]()

  //PRECOND: no se debe agregar una celda fuera de las dimensiones del tablero
  def crearYUbicarCelda(x: Int, y:Int) {
    val celda = new Celda(x, y)
    mapCoord += ((x,y) -> celda)
  }

  def initialize() ={

    for(x <- 0 to dimensionX-1 )
      for(y <- 0 to dimensionY-1)
        crearYUbicarCelda(x, y)

    posicionarPersonajes()

    jugador1.tablero(this)
    jugador2.tablero(this)
  }

  def posicionarPersonajes(): Unit ={
    mapCoord.apply(0,0).agregarPersonajes(cantPersonajes, jugador1)
    mapCoord.apply(dimensionX-1 ,dimensionY-1 ).agregarPersonajes(cantPersonajes, jugador2)
  }

  def celda(x: Int, y: Int): Celda = {
    mapCoord.apply(x, y)
  }

  def celdasVecinasConCompanieros(celda: Celda, jugador: Jugador): List[Celda] = {
    celdasVecinas(celda).filter(_.hayCompaniero(jugador))
  }

  def celdasVecinasConEnemigos(celda: Celda, jugador: Jugador): List[Celda] = {
    celdasVecinas(celda).filter(_.hayEnemigo(jugador))
  }

  def estaDentroDelTablero(x: Int, y: Int): Boolean = {
    if(x >= 0 && x < dimensionX && y >= 0 && y < dimensionY) return true
    false
  }

  def celdasVecinas(celda: Celda): List[Celda] = {
    var celdasVec:List[Celda] = List()
    celda.posiblesCoordVecinas.foreach(a =>
      /*Lo puse dentro de una lista para concatenarlo porque no me reconoce los :: para esta parte*/
      if(estaDentroDelTablero(a._1,a._2))
        celdasVec = celdasVec ++ List(mapCoord.apply(a))
    )
    celdasVec
  }

}
