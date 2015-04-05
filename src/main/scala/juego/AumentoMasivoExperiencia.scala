package juego


class AumentoMasivoExperiencia(val sobreQueCosa: AumentoMasivoExperiencia) {

  var seEjecuto = false
  def ejecutar {
    if (!seEjecuto) sobreQueCosa.aumentarMasivamenteExperiencia
      seEjecuto = true
  }

  def toString =
  "Aumento masivo de experiencia sobre " +
    sobreQueCosa.nombre + " : " +
    (if (seEjecuto) "ejecutado" else "pendiente")

}
