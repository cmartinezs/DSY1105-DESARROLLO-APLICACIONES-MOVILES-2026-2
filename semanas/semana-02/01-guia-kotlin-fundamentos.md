# Guía práctica · Kotlin fundamentos

Esta guía acompaña **1.2.1 Programación en Kotlin y sus fundamentos** y **1.2.2 Guía 2 – Aplicando Kotlin Básico**.

La meta no es aprender “trucos cortos” de Kotlin. Primero comprenderemos la estructura de cada construcción con una sintaxis **explícita**, cercana a Java y fácil de seguir. Después veremos cómo Kotlin permite expresar la misma intención con menos código.

> **Regla de la guía:** primero entender, después acortar.

La progresión será:

```text
forma explícita
      ↓
comprender qué hace cada parte
      ↓
comparar con Java
      ↓
forma Kotlin más idiomática
      ↓
decidir cuándo conviene usarla
```

No siempre “menos líneas” significa “mejor código”. Una sintaxis corta es útil cuando sigue siendo clara para quien la lee.

---

# 1. Variables: primero declarar con claridad

## 1.1 Forma explícita

```kotlin
val nombre: String = "Ana"
var intentos: Int = 1
```

```text
val          nombre       : String       = "Ana"
↑            ↑              ↑              ↑
mutabilidad  identificador  tipo           valor
```

### `val`

La referencia no puede reasignarse.

```kotlin
val nombre: String = "Ana"

// No compila:
// nombre = "Camila"
```

### `var`

Permite reasignación.

```kotlin
var intentos: Int = 1
intentos = intentos + 1
```

## 1.2 Comparación con Java

Java:

```java
String nombre = "Ana";
int intentos = 1;
```

Kotlin explícito:

```kotlin
val nombre: String = "Ana"
var intentos: Int = 1
```

```text
Java   → String nombre
Kotlin → nombre: String
```

También desaparece el `;` obligatorio.

## 1.3 Inferencia de tipos

```kotlin
val nombre: String = "Ana"
```

puede escribirse:

```kotlin
val nombre = "Ana"
```

Y:

```kotlin
var intentos: Int = 1
```

puede escribirse:

```kotlin
var intentos = 1
```

Usaremos normalmente inferencia cuando el tipo sea evidente.

```kotlin
val edad = 20
val promedio = 5.8
val activo = true
val curso = "DSY1105"
```

### Descubre tú

Predice el tipo inferido en:

```kotlin
val a = 10
val b = 10.0
val c = "10"
val d = true
```

Luego verifica en IntelliJ.

---

# 2. Tipos básicos

```kotlin
val edad: Int = 20
val poblacion: Long = 1_500_000L
val promedio: Double = 5.8
val temperatura: Float = 20.5F
val activo: Boolean = true
val inicial: Char = 'A'
val curso: String = "DSY1105"
```

Java:

```java
int edad = 20;
double promedio = 5.8;
boolean activo = true;
```

Kotlin:

```kotlin
val edad: Int = 20
val promedio: Double = 5.8
val activo: Boolean = true
```

Para esta etapa basta comprender los tipos y sus operaciones.

---

# 3. De concatenación a String templates

## 3.1 Forma familiar

```kotlin
val nombre = "Camila"
val nota = 6.1

println(nombre + " obtuvo nota " + nota)
```

## 3.2 Forma Kotlin

```kotlin
println("$nombre obtuvo nota $nota")
```

Para una expresión:

```kotlin
println("Aprobó: ${nota >= 4.0}")
```

Comparación:

```text
"Hola " + nombre + ", tienes " + edad + " años"

↓

"Hola $nombre, tienes $edad años"
```

La segunda forma suele expresar mejor la intención, pero primero debemos comprender que ambas construyen un `String`.

---

# 4. Operadores

## 4.1 Aritméticos

```kotlin
val a = 10
val b = 3

val suma = a + b
val resta = a - b
val multiplicacion = a * b
val division = a / b
val resto = a % b
```

### División entera

```kotlin
val resultado = 10 / 3
println(resultado) // 3
```

Para obtener decimales:

```kotlin
val resultado = 10.0 / 3.0
```

## 4.2 Comparación

```kotlin
val mayor = a > b
val menor = a < b
val iguales = a == b
val distintos = a != b
```

## 4.3 Lógicos

```kotlin
val tieneEdad = true
val tieneEntrada = false

val puedeEntrar = tieneEdad && tieneEntrada
val puedeParticipar = tieneEdad || tieneEntrada
val noTieneEntrada = !tieneEntrada
```

---

# 5. Conversiones

