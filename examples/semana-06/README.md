# Semana 06 · Ejemplos guiados

Esta carpeta no es una colección de soluciones para copiar. Es una **ruta corta de aprendizaje** para observar una idea aislada, ejecutarla y modificarla antes de llevarla al ejercicio, al laboratorio o a PocketLog.

## Cómo trabajar los ejemplos

Para cada ejemplo:

1. lee primero su `README.md`;
2. identifica qué problema intenta resolver;
3. ejecuta el código;
4. cambia una sola cosa;
5. explica con tus palabras qué ocurrió;
6. recién entonces avanza al siguiente.

Si un detalle de sintaxis no queda claro, pregúntalo. Lo importante es comprender primero el concepto general y el flujo.

## Ruta recomendada

1. [Composable mínimo](./composable-minimo/) · qué hace `setContent` y qué significa describir UI con `@Composable`.
2. [Layouts + Modifier](./layouts-modifier/) · organizar contenido con `Column`, `Row`, padding y ancho.
3. [Estado local](./estado-local/) · cómo un cambio de estado provoca una nueva representación de la UI.
4. [Formulario + callbacks](./formulario-callbacks/) · separar el componente visual del lugar donde vive el estado.
5. [Estado + ViewModel mínimo](./estado-viewmodel/) · mover comportamiento y estado de pantalla fuera del composable.

## Idea que conecta los cinco

```text
UI estática
→ layout
→ estado
→ eventos
→ ViewModel
```

No necesitas memorizar cada API. Debes poder explicar **qué responsabilidad está apareciendo en cada paso y por qué**.
