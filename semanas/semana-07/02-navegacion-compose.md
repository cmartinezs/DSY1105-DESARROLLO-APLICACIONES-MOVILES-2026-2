# 02 · Navegación estructurada con Navigation Compose

## Qué problema resolvemos

Una aplicación real suele tener más de una pantalla. No queremos resolverlo con múltiples booleanos como:

```kotlin
if (mostrarDetalle) {
    Detalle()
} else {
    Inicio()
}
```

Ese enfoque deja de escalar rápidamente.

## Modelo mental

```text
Destino
  ↓
Ruta
  ↓
NavHost
  ↓
Back stack
```

Un **destino** es una pantalla o estado navegable relevante. Una **ruta** identifica ese destino.

## Dependencia

En el módulo `app`:

```kotlin
implementation("androidx.navigation:navigation-compose:2.10.1")
```

## NavController

```kotlin
val navController = rememberNavController()
```

El controlador permite navegar y volver.

## NavHost

```kotlin
NavHost(
    navController = navController,
    startDestination = "inicio"
) {
    composable("inicio") {
        PantallaInicio(
            onVerLugares = {
                navController.navigate("lugares")
            }
        )
    }

    composable("lugares") {
        PantallaLugares(
            onSeleccionar = { id ->
                navController.navigate("detalle/$id")
            }
        )
    }

    composable("detalle/{id}") { backStackEntry ->
        val id = backStackEntry.arguments?.getString("id")

        PantallaDetalle(
            id = id,
            onVolver = { navController.popBackStack() }
        )
    }
}
```

## No pasar NavController a todo

Preferimos:

```kotlin
PantallaInicio(
    onVerLugares = {
        navController.navigate("lugares")
    }
)
```

en lugar de:

```kotlin
PantallaInicio(navController)
```

Así la pantalla conoce la **intención** pero no la infraestructura de navegación.

## Back stack

Si navegamos:

```text
Inicio → Lugares → Detalle
```

el back stack recuerda el recorrido. `popBackStack()` vuelve al destino anterior.

## Argumentos simples

Esta semana usa un identificador:

```text
detalle/7
```

La pantalla de destino usa ese ID para obtener o seleccionar la información que necesita.

Evita enviar objetos completos serializados en la ruta.

## Estado de navegación vs estado de UI

```text
¿Dónde estoy?             → navegación
¿Qué datos muestra aquí?  → UI state / ViewModel
```

Son responsabilidades distintas.

## Definition of Done

Debes poder construir Inicio → Lista → Detalle, volver correctamente y explicar qué responsabilidad tiene el `NavHost` frente a cada Composable.
