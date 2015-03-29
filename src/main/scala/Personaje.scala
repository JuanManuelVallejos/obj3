
class Personaje(val jugador: Jugador, val tablero: Tablero){

  val rnd = new scala.util.Random
  val rangoDeEscudo = 1000 to 2000
  val rangoDeExperiencia = 0 to 100
  val rangoDeEnergia = 100 to 200

  var escudo = rangoDeEscudo(rnd.nextInt(rangoDeEscudo length))
  var experiencia = rangoDeExperiencia(rnd.nextInt(rangoDeExperiencia length))
  var energia = rangoDeEnergia(rnd.nextInt(rangoDeEnergia length))

  var politicaPersonal:PoliticaPersonal = new Pancho(tablero)
  var politicaPosicional:PoliticaPosicional = new PoliticaPosicional

  var coordenada = (0,0)

  def potenciaDeAtaque(): Int = (energia / 3) + (experiencia / 5)

  def potenciaDeDefensa(): Int = (energia / 10) + (experiencia / 3)

  def setPoliticaPersonal(politicaPers: PoliticaPersonal)={ politicaPersonal = politicaPers }

  def setPoliticaPosicional(politicaPos: PoliticaPosicional)={ politicaPosicional = politicaPos }

  def moverAPos(x: Int, y: Int) ={ coordenada = (x,y)}

}
