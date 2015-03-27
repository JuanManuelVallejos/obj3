
class Celda() {

  var personajes = List[Personaje]()

  def agregarPersonajes(cantPers : Int, jugador: Jugador) {personajes = new Personaje(jugador) :: personajes}


}
