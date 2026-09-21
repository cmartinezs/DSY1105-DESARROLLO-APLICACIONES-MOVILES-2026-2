# Ejemplo 2 · Layout adaptable

## Qué problema resolvemos
Un ancho fijo que “se ve bien en mi teléfono” puede romperse en otro dispositivo.

Aquí usamos `fillMaxWidth()` para aprovechar el espacio y `widthIn(max = 720.dp)` para mantener una lectura cómoda en pantallas anchas.

```text
usar espacio disponible
pero
mantener un límite razonable de lectura
```

## Prueba tú
1. elimina `widthIn` y prueba una pantalla ancha;
2. reemplaza `fillMaxWidth` por un ancho fijo;
3. vuelve a la versión adaptable y explica la diferencia.

**Pregunta clave:** ¿por qué “adaptable” no significa simplemente “hacer todo más grande”?
