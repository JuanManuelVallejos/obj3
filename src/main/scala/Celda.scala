
class Celda(val x: Int, val y: Int) {

  var personajes = List[Personaje]()

  def agregarPersonajes(cantPers : Int, jugador: Jugador) {
    1 to cantPers foreach { _ =>
      var personaje = new Personaje(jugador, this)
      jugador.agregarPersonaje(personaje)
      personajes = personaje :: personajes
    }
  }

  override def toString = {
    "Potencia de primer personaje: " ++
    personajes.head.potenciaDeAtaque().toString() ++
    "Potencia de segundo personaje: " ++
    personajes.tail.head.potenciaDeAtaque().toString()
  }

  def hayCompaniero(jugador: Jugador): Boolean = {
    personajes.exists(_.jugador.equals(jugador))
  }

  def hayEnemigo(jugador: Jugador): Boolean = {
    personajes.exists(_.jugador != jugador)
  }

  def enemigos(personaje: Personaje) = personajes.filter(_.jugador != personaje.jugador)
}
