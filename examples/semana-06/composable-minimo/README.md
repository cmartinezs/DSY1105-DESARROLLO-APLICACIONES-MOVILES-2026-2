# Ejemplo 1 · Composable mínimo

## Qué aprenderás
Jetpack Compose usa funciones para **describir** cómo debe verse la interfaz. Este ejemplo elimina casi todo el ruido para reconocer `MainActivity`, `setContent`, `MaterialTheme`, `@Composable`, `Text` y `Button`.

## Modelo mental
```text
MainActivity → setContent → función @Composable → componentes visibles
```

Todavía no hay estado ni ViewModel. El botón no modifica nada; eso es intencional.

## Ejecuta y observa
Localiza dónde comienza Compose y qué función describe la pantalla.

## Prueba tú
1. cambia el título;
2. agrega un segundo `Text`;
3. cambia el texto del botón.

**Pregunta clave:** ¿por qué `PantallaBienvenida()` puede leerse como una descripción de la UI?
