# Laboratorio Semana 6 · PocketLog: primera pantalla Compose

## Objetivo

Construir el primer checkpoint Android de PocketLog utilizando **Jetpack Compose**, manteniendo una separación clara entre interfaz y lógica.

## Resultado esperado

Al finalizar, el proyecto debe:

- compilar y ejecutar en emulador o dispositivo;
- mostrar una pantalla inicial propia;
- utilizar componentes Compose básicos;
- responder al menos a una interacción simple;
- evitar lógica de negocio incrustada directamente en composables;
- quedar versionado en el repositorio del estudiante.

## Parte 1 · Crear el proyecto

Crear un proyecto Android con Kotlin y Jetpack Compose. Ejecutarlo antes de modificarlo para verificar que el entorno está correctamente configurado.

## Parte 2 · Construir la pantalla

Crear una pantalla inicial para PocketLog que contenga al menos:

- nombre de la aplicación;
- una breve descripción;
- un dato o estado visible;
- un botón o acción principal;
- una distribución con `Column`, `Row` o equivalente.

No se evalúa diseño avanzado en esta etapa. La prioridad es comprender la construcción declarativa de la interfaz.

## Parte 3 · Interacción

Agregar una interacción pequeña y observable. Ejemplos válidos:

- incrementar un contador;
- cambiar un texto de estado;
- registrar temporalmente una acción;
- activar/desactivar una opción.

Si el estado representa comportamiento de la aplicación y no sólo un detalle efímero del componente visual, moverlo hacia un `ViewModel`.

## Parte 4 · Separación básica

La UI debe poder leerse como una descripción visual. Evitar cálculos de negocio extensos, validaciones complejas o manipulación de datos dentro de los composables.

Modelo recomendado:

```text
Composable
   ↓ evento
ViewModel
   ↓
lógica Kotlin
   ↓ nuevo estado
Composable
```

## Parte 5 · Evidencia

Actualizar el `README.md`/DevLog del repositorio con:

1. qué se construyó;
2. captura o descripción del resultado ejecutado;
3. componentes Compose utilizados;
4. dónde quedó el estado y por qué;
5. principal dificultad encontrada;
6. commit final del checkpoint.

## Criterio de término

El laboratorio está terminado cuando el estudiante puede ejecutar la app y explicar, mirando su propio código, qué responsabilidad tiene la UI, dónde vive el estado y qué cambiaría si la aplicación creciera.
