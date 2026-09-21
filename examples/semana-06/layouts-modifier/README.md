# Ejemplo 2 · Layouts y Modifier

## Qué problema resolvemos
Tener componentes no basta: debemos decidir **cómo se relacionan y ocupan el espacio**.

Se introducen `Column`, `Row`, `fillMaxWidth`, `padding`, `spacedBy` y `weight`.

```text
contenido + contenedor + reglas de espacio = layout
```

`Modifier` expresa tamaño, separación y comportamiento visual; no es decoración al azar.

## Prueba tú
1. cambia el padding externo de 16 a 32 dp;
2. cambia el espacio entre elementos;
3. elimina `fillMaxWidth()` de la fila y compara.

**Pregunta clave:** ¿qué decisiones pertenecen al contenido y cuáles al layout?
