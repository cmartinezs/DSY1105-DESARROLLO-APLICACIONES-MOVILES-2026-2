# 3 · Control de errores y puente a corrutinas

> Este contenido se ejecuta según avance real. No se considera visto solo por estar publicado.

## Errores previsibles

Kotlin permite validar antes de ejecutar una operación peligrosa y también capturar excepciones cuando corresponde.

```kotlin
val texto = "123"
val numero = texto.toIntOrNull()

if (numero == null) {
    println("No es un número válido")
} else {
    println(numero * 2)
}
```

Para entrada de usuario, `toIntOrNull()` suele expresar mejor el problema que provocar deliberadamente una excepción.

```kotlin
try {
    val numero = "abc".toInt()
    println(numero)
} catch (e: NumberFormatException) {
    println("Formato inválido")
}
```

## Principios

No usar `try/catch` para esconder cualquier fallo. Captura solo aquello que puedas interpretar o recuperar razonablemente. Evita `catch (e: Exception)` como solución automática.

## ¿Por qué hablar de asincronía en móviles?

Una aplicación no debería congelar su interfaz mientras espera una operación lenta como red o persistencia. Las corrutinas de Kotlin permiten expresar trabajo suspendible de forma estructurada.

## Primera lectura, solo si se alcanza

```kotlin
suspend fun cargarDatos(): String {
    return "datos"
}
```

`suspend` no significa «ejecutar en otro hilo» ni «hacerlo más rápido». Indica que la función puede suspenderse y reanudarse dentro de un contexto de corrutina.

Antes de profundizar se debe comprender: funciones, retorno, lambdas básicas y flujo normal de ejecución. En una sesión inicial interesa el modelo mental, no memorizar `launch`, `async`, dispatchers y scopes simultáneamente.

## Checkpoint

Distingue validación de captura de excepciones; explica por qué una UI móvil no debe bloquearse; explica qué **no** significa `suspend`. Si no se alcanzó corrutinas en aula, registra este bloque como material disponible pendiente.