## 5.1 Forma directa

```kotlin
val texto = "42"
val numero: Int = texto.toInt()
```

Si el texto no representa un entero válido, la conversión falla en ejecución.

## 5.2 Forma segura

```kotlin
val numero: Int? = texto.toIntOrNull()
```

El resultado puede ser un `Int` o `null`.

```text
toInt()       → confío en que el texto es válido
toIntOrNull() → acepto que la conversión puede fallar
```

La nulabilidad se estudiará con más profundidad cuando corresponda.

---

# 6. `if`: de sentencia explícita a expresión

## 6.1 Forma explícita

```kotlin
val nota = 5.2
var estado = ""

if (nota >= 4.0) {
    estado = "Aprobado"
} else {
    estado = "Reprobado"
}
```

Java tiene prácticamente la misma estructura:

```java
String estado;

if (nota >= 4.0) {
    estado = "Aprobado";
} else {
    estado = "Reprobado";
}
```

## 6.2 `if` como expresión

Kotlin permite que `if` produzca un valor:

```kotlin
val estado = if (nota >= 4.0) {
    "Aprobado"
} else {
    "Reprobado"
}
```

Esto permite reemplazar una variable mutable por una que se calcula una sola vez.

## 6.3 Forma breve

```kotlin
val estado = if (nota >= 4.0) "Aprobado" else "Reprobado"
```

La evolución es:

```text
if explícito + var
        ↓
if como expresión + val
        ↓
forma breve cuando siga siendo legible
```

### Micropráctica

Refactoriza:

```kotlin
val edad = 20
var mensaje = ""

if (edad >= 18) {
    mensaje = "Mayor de edad"
} else {
    mensaje = "Menor de edad"
}
```

hasta una expresión Kotlin.

---

# 7. `when`: primero comprender la necesidad

## 7.1 Con `if / else if`

```kotlin
val opcion = 2
var mensaje = ""

if (opcion == 1) {
    mensaje = "Crear"
} else if (opcion == 2) {
    mensaje = "Editar"
} else if (opcion == 3) {
    mensaje = "Eliminar"
} else {
    mensaje = "Opción desconocida"
}
```

## 7.2 `when` explícito

```kotlin
when (opcion) {
    1 -> {
        mensaje = "Crear"
    }
    2 -> {
        mensaje = "Editar"
    }
    3 -> {
        mensaje = "Eliminar"
    }
    else -> {
        mensaje = "Opción desconocida"
    }
}
```

## 7.3 `when` como expresión

```kotlin
val mensaje = when (opcion) {
    1 -> "Crear"
    2 -> "Editar"
    3 -> "Eliminar"
    else -> "Opción desconocida"
}
```

```text
if / else if
      ↓
when con bloques
      ↓
when como expresión
```

No usamos `when` porque sea “más Kotlin”, sino cuando representa mejor el problema.

---

# 8. Ciclos: primero con bloques completos

## 8.1 `while`

```kotlin
var contador = 1

while (contador <= 3) {
    println(contador)
    contador = contador + 1
}
```

Luego reconocemos la abreviación:

```kotlin
contador++
```

## 8.2 `for`

Java:

```java
for (int numero = 1; numero <= 5; numero++) {
    System.out.println(numero);
}
```

Kotlin:

```kotlin
for (numero in 1..5) {
    println(numero)
}
```

Solo después podemos mostrar la versión de una línea:

```kotlin
for (numero in 1..5) println(numero)
```

Que el lenguaje permita omitir llaves en un caso sencillo no significa que siempre convenga hacerlo.

## 8.3 Rangos

```text
1..5      → 1, 2, 3, 4, 5
1 until 5 → 1, 2, 3, 4
```

---

# 9. Funciones: de la forma completa a expression body

## 9.1 Forma completa

```kotlin
fun calcularDescuento(precio: Double, porcentaje: Double): Double {
    val descuento: Double = precio * porcentaje / 100
    return descuento
}
```

## 9.2 Eliminamos una variable innecesaria

```kotlin
fun calcularDescuento(precio: Double, porcentaje: Double): Double {
    return precio * porcentaje / 100
}
```

## 9.3 Expression body

```kotlin
fun calcularDescuento(precio: Double, porcentaje: Double): Double =
    precio * porcentaje / 100
```

Y, si resulta claro:

```kotlin
fun calcularDescuento(precio: Double, porcentaje: Double) =
    precio * porcentaje / 100
```

Primero debemos comprender:

```text
parámetros
→ cálculo
→ return
→ tipo retornado
```

Luego la sintaxis breve deja de parecer magia.

