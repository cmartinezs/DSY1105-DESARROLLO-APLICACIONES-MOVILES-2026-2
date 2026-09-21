# Ejemplo 5 · Estado + ViewModel mínimo

## Qué problema resolvemos

En los ejemplos anteriores el estado terminó viviendo dentro de un composable. Eso funciona para casos pequeños, pero cuando aparecen reglas y operaciones conviene separar **representación** de **comportamiento**.

Aquí aparece por primera vez un `ViewModel`.

## Modelo mental

```text
usuario pulsa
→ Composable emite callback
→ ViewModel aplica comportamiento
→ UiState cambia
→ Compose observa
→ UI se actualiza
```

## Qué debes reconocer

- `ContadorUiState`: fotografía de lo que la pantalla necesita mostrar;
- `ContadorViewModel`: dueño del estado y del comportamiento;
- `StateFlow`: exposición observable del estado;
- `collectAsStateWithLifecycle()`: puente entre estado observable y Compose;
- `ContadorScreen`: muestra datos y emite eventos.

No hay repository porque un contador no necesita una fuente de datos separada. Agregar capas sin responsabilidad real sólo haría el ejemplo más difícil.

## Ejecuta y observa

Sigue un clic desde `Button` hasta `incrementar()` y de regreso a la UI.

## Prueba tú

1. agrega `disminuir()`;
2. evita valores negativos dentro del ViewModel;
3. agrega `reiniciar()`;
4. muestra un mensaje cuando llegue a 8.

**Pregunta clave:** ¿por qué la regla “no bajar de cero” debería vivir en el ViewModel y no dentro del `onClick`?
