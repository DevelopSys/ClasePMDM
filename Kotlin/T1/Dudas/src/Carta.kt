class Carta(var representacion: String) {

    // 10D
    var valor: Int? = null
    var palo: String? = null

    init {
        when (representacion.substring(0, representacion.length - 1)) {
            "J", "Q", "K" -> {
                valor = 10
            }
            else -> {
                valor = representacion.substring(0, representacion.length - 1).toInt()
            }
        }

    }

}