## 9.4 Otro ejemplo

Forma explícita:

```kotlin
fun esAprobado(nota: Double): Boolean {
    if (nota >= 4.0) {
        return true
    } else {
        return false
    }
}
```

Primera mejora:

```kotlin
fun esAprobado(nota: Double): Boolean {
    return nota >= 4.0
}
```

Expression body:

```kotlin
fun esAprobado(nota: Double): Boolean = nota >= 4.0
```

Con inferencia:

```kotlin
fun esAprobado(nota: Double) = nota >= 4.0
```

---

# 10. Colecciones: primero recorrer, luego operar

## 10.1 Crear una lista

Forma explícita:

```kotlin
val notas: List<Double> = listOf(5.5, 4.8, 6.2)
```

Con inferencia:

```kotlin
val notas = listOf(5.5, 4.8, 6.2)
```

## 10.2 Recorrido tradicional

```kotlin
for (nota in notas) {
    println(nota)
}
```

Después veremos:

```kotlin
notas.forEach { nota ->
    println(nota)
}
```

Y, finalmente:

```kotlin
notas.forEach {
    println(it)
}
```

La progresión es:

```text
for
↓
forEach con parámetro nombrado
↓
forEach con it
```

No empezaremos por `it` sin explicar qué representa.

---

# 11. `List` y `MutableList`

## 11.1 Lista de solo lectura

```kotlin
val nombres: List<String> = listOf("Ana", "Bruno", "Camila")
```

Podemos leer:

```kotlin
println(nombres[0])
```

pero no hacer:

```kotlin
// nombres.add("Diego")
```

## 11.2 Lista mutable

```kotlin
val nombres: MutableList<String> = mutableListOf("Ana", "Bruno", "Camila")

nombres.add("Diego")
```

Luego podemos usar inferencia:

```kotlin
val nombres = mutableListOf("Ana", "Bruno", "Camila")
```

### Pregunta

Si la variable está declarada con `val`, ¿cómo puede cambiar el contenido de la lista?

Pista:

```text
reasignar la variable
≠
modificar el objeto al que apunta
```

---

# 12. Del ciclo manual a `filter`

Supongamos:

```kotlin
val notas = listOf(5.5, 3.2, 6.1, 2.9)
```

Queremos obtener solo las notas aprobadas.

## 12.1 Primero: solución mediante ciclo

```kotlin
val aprobadas = mutableListOf<Double>()

for (nota in notas) {
    if (nota >= 4.0) {
        aprobadas.add(nota)
    }
}
```

Aquí podemos ver mecánicamente:

```text
crear resultado
↓
recorrer
↓
evaluar condición
↓
agregar si cumple
```

## Antes de continuar: ¿por qué ahora aparecen `{ }` después de una función?

Al mirar código como:

```kotlin
notas.filter { nota ->
    nota >= 4.0
}
```

es muy razonable preguntar:

> “En Java normalmente veo `filter(...)`. ¿Por qué Kotlin parece usar llaves?”

No es una regla especial de `filter`.

Las llaves representan una **lambda**, y Kotlin posee una regla llamada **trailing lambda** que permite escribir el último argumento lambda fuera de los paréntesis de una función.

Este tema es una profundización. Puedes continuar la guía comprendiendo que `{ nota -> ... }` representa la condición que `filter` ejecutará para cada elemento.

Si quieres entender **de dónde viene esa sintaxis, por qué solo funciona así con el último argumento, cómo se compara con Java y por qué más adelante Compose se ve tan declarativo**, revisa:

➡️ [**Kotlin avanzado · Lambdas, funciones de orden superior y trailing lambda**](./02-kotlin-avanzado-lambdas-y-trailing-lambda.md)

Después vuelve a este punto.

## 12.2 `filter` con parámetro nombrado

```kotlin
val aprobadas = notas.filter { nota ->
    nota >= 4.0
}
```

Podemos leerlo como:

```text
para cada nota
      ↓
evalúa nota >= 4.0
      ↓
true  → conserva el elemento
false → descártalo del resultado
```

## 12.3 Finalmente: `it`

Cuando existe un único parámetro implícito:

```kotlin
val aprobadas = notas.filter {
    it >= 4.0
}
```

Y, cuando la expresión sigue siendo legible:

```kotlin
val aprobadas = notas.filter { it >= 4.0 }
```

Lo importante es poder explicar cómo esta operación reemplaza el ciclo explícito anterior.

---

# 13. Del ciclo manual a `map`

Queremos transformar cada nota a texto.

## 13.1 Forma explícita

