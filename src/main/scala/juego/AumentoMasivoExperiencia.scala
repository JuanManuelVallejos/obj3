package juego

class AumentoMasivoExperiencia(val sobreQueCosa: ConPersonajes with ConNombre) {

  var seEjecuto = false
  def ejecutar {
    if (!seEjecuto) sobreQueCosa.aumentarMasivamenteExperiencia
    seEjecuto = true
  }

  override def toString =
    "Aumento masivo de experiencia sobre " +
      sobreQueCosa.nombre + " : " +
      (if (seEjecuto) "ejecutado" else "pendiente")

}