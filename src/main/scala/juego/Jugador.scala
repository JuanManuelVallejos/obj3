package juego


class Jugador() {

  var tablero: Tablero = _

  var personajes = List[Personaje]()

  def tablero(tab: Tablero) {tablero = tab}

  def agregarPersonaje(personaje: Personaje) { personajes = personaje :: personajes }

  def setearPolitica(numeroDePersonaje: Int, accion: PoliticaDeAccion, movimiento: PoliticaDeMovimiento): Unit = {
    personajes.apply(numeroDePersonaje).politicaDeAccion(accion)
    personajes.apply(numeroDePersonaje).politicaDeMovimiento(movimiento)
  }


  def celdasVecinasConCompanieros(celda: Celda) = tablero.celdasVecinasConCompanieros(celda, this)

  def celdasVecinasConEnemigos(celda: Celda): List[Celda] = tablero.celdasVecinasConEnemigos(celda, this)

  def celdasVecinas(celda: Celda): List[Celda] = tablero.celdasVecinas(celda)
}

