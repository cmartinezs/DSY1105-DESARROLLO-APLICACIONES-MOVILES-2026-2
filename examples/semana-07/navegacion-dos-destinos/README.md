# Ejemplo 4 · Navegación entre dos destinos

## Qué problema resolvemos
Una aplicación con varias pantallas no debería depender de booleanos como `mostrarDetalle`.

Navigation Compose modela explícitamente destinos, rutas, navegación hacia adelante y back stack.

## Dependencia
En el módulo `app`:

```kotlin
implementation("androidx.navigation:navigation-compose:2.10.1")
```

## Modelo mental
```text
inicio → navigate("detalle") → detalle → popBackStack() → inicio
```

## Prueba tú
1. cambia los nombres de las rutas;
2. agrega un tercer destino sin argumentos;
3. usa el botón atrás del sistema.

**Pregunta clave:** ¿por qué la pantalla recibe callbacks como `onVerDetalle` en vez de recibir directamente el `NavController`?
