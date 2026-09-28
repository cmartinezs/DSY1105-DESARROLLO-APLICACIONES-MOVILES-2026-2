# Ejemplo · Window Size Classes

## Problema

La misma pantalla no debería asumir que siempre dispone del ancho de un teléfono vertical.

## Idea

Obtener la clase de tamaño de ventana y elegir una composición según el espacio disponible.

```text
Compact  → una columna
Medium   → distribución intermedia
Expanded → contenido dividido en zonas
```

## Ejemplo conceptual

```kotlin
@Composable
fun HomeAdaptable(windowWidthSizeClass: WindowWidthSizeClass) {
    when (windowWidthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeCompact()
        WindowWidthSizeClass.Medium -> HomeMedium()
        WindowWidthSizeClass.Expanded -> HomeExpanded()
        else -> HomeCompact()
    }
}
```

## Qué observar

- las variantes reciben el mismo estado;
- cambia la composición, no la lógica de negocio;
- un tamaño diferente no obliga siempre a crear otra pantalla;
- previews y dispositivos distintos ayudan a validar la decisión.

## Modifica

Haz que la versión Expanded muestre lista y detalle al mismo tiempo, mientras Compact mantiene sólo una zona visible.

## Explica

¿Qué problema resuelve Window Size Classes que no resuelve simplemente usar `fillMaxWidth()`?
