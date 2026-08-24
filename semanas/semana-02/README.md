# Semana 2 · Programación de Kotlin y sus fundamentos

**Periodo:** 17 al 22 de agosto de 2026  
**Sección:** DSY1105-009V  
**Actividad institucional:** 1.2 Programación de Kotlin y sus fundamentos

← [Volver al índice](../README.md)

## Objetivo semanal

Consolidar fundamentos de Kotlin mediante práctica incremental:

**Variables → Entrada/Salida → Operadores → Condicionales → Ciclos → Funciones → Colecciones → Integración.**

> Esta secuencia es el mapa semanal. El avance real de la sección determina hasta dónde llega cada sesión; no se marca contenido como visto solo porque aparezca en la planificación.

## Ruta práctica semanal

La práctica de contenido queda organizada en dos niveles:

1. 🧩 [**Ejercicios básicos · Semana 2**](./ejercicios-basicos.md) — ejercicios cortos de variables, operadores, condicionales, ciclos, funciones, null safety y colecciones cuando corresponda.
2. 🧪 [**Laboratorio semanal · Analizador de temperaturas**](./laboratorio-temperaturas/README.md) — integración guiada por checkpoints, desde un programa mínimo ejecutable hasta `List`, `MutableList`, `filter`, `map` y `count`.

Secuencia recomendada:

```text
contenido / ejemplos pequeños
→ ejercicios básicos
→ laboratorio semanal guiado
→ transferencia posterior a PocketLog
```

> PocketLog no reemplaza esta práctica. Primero se aprende el concepto en problemas neutrales y luego se aplica al proyecto transversal.

## Proyecto formativo transversal · PocketLog

Esta semana comienza formalmente **PocketLog**, el proyecto formativo que evolucionará durante el semestre desde Kotlin de consola hasta una aplicación móvil con persistencia, REST y pruebas.

La experiencia se trabaja clase a clase desde el estado real del código.

Material principal:

- [Guías PocketLog · Semana 02](../../proyecto-formativo/guias/semana-02/)
- [PocketLog vivo](../../proyecto-formativo/pocketlog/)
- [Checkpoint Semana 02 · v0.2](../../proyecto-formativo/checkpoints/semana-02/)
- [Roadmap semestral PocketLog](../../proyecto-formativo/ROADMAP-SEMANAL.md)
- [Diseño transversal del proyecto](../../docs/PROYECTO-FORMATIVO-TRANSVERSAL.md)

La distinción es importante:

```text
guía = cómo avanzamos
proyecto vivo = lo que continuamos modificando
checkpoint = fotografía histórica estable
```

## Contenidos oficiales

- **1.2.1** Programación en Kotlin y sus fundamentos.
- **1.2.2** Guía 2 – Aplicando Kotlin Básico.
- **1.2.3** Colecciones y funciones en Kotlin.
- **1.2.4** Guía 3 – Aplicando Colecciones.

## Estado real al cierre del lunes 17

La sección avanzó principalmente en **fundamentos Kotlin**.

### Contenido efectivamente trabajado

- variables;
- `val` / `var`;
- inferencia de tipos;
- tipos básicos;
- introducción a null safety / valores anulables, todavía **sin cerrar el concepto completo**;
- operadores aritméticos;
- operadores de comparación;
- operadores lógicos;
- String templates.

Los estudiantes además **continuaron el laboratorio iniciado en la clase anterior**.

### Estado pedagógico

No se debe asumir todavía como visto en profundidad:

- condicionales Kotlin;
- `when`;
- ciclos;
- funciones;
- colecciones;
- lambdas y operaciones `filter/map/count`.

PocketLog debe avanzar solo hasta los conceptos que hayan sido trabajados realmente.

## Material complementario

- [Guía práctica · fundamentos Kotlin](./01-guia-kotlin-fundamentos.md)
- [Kotlin avanzado · lambdas y trailing lambda](./02-kotlin-avanzado-lambdas-y-trailing-lambda.md)
- [Ejercicios básicos · Semana 2](./ejercicios-basicos.md)
- [Ejemplo complementario · Productos](./ejemplos/Productos.kt)
- [Laboratorio semanal · Analizador de temperaturas](./laboratorio-temperaturas/README.md)

