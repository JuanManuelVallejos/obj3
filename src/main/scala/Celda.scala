import scala.collection.mutable.ListBuffer

class Celda() {

  var personajes = new ListBuffer[Personaje]()

  def agregarPersonajes(cantPers : Int, jugador: Jugador, tablero: Tablero) {personajes += new Personaje(jugador, tablero)}
  
}
