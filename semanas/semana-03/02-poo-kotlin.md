# 2 · POO en Kotlin

## El problema que motiva una clase

Tres listas paralelas funcionan mientras recordemos que la posición 0 de cada una describe el mismo registro. Una clase agrupa datos y comportamiento bajo una abstracción coherente.

```kotlin
class Registro(
    val titulo: String,
    val categoria: String,
    var completado: Boolean = false
) {
    fun completar() {
        completado = true
    }

    fun resumen(): String {
        return "$titulo [$categoria] - ${if (completado) "OK" else "Pendiente"}"
    }
}
```

Uso:

```kotlin
val registro = Registro("Practicar Kotlin", "Estudio")
println(registro.resumen())
registro.completar()
println(registro.resumen())
```

## Kotlin reduce ceremonia, no elimina conceptos

El constructor primario puede declararse en la cabecera. `val` crea una propiedad que no puede reasignarse; `var`, una que sí. Esto no significa que todo deba ser público y mutable.

## Encapsulamiento

```kotlin
class Cuenta(private var saldo: Double) {
    fun depositar(monto: Double) {
        if (monto > 0) saldo += monto
    }

    fun consultarSaldo(): Double = saldo
}
```

El estado se modifica mediante comportamiento controlado.

## `data class`

```kotlin
data class Categoria(val id: Int, val nombre: String)
```

Una `data class` es útil para objetos cuyo propósito principal es representar datos y obtiene implementaciones convenientes como `toString`, `equals` y `copy`. No reemplaza automáticamente a todas las clases de dominio.

## Colecciones de objetos

```kotlin
val registros = mutableListOf(
    Registro("Leer", "Estudio"),
    Registro("Comprar alimento", "Personal")
)

val pendientes = registros.filter { !it.completado }
```

Aquí se conectan las dos mitades de la semana: colecciones + objetos.

## Ejercicios

Crea `Producto`, `Contacto` y `Evento` en ejercicios separados. Para cada uno define propiedades coherentes, al menos un comportamiento y dos instancias. Después crea una lista de uno de los tipos y realiza un filtro.

## Checkpoint

Explica: clase vs objeto; propiedad vs variable local; método/comportamiento; `val` vs `var` dentro del modelo; por qué agrupar datos relacionados reduce el problema de listas paralelas.