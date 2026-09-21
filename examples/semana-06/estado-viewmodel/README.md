# Ejemplo · Estado + ViewModel mínimo

Objetivo: ver la separación más pequeña posible entre UI y comportamiento.

```text
Botón
→ callback
→ ContadorViewModel
→ ContadorUiState
→ Compose
```

No hay repository porque el ejemplo sólo necesita un contador. Esa ausencia es intencional: una capa se agrega cuando resuelve una responsabilidad real.

Revisa `MainActivity.kt` y localiza:
1. dónde vive el estado;
2. qué función modifica el estado;
3. cómo la UI observa el cambio;
4. por qué el composable no calcula el nuevo contador.
