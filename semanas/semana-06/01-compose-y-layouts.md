# Semana 06 · Contenido base · Jetpack Compose y construcción visual

## Objetivo
Comprender el cambio hacia una **UI declarativa** y construir una pantalla Android simple, legible y mantenible.

## 1. Modelo mental
```text
estado actual → función @Composable → interfaz
```
Compose describe cómo se ve la interfaz para un estado. Cuando el estado observado cambia, la UI se actualiza.

## 2. @Composable
```kotlin
@Composable
fun Saludo(nombre: String) {
    Text("Hola, $nombre")
}
```
Una función composable recibe datos, describe UI e idealmente no contiene reglas de negocio.

## 3. Componentes mínimos
- `Text`: información.
- `Button`: acciones.
- `OutlinedTextField`: entrada.
- `Column` / `Row`: layout.
- `LazyColumn`: listas dinámicas.
- `Card`: agrupación visual.
- `Scaffold`: estructura de pantalla.
- `Modifier`: tamaño, padding y comportamiento visual.

## 4. Modifier
```kotlin
Modifier
    .fillMaxWidth()
    .padding(16.dp)
```
Esta semana basta dominar `fillMaxWidth`, `fillMaxSize`, `padding`, `height` y `weight` cuando corresponda.

## 5. Estado e interacción
```kotlin
OutlinedTextField(
    value = state.nombre,
    onValueChange = onNombreChange,
    label = { Text("Nombre") }
)
```
La pantalla **muestra estado y emite eventos**. No debería decidir cómo almacenar o validar la información.

## 6. Listas
```kotlin
LazyColumn {
    items(state.elementos, key = { it.id }) { elemento ->
        Text(elemento.nombre)
    }
}
```

## 7. Resultado esperado
Al cerrar este contenido debes poder:
1. explicar UI declarativa;
2. construir una pantalla con composables;
3. organizarla con Column, Row y LazyColumn;
4. usar Modifier conscientemente;
5. recibir estado y emitir callbacks sin mezclar negocio en la UI.

→ [Profundización: estado, arquitectura y MVVM](./01-compose-y-layouts/README.md)
