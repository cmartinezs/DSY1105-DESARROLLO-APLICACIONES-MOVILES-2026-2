# Profundización · Shared ViewModel y ciclo de vida del flujo

## Dos patrones que no compiten

### Detalle identificado

```text
lista → detalle/{id}
```

La ruta identifica un recurso.

### Flujo compartido

```text
registro ↔ ViewModel compartido ↔ resumen
```

Varias pantallas participan del mismo estado temporal.

## Scope del ViewModel

Para que Registro y Resumen observen exactamente el mismo objeto, ambos destinos deben obtener el ViewModel desde un scope compartido apropiado.

La intención pedagógica es comprender la identidad del estado compartido; no memorizar una receta sin entenderla.

## Estado sensible

Si el formulario contiene una clave, no muestres su valor en texto abierto en Resumen. La guía incorpora `PasswordVisualTransformation` en el registro; la visualización posterior debe mantener criterio básico.

## Reentrada

Pregunta qué debería ocurrir si el usuario vuelve desde Resumen a Registro:
- ¿conserva los datos?;
- ¿puede corregirlos?;
- ¿qué errores deben seguir visibles?;
- ¿cuándo se limpia el flujo?

## Puente futuro

Persistencia local resolverá otro problema: conservar datos más allá del ciclo del proceso o de la aplicación. Un Shared ViewModel no reemplaza Room ni DataStore.
