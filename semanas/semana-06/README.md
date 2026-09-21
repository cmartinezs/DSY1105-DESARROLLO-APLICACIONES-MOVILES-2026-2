# Semana 6 · Arquitectura, MVVM y primera UI con Jetpack Compose

**Periodo:** 14 al 19 de septiembre de 2026  
**Asignatura:** DSY1105 Desarrollo de Aplicaciones Móviles

← [Volver al índice](../README.md)

## Foco curricular

La Semana 6 inicia el módulo **Desarrollando componentes visuales y funcionalidades nativas para aplicaciones móviles**.

El cronograma institucional establece:

- **2.1.1 Arquitectura y planificación colaborativa**.
- **2.1.2 Guía · Configuración inicial del proyecto móvil con MVVM y herramientas colaborativas**.
- **2.1.3 Componentes básicos de diseño visual inicial en apps móviles**.
- **2.1.4 Guía · Construcción visual de pantalla base con Jetpack Compose**.

No hay evaluación sumativa esta semana.

## Objetivo pedagógico

Transformar el modelo mental del estudiante:

```text
programa Kotlin de consola
→ aplicación Android
→ UI declarativa
→ estado de pantalla
→ eventos
→ ViewModel
→ separación UI / comportamiento
```

Al finalizar, el estudiante debe poder construir una app Android de una pantalla y explicar el flujo completo de un evento desde la UI hasta el nuevo estado.

## Ruta sugerida

### Bloque 1 · Entrar a Android
1. reconocer Activity y `setContent`;
2. ejecutar un proyecto Compose;
3. identificar qué hace `@Composable`;
4. modificar una pantalla mínima.

### Bloque 2 · Construir visualmente
1. Text y Button;
2. Column y Row;
3. Modifier;
4. OutlinedTextField;
5. LazyColumn;
6. Card;
7. Scaffold.

→ [Contenido base · Compose y layouts](./01-compose-y-layouts.md)

### Bloque 3 · Separar responsabilidades
1. estado;
2. callbacks;
3. UiState;
4. ViewModel;
5. StateFlow;
6. repository temporal cuando exista una responsabilidad que separar.

→ [Profundización · estado, flujo unidireccional y MVVM](./01-compose-y-layouts/README.md)

## Ejemplos guiados

Antes del ejercicio o laboratorio, recorre los cinco ejemplos en orden:

1. [Composable mínimo](../../examples/semana-06/composable-minimo/)
2. [Layouts + Modifier](../../examples/semana-06/layouts-modifier/)
3. [Estado local](../../examples/semana-06/estado-local/)
4. [Formulario + callbacks](../../examples/semana-06/formulario-callbacks/)
5. [Estado + ViewModel mínimo](../../examples/semana-06/estado-viewmodel/)

→ [Ver ruta completa de ejemplos](../../examples/semana-06/)

Cada ejemplo explica el problema general, qué observar, una modificación concreta y una pregunta conceptual. El código es una superficie para experimentar, no una instrucción de “anda y mira”.

## Ejercicio focalizado

→ [HabitCounter](./ejercicios-basicos.md)

Una sola pantalla y un ViewModel. No PocketLog, navegación ni persistencia.

## Laboratorio desde cero

→ [ChecklistDiaria](../../labs/semana-06-checklist-diaria/README.md)

Construye una aplicación útil desde Empty Activity y llega a:

```text
modelo → repository temporal → UiState → ViewModel → Compose
```

## Proyecto transversal · PocketLog v0.6

Después de practicar en un problema pequeño, se retoma PocketLog:

→ [PocketLog · Semana 06](../../proyecto-formativo/semana-06/README.md)

El objetivo no es “hacer otra demo Android”, sino preservar lo construido en v0.4 y cambiar su superficie desde consola hacia Compose.

## Qué NO incorporar todavía

- Navigation Compose;
- Room/SQLite;
- REST;
- DI;
- cámara;
- múltiples pantallas;
- arquitectura adaptativa avanzada;
- animaciones complejas.

Estas restricciones mantienen visible el objetivo real de la semana.

## Evidencia mínima de cierre

- [ ] proyecto Android ejecutable;
- [ ] al menos una UI Compose construida;
- [ ] layout con componentes básicos;
- [ ] estado agrupado de forma comprensible;
- [ ] comportamiento fuera del composable principal;
- [ ] estudiante puede explicar el flujo evento → estado → UI;
- [ ] lab ChecklistDiaria terminado o equivalente;
- [ ] PocketLog v0.6 migrado;
- [ ] DevLog actualizado.

## Definition of Done

Puedes cerrar la semana cuando seas capaz de explicar, sin depender del código:

```text
usuario
→ composable
→ callback
→ ViewModel
→ lógica / repository
→ UiState
→ Compose representa el cambio
```

## Puente a Semana 7

Semana 6 responde:

> ¿Cómo construyo una pantalla Android y separo UI de comportamiento?

Semana 7 responderá:

> ¿Cómo hago esa experiencia visualmente más clara, adaptable y navegable?

Por eso **no adelantamos Navigation** aquí.
