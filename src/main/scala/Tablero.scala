import scala.collection.mutable.Map

class Tablero (val dimension: Int ,val cantPersonajes: Int,val  jugador1: Jugador,val jugador2: Jugador){

  var mapCoord = Map[(Int,Int), Celda]()

  def crearYUbicarCelda(x: Int, y:Int) {
    val celda = new Celda(x, y)
    mapCoord += ((x,y) -> celda)
  }

  def initialize() ={

    for(x <- 0 to dimension-1 )
    for(y <- 0 to dimension-1)
    crearYUbicarCelda(x, y)

    posicionarPersonajes()

    jugador1.tablero(this)
    jugador2.tablero(this)
  }

<<<<<<< HEAD
  def posicionarJugadores(): Unit ={
    mapCoord.apply(0,0).agregarPersonajes(cantPersonajes, jugador1, this)
    mapCoord.apply(dimension-1 ,dimension-1 ).agregarPersonajes(cantPersonajes, jugador2, this)
=======
  def posicionarPersonajes(): Unit ={
    mapCoord.apply(0,0).agregarPersonajes(cantPersonajes, jugador1)
    mapCoord.apply(dimension-1 ,dimension-1 ).agregarPersonajes(cantPersonajes, jugador2)
  }

  def celda(x: Int, y: Int): Celda = {
    mapCoord.apply(x, y)
  }

  def celdasVecinasConCompanieros(celda: Celda, jugador: Jugador): List[Celda] = {
    celdasVecinas(celda).filter(_.hayCompaniero(jugador))
  }

  def celdasVecinasConEnemigos(celda: Celda, jugador: Jugador): List[Celda] = {
    celdasVecinas(celda).filter(_.hayEnemigo(jugador))
>>>>>>> 8ad179117aec626c0257e4b20a9b119eb8a32c3c
  }

  def celdasVecinas(celda: Celda): List[Celda] = List(celdaNorte(celda), celdaSur(celda), celdaEste(celda), celdaOeste(celda))

  def celdaNorte(celda: Celda): Celda = mapCoord.apply(celda.x, celda.y + 1)

  def celdaSur(celda: Celda): Celda = mapCoord.apply(celda.x, celda.y - 1)

  def celdaEste(celda: Celda): Celda = mapCoord.apply(celda.x + 1, celda.y)

  def celdaOeste(celda: Celda): Celda = mapCoord.apply(celda.x - 1, celda.y)
}
