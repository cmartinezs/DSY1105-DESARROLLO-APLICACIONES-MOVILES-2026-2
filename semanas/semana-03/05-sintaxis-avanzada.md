# 5 · Sintaxis avanzada Kotlin · `data class` y `sealed class`

Este bloque acompaña el recurso institucional **1.3.3 · Corrutinas y sintaxis avanzada Kotlin**. El objetivo es comprender para qué sirven estas construcciones, no usarlas solo porque reducen líneas de código.

## `data class`

Cuando una clase existe principalmente para representar datos, Kotlin puede generar automáticamente comportamiento útil.

```kotlin
data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double
)
```

```kotlin
val p1 = Producto(1, "Teclado", 29990.0)
val p2 = p1.copy(precio = 24990.0)

println(p1)
println(p2)
println(p1 == p2)
```

Una `data class` genera implementaciones convenientes como `toString()`, `equals()`, `hashCode()` y `copy()`.

### Cuándo usarla

Úsala cuando el propósito principal del tipo sea **transportar o representar datos**.

No reemplaza automáticamente a toda clase de dominio. Si un objeto protege invariantes y concentra comportamiento importante, una clase normal puede expresar mejor esa responsabilidad.

---

## `sealed class`

Una `sealed class` permite modelar un conjunto **cerrado y conocido** de variantes.

```kotlin
sealed class Resultado

data class Exito(val mensaje: String) : Resultado()
data class Error(val causa: String) : Resultado()
object Cargando : Resultado()
```

Luego podemos tratar cada variante de manera explícita:

```kotlin
fun mostrar(resultado: Resultado) {
    when (resultado) {
        is Exito -> println("OK: ${resultado.mensaje}")
        is Error -> println("Error: ${resultado.causa}")
        Cargando -> println("Cargando...")
    }
}
```

El compilador conoce todas las alternativas de la jerarquía sellada, por lo que `when` puede ser exhaustivo.

## ¿Por qué esto es útil en aplicaciones móviles?

Una operación de red o persistencia suele tener estados como:

```text
Cargando
Éxito
Error
```

Modelarlos como variantes de un mismo tipo evita combinaciones incoherentes de booleanos como:

```text
isLoading = true
hasError = true
success = true
```

## Relación con POO

`sealed class` conecta varios conceptos ya trabajados:

- herencia;
- especialización;
- polimorfismo;
- modelado de estados;
- control explícito de variantes.

## Mini práctica

Modela un proceso de autenticación con exactamente estos estados:

- `Esperando`;
- `Autenticado`, con nombre de usuario;
- `Rechazado`, con motivo.

Después crea una función que reciba el tipo general y use `when` para mostrar el mensaje correspondiente.

## Checkpoint

Explica:

1. por qué `Producto` podría ser `data class`;
2. por qué una cuenta bancaria con reglas complejas no necesariamente debería serlo;
3. qué problema resuelve una `sealed class`;
4. cómo una jerarquía sellada se relaciona con herencia y polimorfismo.