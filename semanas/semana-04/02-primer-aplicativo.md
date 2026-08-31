# 1.4.2 · Mi primer aplicativo en Android Studio

## Objetivo

Crear, ejecutar y modificar una aplicación Android mínima usando Kotlin, verificando cada etapa del ciclo de desarrollo.

## Regla pedagógica

La meta no es construir una aplicación completa. La meta es que el estudiante pueda repetir conscientemente el ciclo:

```text
crear → ejecutar → observar → modificar → ejecutar → verificar
```

## Secuencia

1. Crear un proyecto Android mínimo usando la plantilla disponible acordada en clase.
2. Revisar nombre, package/namespace, ubicación y versión mínima configurada.
3. Esperar la sincronización inicial de Gradle y distinguir warnings de errores bloqueantes.
4. Seleccionar emulador o dispositivo.
5. Ejecutar la aplicación sin modificaciones.
6. Identificar el código Kotlin y los recursos relevantes del proyecto generado.
7. Realizar una modificación pequeña y visible.
8. Volver a ejecutar.
9. Explicar qué archivo se cambió y por qué el resultado cambió.

## Checkpoints

### CP1 · Proyecto creado

- El proyecto abre.
- Gradle termina su sincronización sin error bloqueante.
- El módulo de aplicación es reconocible.

### CP2 · Primera ejecución

- Existe un dispositivo seleccionado.
- La app se instala y abre.
- El estudiante puede distinguir error de build, error de instalación y error en runtime.

### CP3 · Primera modificación

- Se cambia un texto o comportamiento mínimo.
- Se recompila/reinstala según corresponda.
- El cambio es visible y reproducible.

### CP4 · Explicación

El estudiante puede responder:

- ¿qué archivo modifiqué?;
- ¿qué parte pertenece a Kotlin?;
- ¿qué parte corresponde a recursos/configuración?;
- ¿qué hizo Android Studio para ejecutar la app?;
- ¿dónde miraría primero si la app no compila?

## Extensión opcional

Sólo si el grupo completa los checkpoints con holgura, agregar una interacción mínima que reutilice conceptos Kotlin ya aprendidos. No introducir todavía arquitectura MVVM, persistencia, navegación compleja ni contenidos visuales de semanas futuras.
