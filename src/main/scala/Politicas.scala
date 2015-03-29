
abstract class Politica() {
  var personaje: Personaje = _
  def personaje(pers: Personaje) { personaje = pers }
}

abstract class PoliticaDeAccion extends Politica {

  def condicionDeMovimiento: Boolean

  def coordenadasDeCelda: (Int, Int) = (personaje.celda.x, personaje.celda.y)

  def sugerir: (Int, Int) = {
    if(condicionDeMovimiento) {
      personaje.posicionAMoverse
    } else {
      coordenadasDeCelda
    }
  }

}

class Pancho extends PoliticaDeAccion {
  def condicionDeMovimiento(): Boolean = false
}

class Colaborador extends PoliticaDeAccion {

  def condicionDeMovimiento(): Boolean = personaje.celdasVecinasConCompanieros().length > 1

}

class Precavido extends PoliticaDeAccion {

  def hayEnemigoConMasEnergia(celdas: List[Celda]): Boolean = {
    celdas.exists(_.enemigos(personaje).exists(_.masEnergia(personaje)))
  }

  def condicionDeMovimiento(): Boolean = hayEnemigoConMasEnergia(personaje.celdasVecinasConEnemigos())

}

abstract class PoliticaDeMovimiento extends Politica {
  def posicionAMoverse: (Int, Int)
}

class EvitarProblemas extends PoliticaDeMovimiento {
  def posicionAMoverse: (Int, Int) = {
    (personaje.celda.x + 1, personaje.celda.y)
  }
}