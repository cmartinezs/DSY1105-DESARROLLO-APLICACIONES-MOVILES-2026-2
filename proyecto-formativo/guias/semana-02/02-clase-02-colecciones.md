# PocketLog · Semana 02 · Clase 02

**Sesión:** Jueves 20 de agosto  
**Foco:** Funciones y colecciones  
**Duración docente disponible:** 2 bloques  
**Punto de partida:** resultado funcional de la [Clase 01](./01-clase-01-fundamentos.md)

## Objetivo de la clase

Tomar el PocketLog que ya lista registros y agregar operaciones sobre la información sin esconder el mecanismo detrás de sintaxis corta demasiado pronto.

La progresión será:

```text
recorrer manualmente
→ resolver con ciclos y condiciones
→ extraer función
→ reconocer el patrón
→ usar operación de colección equivalente
→ comparar ambas soluciones
```

---

# Ruta de la clase

| Etapa | Contenido | Qué cambia en PocketLog |
|---|---|---|
| 1 | repaso | comprobamos el checkpoint anterior |
| 2 | filtros con `for` | obtenemos registros por categoría |
| 3 | funciones | reutilizamos el filtro |
| 4 | `filterIndexed` | expresamos la misma intención con Kotlin |
| 5 | conteo manual | calculamos pendientes |
| 6 | `count` | sustituimos el patrón conocido |
| 7 | transformación | preparamos `map` con un caso simple |

---

# Etapa 1 · Recuperar el estado anterior

Antes de agregar código, ejecuta PocketLog.

Debe mostrar todos los registros.

No continúes si el checkpoint anterior no funciona.

## Preguntas rápidas

Debes poder responder:

1. ¿por qué existen tres listas?;
2. ¿qué representa el mismo índice en cada una?;
3. ¿qué hace `mostrarRegistros`?;
4. ¿por qué recibe `List` y no necesita `MutableList`?

---

# Etapa 2 · Mostrar solo una categoría

Nueva necesidad:

> Queremos ver solamente los registros de categoría `estudio`.

No comenzamos con `filter`.

Primero resolvemos el problema con las herramientas conocidas.

```kotlin
val resultados: MutableList<String> = mutableListOf()

for (indice in titulos.indices) {
    if (categorias[indice].equals("estudio", ignoreCase = true)) {
        resultados.add(titulos[indice])
    }
}

for (titulo in resultados) {
    println(titulo)
}
```

## Explica antes de avanzar

```text
resultados
    ↓
for
    ↓
if
    ↓
add
```

¿Qué papel cumple cada parte?

---

# Etapa 3 · Generalizar con una función

El código anterior solo sirve para `estudio`.

Movemos la categoría a un parámetro:

```kotlin
fun filtrarTitulosPorCategoria(
    titulos: List<String>,
    categorias: List<String>,
    categoriaBuscada: String
): List<String> {
    val resultado: MutableList<String> = mutableListOf()

    for (indice in titulos.indices) {
        if (categorias[indice].equals(categoriaBuscada, ignoreCase = true)) {
            resultado.add(titulos[indice])
        }
    }

    return resultado
}
```

Ahora:

```kotlin
val estudio = filtrarTitulosPorCategoria(titulos, categorias, "estudio")
val personal = filtrarTitulosPorCategoria(titulos, categorias, "personal")
```

## Prueba tú

Agrega una categoría distinta y comprueba que la misma función siga sirviendo.

---

# Etapa 4 · Reconocer el patrón: filtrar

Lo que acabamos de programar manualmente hace esto:

```text
recorrer una colección
→ evaluar una condición
→ conservar solo elementos que cumplen
```

Ese patrón tiene un nombre: **filtrar**.

Kotlin ofrece una operación para expresarlo.

Forma explícita de la lambda:

```kotlin
val resultado = titulos.filterIndexed { indice, titulo ->
    categorias[indice].equals("estudio", ignoreCase = true)
}
```

En este caso `titulo` no se utiliza:

```kotlin
val resultado = titulos.filterIndexed { indice, _ ->
    categorias[indice].equals("estudio", ignoreCase = true)
}
```

## Importante: ¿por qué aparecen llaves?

Las llaves contienen una **lambda**. No son una sintaxis especial de `filter`.

Si quieres comprender desde la forma completa por qué Kotlin permite sacar esa lambda fuera de los paréntesis, consulta:

