# Profundización · Back stack, rutas y límites de navegación

## 1. La navegación es estado

Cuando el usuario está en:

```text
Inicio → Lista → Detalle
```

la aplicación conserva una historia de destinos. Esa historia es el **back stack**.

## 2. Navegar no es llamar una función

Aunque un destino termine ejecutando un Composable, conceptualmente no estamos “llamando otra pantalla”. Estamos cambiando el estado de navegación y Compose representa el destino activo.

## 3. Contratos de pantalla

Una pantalla reusable recibe datos y eventos:

```kotlin
@Composable
fun PantallaDetalle(
    lugar: Lugar,
    onVolver: () -> Unit
)
```

No necesita conocer rutas ni strings.

Esto separa:

```text
AppNavigation.kt  → sabe rutas
PantallaDetalle   → sabe UI
ViewModel         → sabe estado/comportamiento
```

## 4. Centralizar rutas

Para evitar strings repetidos:

```kotlin
object Rutas {
    const val INICIO = "inicio"
    const val LUGARES = "lugares"
    const val DETALLE = "detalle/{id}"

    fun detalle(id: Int) = "detalle/$id"
}
```

No necesitamos todavía una arquitectura de navegación compleja; sólo evitar rutas mágicas dispersas.

## 5. Navegación y ViewModel

El ViewModel no debería ejecutar `navController.navigate(...)` en esta etapa. Puede producir un resultado o evento; la capa de UI/navigation decide qué destino abrir.

## 6. Errores comunes

- colocar todo el `NavHost` dentro de una pantalla;
- pasar `NavController` a cada Composable;
- construir rutas en muchos lugares;
- enviar objetos completos como texto;
- usar navegación para representar estados internos simples;
- mezclar validación/formularios de Semana 8 antes de tiempo.

## 7. Navigation 2 vs Navigation 3

En septiembre de 2026 existen Navigation 2.10.1 estable y Navigation 3 estable. Para esta asignatura usamos Navigation Compose clásico porque permite aprender destino, ruta y back stack con menos conceptos simultáneos. La migración de librería no aporta al resultado de aprendizaje de esta semana.
