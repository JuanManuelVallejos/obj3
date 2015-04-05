package ar.edu.unq.obj3.demo

import juego.{AumentoMasivoExperiencia, Celda, Personaje, Jugador}
import org.scalatest.FlatSpec

class AumentoMasivoExperienciaTest extends FlatSpec{

  val jugador1 = new Jugador("Juan")
  val jugador2 = new Jugador("Nicolas")


  val celda = new Celda(5,5)

  val personaje1MenosEnergia = new Personaje(jugador1,celda)
  personaje1MenosEnergia.energia = 8
  personaje1MenosEnergia.experiencia = 0

  val personaje1MasEnergia  = new Personaje(jugador1, celda)
  personaje1MasEnergia.energia = 15
  personaje1MasEnergia.experiencia = 0

  val personaje2MenosEnergia = new Personaje(jugador2,celda)
  personaje2MenosEnergia.energia = 3
  personaje2MenosEnergia.experiencia = 0

  val personaje2MasEnergia  = new Personaje(jugador2, celda)
  personaje2MasEnergia.energia = 19
  personaje2MasEnergia.experiencia = 0

  jugador1.personajes = List(personaje1MasEnergia,personaje1MenosEnergia)
  jugador2.personajes = List(personaje2MasEnergia,personaje2MenosEnergia)

  celda.personajes = List(personaje1MasEnergia,personaje1MenosEnergia,personaje2MasEnergia,personaje2MenosEnergia)

  val aumentoJugador = new AumentoMasivoExperiencia(jugador1)
  val aumentoCelda = new AumentoMasivoExperiencia(celda)

  "ejecutar para jugador" should "aumentar la experiencia del personaje energetico y mantener el de menos energia" in{
    assert(aumentoJugador.toString == "Aumento masivo de experiencia sobre Juan : pendiente")
    aumentoJugador.ejecutar
    assert(personaje1MasEnergia.experiencia == 2)
    assert(personaje1MenosEnergia.experiencia == 0)

    assert(personaje2MasEnergia.experiencia == 0)
    assert(aumentoJugador.toString == "Aumento masivo de experiencia sobre Juan : ejecutado")
  }

  "ejecutar para celda" should "aumentar la experiencia de los personajes energeticos y mantener los de menos energia de la celda" in{

    assert(aumentoCelda.toString == "Aumento masivo de experiencia sobre Celda de posicion (5,5) : pendiente")
    aumentoCelda.ejecutar

    assert(personaje1MasEnergia.experiencia == 4)
    assert(personaje2MasEnergia.experiencia == 2)

    assert(personaje1MenosEnergia.experiencia == 0)
    assert(personaje2MenosEnergia.experiencia == 0)
    assert(aumentoCelda.toString == "Aumento masivo de experiencia sobre Celda de posicion (5,5) : ejecutado")
  }

}
