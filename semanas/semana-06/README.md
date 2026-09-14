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

Esta semana debe producir una transición explícita:

```text
Kotlin console
→ proyecto Android
→ UI declarativa con Compose
→ estado de pantalla
→ separación inicial View / ViewModel / lógica
```

Al terminar la semana, cada estudiante debe ser capaz de crear y ejecutar un proyecto Android, construir una pantalla Compose simple y explicar por qué la lógica de negocio no debe quedar mezclada directamente con la UI.

## Clase del lunes 14 de septiembre · 19:01–21:10

### 1. Cierre del tramo anterior

- situar EP1 como cierre del primer módulo;
- explicar el cambio de foco desde ejercicios Kotlin hacia producto móvil ejecutable;
- recuperar sólo los conceptos Kotlin necesarios para leer y escribir Compose.

### 2. Modelo mental Android

Introducir sin sobrecargar:

```text
Aplicación Android
├── UI · Jetpack Compose
├── Estado
├── ViewModel
└── Modelo / lógica de negocio
```

Explicar MVVM como separación de responsabilidades, no como una estructura ceremonial.

### 3. Proyecto mínimo en Android Studio

Cada estudiante debe:

1. crear o abrir un proyecto Android con Kotlin y Compose;
2. identificar `MainActivity` y el punto de entrada de Compose;
3. ejecutar la aplicación en emulador o dispositivo;
4. reemplazar la pantalla inicial por una UI propia.

### 4. Componentes Compose mínimos

Trabajar inicialmente con:

- `@Composable`;
- `Text`;
- `Button`;
- `Column` y/o `Row`;
- `Modifier`;
- `MaterialTheme`;
- estado simple sólo cuando ayude a comprender interacción.

Ejemplo conceptual:

```kotlin
@Composable
fun PantallaInicio() {
    Column {
        Text("PocketLog")
        Text("Mi primera aplicación Android")
        Button(onClick = { }) {
            Text("Comenzar")
        }
    }
}
```

## MVVM · profundidad esperada esta semana

El estudiante debe comprender inicialmente:

```text
View (Compose)
    ↓ observa / envía eventos
ViewModel
    ↓ coordina
Modelo / lógica
```

Todavía no se requiere una arquitectura compleja, inyección de dependencias, repositorios de datos ni persistencia. Es preferible una separación pequeña pero comprensible y defendible.

## PocketLog

PocketLog retoma su evolución transversal en Android.

Checkpoint recomendado de Semana 6:

- proyecto Android ejecutable;
- pantalla inicial Compose;
- identidad visual mínima;
- estado básico si existe una interacción real;
- `ViewModel` inicial cuando haya estado o comportamiento que justifique separarlo;
- lógica de dominio Kotlin preservada fuera de la UI.

## Laboratorio

→ [Laboratorio Semana 6 · PocketLog: primera pantalla Compose](../../labs/semana-06-pocketlog-compose/README.md)

## Evidencia mínima de cierre semanal

- aplicación Android ejecutando correctamente;
- al menos una pantalla Compose construida por el estudiante;
- uso consciente de componentes y layout;
- separación explícita entre UI y lógica;
- repositorio actualizado;
- DevLog con decisiones, dificultades y resultado alcanzado.

## Próxima semana

Semana 7 profundiza en **diseño visual profesional, jerarquía, adaptabilidad y navegación estructurada**. Por eso esta semana debe priorizar una base Compose limpia antes de introducir navegación multipantalla.
