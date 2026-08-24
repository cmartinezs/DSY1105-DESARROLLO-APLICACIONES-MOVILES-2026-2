# Laboratorio semanal · Semana 3 · De datos sueltos a objetos

**Duración sugerida:** 50–70 minutos  
**Modalidad:** individual  
**Prerrequisito:** [ejercicios básicos de Semana 3](./ejercicios-basicos.md)

## Objetivo

Integrar progresivamente el cierre de colecciones con POO y control de errores en Kotlin. El laboratorio está dividido en checkpoints para que cada estudiante pueda comprobar que una parte funciona antes de continuar.

> PocketLog aparece solo al final como transferencia. El problema principal del laboratorio es neutral y autocontenido.

---

# Contexto

Construirás un pequeño gestor de actividades. Cada actividad tendrá:

- título;
- categoría;
- estado completado/pendiente.

Comenzarás con datos simples y terminarás modelándolos con objetos.

---

# Checkpoint 0 · Programa mínimo

1. crea `GestorActividades.kt`;
2. agrega `fun main()`;
3. imprime `Gestor iniciado`;
4. ejecuta.

No continúes hasta que compile.

---

# Checkpoint 1 · Colección básica

Crea una `MutableList<String>` con cinco actividades.

Luego:

1. agrega una sexta;
2. muestra todas con `for`;
3. vuelve a recorrerlas con `forEach`;
4. usa `filter` para seleccionar títulos según una condición simple;
5. usa `map` para producir una lista de títulos transformados;
6. usa `count` para contar elementos que cumplan una condición.

### Verificación

Debes poder responder:

- ¿cuándo necesito `MutableList`?;
- ¿qué retorna `filter`?;
- ¿qué retorna `map`?;
- ¿qué diferencia hay entre recorrer y transformar?

---

# Checkpoint 2 · Detectar deuda de modelado

Representa temporalmente tres actividades con tres listas paralelas:

```text
titulos
categorias
completados
```

Ejemplo conceptual:

```text
índice 0 -> "Estudiar Kotlin" / "Estudio" / false
```

## Prueba el problema

Imagina que agregas un título pero olvidas agregar su categoría.

Responde antes de continuar:

1. ¿qué representa el índice?;
2. ¿qué ocurre si las listas tienen tamaños distintos?;
3. ¿qué tan fácil es mantener la coherencia?;
4. ¿qué concepto de POO podría resolver esto?

---

# Checkpoint 3 · Primera clase

Crea una clase `Actividad` con:

```text
titulo
categoria
completada
```

Agrega un método:

```text
resumen()
```

que retorne una representación legible.

Crea dos instancias manualmente y muestra sus resúmenes.

### No avances hasta poder explicar

- clase;
- objeto;
- propiedad;
- método.

---

# Checkpoint 4 · Comportamiento y encapsulamiento

Agrega a `Actividad` un método:

```text
completar()
```

El estado no debe modificarse arbitrariamente desde cualquier parte del programa si puedes evitarlo.

Prueba:

1. actividad pendiente;
2. ejecutar `completar()`;
3. mostrar resumen otra vez.

### Resultado esperado conceptual

```text
Antes: pendiente
Después: completada
```

---

# Checkpoint 5 · Colección de objetos

Reemplaza las listas paralelas por:

```text
MutableList<Actividad>
```

Agrega al menos cuatro objetos.

Luego:

- recorre y muestra sus resúmenes;
- obtiene pendientes con `filter`;
- obtiene títulos con `map`;
- cuenta completadas con `count`.

### Punto pedagógico

Ahora cada elemento de la colección representa una unidad coherente: una actividad completa.

---

# Checkpoint 6 · Herencia y polimorfismo

Solo cuando herencia ya haya sido trabajada:

1. convierte `Actividad` en una clase base apropiada para extensión;
2. crea dos especializaciones simples, por ejemplo:
   - `ActividadEstudio`;
   - `ActividadPersonal`;
3. sobrescribe un comportamiento pequeño, por ejemplo `descripcionTipo()`;
4. guarda objetos de ambos tipos en una colección del tipo general;
5. recórrela y observa el comportamiento sobrescrito.

### Debes poder explicar