➡️ [Kotlin avanzado · lambdas y trailing lambda](../../../semanas/semana-02/02-kotlin-avanzado-lambdas-y-trailing-lambda.md)

Para continuar la clase basta entender:

```text
versión manual → recorre, decide y agrega
filter/filterIndexed → expresa directamente esa intención
```

---

# Etapa 5 · Contar pendientes manualmente

Nueva pregunta:

> ¿Cuántos registros siguen pendientes?

Primero:

```kotlin
var pendientes: Int = 0

for (completado in completados) {
    if (!completado) {
        pendientes = pendientes + 1
    }
}
```

Primera abreviación:

```kotlin
pendientes++
```

Antes de avanzar explica por qué ambas instrucciones producen el mismo incremento.

---

# Etapa 6 · Reconocer otro patrón: contar

La operación anterior hace:

```text
recorrer
→ evaluar condición
→ aumentar contador cuando cumple
```

Kotlin permite expresar esa intención mediante `count`:

```kotlin
val pendientes = completados.count { completado ->
    !completado
}
```

Cuando ya se comprende el parámetro:

```kotlin
val pendientes = completados.count { !it }
```

## Regla

No reemplazamos el ciclo porque esté "mal".

Lo reemplazamos porque ya entendemos el mecanismo y `count` comunica mejor la intención.

---

# Etapa 7 · Primera transformación con `map`

Ahora queremos producir textos legibles a partir de los Boolean:

```text
false → PENDIENTE
true  → COMPLETADO
```

Primero manualmente:

```kotlin
val estados: MutableList<String> = mutableListOf()

for (completado in completados) {
    if (completado) {
        estados.add("COMPLETADO")
    } else {
        estados.add("PENDIENTE")
    }
}
```

Observa el patrón:

```text
recorrer cada elemento
→ producir un nuevo valor
→ guardar un resultado por cada elemento
```

Eso es una **transformación**.

Con `map`:

```kotlin
val estados = completados.map { completado ->
    if (completado) {
        "COMPLETADO"
    } else {
        "PENDIENTE"
    }
}
```

Luego podemos simplificar el `if`:

```kotlin
val estados = completados.map { completado ->
    if (completado) "COMPLETADO" else "PENDIENTE"
}
```

No es necesario llegar hoy a la versión más compacta si todavía no resulta clara.

---

# Integramos PocketLog

Al finalizar la clase, la aplicación debería poder demostrar al menos:

```text
1. listar todos los registros
2. filtrar títulos por una categoría
3. contar pendientes
4. transformar estados a texto
```

La versión final de la semana está disponible como referencia en:

➡️ [`../../checkpoints/semana-02/PocketLog.kt`](../../checkpoints/semana-02/PocketLog.kt)

El proyecto vivo que continúa evolucionando está en:

➡️ [`../../pocketlog/`](../../pocketlog/)

No copies el checkpoint antes de intentar construir cada parte.

---

# Prueba tú · 10–15 minutos

Escoge una:

### A · Contar por categoría

Crea una función que reciba una categoría y devuelva cuántos registros pertenecen a ella.

### B · Títulos completados

Obtén únicamente los títulos cuyo estado sea completado.

### C · Dos soluciones

Resuelve un filtro primero con `for` y después con una operación de colección. Explica cuál comunica mejor la intención y por qué.

---

# Checkpoint de salida de la Clase 02

Al terminar deberías poder explicar esta evolución:

```text
for + if + add
      ↓
filter

for + if + contador
      ↓
count

for + producir nuevo valor
      ↓
map
```

Si solo recuerdas `filter { ... }` pero no puedes reconstruir la versión manual, vuelve un paso atrás.

---

# Una incomodidad que NO resolveremos hoy

Nuestro código sigue dependiendo de que:

```text
titulos[0]
categorias[0]
completados[0]
```

pertenezcan siempre al mismo registro.

¿Qué pasa si agregamos un título y olvidamos agregar su categoría?

No respondas todavía con una tecnología que no hemos estudiado.

Solo registra la observación:

> **hay datos que pertenecen juntos, pero nuestra estructura actual obliga a mantenerlos separados y sincronizados manualmente.**

Esa será una excelente pregunta para retomar cuando el contenido del curso nos entregue nuevas herramientas.

➡️ Termina con [Cierre y checkpoint de Semana 02](./03-cierre-y-checkpoint.md).
