# Ejemplo 5 · Navegación completa: Inicio → Lista → Detalle

Este ejemplo reúne las ideas de la semana en una app pequeña.

## Qué integra

- jerarquía visual;
- `Scaffold`;
- ancho adaptable;
- `NavHost`;
- tres destinos;
- argumento simple por ID;
- retorno mediante back stack;
- pantallas desacopladas del `NavController`.

No representa PocketLog ni el laboratorio semanal: es una referencia pequeña para estudiar el patrón.

## Dependencia

En el módulo `app`:

```kotlin
implementation("androidx.navigation:navigation-compose:2.10.1")
```

## Flujo

```text
Inicio → Categorías → Detalle(id) → volver
```

El destino de detalle recibe sólo un identificador. No enviamos un objeto completo serializado dentro de la ruta.

## Ejecuta y observa

Sigue un elemento desde `PantallaCategorias`:

```text
onSeleccionar(id)
→ navigate("detalle/$id")
→ composable("detalle/{id}")
→ buscar categoría
→ PantallaDetalle
```

## Prueba tú

1. agrega una cuarta categoría;
2. navega a ella;
3. prueba manualmente un ID inexistente;
4. agrega un botón para volver también desde la lista;
5. explica qué estado pertenece a navegación y qué datos pertenecen a la pantalla.

**Pregunta clave:** ¿por qué la ruta transporta un ID y la pantalla resuelve el dato en vez de transportar el objeto completo?
