import scala.collection.mutable.Map

class Tablero (val dimension: Int ,val cantPersonajes: Int,val  jugador1: Jugador,val jugador2: Jugador){

  var mapCoord = Map[(Int,Int), Celda]()

  def crearYUbicarCelda(x: Int, y:Int) {
    val celda = new Celda()
    mapCoord += ((x,y) -> celda)
  }

  def initialize() ={

    for(x <- 0 to dimension-1 )
      for(y <- 0 to dimension-1)
        crearYUbicarCelda(x, y)

    posicionarJugadores()
  }

  def posicionarJugadores(): Unit ={
    mapCoord.apply(0,0).agregarPersonajes(cantPersonajes, jugador1, this)
    mapCoord.apply(dimension-1 ,dimension-1 ).agregarPersonajes(cantPersonajes, jugador2, this)
  }

}
