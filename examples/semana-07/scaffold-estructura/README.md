# Ejemplo 3 · Scaffold y estructura de pantalla

## Qué problema resolvemos
Cuando una pantalla crece aparecen zonas con responsabilidades distintas: barra superior, contenido, acciones, etc.

`Scaffold` entrega una estructura general y proporciona `innerPadding` para evitar que el contenido quede debajo de sus barras.

```text
Scaffold
├── topBar
└── content(innerPadding)
```

## Ejecuta y observa
Localiza dónde se aplica primero `innerPadding` y luego el padding propio del contenido.

## Prueba tú
1. elimina temporalmente `.padding(innerPadding)`;
2. observa qué ocurre;
3. restaura el padding;
4. cambia sólo el contenido sin tocar la estructura general.

**Pregunta clave:** ¿qué responsabilidad resuelve `Scaffold` que no conviene repetir manualmente?