- por qué aparece `open`;
- qué hace `override`;
- por qué una referencia general puede ejecutar comportamientos distintos.

---

# Checkpoint 7 · Control de errores

Agrega una operación:

```text
completarPorIndice(indice)
```

## Primera versión

Prueba con un índice válido.

## Segunda prueba

Prueba con un índice inválido.

## Corrección

Resuelve el problema de forma explícita:

- validando el rango antes de acceder, o
- capturando una excepción específica si el ejercicio docente busca practicar `try/catch`.

### Prohibido como solución final

```kotlin
catch (e: Exception)
```

sin justificar por qué necesitas una captura tan amplia.

---

# Checkpoint 8 · `data class`

Cuando este contenido haya sido trabajado, evalúa si `Actividad` completa debe ser `data class` o si conviene crear otra estructura de datos para representar un registro inmutable.

No conviertas una clase automáticamente solo porque la sintaxis existe.

Responde:

1. ¿qué comportamiento aporta `data class`?;
2. ¿tu clase tiene comportamiento relevante además de transportar datos?;
3. ¿qué decisión tomaste y por qué?

---

# Checkpoint 9 · `sealed class`

Si `sealed class` ya fue introducida, modela un resultado cerrado para una operación:

```text
ResultadoOperacion
├── Exito
└── Error
```

Haz que una operación retorne uno de esos resultados y procesa ambos con `when`.

---

# Checkpoint 10 · Corrutinas

Solo si el bloque de corrutinas fue realmente cubierto:

1. identifica una operación que conceptualmente podría demorar;
2. explica por qué bloquear sería un problema en una aplicación móvil;
3. implementa únicamente la estructura mínima indicada por el docente;
4. explica qué significa `suspend` antes de usarlo como palabra mágica.

Este checkpoint puede quedar pendiente si la sección todavía está consolidando POO y errores.

---

# Checkpoint 11 · Transferencia a PocketLog

Solo después de resolver el problema neutral:

- identifica dónde PocketLog mantiene datos relacionados;
- aplica una clase u objeto solo si mejora el modelo;
- usa colecciones de objetos donde corresponda;
- incorpora control de errores acorde al contenido realmente comprendido.

No copies este laboratorio literalmente al proyecto transversal.

---

## Errores frecuentes

### `This type is final, so it cannot be inherited from`

En Kotlin las clases son finales por defecto. Revisa si la clase base debe ser `open`.

### `'metodo' in 'Clase' is final and cannot be overridden`

El método debe permitir sobrescritura si ese es el diseño buscado.

### `Unresolved reference` al acceder a una propiedad

Verifica nombre, alcance y si la propiedad pertenece realmente al objeto que estás usando.

### `IndexOutOfBoundsException`

Intentaste acceder a una posición inexistente. Comprueba el rango antes del acceso.

### Cambios de estado desde cualquier lugar

Si una propiedad no debería modificarse libremente, revisa encapsulamiento y expón comportamiento mediante métodos.

### Confundir `map` con modificación

`map` produce otra colección. No cambia automáticamente los objetos originales.

---

## Evidencia mínima

- programa Kotlin ejecutable;
- colección básica y colección de objetos;
- clase propia con al menos dos instancias;
- método `resumen()`;
- comportamiento `completar()`;
- consulta con `filter`, `map` y `count`;
- un error potencial manejado explícitamente;
- herencia/polimorfismo solo si ese bloque fue alcanzado;
- `data class`, `sealed class` y corrutinas solo cuando hayan sido trabajadas;
- DevLog con aprendizaje, dificultad, error real y siguiente paso.

## Criterios de logro

- [ ] sé construir y modificar una colección;
- [ ] entiendo `filter`, `map` y `count`;
- [ ] puedo explicar por qué una clase mejora el modelo;
- [ ] mi colección contiene objetos coherentes;
- [ ] comprendo encapsulamiento básico;
- [ ] entiendo `open` / `override` si fueron trabajados;
- [ ] no oculto errores con capturas genéricas;
- [ ] no uso sintaxis avanzada sin poder explicar el problema que resuelve;
- [ ] PocketLog recibe solo conceptos previamente comprendidos.
