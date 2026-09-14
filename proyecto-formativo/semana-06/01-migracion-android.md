# Semana 06 · Migración paso a paso a Android

0. Crear/abrir proyecto Compose y ejecutarlo sin cambios.
1. Preservar dominio en `domain/Registro.kt`.
2. Crear `RegistroRepository` temporal en memoria; aún no es persistencia.
3. Crear `PocketLogUiState` con lista, filtro, formulario, mensaje y contadores.
4. Crear `PocketLogViewModel`: recibe eventos, valida, modifica repository y recalcula estado.
5. Crear `PocketLogScreen`: observa estado, dibuja y emite callbacks.
6. `MainActivity` sólo conecta ViewModel con Compose.
7. Probar guardar vacío, agregar, completar, filtrar y contadores.

Flujo obligatorio:
```text
usuario → Composable → ViewModel → Repository → UiState → Compose redibuja
```

El estudiante debe explicar qué parte de v0.4 se conservó conceptualmente y qué cambiará cuando llegue persistencia.
