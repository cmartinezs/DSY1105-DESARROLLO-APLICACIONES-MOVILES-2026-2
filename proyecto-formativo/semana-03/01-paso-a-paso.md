# Semana 03 · Paso a paso

## Modelo
```kotlin
class Registro(
    val id: Int,
    var titulo: String,
    var categoria: String,
    var completado: Boolean = false
) {
    fun completar() { completado = true }
}
```

## Colección
```kotlin
val registros = mutableListOf<Registro>()
```

## Buscar y filtrar
```kotlin
val encontrado = registros.find { it.id == idBuscado }
val estudio = registros.filter { it.categoria.equals("estudio", true) }
val pendientes = registros.filter { !it.completado }
val cantidadPendientes = registros.count { !it.completado }
```

Validar vacío y números; reservar `try/catch` para errores reales. El estudiante debe explicar por qué una lista de objetos mejora la representación.
