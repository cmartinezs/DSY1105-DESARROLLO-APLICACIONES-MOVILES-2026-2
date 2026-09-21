# PocketLog · Roadmap conciliado con el avance real

## Semana 1 · v0.1 · primer programa Kotlin
Disponible: variables, tipos, `val`/`var`, String templates, `if/else`, funciones y null safety inicial.

Se implementa un único registro con datos separados, mostrar, cambiar estado y validación simple. No se usan colecciones, clases, corrutinas ni Android.

## Semana 2 · v0.2 · flujo de consola
La semana cerró realmente en condicionales, ciclos y funciones básicas. Las colecciones quedaron para Semana 3.

Se implementa menú con `while`, `when`, lectura, `toIntOrNull`, funciones y un único registro activo. La imposibilidad de mantener múltiples registros es deuda deliberada.

## Semana 3 · v0.3 · colecciones + objeto
Se cierran `List`/`MutableList` y recorridos; luego se transfiere a POO.

Se implementa `MutableList<Registro>`, múltiples objetos, búsqueda, filtros, conteos, completar por ID y manejo de errores. Se evita herencia artificial, `sealed class` y corrutinas sin necesidad real.

## Semana 4 · v0.4 · aplicación Kotlin de consola completa
Se consolidan todos los requerimientos habilitados: registrar, listar, buscar, completar, filtrar, contar y validar. El código debe ser explicable de punta a punta.

## Semana 5 · evaluación
PocketLog se congela y no entrega una nueva versión.

## Semana 6 · v0.6 · Android + Compose
Se toma v0.4 y se presenta en Android. Se implementan listado, formulario mínimo, completar, filtros, contadores, `ViewModel`, `UiState` y lógica fuera de composables.

No se introduce todavía navegación multipantalla, Room/SQLite, REST, DI, cámara ni animaciones complejas.

## Semana 7 · v0.7 · diseño + navegación
Se preserva el comportamiento de v0.6 y se reorganiza la experiencia en destinos navegables.

```text
Inicio → Registros → Detalle
```

Se incorporan jerarquía visual, ancho adaptable, `NavHost`, rutas, back stack y paso de un ID simple. El ViewModel y el dominio continúan ajenos a la infraestructura de navegación.

Aún no se agregan persistencia, REST, cámara ni formularios avanzados.
