package juego


abstract class Politica() {
  var personaje: Personaje = _
  def personaje(pers: Personaje) { personaje = pers }
}

abstract class PoliticaDeAccion extends Politica {

  def condicionDeMovimiento: Boolean

}

class Pancho extends PoliticaDeAccion {
  def condicionDeMovimiento: Boolean = false
}

class Colaborador extends PoliticaDeAccion {

  def condicionDeMovimiento: Boolean = personaje.celdasVecinasConCompanieros.length <= 1

}

class Precavido extends PoliticaDeAccion {

  def hayEnemigoConMasEnergia(celdas: List[Celda]): Boolean = {
    celdas.exists(_.enemigos(personaje).exists(_.masEnergia(personaje)))
  }

  def condicionDeMovimiento: Boolean = !hayEnemigoConMasEnergia(personaje.celdasVecinasConEnemigos)

}

abstract class PoliticaDeMovimiento extends Politica {
  def posicionAMoverse: (Int, Int)
}

class EvitarProblemas extends PoliticaDeMovimiento {

  def posicionAMoverse: (Int, Int) = {
    personaje.celdasVecinasConEnemigos.min(Ordering.by((c:Celda) => c.sumaDePotenciasAtaqueEnemigo(personaje.jugador))).coordenada()

  }
}

class Atacar extends PoliticaDeMovimiento {
  def posicionAMoverse: (Int, Int) = {

    val celdasVecConEnemigos = personaje.celdasVecinasConEnemigos

    if(celdasVecConEnemigos.isEmpty) personaje.celdasVecinas.head.coordenada()
    else{
      celdasVecConEnemigos.min(Ordering.by((c:Celda) => c.sumaDePotenciasDefensaEnemigas(personaje.jugador))).coordenada()
    }
  }
}

class Animo extends PoliticaDeMovimiento {
  def posicionAMoverse: (Int, Int) = {

    if (personaje.energia > 50) {
      val ataq = new Atacar
      ataq.personaje(personaje)
      ataq.posicionAMoverse
    } else {
      val ev = new EvitarProblemas
      ev.personaje(personaje)
      ev.posicionAMoverse
    }
  }
}

class ReforzarAtaque extends PoliticaDeMovimiento {

  def posicionAMoverse: (Int, Int) = {

    val celdasVecConAmigos = personaje.celdasVecinasConCompanieros
    if (celdasVecConAmigos.isEmpty) personaje.celdasVecinas.head.coordenada()
    else {
      celdasVecConAmigos.max(Ordering.by((c: Celda) => c.sumaDePotenciasAtaqueAmigo(personaje.jugador))).coordenada()
    }
  }
}
