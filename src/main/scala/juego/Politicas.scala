package juego


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

  def posicionAMoverse( cond: ()->Boolean): (Int, Int) = {

    var menor:Celda = null

    if(personaje.celdasVecinasConEnemigos() == null){ menor =  personaje.celda}else {
      menor = personaje.celdasVecinasConEnemigos().apply(0)
      personaje.celdasVecinasConEnemigos().foreach(celda => if (cond.app > celda.sumaDePotenciasAtaqueEnemigo(personaje.jugador)) menor = celda)
    }
    menor.coordenada()
  }
}

class Atacar extends PoliticaDeMovimiento {
  def posicionAMoverse: (Int, Int) = {
    var menor:Celda = null
    if(personaje.celdasVecinasConEnemigos() == null){ menor =  personaje.jugador.tablero.celdaNorte(personaje.celda)}else {
      menor = personaje.celdasVecinasConEnemigos().apply(0)
      personaje.celdasVecinasConEnemigos().foreach(celda => if(menor.sumaDePotenciasDefensa(personaje.jugador) > celda.sumaDePotenciasDefensa(personaje.jugador)) menor = celda)
    }
     menor.coordenada()
  }
}


class Animo extends PoliticaDeMovimiento {
  def posicionAMoverse: (Int, Int) = {

    if (personaje.energia > 50) {
      var ataq = new Atacar
      ataq.personaje(personaje)
      ataq.posicionAMoverse
    } else {
      var ev = new EvitarProblemas
      ev.personaje(personaje)
      ev.posicionAMoverse
    }
  }

  class ReforzarAtaque extends PoliticaDeMovimiento {
    def posicionAMoverse: (Int, Int) = {
      var mayor: Celda = null
      if (personaje.celdasVecinasConCompanieros() == null) {
        mayor = personaje.celda
      } else {
        mayor = personaje.celdasVecinasConCompanieros().apply(0)
        personaje.celdasVecinasConCompanieros().foreach(celda => if (mayor.sumaDePotenciasAtaqueAmigo(personaje.jugador) < celda.sumaDePotenciasAtaqueAmigo(personaje.jugador)) mayor = celda)
      }
      mayor.coordenada()
    }
  }

}