## Dinámica viva de la semana

Esta semana queda preparada **Predice Kotlin antes de ejecutar**.

➡️ [Abrir dinámica](./dinamica-viva-predice-kotlin.md)

La actividad usa casos de inferencia, `val`/`var`, operadores y String templates. El caso de null safety se utiliza únicamente cuando el concepto haya sido cerrado suficientemente en clase.

## Lunes 17 · registro real

### Se alcanzó

```text
variables
→ tipos explícitos e inferencia
→ val / var
→ tipos básicos
→ null safety (introducción parcial)
→ operadores aritméticos
→ operadores de comparación
→ operadores lógicos
→ String templates
→ continuidad laboratorio anterior
```

### No se fuerza como pendiente inmediato

El material planificado inicialmente incluía más contenido, pero se priorizó comprensión. La sesión del jueves debe continuar desde este checkpoint real.

## Jueves 20 · registro real

La sesión tuvo dos objetivos simultáneos: continuar fundamentos Kotlin y dejar operacional el estándar de trabajo del estudiante para el resto del semestre.

### Trabajo transversal realizado

Se presentó y trabajó en clase:

- estructura del repositorio personal del estudiante;
- propósito y organización del repositorio semestral;
- ubicación y uso del `README`;
- DevLog como bitácora técnica semanal;
- creación y registro del **primer DevLog** de cada estudiante.

Esta actividad consumió una parte relevante del tiempo de clase, pero se considera inversión operacional: en las próximas semanas el estudiante ya debería llegar con su repositorio creado y limitarse a actualizar código, documentación y DevLog.

### Avance técnico real

Se continuó profundizando en los fundamentos de Kotlin hasta dejar la sección preparada para iniciar **colecciones** en la próxima clase.

El checkpoint de continuidad queda así:

```text
fundamentos Kotlin
→ condicionales
→ ciclos
→ funciones básicas
→ PRÓXIMA CLASE: colecciones
```

No se considera todavía cubierto en profundidad:

- `List` y `MutableList`;
- iteración sobre colecciones;
- `map`;
- `filter`;
- integración completa de PocketLog v0.2 con colecciones.

## Próxima clase · punto de arranque

La siguiente sesión debe comenzar directamente desde **colecciones**, sin volver a dedicar un bloque significativo a creación de repositorio o introducción al DevLog.

Secuencia recomendada:

```text
List
→ MutableList
→ recorrido con for
→ forEach
→ filter
→ map
→ aplicación en PocketLog
```

El objetivo es recuperar velocidad curricular ahora que la infraestructura de trabajo del estudiante ya quedó instalada.

## PocketLog · checkpoint real

PocketLog de Semana 02 permanece **en progreso**. No se fuerza una versión completa antes de que la sección estudie las piezas que utiliza.

La evolución real queda:

```text
variables y estado simple
→ decisiones
→ repetición
→ funciones
→ colecciones (siguiente paso)
```

El checkpoint v0.2 debe cerrarse cuando las colecciones hayan sido trabajadas y aplicadas con comprensión.

## Evidencia mínima de esta etapa

El estudiante debe poder explicar y ejecutar lo efectivamente cubierto y, además, mantener su repositorio bajo el estándar del curso con un primer DevLog registrado.

Al continuar desde colecciones deberá poder conectar:

1. datos individuales;
2. agrupación de múltiples valores;
3. recorrido;
4. filtrado;
5. transformación;
6. aplicación al proyecto formativo.

## Material institucional

- [Biblioteca pública](https://drive.google.com/drive/folders/1_Ew_IE0InqJbPY0Ggu8p0cHl4Avv3rYs?usp=sharing)
- [Semana 02 en Drive](https://drive.google.com/drive/folders/1dNgCNnnCU5aURfT_5qlU7NH9RQYNe8bj)
