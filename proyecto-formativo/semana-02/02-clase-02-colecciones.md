# PocketLog · Semana 02 · Clase 02

**Foco:** funciones y colecciones  
**Punto de partida:** [Clase 01](./01-clase-01-fundamentos.md)

## Objetivo

Tomar el PocketLog que ya lista registros y agregar operaciones sobre la información sin esconder el mecanismo detrás de sintaxis corta demasiado pronto.

La progresión es:

```text
recorrer manualmente
→ resolver con ciclos y condiciones
→ extraer función
→ reconocer patrón
→ usar operación de colección equivalente
→ comparar soluciones
```

## 1. Recuperar estado anterior

Ejecuta PocketLog antes de modificarlo.

**Checkpoint:** muestra correctamente todos los registros creados en Clase 01.

## 2. Filtrar manualmente

Crea una colección `resultados`, recorre índices y agrega sólo títulos cuya categoría corresponda a la buscada.

**Checkpoint:** puedes explicar `for → if → add` y obtienes sólo registros de la categoría elegida.

## 3. Extraer una función

Crea `filtrarTitulosPorCategoria(titulos, categorias, categoriaBuscada)` y úsala con al menos dos categorías.

**Checkpoint:** la misma función funciona para distintos valores del parámetro.

## 4. Reconocer `filter` / `filterIndexed`

Cuando el patrón manual ya sea comprendido, expresa la misma intención con una operación de colección.

Para profundizar en lambdas y trailing lambda consulta [Kotlin avanzado · lambdas y trailing lambda](../../semanas/semana-02/02-kotlin-avanzado-lambdas-y-trailing-lambda.md).

**Checkpoint:** puedes explicar qué parte de la solución manual reemplaza `filter`.

## 5. Contar pendientes manualmente

Usa un contador, un `for` y una condición.

**Checkpoint:** el resultado coincide con los datos de entrada.

## 6. Reconocer `count`

Reemplaza el patrón manual por `count` sólo después de comprenderlo.

**Checkpoint:** puedes explicar por qué ambas soluciones producen el mismo resultado.

## 7. Transformar con `map`

Convierte estados Boolean a textos `PENDIENTE` / `COMPLETADO`, primero manualmente y después con `map`.

**Checkpoint:** la colección transformada conserva la cantidad de elementos y puedes explicar que `map` produce otra colección.

## Cierre

No continúes si una operación corta funciona pero no puedes explicar el algoritmo equivalente.

➡️ Continúa con [Cierre y checkpoint](./03-cierre-y-checkpoint.md).
