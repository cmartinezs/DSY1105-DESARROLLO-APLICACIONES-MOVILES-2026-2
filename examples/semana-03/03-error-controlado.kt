fun main() {
    val valores = listOf(10, 20, 30)
    val indice = 5
    val valor = valores.getOrNull(indice)
    println(valor ?: "Índice fuera de rango")
}
