# 02 · Navegación y estructura visual con Navigation Compose

## Qué problema resolvemos

Una app multipantalla necesita destinos, rutas, historial y una estructura visual coherente. Guía 10 incorpora `NavHost`, `NavController`, `TopAppBar`, `NavigationDrawer` y `NavigationBar`.

## Modelo mental

```text
destino
→ ruta
→ NavHost
→ back stack
→ estructura visual que permite moverse
```

## Rutas reutilizables

Evita strings dispersos. Puedes usar un objeto o una `sealed class` para centralizar rutas.

```kotlin
sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Listado : Screen("listado")
    data object Detalle : Screen("detalle/{id}") {
        fun create(id: Int) = "detalle/$id"
    }
}
```

## NavHost y NavController

```kotlin
val navController = rememberNavController()

NavHost(
    navController = navController,
    startDestination = Screen.Home.route
) {
    composable(Screen.Home.route) { /* ... */ }
    composable(Screen.Listado.route) { /* ... */ }
    composable(Screen.Detalle.route) { entry ->
        val id = entry.arguments?.getString("id")
        // detalle
    }
}
```

## Estructura visual

Según la necesidad, integra:
- `TopAppBar`;
- `NavigationDrawer`;
- `NavigationBar`;
- contenido dentro de `Scaffold`.

Estas piezas deben representar destinos o acciones reales, no decoración.

## Pantallas desacopladas

Preferimos callbacks:

```kotlin
PantallaListado(
    onSeleccionar = { id ->
        navController.navigate(Screen.Detalle.create(id))
    }
)
```

La pantalla expresa intención; la capa de navegación conoce rutas.

## Back stack

`popBackStack()` vuelve al destino anterior y conserva una historia navegable coherente.

## Argumentos simples

Usa IDs cuando sea suficiente. Evita serializar objetos completos en la ruta.

## Definition of Done

Puedes construir al menos tres destinos, integrar una estructura visual de navegación, volver correctamente y explicar qué pertenece a UI, navegación y estado.
