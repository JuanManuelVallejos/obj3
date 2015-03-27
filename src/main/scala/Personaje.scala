
class Personaje(val jugador: Jugador){

  val rnd = new scala.util.Random
  val rangoDeEscudo = 1000 to 2000
  val rangoDeExperiencia = 0 to 100
  val rangoDeEnergia = 100 to 200

  var escudo = rangoDeEscudo(rnd.nextInt(rangoDeEscudo length))
  var experiencia = rangoDeExperiencia(rnd.nextInt(rangoDeExperiencia length))
  var energia = rangoDeEnergia(rnd.nextInt(rangoDeEnergia length))


  def potenciaDeAtaque(): Int = (energia / 3) + (experiencia / 5)

  def potenciaDeDefensa(): Int = (energia / 10) + (experiencia / 3)

}
