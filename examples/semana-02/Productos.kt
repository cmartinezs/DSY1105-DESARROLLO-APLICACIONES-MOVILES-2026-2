fun main() {
    val nombre = "Valentina"
    val precios = listOf(12990, 7990, 15990, 4990)
    val presupuesto = 12000

    println("Cliente: $nombre")
    println("Presupuesto: $$presupuesto")

    val disponibles = precios.filter { it <= presupuesto }
    println("Productos dentro del presupuesto: $disponibles")

    val preciosConIva = precios.map { precio -> precio * 1.19 }
    println("Precios con IVA: $preciosConIva")

    val cantidadDisponibles = disponibles.size
    val mensaje = when {
        cantidadDisponibles == 0 -> "No hay opciones"
        cantidadDisponibles == 1 -> "Hay una opción"
        else -> "Hay $cantidadDisponibles opciones"
    }

    println(mensaje)
}
