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

En Kotlin podemos declarar el tipo directamente:

```kotlin
val nombre: String = "Ana"
var intentos: Int = 1
```

Aquí podemos identificar claramente:

```text
val          nombre       : String       = "Ana"
↑            ↑              ↑              ↑
mutabilidad  identificador  tipo           valor
```

### `val`

La referencia no puede reasignarse.

```kotlin
val nombre: String = "Ana"

// Esto no compila:
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

Una diferencia visible es que Kotlin coloca el tipo **después del nombre**.

```text
Java   → String nombre
Kotlin → nombre: String
```

También desaparece el `;` obligatorio.

## 1.3 Evolucionamos: inferencia de tipos

El compilador puede deducir el tipo desde el valor asignado.

Por eso:

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

### ¿Cuál usar?

Usaremos normalmente inferencia cuando el tipo sea evidente:

```kotlin
val edad = 20
val promedio = 5.8
val activo = true
val curso = "DSY1105"
```

Pero escribir el tipo puede mejorar claridad en algunos casos:

```kotlin
val total: Double = 10.0
```

### Descubre tú

Predice el tipo que Kotlin inferirá para:

```kotlin
val a = 10
val b = 10.0
val c = "10"
val d = true
```

Luego verifica en IntelliJ.

---

# 2. Tipos básicos

Los tipos que utilizaremos inicialmente son:

```kotlin
val edad: Int = 20
val poblacion: Long = 1_500_000L
val promedio: Double = 5.8
val temperatura: Float = 20.5F
val activo: Boolean = true
val inicial: Char = 'A'
val curso: String = "DSY1105"
```

## Kotlin no utiliza tipos primitivos en la sintaxis del lenguaje

En Java probablemente han visto:

```java
int edad = 20;
double promedio = 5.8;
boolean activo = true;
```

En Kotlin escribimos:

```kotlin
val edad: Int = 20
val promedio: Double = 5.8
val activo: Boolean = true
```

Para esta etapa basta entender sus tipos y operaciones. Los detalles internos de representación no son necesarios todavía.

---

# 3. Mostrar información: de concatenación a String templates

## 3.1 Forma conocida desde Java

Podemos concatenar textos:

```kotlin
val nombre = "Camila"
val nota = 6.1

println(nombre + " obtuvo nota " + nota)
```

Esto funciona y resulta familiar si venimos de Java.

## 3.2 Problema

Cuando aparecen más valores, la lectura se vuelve más ruidosa:

```kotlin
println("Estudiante: " + nombre + " | Nota: " + nota + " | Aprobó: " + (nota >= 4.0))
```

## 3.3 Forma idiomática: String templates

Kotlin permite insertar variables directamente:

```kotlin
println("$nombre obtuvo nota $nota")
```

Para insertar una expresión usamos `${...}`:

```kotlin
println("Aprobó: ${nota >= 4.0}")
```

La versión anterior completa puede transformarse en:

```kotlin
println("Estudiante: $nombre | Nota: $nota | Aprobó: ${nota >= 4.0}")
```

### Comparación

```text
Concatenación
"Hola " + nombre + ", tienes " + edad + " años"

String template
"Hola $nombre, tienes $edad años"
```

### Decisión

En Kotlin preferiremos normalmente String templates porque expresan mejor la intención.

No obstante, primero es importante comprender que ambas formas construyen un `String`.

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

### Atención con la división entera

```kotlin
val resultado = 10 / 3
println(resultado)
```

Resultado:

```text
3
```

Si necesitamos decimales:

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

# 5. Conversiones: primero la forma directa

Supongamos que recibimos:

```kotlin
val texto = "42"
```

## 5.1 Conversión directa

```kotlin
val numero: Int = texto.toInt()
```

Esto funciona si el texto representa un número válido.

Pero:

```kotlin
val texto = "cuarenta y dos"
val numero = texto.toInt()
```

provocará un error en ejecución.

## 5.2 Forma segura

Kotlin ofrece:

```kotlin
val numero: Int? = texto.toIntOrNull()
```

Ahora el resultado puede ser:

```text
42
```

o:

```text
null
```

El `?` indica que la variable puede no contener un `Int` válido.

> La nulabilidad se estudiará con más profundidad cuando corresponda. Por ahora interesa comprender por qué `toIntOrNull()` evita que una entrada inválida detenga inmediatamente el programa.

### Comparación

```text
toInt()       → confío en que el texto es válido
toIntOrNull() → acepto que la conversión puede fallar
```

---

# 6. Condicional `if`: de sentencia explícita a expresión

## 6.1 Forma explícita

Comencemos de una manera muy similar a Java:

```kotlin
val nota = 5.2
var estado = ""

if (nota >= 4.0) {
    estado = "Aprobado"
} else {
    estado = "Reprobado"
}

println(estado)
```

Aquí podemos seguir el flujo claramente:

```text
crear variable
      ↓
