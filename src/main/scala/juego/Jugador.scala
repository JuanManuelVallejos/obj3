package juego

import scala.language.postfixOps


class Jugador(override val nombre: String) extends ConPersonajes with ConNombre{

  var tablero: Tablero = _

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

