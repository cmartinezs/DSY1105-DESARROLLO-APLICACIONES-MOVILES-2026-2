# Laboratorio semanal · Semana 1 · Control de batería Java → Kotlin

**Duración sugerida:** 25–35 minutos  
**Modalidad:** individual  
**Prerrequisito:** completar o comprender los [ejercicios básicos de Semana 1](../ejercicios-basicos.md)

← [Volver a Semana 01](../README.md)

## Objetivo

Construir un programa pequeño primero en Java y luego en Kotlin, manteniendo la misma lógica y aplicando los conceptos introductorios de la semana:

- variables y tipos;
- `val` / `var`;
- inferencia;
- salida por consola;
- `if/else`;
- funciones;
- String templates;
- `String?` y operador Elvis `?:`.

> No se busca Android todavía. El foco es comprender el cambio de sintaxis y de estilo entre Java y Kotlin.

---

# Problema

Un teléfono tiene estos datos iniciales:

```text
modelo = Galaxy A55
bateria = 18
modoAhorro = false
propietario = sin dato
```

El programa debe mostrar un resumen y clasificar la batería:

- menor a `20` → `Batería baja`;
- entre `20` y `79` → `Batería suficiente`;
- `80` o más → `Batería alta`.

Si no hay propietario, mostrar `Sin propietario`.

Salida esperada aproximada:

```text
=== TELÉFONO ===
Modelo: Galaxy A55
Batería: 18%
Estado: Batería baja
Ahorro de energía: false
Propietario: Sin propietario
```

---

# Parte 0 · Preparación

Antes de escribir lógica:

1. abre el proyecto indicado por el docente;
2. ejecuta un `Hello World` en Java;
3. ejecuta un `Hello World` en Kotlin;
4. recién después continúa.

### Si algo falla

- **No aparece el botón Run:** verifica que exista `main`.
- **El archivo Kotlin no compila:** confirma que la extensión sea `.kt`.
- **Java no encuentra la clase:** revisa package y ubicación del archivo.
- **Kotlin no reconoce sintaxis:** no pegues código Java dentro del archivo `.kt`.

---

# Parte A · Java

Trabaja en:

```text
src/main/java/cl/duoc/dsy1105/lab/LaboratorioJava.java
```

## Paso 1 · Declara los datos

Crea las variables del teléfono. El propietario puede ser `null`.

Ejecuta. Aunque todavía no muestre todo, el programa debe compilar.

## Paso 2 · Muestra los datos básicos

Imprime modelo, batería y modo ahorro.

Ejecuta nuevamente.

## Paso 3 · Crea la función de clasificación

Crea:

```text
obtenerEstadoBateria(int bateria)
```

Debe retornar un `String`.

Implementa las tres reglas usando `if / else if / else`.

## Paso 4 · Usa la función

Guarda o imprime el resultado de `obtenerEstadoBateria`.

Ejecuta con batería `18`.

Debe aparecer:

```text
Batería baja
```

## Paso 5 · Controla propietario nulo

Antes de imprimir el propietario, comprueba si es `null`.

Si lo es, imprime `Sin propietario`.

## Checkpoint Java

No avances a Kotlin hasta cumplir:

- [ ] compila;
- [ ] muestra los datos;
- [ ] clasifica `18` como batería baja;
- [ ] muestra `Sin propietario`;
- [ ] puedes explicar dónde está la función.

---

# Parte B · Kotlin

Trabaja en:

```text
src/main/kotlin/cl/duoc/dsy1105/lab/LaboratorioKotlin.kt
```

La meta es reproducir el comportamiento, no traducir línea por línea.

## Paso 1 · Declara los datos

- usa `val` por defecto;
- usa inferencia donde sea clara;
- declara propietario como `String?`.

Ejecuta inmediatamente.

## Paso 2 · Imprime con String templates

Evita concatenar si puedes expresar el dato como:

```kotlin
"Modelo: $modelo"
```

## Paso 3 · Crea `obtenerEstadoBateria`

Debe recibir un `Int` y retornar un `String`.

Usa `if / else if / else`.

No uses `when` si todavía no fue trabajado.

## Paso 4 · Resuelve el propietario

Utiliza el operador Elvis:

```text
valorNullable ?: valorAlternativo
```

No necesitas `if` para este punto.

## Paso 5 · Ejecuta y compara

Java y Kotlin deben producir resultados conceptualmente equivalentes.

---

# Parte C · Pruebas manuales

Cambia solo la batería y ejecuta ambos programas con:

```text
18
55
90
```

Resultados esperados:

```text
18 -> Batería baja
55 -> Batería suficiente
90 -> Batería alta
```

Luego asigna un propietario real y comprueba que deje de aparecer `Sin propietario`.

---

# Parte D · Mini extensión

Agrega:

```text
cargando = true
```

Si está cargando, muestra:

```text
El teléfono está conectado al cargador
```

Hazlo primero en Java y luego en Kotlin.

---

## Errores frecuentes

### `Val cannot be reassigned`

Intentaste modificar un `val`. Decide si realmente el dato debe cambiar. Si debe cambiar, usa `var`.

### `Null can not be a value of a non-null type String`

Declaraste un `String` normal y luego intentaste asignar `null`. Si el dato puede faltar, debe ser `String?`.

### Resultado incorrecto en 20 u 80

Revisa los límites de las condiciones. Prueba explícitamente `19`, `20`, `79` y `80`.

### Java y Kotlin muestran cosas distintas

No corrijas ambas versiones a la vez. Primero define cuál salida es la correcta y luego ajusta la otra.

---

## Evidencia mínima

- archivo Java ejecutable;
- archivo Kotlin ejecutable;
- salida de al menos una ejecución de cada uno;
- respuesta breve a:
  1. ¿qué dato dejaste con `val` y por qué?;
  2. ¿para qué utilizaste `String?`?;
  3. ¿qué reemplazó el operador Elvis respecto de la versión Java?;
  4. menciona dos diferencias de sintaxis Java ↔ Kotlin.

## Criterio de éxito

- [ ] ambas versiones ejecutan sin errores;
- [ ] ambas implementan las tres reglas;
- [ ] Kotlin usa `val`, String templates, `String?` y `?:`;
- [ ] se probaron al menos tres valores de batería;
- [ ] el estudiante puede explicar el código sin depender de una solución copiada.
