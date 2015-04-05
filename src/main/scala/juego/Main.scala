package juego

import javax.swing.UIManager

/**
 * Created by musimundo on 30/03/2015.
 */
object Main extends App {
  /*

  var jugador1 = new Jugador()
  var jugador2 = new Jugador()

    var tab = new Tablero(4,4, 0, jugador1, jugador2)
    tab.crearYUbicarCelda(3,3)
    tab.crearYUbicarCelda(0,0)
    tab.posicionarPersonajes()
  tab.initialize()

  val jugador1 = new Jugador()
  val jugador2 = new Jugador()
  val tablero = new Tablero(4, 4, 0, jugador1, jugador2)
  tablero.initialize()
  val personaje1 = new Personaje(jugador1,tablero.celda(1,1))

  val animo = new Animo()
  val pancho = new Pancho()
  personaje1.politicaDeMovimiento(animo)
  jugador1.agregarPersonaje(personaje1)

  jugador1.setearPolitica(0,pancho,animo)

  val jugador1 = new Jugador()
  val jugador2 = new Jugador()
  val tablero = new Tablero(4, 4, 0, jugador1, jugador2)
  tablero.initialize()

  val personaje1 = new Personaje(jugador1, tablero.celda(1, 1))

  val atacar = new Atacar()
  personaje1.politicaDeMovimiento(atacar)
  jugador1.agregarPersonaje(personaje1)

  tablero.celda(1, 2).agregarPersonajes(1, jugador2)
  tablero.celda(2, 1).agregarPersonajes(1, jugador2)
  tablero.celda(1, 0).agregarPersonajes(5, jugador2)
  tablero.celda(0, 1).agregarPersonajes(1, jugador2)

  println(personaje1.posicionAMoverse())
    */

  val jugadorA = new Jugador()
  val jugadorB = new Jugador()
  val tablero = new Tablero(4,4,2,jugadorA,jugadorB)
  tablero.initialize()

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

  println(jugadorB.personajes.apply(0).sugerir)
  println(jugadorB.personajes.apply(1).sugerir)

  println(jugadorB.personajes.apply(1).celdasVecinasConEnemigos)

/*
  personaje1.energia = 40

  println(personaje1.posicionAMoverse())
*/

/*
  jugador1.setearPolitica(0, new Pancho(), new EvitarProblemas())
  jugador1.setearPolitica(1, new Colaborador(), new EvitarProblemas())
  jugador1.setearPolitica(2, new Precavido(), new EvitarProblemas())


//  println(tab.celda(0, 0).personajes.length)
//  println(tab.celda(3, 3).personajes.length)

//  var celda = new Celda()
//  println(celda)
//
//
//  val rnd = new scala.util.Random
//  val range = 100 to 200
//  println(range(rnd.nextInt(range length)))
//  println(range(rnd.nextInt(range length)))
//
//
//  val personaje = new Personaje(new Jugador())
//
//  println(personaje.potenciaDeAtaque())
*/
}
