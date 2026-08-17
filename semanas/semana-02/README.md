# Semana 2 · Programación de Kotlin y sus fundamentos

**Periodo:** 17 al 22 de agosto de 2026  
**Sección:** DSY1105-009V  
**Actividad institucional:** 1.2 Programación de Kotlin y sus fundamentos

← [Volver al índice](../README.md)

## Objetivo semanal

Consolidar fundamentos de Kotlin mediante práctica incremental:

**Variables → Entrada/Salida → Operadores → Condicionales → Ciclos → Funciones → Colecciones → Integración.**

## Proyecto formativo transversal · PocketLog

Esta semana comienza formalmente **PocketLog**, el proyecto formativo que evolucionará durante el semestre desde Kotlin de consola hasta una aplicación móvil con persistencia, REST y pruebas.

El trabajo principal no consiste en recibir una solución terminada. Se sigue una guía en la que cada paso presenta:

```text
problema → alternativas → decisión → código → prueba → reflexión
```

Material principal:

- [PocketLog · Guía paso a paso Semana 02](../../proyecto-formativo/semana-02/GUIA-PASO-A-PASO.md)
- [PocketLog · checkpoint Semana 02 · v0.2](../../proyecto-formativo/checkpoint-semana-02/PocketLog.kt)
- [Diseño transversal del proyecto](../../docs/PROYECTO-FORMATIVO-TRANSVERSAL.md)

> El checkpoint de esta semana se conserva. En Semana 03 no se sobrescribe: se crea una nueva versión y se compara la evolución.

## Contenidos oficiales

- **1.2.1** Programación en Kotlin y sus fundamentos.
- **1.2.2** Guía 2 – Aplicando Kotlin Básico.
- **1.2.3** Colecciones y funciones en Kotlin.
- **1.2.4** Guía 3 – Aplicando Colecciones.

## Patrón estándar de trabajo

Cada contenido importante se aborda con:

1. explicación breve;
2. ejemplo guiado ejecutable;
3. aplicación del concepto sobre PocketLog;
4. una pequeña decisión o descubrimiento que el estudiante debe resolver;
5. evidencia y explicación de decisiones;
6. actualización del checkpoint semanal cuando corresponda.

La práctica no queda como actividad opcional al final de la teoría.

## Material complementario

Además de PocketLog quedan disponibles ejercicios de transferencia con dominios distintos:

- [Guía práctica · fundamentos Kotlin](./01-guia-kotlin-fundamentos.md)
- [Ejemplo complementario · Productos](./ejemplos/Productos.kt)
- [Laboratorio de transferencia · Analizador de temperaturas](./laboratorio-temperaturas/README.md)

Estos materiales sirven para comprobar que el estudiante puede aplicar Kotlin fuera del dominio PocketLog. **No reemplazan el hilo longitudinal.**

## Lunes 17 · 19:01–21:10

### Bloque 1 · 19:01–19:40

- `val` y `var`;
- inferencia de tipos;
- tipos básicos;
- `println`;
- String templates;
- conversiones simples/seguras.

**PocketLog:** pasos 0–3 de la guía. Construir el primer registro de forma procedural y discutir decisiones `val` vs `var`, concatenación vs String templates e `if` como expresión.

### Bloque 2 · 19:41–20:20

- operadores;
- `if`;
- `when`;
- `for` y rangos;
- `while`.

**PocketLog:** ampliar de un registro a varios y recorrerlos. Comparar variables individuales vs colecciones.

### Bloque 3 · 20:31–21:10

- funciones;
- parámetros y retorno;
- primera colección con `listOf` / `mutableListOf`;
- extracción de lógica repetida.

**PocketLog:** comenzar a separar `mostrarRegistros(...)` y observar por qué una función que solo lee puede recibir `List` aunque `main` tenga `MutableList`.

## Jueves 20 · 21:11–22:30

- `List` vs `MutableList`;
- mutabilidad/inmutabilidad;
- iteraciones;
- `filter` / `filterIndexed`;
- `map`;
- `count`;
- cierre del checkpoint PocketLog v0.2;
- laboratorio de transferencia si el avance lo permite.

### Cierre PocketLog

La versión final de Semana 02 debe poder:

```text
listar registros
filtrar por categoría
identificar pendientes
contar pendientes
producir un resumen
```

Todavía utiliza tres listas coordinadas:

```text
títulos
categorías
completados
```

Esto es intencional.

La pregunta de salida es:

> **¿Qué problema aparece cuando un mismo concepto está dividido entre varias listas que siempre deben mantenerse sincronizadas?**

Esa limitación será la entrada pedagógica de Semana 03 para introducir POO.

## Evidencia mínima semanal

El estudiante debe poder:

1. elegir razonadamente entre `val` y `var`;
2. aplicar tipos y conversiones;
3. usar `if` y `when`;
4. implementar ciclos;
5. escribir funciones con parámetros/retorno;
6. trabajar con colecciones;
7. explicar `List` vs `MutableList`;
8. explicar una versión imperativa de un filtro y luego `filter`/`filterIndexed`;
9. ejecutar PocketLog v0.2;
10. explicar al menos dos decisiones tomadas durante la guía;
11. identificar una limitación de la versión actual que motive una mejora futura.

## Material institucional

- [Biblioteca pública](https://drive.google.com/drive/folders/1_Ew_IE0InqJbPY0Ggu8p0cHl4Avv3rYs?usp=sharing)
- [Semana 02 en Drive](https://drive.google.com/drive/folders/1dNgCNnnCU5aURfT_5qlU7NH9RQYNe8bj)

El puente Java → Kotlin de Semana 01 sigue disponible como apoyo cuando una comparación ayude, pero la prioridad esta semana es escribir y razonar directamente en Kotlin.
