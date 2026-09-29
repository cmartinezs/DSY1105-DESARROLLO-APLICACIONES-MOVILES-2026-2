# Estándar de laboratorios guiados · DSY1105

## Propósito

En DSY1105, un **laboratorio** no es una lista de requerimientos ni un desafío abierto.

Un laboratorio es una **guía de construcción paso a paso**, diseñada para acompañar al estudiante desde un proyecto inicial ejecutable hasta un resultado funcional completo.

La expectativa es que un estudiante que todavía no domina el contenido pueda avanzar progresivamente:

```text
leer
→ escribir/modificar código
→ ejecutar
→ observar
→ comprobar
→ comprender
→ continuar
```

Los ejercicios focalizados y desafíos pueden exigir mayor autonomía. Los labs deliberadamente entregan más andamiaje.

## Contrato obligatorio de todo lab

Todo laboratorio publicado debe incluir, cuando corresponda al contenido:

1. propósito y aprendizaje esperado;
2. resultado funcional final;
3. arquitectura o flujo conceptual que se construirá;
4. creación/configuración inicial del proyecto;
5. dependencias exactas necesarias;
6. estructura de carpetas/packages;
7. construcción incremental en pasos numerados;
8. código suficiente en cada paso para poder implementarlo;
9. explicación de qué hace el código recién introducido;
10. checkpoints ejecutables durante el recorrido;
11. casos manuales de prueba;
12. explicación final del flujo completo;
13. DevLog/evidencia esperada;
14. límites explícitos de la semana;
15. Definition of Done;
16. proyecto o checkpoint de referencia cuando sea razonable.

## Qué significa “paso a paso”

Un paso no debe limitarse a:

> Crea un ViewModel con StateFlow y validaciones.

Debe indicar de forma suficiente:

- archivo a crear o modificar;
- package/ruta;
- código base o bloque relevante;
- qué responsabilidad cumple;
- qué debería compilar/verse al terminar;
- cómo comprobarlo antes del siguiente paso.

Ejemplo:

```text
Paso 5 · Crear ViewModel
→ ruta del archivo
→ imports
→ código MutableStateFlow
→ explicar privado/público
→ compilar
→ checkpoint
```

## Código: cuánto entregar

El código de un lab debe ser **pedagógicamente suficiente**, no necesariamente entregar de inmediato el archivo final completo.

Preferimos construirlo por capas:

```text
esqueleto
→ primera responsabilidad
→ ejecutar
→ segunda responsabilidad
→ ejecutar
→ integración
```

Cuando una API o patrón aparece por primera vez, el lab debe mostrar un ejemplo concreto y utilizable.

No se debe obligar al estudiante a adivinar sintaxis o configuración que todavía no se ha enseñado si ese descubrimiento no es el objetivo del laboratorio.

## Checkpoints

Cada bloque significativo debe terminar, cuando sea útil, con una comprobación observable.

Ejemplos:

- el proyecto compila;
- la app abre;
- aparece un componente;
- cambia el estado;
- una ruta navega;
- un error se muestra;
- un dato se conserva durante el flujo;
- un caso inválido no ejecuta la acción.

Los checkpoints reducen el radio de búsqueda cuando algo falla.

## Explicar antes de abstraer

Cuando se introduce una estructura nueva:

```text
UiState
ViewModel
StateFlow
Repository
NavHost
SensorManager
Room
etc.
```

el lab debe explicar brevemente qué problema resuelve **en ese contexto**.

No presentar arquitectura como ceremonia.

## Proyecto de referencia

Cuando sea viable, el directorio del lab incluye un proyecto ejecutable o checkpoint final.

Regla:

> construir primero siguiendo la guía; comparar con la referencia después.

La referencia sirve para:
- recuperación cuando el estudiante se bloquea;
- contraste;
- revisión posterior;
- demostración docente.

No sustituye el proceso guiado.

## Relación con ejercicios

### Ejemplo

Aísla una idea pequeña.

### Ejercicio focalizado

Pide aplicar lo aprendido con mayor autonomía.

### Laboratorio

Guía una construcción completa de principio a fin.

### Proyecto transversal

Obliga a transferir e integrar aprendizajes anteriores en un producto que evoluciona.

### Proyecto VcM

Exige decisiones autónomas del equipo; el material docente no entrega su solución.

```text
ejemplo
→ observa

ejercicio
→ aplica

lab
→ aprende construyendo acompañado

transversal
→ integra

VcM
→ decide y justifica
```

## Qué NO califica como lab completo

No es suficiente publicar:

- una lista de archivos que deben existir;
- una lista de funcionalidades;
- un checklist de requisitos;
- pseudocódigo sin construcción guiada;
- “investiga cómo hacer X” para contenido aún no enseñado;
- sólo el código final sin proceso;
- sólo un repositorio de referencia sin guía.

Esos formatos pueden servir como ejercicio o desafío, pero no cumplen el contrato de laboratorio guiado.

## Definition of Done editorial de un lab

Antes de publicar un lab, el docente debe poder responder sí a estas preguntas:

- ¿un estudiante puede comenzar desde cero?
- ¿cada concepto nuevo tiene contexto suficiente?
- ¿hay código concreto donde realmente se necesita?
- ¿los pasos tienen un orden ejecutable?
- ¿hay checkpoints que permitan detectar dónde falló?
- ¿el estudiante sabe qué resultado esperar?
- ¿hay pruebas manuales?
- ¿se explica el flujo final?
- ¿se distingue qué debe comprender de qué puede simplemente copiar/configurar?
- ¿el alcance respeta la semana?
- ¿la guía no resuelve una evaluación o proyecto VcM?
- ¿la referencia final, si existe, coincide con la guía?

Si alguna respuesta es no, el lab todavía no está listo para publicación.
