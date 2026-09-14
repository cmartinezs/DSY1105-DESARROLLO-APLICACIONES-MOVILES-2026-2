# PocketLog v0.6 · Android + Jetpack Compose

Proyecto de referencia completo para el checkpoint de Semana 6.

## Stack
- Android Gradle Plugin 9.4.0
- Kotlin 2.3.21
- Compose BOM 2026.08.00
- Activity Compose 1.13.0
- Lifecycle ViewModel Compose 2.10.0

## Funciones
- listar registros;
- agregar;
- completar;
- filtrar todos/pendientes/completados;
- contar total/pendientes/completados;
- validar título y categoría.

## Arquitectura didáctica
```text
MainActivity
   ↓
PocketLogScreen (Compose)
   ↓ eventos / observa estado
PocketLogViewModel
   ↓
RegistroRepository (memoria)
   ↓
Registro
```

No hay navegación, persistencia, REST ni DI porque todavía no corresponden.

Abrir esta carpeta como proyecto en Android Studio y sincronizar Gradle. Requiere JDK 17+ y SDK compatible con API 37.
