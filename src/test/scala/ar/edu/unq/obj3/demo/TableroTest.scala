package ar.edu.unq.obj3.demo

import juego.{Jugador, Tablero}
import org.scalatest.FlatSpec


class TableroTest extends FlatSpec{


  val jugador1 = new Jugador
  val jugador2 = new Jugador

  val tablero = new Tablero(4,4,4,jugador1,jugador2)

  "Crear y ubicar celda" should "agregar la celda con coordenada (3,3)" in {

    tablero.crearYUbicarCelda(3,3)

    assert(tablero.mapCoord.head._1 == (3,3))
  }

  "Posicionar a los Personajes de Cada Jugador" should "posicionar a los jugadores del jugador1 en la primer celda y los del jugador2 en la ultima celda" in {

    tablero.crearYUbicarCelda(0,0)
    tablero.crearYUbicarCelda(3,3)
    tablero.crearYUbicarCelda(2,3)
    tablero.posicionarPersonajes()

    assert(tablero.celda(0,0).personajes.length == 4)
    assert(tablero.celda(3,3).personajes.length == 4)
    assert(tablero.celda(2,3).personajes.length == 0)

  }


   "Celda Vecinas con Companieros" should "Retorna la lista de Celda con Companieros" in {

     tablero.initialize()
     tablero.celda(0,1).agregarPersonajes(2,jugador1)

     assert(tablero.celdasVecinasConCompanieros(tablero.celda(0,0),jugador1).length == 1)

     tablero.celda(1,0).agregarPersonajes(2,jugador1)

     assert(tablero.celdasVecinasConCompanieros(tablero.celda(0,0),jugador1).length == 2)
     }

  "Celda Vecinas con Enemigos" should "Retorna la lista de Celda con Enemigos" in {

    tablero.initialize()
    tablero.celda(0,1).agregarPersonajes(2,jugador2)

    assert(tablero.celdasVecinasConEnemigos(tablero.celda(0,0),jugador1).length == 1)

    tablero.celda(1,0).agregarPersonajes(2,jugador2)

    assert(tablero.celdasVecinasConEnemigos(tablero.celda(0,0),jugador1).length == 2)

    }

  "Esta Dentro del Tablero" should "Retornar un booleano indicando si esta dentro de las dimensiones del Tablero" in {

    assert(tablero.estaDentroDelTablero(5, 4) == false)
    assert(tablero.estaDentroDelTablero(3, 3) == true)
    assert(tablero.estaDentroDelTablero(0, 0) == true)
  }
  "Celdas Vecinas" should "Retornar una lista de celdas Vecinas" in {

    tablero.initialize()

    assert(tablero.celdasVecinas(tablero.celda(0,0)).length == 2)


  }
}
