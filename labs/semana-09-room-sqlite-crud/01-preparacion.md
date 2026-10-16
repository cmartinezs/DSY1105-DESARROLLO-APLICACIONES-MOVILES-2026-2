# 01 · Preparar Android Studio y Room

[← Índice](README.md) · [Siguiente → Persistencia](02-persistencia.md)

## Paso 0 · Crear y ejecutar la plantilla

1. Abre Android Studio → **New Project → Empty Activity**.
2. Nombre: `MisNotasRoom`; package: `cl.duoc.misnotasroom`; Kotlin; Min SDK **26**.
3. Ejecuta la plantilla en emulador antes de agregar persistencia.

🔔 **Checkpoint 0:** la aplicación base abre. Si falla, resuélvelo antes de avanzar.

## Paso 1 · Entender qué instalamos

- **SQLite:** motor de base de datos local del dispositivo.
- **Room:** abstrae SQLite mediante entidades, DAO y Database; comprueba consultas y genera código.
- **KSP:** ejecuta el procesador de Room durante la compilación.
- **Lifecycle/Compose:** observa flujos sin duplicar la información en la pantalla.

## Paso 2 · Configurar Gradle

Los archivos completos de configuración, que debes **tomar como referencia exacta**, están en:

- [settings.gradle.kts](referencia/settings.gradle.kts)
- [build.gradle.kts raíz](referencia/build.gradle.kts)
- [app/build.gradle.kts](referencia/app/build.gradle.kts)

La configuración mantiene el estilo de los laboratorios anteriores del curso (Kotlin DSL, Java 17 y Compose). Revisa las versiones fijadas en esos archivos; no mezcles fragmentos de otros proyectos con versiones incompatibles.

En el Gradle de la aplicación observarás estas líneas:

```kotlin
implementation("androidx.room:room-runtime:2.8.5")
ksp("androidx.room:room-compiler:2.8.5")
implementation("androidx.lifecycle:lifecycle-runtime-compose:2.10.0")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
```

Y la aplicación del plugin en `plugins`:

```kotlin
id("com.google.devtools.ksp")
```

**No necesitas escribir manualmente las clases generadas de Room.**

## Paso 3 · Crear los paquetes

En `app/src/main/java/cl/duoc/misnotasroom/` crea:

```text
data/
ui/
MainActivity.kt
```

Consulta la estructura final en el [índice del laboratorio](README.md).

🔔 **Checkpoint 1:** Gradle sincroniza y `Build → Make Project` no da errores con el proyecto de referencia. No sigas si aparece un problema de versiones o SDK.

> Si construyes desde una plantilla reciente de Android Studio, conserva los ajustes compatibles de tu plantilla y reproduce las dependencias y responsabilidades, no dupliques plugins ni bloques `android`.
