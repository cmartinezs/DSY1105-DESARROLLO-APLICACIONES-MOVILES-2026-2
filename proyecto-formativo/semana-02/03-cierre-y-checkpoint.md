# PocketLog · Semana 02 · Cierre y checkpoint

## Qué debería existir al terminar la semana

PocketLog v0.2 debe ser una aplicación de consola sencilla, pero funcional.

Debe demostrar únicamente contenidos trabajados esta semana:

```text
variables y tipos
val / var
salida por consola
String templates
if / when cuando corresponda
ciclos
funciones
List / MutableList
filter / map / count después de comprender su equivalente manual
```

No necesita clases propias, Android ni arquitectura futura.

---

# Del lunes al jueves

## Estado después de Clase 01

```text
varios registros
→ almacenados en listas
→ asociados por índice
→ recorridos con for
→ mostrados mediante una función
```

## Estado después de Clase 02

Sobre la misma base agregamos:

```text
filtrar
contar
transformar
```

Primero mediante mecanismos explícitos y después, cuando el patrón ya era reconocible, con operaciones de colección de Kotlin.

---

# Qué debe poder explicar el estudiante

No basta con ejecutar el código.

Debe poder responder, por ejemplo:

1. ¿por qué empezamos con tipos explícitos y luego usamos inferencia?;
2. ¿qué diferencia existe entre `val` y `var`?;
3. ¿por qué `if` puede asignarse a una variable en Kotlin?;
4. ¿qué problema resolvió la primera colección?;
5. ¿qué hace manualmente un filtro?;
6. ¿qué reemplaza `filter`?;
7. ¿qué reemplaza `count`?;
8. ¿qué diferencia conceptual existe entre `filter` y `map`?;
9. ¿por qué las lambdas aparecen entre llaves?;
10. ¿qué fragilidad tienen las listas paralelas actuales?

---

# Checkpoint ejecutable

La versión de referencia se conserva en:

➡️ [`../checkpoint-semana-02/PocketLog.kt`](../checkpoint-semana-02/PocketLog.kt)

Este archivo representa **el estado de PocketLog al cierre de Semana 02**.

La siguiente semana no lo reemplazará. Se copiará/evolucionará hacia un nuevo checkpoint.

---

# Regla antes de cerrar

Ejecuta el proyecto y verifica:

- muestra todos los registros;
- un filtro por categoría devuelve resultados correctos;
- el conteo de pendientes coincide con los datos;
- la transformación de estados conserva la cantidad de elementos;
- no hay excepciones por índices desalineados en el ejemplo base.

Luego cambia un dato y vuelve a probar.

---

# Una deuda visible

La versión funciona, pero mantener tres colecciones coordinadas exige disciplina manual:

```text
titulos
categorias
completados
```

Mientras todas tengan el mismo tamaño y orden, funciona.

Si una se descoordina, la aplicación puede mezclar información o fallar.

No solucionaremos ese problema con contenido futuro adelantado.

Lo guardamos como **deuda observable** para retomarla cuando el plan de la asignatura introduzca herramientas apropiadas.

---

# Versión

```text
PocketLog v0.2
Estado: checkpoint formativo estable
Interfaz: consola
Persistencia: memoria durante ejecución
Modelo: colecciones básicas
Objetivo: demostrar fundamentos Kotlin de Semana 02
```

➡️ Si quieres experimentar sin modificar el checkpoint obligatorio, usa [EXPLORA.md](./EXPLORA.md).
