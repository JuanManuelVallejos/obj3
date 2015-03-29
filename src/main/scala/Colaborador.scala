
class Colaborador (val tablero: Tablero) extends PoliticaPersonal(tablero){

  override def sugerenciaPersonal(personaje: Personaje): Unit = personaje.coordenada

}
