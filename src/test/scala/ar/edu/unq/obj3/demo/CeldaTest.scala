package ar.edu.unq.obj3.demo
import org.scalatest.FlatSpec
import juego.{Personaje, Jugador, Celda}

class CeldaTest extends FlatSpec{

    val jugador = new Jugador()
    val jugador1 = new Jugador()


  "Agregar personajes con argumento 18" should "agregar 18 personajes" in{
    val celda = new Celda(5, 5)
    celda.agregarPersonajes(18,jugador)
    assert(celda.personajes.length == 18)
  }

  "Hay Companiero en la Celda Actual" should "Deberia haber un companiero" in{
    val celda = new Celda(5, 5)
    celda.agregarPersonajes(2,jugador)
    assert(celda.hayCompaniero(jugador))
  }

  "Hay Enemigo en la Celda Actual" should "Haber un Enemigo perteneciente al Jugador1" in{
    val celda = new Celda(5, 5)
    celda.agregarPersonajes(2,jugador1)
    assert(celda.hayEnemigo(jugador))
  }


  "Hay Enemigo en la Celda Actual" should "Retornar False" in{
    val celda = new Celda(8,8)
    assert(!celda.hayEnemigo(jugador))
  }

  "Suma de potencias ataque amigo" should "retornar 9" in{
    val celda = new Celda(5, 5)

    //potenciaDeAtaque = (energia/3)+(experiencia/5)

    //aliados

    val personaje10 = new Personaje(jugador,null)
    val personaje11 = new Personaje(jugador,null)
    personaje10.energia = 9; personaje10.experiencia = 10; //potencia = 5
    personaje11.energia = 3; personaje11.experiencia = 15; //potencia = 4

    //enemigos

    val personaje20 = new Personaje(jugador1,null)
    val personaje21 = new Personaje(jugador1,null)

    celda.personajes = List(personaje10,personaje11,personaje20,personaje21)

    assert(celda.sumaDePotenciasAtaqueAmigo(jugador) == 9)
  }

  "Suma de potencias ataque enemigo" should "retornar 9" in{
    val celda = new Celda(5, 5)

    //potenciaDeAtaque = (energia/3)+(experiencia/5)

    //enemigos

    val personaje10 = new Personaje(jugador,null)
    val personaje11 = new Personaje(jugador,null)
    personaje10.energia = 9; personaje10.experiencia = 10; //potencia = 5
    personaje11.energia = 3; personaje11.experiencia = 15; //potencia = 4

    //aliados

    val personaje20 = new Personaje(jugador1,null)
    val personaje21 = new Personaje(jugador1,null)

    celda.personajes = List(personaje10,personaje11,personaje20,personaje21)

    assert(celda.sumaDePotenciasAtaqueEnemigo(jugador1) == 9)
  }

  "La suma de potencias de defensa enemigas" should "retornar 82" in {
    //potencia de defensa =  escudo + (energia/10) + (experiencia/3)

    val celda = new Celda(5, 5)

    //aliados

    val personaje10 = new Personaje(jugador1,null)
    val personaje11 = new Personaje(jugador1,null)
    personaje10.energia = 10;personaje10.experiencia = 3; personaje10.escudo = 30;//potencia = 32
    personaje11.energia = 50; personaje11.experiencia = 15; personaje11.escudo = 40; //potencia = 50

    //enemigos

    val personaje20 = new Personaje(jugador,null)
    val personaje21 = new Personaje(jugador,null)

    celda.personajes = List(personaje10,personaje11,personaje20,personaje21)

    assert(celda.sumaDePotenciasDefensaEnemigas(jugador)==82)
  }

}
