import scala.util.Random

<<<<<<< HEAD
class Personaje(val jugador: Jugador, val tablero: Tablero){
=======
class Personaje(val jugador: Jugador, var celda: Celda){
>>>>>>> 8ad179117aec626c0257e4b20a9b119eb8a32c3c

  val rnd = new Random()
  val rangoDeEscudo = 1000 to 2000
  val rangoDeExperiencia = 0 to 100
  val rangoDeEnergia = 100 to 200
  var politicaDeAccion: PoliticaDeAccion = _
  var politicaDeMovimiento: PoliticaDeMovimiento = _

  var escudo = rangoDeEscudo(rnd.nextInt(rangoDeEscudo length))
  var experiencia = rangoDeExperiencia(rnd.nextInt(rangoDeExperiencia length))
  var energia = rangoDeEnergia(rnd.nextInt(rangoDeEnergia length))

  var politicaPersonal:PoliticaPersonal = new Pancho(tablero)
  var politicaPosicional:PoliticaPosicional = new PoliticaPosicional

  var coordenada = (0,0)

  def potenciaDeAtaque(): Int = (energia / 3) + (experiencia / 5)

  def potenciaDeDefensa(): Int = escudo + (energia / 10) + (experiencia / 3)

<<<<<<< HEAD
  def setPoliticaPersonal(politicaPers: PoliticaPersonal)={ politicaPersonal = politicaPers }

  def setPoliticaPosicional(politicaPos: PoliticaPosicional)={ politicaPosicional = politicaPos }

  def moverAPos(x: Int, y: Int) ={ coordenada = (x,y)}

=======
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

  def celdasVecinasConEnemigos(): List[Celda] = jugador.celdasVecinasConEnemigos(celda)

  def masEnergia(personaje: Personaje): Boolean = energia > personaje.energia
>>>>>>> 8ad179117aec626c0257e4b20a9b119eb8a32c3c
}
