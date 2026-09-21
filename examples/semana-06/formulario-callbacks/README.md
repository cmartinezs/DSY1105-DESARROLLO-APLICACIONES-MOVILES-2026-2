# Ejemplo 4 · Formulario y callbacks

## Qué problema resolvemos
Un componente reutilizable no debería necesitar saber **dónde** se guarda el estado. Puede recibir el valor y emitir un evento cuando el usuario escribe. Esto se conoce como **state hoisting**.

```text
Pantalla ↓ nombre → CampoNombre → onNombreChange ↑ Pantalla
```

`CampoNombre` no usa `rememberSaveable`: el estado vive en `FormularioSimple`.

## Prueba tú
1. agrega un campo para ciudad siguiendo el mismo patrón;
2. muestra ambos valores en un resumen;
3. reutiliza el campo con otra etiqueta.

**Pregunta clave:** ¿qué ganamos al evitar que cada componente sea dueño de su propio estado?