evaluar condición
      ↓
asignar un valor u otro
      ↓
mostrar resultado
```

## 6.2 Comparación con Java

Java:

```java
String estado;

if (nota >= 4.0) {
    estado = "Aprobado";
} else {
    estado = "Reprobado";
}
```

Kotlin puede escribirse prácticamente igual en su estructura.

## 6.3 Kotlin permite algo más: `if` produce un valor

Como ambas ramas producen un resultado, podemos eliminar la variable mutable:

```kotlin
val estado = if (nota >= 4.0) {
    "Aprobado"
} else {
    "Reprobado"
}
```

Esta versión tiene una ventaja conceptual:

```text
antes
var estado
→ después lo modificamos

ahora
val estado
→ se calcula una vez
```

## 6.4 Forma corta

Si cada rama es muy simple:

```kotlin
val estado = if (nota >= 4.0) "Aprobado" else "Reprobado"
```

Las tres versiones son válidas.

### ¿Cuál enseñar primero?

Primero:

```kotlin
if (...) {
    ...
} else {
    ...
}
```

Después:

```kotlin
val resultado = if (...) {
    ...
} else {
    ...
}
```

Finalmente, cuando siga siendo legible:

```kotlin
val resultado = if (...) valorA else valorB
```

### Micropráctica

Convierte esta versión explícita a una expresión Kotlin:

```kotlin
val edad = 20
var mensaje = ""

if (edad >= 18) {
    mensaje = "Mayor de edad"
} else {
    mensaje = "Menor de edad"
}
```

---

# 7. `when`: primero entender el problema que resuelve

Supongamos que tenemos varias opciones.

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

Funciona.

Pero estamos comparando repetidamente la misma variable.

## 7.2 `when` explícito

```kotlin
val opcion = 2
var mensaje = ""

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

Al igual que `if`, `when` puede producir un valor:

```kotlin
val mensaje = when (opcion) {
    1 -> "Crear"
    2 -> "Editar"
    3 -> "Eliminar"
    else -> "Opción desconocida"
}
```

### Evolución

```text
if / else if
      ↓
when con bloques
      ↓
when como expresión
```

No usamos `when` porque sea “más Kotlin”. Lo usamos cuando representa mejor el problema.

---

# 8. Ciclos: primero con bloques completos

## 8.1 `while`

Forma explícita:

```kotlin
var contador = 1

while (contador <= 3) {
    println(contador)
    contador = contador + 1
}
```

Después podemos reconocer la abreviación:

```kotlin
contador++
```

Quedando:

```kotlin
var contador = 1

while (contador <= 3) {
    println(contador)
    contador++
}
```

## 8.2 `for`

Java suele requerir algo como:

```java
for (int numero = 1; numero <= 5; numero++) {
    System.out.println(numero);
}
```

En Kotlin expresamos directamente el rango:

```kotlin
for (numero in 1..5) {
    println(numero)
}
```

Primero usaremos siempre las llaves para que sea visible el bloque.

Solo después mostraremos que, si existe una única instrucción, Kotlin permite:

```kotlin
for (numero in 1..5) println(numero)
```

### Recomendación pedagógica

Que el lenguaje permita omitir llaves en un caso sencillo **no significa que siempre convenga hacerlo**.

Mientras estamos aprendiendo flujo de control, la versión con bloque suele ser más clara.

## 8.3 Rangos

```kotlin
for (numero in 1..5) {
    println(numero)
}
```

`1..5` incluye ambos extremos.

También podemos encontrar:

```kotlin
for (numero in 1 until 5) {
    println(numero)
}
```

Aquí `5` queda fuera.

Comparación:

```text
1..5      → 1, 2, 3, 4, 5
1 until 5 → 1, 2, 3, 4
```

---

# 9. Funciones: de la forma completa a expression body

## 9.1 Forma completa

Comencemos declarando todo explícitamente:

```kotlin
fun calcularDescuento(precio: Double, porcentaje: Double): Double {
    val descuento: Double = precio * porcentaje / 100
    return descuento
}
```

Podemos identificar:

```text
fun calcularDescuento(precio: Double, porcentaje: Double): Double
↑   ↑                 ↑                                  ↑
    nombre            parámetros                         retorno
```

## 9.2 Primera simplificación

La variable intermedia no siempre es necesaria:

```kotlin
fun calcularDescuento(precio: Double, porcentaje: Double): Double {
    return precio * porcentaje / 100
}
```

## 9.3 Expression body

Cuando una función consiste únicamente en devolver una expresión, Kotlin permite:

```kotlin
fun calcularDescuento(precio: Double, porcentaje: Double): Double =
    precio * porcentaje / 100
```

Incluso el retorno puede inferirse en algunos casos:

```kotlin
fun calcularDescuento(precio: Double, porcentaje: Double) =
    precio * porcentaje / 100
```

