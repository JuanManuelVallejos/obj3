package juego

import scala.util.Random

class Personaje(val jugador: Jugador, var celda: Celda){

  val rnd = new Random()
  val rangoDeEscudo = 1000 to 2000
  val rangoDeExperiencia = 0 to 100
  val rangoDeEnergia = 100 to 200


  var politicaDeAccion: PoliticaDeAccion = _
  var politicaDeMovimiento: PoliticaDeMovimiento = _
  var escudo = rangoDeEscudo(rnd.nextInt(rangoDeEscudo length))
  var experiencia = rangoDeExperiencia(rnd.nextInt(rangoDeExperiencia length))
  var energia = rangoDeEnergia(rnd.nextInt(rangoDeEnergia length))


  def potenciaDeAtaque(): Int = (energia / 3) + (experiencia / 5)

  def potenciaDeDefensa(): Int = escudo + (energia / 10) + (experiencia / 3)

  def politicaDeAccion(accion: PoliticaDeAccion) {
    politicaDeAccion = accion
    accion.personaje(this)
  }

  def politicaDeMovimiento(movimiento: PoliticaDeMovimiento) {
    politicaDeMovimiento = movimiento
    movimiento.personaje(this)
  }

  def celdasVecinasConCompanieros() = jugador.celdasVecinasConCompanieros(celda)

  def posicionAMoverse(): (Int, Int) = politicaDeMovimiento.posicionAMoverse

  def celdasVecinasConEnemigos: List[Celda] = jugador.celdasVecinasConEnemigos(celda)

  def celdasVecinas: List[Celda] = jugador.celdasVecinas(celda)

  def masEnergia(personaje: Personaje): Boolean = energia > personaje.energia
}
