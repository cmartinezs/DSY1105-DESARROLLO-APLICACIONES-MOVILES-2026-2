# Ejemplo 3 · Estado local y recomposición

## Qué problema resolvemos
Hasta ahora la pantalla era estática. Una app necesita reaccionar a acciones del usuario.

Este ejemplo usa `rememberSaveable` para mantener un contador dentro de la pantalla.

```text
estado cambia → Compose detecta el cambio → reevalúa lo necesario → UI representa el nuevo estado
```

## Prueba tú
1. agrega un botón para disminuir;
2. evita números negativos;
3. agrega un botón para reiniciar.

**Pregunta clave:** ¿dónde vive actualmente el estado y qué problema aparecería si la lógica creciera mucho?
