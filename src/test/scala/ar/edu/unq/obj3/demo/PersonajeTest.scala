package ar.edu.unq.obj3.demo
import org.scalatest.FlatSpec
import juego.{Tablero, Personaje, Jugador, Celda}

class PersonajeTest extends FlatSpec {

  val jugador = new Jugador()
  val celda = new Celda(5,5)
  val personaje = new Personaje(jugador,celda)
  val tablero = new Tablero(4,4,4,jugador, new Jugador())

  personaje.energia = 30
  personaje.escudo = 50
  personaje.experiencia = 15

  "potencia de ataque" should "retornar 13" in {
    assert(personaje.potenciaDeAtaque()==13)
  }

  "potencia de defensa" should "retornar 58" in {
    assert(personaje.potenciaDeDefensa()==58)
  }

}
