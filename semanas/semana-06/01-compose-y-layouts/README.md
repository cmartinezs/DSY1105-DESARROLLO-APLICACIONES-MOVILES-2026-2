# Semana 06 · Profundización · Estado, flujo unidireccional y MVVM

Este material amplía la semana. Su objetivo es entender **por qué** la aplicación se organiza así.

## UI como función del estado
```text
UI = f(estado)
```
Si el dato relevante vive en el ViewModel, la UI lo representa; no crea una segunda fuente de verdad.

## Flujo unidireccional
```text
usuario
  ↓ evento
Composable
  ↓ callback
ViewModel
  ↓ actualiza
UiState
  ↓ observado por
Composable
```
Los eventos suben y el estado baja.

## State hoisting
```kotlin
@Composable
fun CampoNombre(
    nombre: String,
    onNombreChange: (String) -> Unit
) { /* UI */ }
```
El componente recibe sólo lo necesario y el estado queda en un nivel superior.

## ViewModel
Puede recibir eventos, validar, coordinar operaciones y calcular estado. No debería dibujar composables ni conocer paddings, botones o colores.

## UiState
```kotlin
data class PantallaUiState(
    val texto: String = "",
    val elementos: List<Elemento> = emptyList(),
    val mensaje: String? = null
)
```
Es una fotografía de lo que la pantalla necesita representar.

## StateFlow
Modelo suficiente para el curso:
```text
MutableStateFlow privado
→ StateFlow público
→ collectAsStateWithLifecycle()
→ Compose
```
Lo importante es distinguir quién posee, observa y modifica el estado.

## Repository temporal
```text
ViewModel → Repository → MutableList
```
Un repositorio en memoria es una frontera, **no persistencia**. Al cerrar la app los datos pueden desaparecer.

## Recomposición
Compose puede reevaluar composables cuando cambia estado observado. Evita operaciones costosas, mutaciones arbitrarias y reglas de negocio dentro de `onClick`.

## Arquitectura mínima
```text
Activity
  ↓
Screen
  ↕ eventos / UiState
ViewModel
  ↓
Repository temporal
  ↓
Modelo
```
No agregues capas por ceremonia.

## Comprueba
1. ¿Por qué una Screen no debería modificar una lista global?
2. ¿Qué diferencia hay entre UiState y modelo de dominio?
3. ¿Por qué repository en memoria no es persistencia?
4. ¿Qué ganamos emitiendo callbacks?
5. ¿Qué ocurre visualmente al cambiar UiState?