```kotlin
val textos = mutableListOf<String>()

for (nota in notas) {
    textos.add("Nota: $nota")
}
```

## 13.2 `map` con parámetro nombrado

```kotlin
val textos = notas.map { nota ->
    "Nota: $nota"
}
```

## 13.3 Forma corta

```kotlin
val textos = notas.map { "Nota: $it" }
```

```text
filter → conserva algunos elementos
map    → transforma cada elemento
```

---

# 14. Contar: del acumulador a `count`

Forma explícita:

```kotlin
var cantidadAprobadas = 0

for (nota in notas) {
    if (nota >= 4.0) {
        cantidadAprobadas = cantidadAprobadas + 1
    }
}
```

Primera abreviación:

```kotlin
cantidadAprobadas++
```

Luego podemos expresar directamente la intención:

```kotlin
val cantidadAprobadas = notas.count { nota ->
    nota >= 4.0
}
```

Y finalmente:

```kotlin
val cantidadAprobadas = notas.count { it >= 4.0 }
```

---

# 15. La sintaxis corta no es una competencia

Kotlin permite escribir:

```kotlin
val resultado = notas.filter { it >= 4.0 }.map { "Nota: $it" }
```

Pero también podemos separar:

```kotlin
val aprobadas = notas.filter { nota ->
    nota >= 4.0
}

val resultado = aprobadas.map { nota ->
    "Nota: $nota"
}
```

La pregunta no es:

> “¿Cuál tiene menos caracteres?”

Sino:

> “¿Cuál comunica mejor la intención para este equipo y este momento?”

---

# 16. Resumen de evolución sintáctica

## Variables

```kotlin
val nombre: String = "Ana"
```

↓ inferencia

```kotlin
val nombre = "Ana"
```

## Condicionales

```kotlin
var estado = ""
if (nota >= 4.0) {
    estado = "Aprobado"
} else {
    estado = "Reprobado"
}
```

↓ `if` como expresión

```kotlin
val estado = if (nota >= 4.0) {
    "Aprobado"
} else {
    "Reprobado"
}
```

↓ forma breve

```kotlin
val estado = if (nota >= 4.0) "Aprobado" else "Reprobado"
```

## Funciones

```kotlin
fun esAprobado(nota: Double): Boolean {
    return nota >= 4.0
}
```

↓ expression body

```kotlin
fun esAprobado(nota: Double): Boolean = nota >= 4.0
```

## Colecciones

```kotlin
for (nota in notas) {
    if (nota >= 4.0) {
        aprobadas.add(nota)
    }
}
```

↓ operación de colección

```kotlin
val aprobadas = notas.filter { nota ->
    nota >= 4.0
}
```

↓ parámetro implícito

```kotlin
val aprobadas = notas.filter { it >= 4.0 }
```

---

# 17. Rutina práctica para cada concepto

Después de cada apartado:

1. ejecutar la versión explícita;
2. explicar qué hace cada línea;
3. modificar un dato;
4. predecir la salida;
5. provocar un error pequeño;
6. leer el mensaje del compilador;
7. corregirlo;
8. transformar la solución a una versión más idiomática;
9. comprobar que ambas producen el mismo resultado;
10. explicar cuál preferirías y por qué.

---

# 18. Errores frecuentes

- aprender Kotlin memorizando únicamente sintaxis corta;
- usar `var` para todo;
- creer que inferencia significa que Kotlin “no tiene tipos”;
- confundir `=` con `==`;
- olvidar que `1..5` incluye ambos extremos;
- usar `toInt()` sobre texto inválido sin pensar qué ocurre;
- usar `it` sin comprender qué representa;
- creer que las llaves de `filter { ... }` sustituyen mágicamente sus paréntesis;
- encadenar `filter`, `map` y otras operaciones sin poder explicar cada transformación;
- escribir funciones de una línea antes de comprender parámetros y retorno;
- asumir que menos líneas siempre significa mejor código.

---

# 19. Puente hacia PocketLog

La guía de **PocketLog Semana 02** aplicará la misma progresión.

Antes de llegar a:

```kotlin
val pendientes = completados.count { !it }
```

primero construiremos:

```kotlin
var pendientes = 0

for (completado in completados) {
    if (!completado) {
        pendientes = pendientes + 1
    }
}
```

Luego podremos comparar:

```kotlin
val pendientes = completados.count { completado ->
    !completado
}
```

Y finalmente:

```kotlin
val pendientes = completados.count { !it }
```

El criterio durante todo el proyecto formativo será:

> **primero hacer visible el mecanismo; después aprender la abstracción que permite expresarlo mejor.**
