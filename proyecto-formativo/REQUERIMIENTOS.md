# PocketLog · Requerimientos funcionales y evolución curricular

PocketLog nace en **Semana 01** como una aplicación Kotlin de consola muy simple y evoluciona durante el semestre sin cambiar de problema de negocio.

La regla es:

> Los requerimientos se conocen desde el inicio; la forma de implementarlos cambia cuando el contenido de la asignatura habilita mejores soluciones.

Esto permite que el estudiante vea deuda técnica real y refactorice el mismo producto en lugar de comenzar ejercicios desconectados cada semana.

## Alcance base de la Unidad 1 / EV1

Antes de EV1, PocketLog debe permitir, en consola y usando sólo Kotlin correspondiente al avance curricular:

1. registrar al menos un elemento con:
   - identificador;
   - título;
   - categoría;
   - estado pendiente/completado;
2. mostrar uno o más registros;
3. cambiar el estado de un registro;
4. buscar un registro por identificador;
5. filtrar registros por categoría o estado;
6. contar registros según una condición;
7. validar datos y manejar al menos un error relevante;
8. organizar el programa usando funciones y, cuando corresponda curricularmente, clases/objetos;
9. demostrar el uso de colecciones cuando sean introducidas;
10. incorporar corrutinas sólo en una operación didáctica coherente si el contenido institucional las ha trabajado.

PocketLog **no es la evaluación** y no debe utilizar el mismo caso de negocio que EV1. Su función es entrenar progresivamente las mismas capacidades técnicas de la unidad.

## Evolución esperada de los mismos requerimientos

### Semana 01 · v0.1 · datos y funciones sueltas

El producto ya existe y ejecuta en consola.

Representación deliberadamente inicial:

```text
idRegistro
tituloRegistro
categoriaRegistro
registroCompletado
```

Las operaciones también son funciones top-level independientes.

El objetivo no es una buena arquitectura: es hacer visible que ya existe un sistema funcional con datos relacionados, pero todavía expresados de forma elemental.

### Semana 02 · v0.2 · varios registros y colecciones

Los mismos requerimientos empiezan a necesitar:

- `List` / `MutableList`;
- ciclos;
- funciones;
- `filter`, `map`, `count` cuando correspondan.

La deuda deliberada puede manifestarse mediante listas paralelas.

### Semana 03 · v0.3 · POO y control de errores

El problema de mantener datos relacionados en estructuras separadas justifica:

- clase/objeto;
- encapsulamiento;
- `data class` cuando corresponda;
- colecciones de objetos;
- búsqueda y cambio de estado sobre objetos;
- `sealed class` o mecanismo equivalente cuando haya sido estudiado;
- manejo explícito de errores;
- corrutinas sólo después de su introducción formal.

### Semana 04 · v0.4 · consolidación previa a EV1

PocketLog debe quedar como una aplicación Kotlin de consola completa y explicable, suficiente para repasar las capacidades técnicas que la Unidad 1 exige antes de EV1.

## Regla de trazabilidad

Cada requerimiento tiene dos estados diferentes:

```text
REQUERIMIENTO CONOCIDO
        ≠
TÉCNICA DE IMPLEMENTACIÓN HABILITADA
```

Ejemplo:

```text
"buscar un registro"
Semana 01 -> una función sobre datos sueltos
Semana 02 -> una función sobre colecciones
Semana 03 -> una operación sobre objetos
```

No se inventan requerimientos nuevos sólo para justificar una tecnología. La tecnología aparece porque mejora la implementación de un requerimiento ya conocido.
