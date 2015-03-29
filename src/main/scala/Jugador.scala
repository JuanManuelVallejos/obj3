
class Jugador() {

<<<<<<< HEAD

=======
  var tablero: Tablero = _
>>>>>>> 8ad179117aec626c0257e4b20a9b119eb8a32c3c

  var personajes = List[Personaje]()

  def tablero(tab: Tablero) = tablero = tab

  def agregarPersonaje(personaje: Personaje) { personajes = personaje :: personajes }

  def setearPolitica(numeroDePersonaje: Int, accion: PoliticaDeAccion, movimiento: PoliticaDeMovimiento): Unit = {
    personajes.apply(numeroDePersonaje).politicaDeAccion(accion)
    personajes.apply(numeroDePersonaje).politicaDeMovimiento(movimiento)
  }

  def recomendacionesDePersonajes(): String = {
    personajes.foreach(_.)
  }

  def celdasVecinasConCompanieros(celda: Celda) = tablero.celdasVecinasConCompanieros(celda, this)

  def celdasVecinasConEnemigos(celda: Celda): List[Celda] = tablero.celdasVecinasConEnemigos(celda, this)
}

