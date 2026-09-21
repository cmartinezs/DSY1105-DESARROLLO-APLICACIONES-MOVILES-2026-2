package cl.duoc.rutalocal

data class Lugar(
    val id: Int,
    val nombre: String,
    val categoria: String,
    val descripcion: String,
    val referencia: String
)

val lugaresDemo = listOf(
    Lugar(
        id = 1,
        nombre = "Biblioteca Central",
        categoria = "Estudio",
        descripcion = "Espacio tranquilo para estudiar, leer o trabajar en grupo.",
        referencia = "Edificio A · primer piso"
    ),
    Lugar(
        id = 2,
        nombre = "Casino",
        categoria = "Alimentación",
        descripcion = "Punto principal para almorzar o comprar algo durante la jornada.",
        referencia = "Patio central"
    ),
    Lugar(
        id = 3,
        nombre = "Sala de estudio 24",
        categoria = "Estudio",
        descripcion = "Sala con mesas y enchufes pensada para trabajo individual o colaborativo.",
        referencia = "Edificio B · segundo piso"
    ),
    Lugar(
        id = 4,
        nombre = "Punto de primeros auxilios",
        categoria = "Servicios",
        descripcion = "Lugar de apoyo para incidentes menores y orientación de salud.",
        referencia = "Junto a recepción"
    )
)