### ¿Debemos saltar directamente a la última versión?

No.

Primero debemos comprender:

```text
parámetros
→ cálculo
→ return
→ tipo retornado
```

Luego la sintaxis corta deja de parecer “magia”.

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

Forma idiomática:

```kotlin
fun esAprobado(nota: Double): Boolean = nota >= 4.0
```

Finalmente, si queremos permitir inferencia:

```kotlin
fun esAprobado(nota: Double) = nota >= 4.0
```

### Pregunta importante

¿Cuál de las cuatro versiones explica mejor el concepto a alguien que está aprendiendo?

¿Cuál preferirías encontrar en un proyecto una vez que ya entiendes la sintaxis?

---

# 10. Colecciones: primero recorrer, luego operar sobre ellas

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

Primero:

```kotlin
for (nota in notas) {
    println(nota)
}
```

Esto es importante porque permite visualizar claramente la iteración.

Después veremos formas como:

```kotlin
notas.forEach { nota ->
    println(nota)
}
```

Y, cuando el contexto sea evidente:

```kotlin
notas.forEach {
    println(it)
}
```

La progresión es importante:

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

## Lista de solo lectura

```kotlin
val nombres: List<String> = listOf("Ana", "Bruno", "Camila")
```

Podemos leer:

```kotlin
println(nombres[0])
```

Pero no agregar directamente:

```kotlin
// nombres.add("Diego")
```

## Lista mutable

```kotlin
val nombres: MutableList<String> = mutableListOf("Ana", "Bruno", "Camila")

nombres.add("Diego")
```

Luego podemos simplificar la declaración:

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

Esta solución es importante porque muestra qué está ocurriendo realmente:

```text
crear resultado
↓
recorrer
↓
evaluar condición
↓
agregar si cumple
```

## 12.2 Después: `filter` con parámetro nombrado

```kotlin
val aprobadas = notas.filter { nota ->
    nota >= 4.0
}
```

## 12.3 Finalmente: `it`

Cuando existe un único parámetro implícito:

```kotlin
val aprobadas = notas.filter {
    it >= 4.0
}
```

Y si la expresión sigue siendo legible:

```kotlin
val aprobadas = notas.filter { it >= 4.0 }
```

### Lo importante

Las cuatro formas resuelven el mismo problema conceptual.

Kotlin permite expresar más directamente **qué queremos**:

```text
"filtrar las notas"
```

en vez de describir cada paso mecánico de cómo construir el resultado.

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

### Diferencia conceptual

```text
filter → conserva algunos elementos
map    → transforma cada elemento
```

---

# 14. La sintaxis corta no es una competencia

Kotlin permite escribir código muy compacto:

```kotlin
val resultado = notas.filter { it >= 4.0 }.map { "Nota: $it" }
```

Eso puede ser claro cuando ya dominamos las operaciones.

Pero al principio también podemos separar:

```kotlin
val aprobadas = notas.filter { nota ->
    nota >= 4.0
}

val resultado = aprobadas.map { nota ->
    "Nota: $nota"
}
```

Ambas son válidas.

La pregunta no es:

> “¿Cuál tiene menos caracteres?”

La pregunta es:

> “¿Cuál comunica mejor la intención para este equipo y este momento?”

---

# 15. Resumen de evolución sintáctica

Durante esta semana veremos repetidamente el mismo patrón.

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

# 16. Rutina práctica para cada concepto

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

# 17. Errores frecuentes

- intentar aprender Kotlin memorizando únicamente sintaxis corta;
- usar `var` para todo;
- creer que inferencia significa que Kotlin “no tiene tipos”;
- confundir `=` con `==`;
- olvidar que `1..5` incluye ambos extremos;
- utilizar `toInt()` sobre texto inválido sin considerar qué ocurre;
- usar `it` sin comprender a qué parámetro representa;
- encadenar `filter`, `map` y otras operaciones sin saber explicar cada transformación;
- escribir funciones de una línea antes de comprender parámetros y retorno;
- asumir que menos líneas siempre significa mejor código.

---

# 18. Puente hacia PocketLog

La guía de **PocketLog Semana 02** aplicará la misma progresión.

No se entregará directamente código extremadamente compacto.

Por ejemplo, antes de llegar a:

```kotlin
val pendientes = completados.count { !it }
```

primero podemos construir la operación explícitamente:

```kotlin
var pendientes = 0

for (completado in completados) {
    if (!completado) {
        pendientes = pendientes + 1
    }
}
```

Después podremos comparar ambas soluciones y responder:

- ¿qué hace el ciclo?;
- ¿qué expresa `count`?;
- ¿por qué producen el mismo resultado?;
- ¿cuál es más conveniente una vez comprendido el problema?

Ese será el criterio durante todo el proyecto formativo:

> **primero hacer visible el mecanismo; después aprender la abstracción que permite expresarlo mejor.**
