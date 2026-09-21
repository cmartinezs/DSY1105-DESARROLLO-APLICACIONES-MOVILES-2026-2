# PocketLog · Semana 06 · v0.6 · Android + Jetpack Compose

## RECIBE

PocketLog v0.4 es una aplicación Kotlin de consola que ya permite:

- registrar;
- listar;
- buscar;
- completar;
- filtrar;
- contar;
- validar entradas.

Semana 5 fue una pausa por EP1: no existe una v0.5 funcional nueva.

## REQUERIMIENTO

El producto debe abandonar la consola como interfaz principal y convertirse en una aplicación Android real, **sin perder las capacidades ya construidas**.

## APRENDEMOS

- proyecto Android;
- MainActivity;
- Jetpack Compose;
- componentes visuales básicos;
- Modifier;
- LazyColumn;
- UiState;
- ViewModel;
- StateFlow;
- flujo unidireccional;
- separación UI / comportamiento.

## PROBLEMA

La v0.4 concentra interacción, entrada y salida en consola:

```text
usuario
→ menú
→ lectura por consola
→ funciones
→ lista
→ println
```

Ese flujo no puede trasladarse literalmente a Android.

## DECISIÓN

Preservar el **dominio y comportamiento** y reemplazar la forma de interacción:

```text
usuario
→ Compose
→ callback
→ ViewModel
→ Repository en memoria
→ UiState
→ Compose
```

No se reescribe el producto desde cero.

## PASO A PASO

1. ejecutar v0.4 y listar capacidades que deben sobrevivir;
2. crear/validar proyecto Android Compose;
3. trasladar `Registro` a dominio;
4. crear repository temporal en memoria;
5. modelar `PocketLogUiState`;
6. crear `PocketLogViewModel`;
7. implementar agregar y validación;
8. implementar completar;
9. implementar filtros;
10. calcular contadores;
11. construir `PocketLogScreen`;
12. conectar `MainActivity`;
13. comprobar equivalencia funcional con v0.4.

→ [Migración detallada](./01-migracion-android.md)

## DESCUBRE TÚ

Antes de mirar el checkpoint:

- identifica qué código de v0.4 sigue siendo concepto de dominio;
- decide qué información necesita realmente la pantalla;
- decide qué eventos debe emitir la UI;
- detecta qué reglas no deberían vivir dentro de composables;
- explica por qué el repository actual todavía no es persistencia.

## COMPRUEBA

- guardar vacío produce validación;
- agregar válido muestra el registro;
- completar cambia estado;
- filtros todos/pendientes/completados funcionan;
- contadores coinciden;
- UI no modifica directamente la colección;
- ViewModel no contiene detalles visuales;
- cerrar el proceso puede perder datos y puedes explicar por qué.

## CHECKPOINT

→ [PocketLog v0.6 Android](../checkpoints/semana-06/android/)

## DEJA ABIERTO

La app funciona en Android pero toda la experiencia sigue concentrada en una sola superficie.

Semana 7 resolverá esa deuda con:
- jerarquía visual;
- adaptabilidad;
- destinos;
- navegación;
- detalle.

No adelantamos Navigation Compose en v0.6.
