# 1.4.1 · Kotlin y Android Studio

## Objetivo

Comprender Android Studio como entorno de desarrollo y reconocer la estructura mínima de un proyecto Android escrito en Kotlin.

## Ideas clave

Android Studio no reemplaza Kotlin: agrega el ecosistema necesario para construir, ejecutar, depurar y empaquetar aplicaciones Android.

El estudiante debe distinguir al menos:

- **Kotlin**: lenguaje de programación.
- **Android SDK**: APIs y herramientas de la plataforma Android.
- **Gradle**: sistema de build y dependencias.
- **Android Studio**: IDE que integra edición, build, ejecución y depuración.
- **Emulador/dispositivo**: entorno donde se ejecuta la aplicación.

## Ciclo de trabajo mínimo

```text
editar código/recursos
→ sincronizar/build
→ instalar
→ ejecutar
→ observar
→ corregir
→ volver a ejecutar
```

## Estructura que deben reconocer

No memorizar toda la jerarquía. Para Semana 4 basta con ubicar y explicar el propósito general de:

- módulo `app`;
- código fuente Kotlin;
- recursos `res`;
- `AndroidManifest.xml`;
- archivos Gradle relevantes;
- configuración de ejecución.

## Conceptos de clase

### Proyecto vs módulo

El proyecto puede contener uno o más módulos. Para el primer aplicativo normalmente se trabajará sobre el módulo `app`.

### Manifest

El manifest declara información esencial de la aplicación y componentes Android. En esta semana se inspecciona; no se exige dominar todas sus posibilidades.

### Recursos

Android separa recursos del código. Textos, imágenes, dimensiones y otros elementos pueden vivir fuera del código Kotlin.

### Build

Una app Android pasa por un proceso de build antes de ejecutarse. Que el código Kotlin sea sintácticamente correcto no garantiza por sí solo que el proyecto Android completo pueda compilar y arrancar.

## Checkpoint

El estudiante debe poder señalar en su proyecto:

1. dónde está el código Kotlin;
2. dónde están los recursos;
3. dónde está el manifest;
4. qué hace Gradle en términos generales;
5. dónde selecciona el dispositivo de ejecución.

## Errores comunes

- confundir Android Studio con el lenguaje Kotlin;
- editar un archivo correcto pero ejecutar otra configuración;
- asumir que un emulador lento significa que el código está mal;
- ignorar mensajes de Gradle/SDK;
- copiar configuraciones sin entender qué archivo se modificó.

## Cierre

Antes de avanzar, cada estudiante debe haber abierto o creado un proyecto y poder navegar por sus componentes básicos sin depender completamente de la demostración del docente.
