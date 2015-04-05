package ar.edu.unq.obj3.demo

import org.scalatest.FlatSpec
import juego._

class EscenarioTest extends FlatSpec {

  val jugadorA = new Jugador("")
  val jugadorB = new Jugador("")
  val tablero = new Tablero(4, 4, 2, jugadorA, jugadorB)
  tablero.initialize()

  "Tablero de dimension 4 x 4" should "Crea un Tablero con Dimension 4 x 4" in {


    assert(tablero.celda(0, 0).personajes.length == 2)
    assert(tablero.celda(3, 3).personajes.length == 2)
    assert(tablero.mapCoord.toList.length == 16)
    assert(!tablero.estaDentroDelTablero(3, 4))
    assert(!tablero.estaDentroDelTablero(4, 4))
    assert(!tablero.estaDentroDelTablero(4, 3))
  }

  "Jugadores" should "pertenecer al tablero y la cantidad de personajes es 2" in {

    assert(jugadorA.personajes.length == 2)
    assert(jugadorB.personajes.length == 2)
    assert(jugadorA.tablero == tablero)
    assert(jugadorB.tablero == tablero)
  }

  /*
  El jugador A elige políticas pancho y evitar problemas,
  En este caso, tomar dos personajes de A y dos de B.
  Para los dos personajes de A la recomendación tiene que ser que se queden en el lugar.
   */
  "JugadorA" should "Personajes tener politica de pancho y evitar problemas" in {

    val pancho = new Pancho()
    val evitarProblemas = new EvitarProblemas()

    jugadorA.setearPolitica(0, pancho, evitarProblemas)
    jugadorA.setearPolitica(1, pancho, evitarProblemas)

    assert(jugadorA.personajes.apply(0).sugerir ==(0, 0))
    assert(jugadorA.personajes.apply(1).sugerir ==(0, 0))

  }

/*
  el jugador B elige colaborador y salir a atacar.
  Para el segundo personaje, que haya otra celda vecina con un solo enemigo,
  pero de potencia de defensa mayor a la suma de los dos personajes de la celda elegida.

  */
  "JugadorB" should "Personajes tienen politica de colaborador y atacar" in{

val colaborador = new Colaborador()
val atacar = new Atacar()
val personajeEnemigoMasPoderoso = new Personaje(jugadorA,tablero.celda(3,2))


jugadorB.setearPolitica(0,colaborador,atacar)
jugadorB.setearPolitica(1,colaborador,atacar)

assert(jugadorB.personajes.apply(0).sugerir == (3,2))

tablero.celda(3,2).agregarPersonaje(personajeEnemigoMasPoderoso,jugadorA)

personajeEnemigoMasPoderoso.energia = 200
personajeEnemigoMasPoderoso.experiencia = 100
personajeEnemigoMasPoderoso.escudo = 2000

jugadorB.personajes.apply(0).energia = 100
jugadorB.personajes.apply(0).experiencia = 0
jugadorB.personajes.apply(0).escudo = 1000

jugadorB.personajes.apply(1).energia = 100
jugadorB.personajes.apply(1).experiencia = 0
jugadorB.personajes.apply(1).escudo = 1000

assert(jugadorB.personajes.apply(1).sugerir == (3,2))

}
/*
  Configurar los personajes de forma tal que para uno de los personajes de B la recomendación sea quedarse,
  y para el otro, moverse a una celda con dos enemigos.

 */
  "JugadorB" should "Personaje 1 tiene politica de pancho y atacar y Personaje2 tiene politica de" in{

val pancho = new Pancho()
val colaborador = new Colaborador()
val precavido = new Precavido()
val atacar = new Atacar()
val personajeEnemigoDebil = new Personaje(jugadorA,tablero.celda(2,3))
val personajeenemigoDebil2 = new Personaje(jugadorA,tablero.celda(2,3))

  jugadorB.setearPolitica(0,pancho,atacar)
  jugadorB.setearPolitica(1,precavido,atacar)

  jugadorB.personajes.apply(1).energia = 200
  jugadorB.personajes.apply(1).experiencia = 100
  jugadorB.personajes.apply(1).escudo = 2000

  personajeEnemigoDebil.energia = 100
    personajeEnemigoDebil.experiencia = 0
    personajeEnemigoDebil.escudo = 1000

    personajeenemigoDebil2.energia = 100
    personajeenemigoDebil2.experiencia = 0
    personajeenemigoDebil2.escudo = 1000

    tablero.celda(2,3).agregarPersonaje(personajeEnemigoDebil,jugadorA)
    tablero.celda(2,3).agregarPersonaje(personajeenemigoDebil2,jugadorA)

  assert(jugadorB.personajes.apply(0).sugerir == (3,3))
  assert(jugadorB.personajes.apply(1).sugerir == (2,3))

}

  /*
  En el mismo escenario, swapear las políticas de A y de B.
  Ahora la opción elegida para los dos personajes de B va a ser quedarse.
  Acomodar el escenario para que la acción elegida para los dos personajes de A sea moverse a celdas distintas.

   */

  /*
  Armar un escenario más combinando políticas de dos jugadores,
  donde ninguno de los dos elige pancho, y la política de “para donde moverse” no sea la misma para los dos jugadores.
  Explicar el escenario en el comentario del test.
   */

  "Nuevo Escenario" should "Personaje1 del JugadorB tiene politica de colaborador y atacar, el personaje2 del JugadorB tiene politica de precavido y evitar problemas" in{


    val colaborador = new Colaborador()
    val precavido = new Precavido()
    val atacar = new Atacar()
    val reforzarAtaque = new ReforzarAtaque()

    val personajeEnemigoDebil = new Personaje(jugadorA,tablero.celda(2,3))
    val personajeenemigoDebil2 = new Personaje(jugadorA,tablero.celda(2,3))
    val personajeAliado = new Personaje(jugadorB,tablero.celda(2,3))
    val personajeAliado2 = new Personaje(jugadorB,tablero.celda(2,3))

    jugadorB.setearPolitica(0,colaborador,atacar)
    jugadorB.setearPolitica(1,precavido,reforzarAtaque)

    jugadorB.personajes.apply(1).energia = 200
    jugadorB.personajes.apply(1).experiencia = 100
    jugadorB.personajes.apply(1).escudo = 2000

    personajeEnemigoDebil.energia = 100
    personajeEnemigoDebil.experiencia = 0
    personajeEnemigoDebil.escudo = 1000

    personajeenemigoDebil2.energia = 100
    personajeenemigoDebil2.experiencia = 0
    personajeenemigoDebil2.escudo = 1000

    tablero.celda(2,3).agregarPersonaje(personajeEnemigoDebil,jugadorA)
    tablero.celda(2,3).agregarPersonaje(personajeenemigoDebil2,jugadorA)

    assert(jugadorB.personajes.apply(1).sugerir == (3,2))
    assert(jugadorB.personajes.apply(0).sugerir == (3,2))

  }

}


