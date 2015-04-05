package juego

trait AumentoDeExperiencia {

  val personajes:List[Personaje]
  val nombre: String

  def aumentarMasivamenteExperiencia: Unit ={
    personajes.foreach(personaje =>
      if(personaje.energia <= 10) personaje.experiencia += 2
    )
  }

}
