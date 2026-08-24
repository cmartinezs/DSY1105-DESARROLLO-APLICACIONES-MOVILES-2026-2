# Laboratorio semanal · Semana 2 · Analizador de temperaturas

**Duración sugerida:** 35–45 minutos  
**Modalidad:** individual  
**Prerrequisito:** fundamentos Kotlin y [ejercicios básicos de Semana 2](../ejercicios-basicos.md)

## Objetivo

Integrar progresivamente:

- variables;
- operadores;
- condicionales;
- ciclos;
- funciones;
- null safety básico;
- `List` / `MutableList`;
- `for` / `forEach`;
- `filter`, `map` y `count` cuando hayan sido trabajados.

> El laboratorio está diseñado por checkpoints. Si una operación todavía no se ha visto en clase, se detiene ahí y se continúa cuando corresponda.

---

# Problema

Una aplicación registra estas temperaturas durante el día:

```text
18, 22, 25, 17, 29, 31, 20
```

Debes construir un analizador en Kotlin.

---

# Checkpoint 0 · Proyecto ejecutable

1. crea o abre un proyecto Kotlin de consola;
2. crea `AnalizadorTemperaturas.kt`;
3. agrega `fun main()`;
4. imprime `Analizador iniciado`;
5. ejecuta.

No continúes hasta ver el mensaje en consola.

### Si falla

- verifica extensión `.kt`;
- comprueba que `main` esté fuera de otra función;
- corrige primero los errores rojos del IDE;
- ejecuta nuevamente antes de añadir más código.

---

# Checkpoint 1 · Lista y recorrido básico

## Paso 1

Crea una `List<Int>` con:

```text
18, 22, 25, 17, 29, 31, 20
```

## Paso 2

Imprime la lista completa.

## Paso 3

Recórrela con `for` y muestra una temperatura por línea:

```text
Temperatura: 18°C
...
```

### Verificación

Deben aparecer exactamente siete temperaturas.

---

# Checkpoint 2 · Función de clasificación

Crea:

```text
clasificarTemperatura(temperatura: Int): String
```

Reglas:

- menor a `18` → `Frío`;
- de `18` a `24` → `Templado`;
- `25` o más → `Caluroso`.

Primero prueba manualmente:

```text
17 -> Frío
18 -> Templado
24 -> Templado
25 -> Caluroso
```

Luego recorre la lista y muestra:

```text
18°C -> Templado
25°C -> Caluroso
```

---

# Checkpoint 3 · Conteo sin magia

Antes de usar `count`, resuelve cuántas temperaturas son `>= 25` con:

- una variable contador;
- un `for`;
- un `if`.

Muestra el total.

### ¿Por qué hacerlo así primero?

Porque debes comprender el algoritmo antes de reemplazarlo por una operación de colección.

---

# Checkpoint 4 · Colección mutable

Copia las temperaturas a una `MutableList` o crea una lista mutable equivalente.

Agrega una nueva medición:

```text
26
```

Vuelve a recorrer la colección y comprueba que ahora existan ocho valores.

---

# Checkpoint 5 · `filter`

Solo cuando `filter` haya sido trabajado:

Obtén una nueva colección con temperaturas `>= 25`.

Guárdala en una variable y muéstrala.

No modifiques la colección original.

### Debes poder explicar

`filter` **selecciona elementos** según una condición.

---

# Checkpoint 6 · `map`

Obtén otra colección donde cada temperatura aumente en `1` grado.

Ejemplo conceptual:

```text
18 -> 19
22 -> 23
```

### Debes poder explicar

`map` **transforma cada elemento** y produce otra colección.

---

# Checkpoint 7 · `count`

Calcula cuántas temperaturas son mayores a `25` utilizando `count`.

Compara el resultado con el contador manual del Checkpoint 3.

---

# Checkpoint 8 · Resumen final

Muestra un resumen similar a:

```text
=== RESUMEN ===
Registros: 8
Temperaturas >= 25: ...
Temperaturas > 25: ...
```

Si promedio, mínima y máxima ya fueron explicados, puedes agregarlos como extensión; no son requisito base.

---

## Errores frecuentes

### `Unresolved reference: filter` / `map`

Comprueba que estás trabajando sobre una colección Kotlin y que no escribiste el nombre de la operación incorrectamente.

### Intento de `add` sobre `List`

`List` es de solo lectura. Si necesitas agregar o eliminar elementos, usa `MutableList`.

### El límite 25 queda mal clasificado

Prueba explícitamente `24` y `25`. Revisa `>` versus `>=`.

### `map` cambia la lista original

No debería. `map` retorna una nueva colección. Guarda su resultado en otra variable.

### Todo está en una sola línea

Sepáralo. En esta etapa importa poder inspeccionar cada resultado intermedio.

---

## Evidencia mínima

- archivo `.kt` ejecutable;
- salida de ejecución;
- función `clasificarTemperatura`;
- recorrido con `for`;
- uso de `MutableList`;
- `filter`, `map` y `count` solo si ya fueron trabajados;
- respuestas breves:
  1. diferencia entre `List` y `MutableList`;
  2. qué selecciona `filter`;
  3. qué transforma `map`;
  4. qué ventaja tiene `count` frente al contador manual una vez comprendido el algoritmo.

## Criterio de logro

- [ ] programa ejecuta sin errores;
- [ ] puedo recorrer una colección;
- [ ] sé clasificar con una función;
- [ ] sé modificar una colección mutable;
- [ ] comprendo qué hacen `filter`, `map` y `count`;
- [ ] puedo explicar el código paso a paso.
