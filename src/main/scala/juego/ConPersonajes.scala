package juego

trait ConPersonajes {

  var personajes = List[Personaje]()

  def aumentarMasivamenteExperiencia: Unit ={
    personajes.foreach(personaje =>
      if(personaje.energia >= 10) personaje.experiencia += 2
    )
  }

}
