# 3 · Control de errores y corrutinas

> Este contenido se ejecuta según avance real. Publicarlo no significa que haya sido trabajado en aula.

## 1. Primero: prevenir errores cuando sea razonable

```kotlin
val texto = "123"
val numero = texto.toIntOrNull()

if (numero == null) {
    println("No es un número válido")
} else {
    println(numero * 2)
}
```

`toIntOrNull()` permite representar el fallo esperado sin usar una excepción como control normal del flujo.

## 2. `try-catch`: cuando una operación puede lanzar una excepción

```kotlin
try {
    val numero = "abc".toInt()
    println(numero)
} catch (e: NumberFormatException) {
    println("Formato inválido")
}
```

Reglas:

- captura una excepción que puedas interpretar o recuperar;
- evita `catch (e: Exception)` por defecto;
- no uses `try-catch` para esconder errores de programación;
- distingue un dato inválido esperado de un fallo inesperado.

## Mini práctica

Implementa una función que reciba un texto y devuelva el doble de un entero válido. Haz dos versiones:

1. usando `toIntOrNull()`;
2. usando `try-catch` con `NumberFormatException`.

Explica cuál usarías en una entrada habitual de usuario y por qué.

---

# 4 · ¿Por qué una aplicación necesita asincronía?

Supón que una aplicación debe consultar una API. Si la operación tarda varios segundos y bloquea el hilo que atiende la interfaz, la aplicación parece congelada.

```text
trabajo rápido → respuesta inmediata
trabajo lento bloqueante → interfaz congelada
trabajo suspendible → la aplicación puede seguir respondiendo
```

Las corrutinas permiten expresar trabajo suspendible de forma estructurada y legible.

## `suspend` no significa «otro hilo»

```kotlin
suspend fun cargarDatos(): String {
    return "datos"
}
```

`suspend` indica que una función **puede suspenderse y reanudarse** dentro de una corrutina. No significa automáticamente:

- crear un hilo;
- ejecutar en paralelo;
- ejecutar más rápido;
- evitar por sí sola toda operación bloqueante.

## Primera demostración controlada

Para una aplicación de consola que tenga `kotlinx-coroutines` disponible:

```kotlin
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun cargarDatos(): String {
    delay(1000)
    return "Datos cargados"
}

fun main() = runBlocking {
    println("Inicio")
    println(cargarDatos())
    println("Fin")
}
```

`delay()` suspende la corrutina sin representar un `Thread.sleep()` bloqueante. `runBlocking` se utiliza aquí únicamente como puente didáctico para ejecutar una corrutina desde una consola.

## Qué NO hacer todavía

No memorices simultáneamente `launch`, `async`, `Dispatchers`, scopes, jobs y manejo avanzado de concurrencia. Primero comprende:

1. qué problema queremos resolver;
2. qué significa suspensión;
3. que una función `suspend` debe ejecutarse dentro de un contexto de corrutina;
4. que asincronía y paralelismo no son sinónimos.

## Checkpoint

Debes poder explicar:

- validación vs excepción;
- cuándo `try-catch` es razonable;
- por qué una UI móvil no debe bloquearse;
- qué significa `suspend`;
- qué **no** garantiza una corrutina;
- por qué `runBlocking` es aceptable para una demostración de consola pero no representa el patrón normal de una UI Android.