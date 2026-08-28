# Laboratorio semanal · Semana 3 · De datos sueltos a objetos

**Duración sugerida:** 50–70 minutos  
**Modalidad:** individual  
**Prerrequisito:** [ejercicios básicos de Semana 3](../../semanas/semana-03/ejercicios-basicos.md)

## Objetivo

Integrar progresivamente el cierre de colecciones con POO y control de errores en Kotlin. El laboratorio está dividido en checkpoints para que cada estudiante pueda comprobar que una parte funciona antes de continuar.

> PocketLog aparece solo al final como transferencia. El problema principal del laboratorio es neutral y autocontenido.

## Contexto

Construirás un pequeño gestor de actividades. Cada actividad tendrá título, categoría y estado completado/pendiente. Comenzarás con datos simples y terminarás modelándolos con objetos.

## Checkpoint 0 · Programa mínimo

Crea `GestorActividades.kt`, agrega `fun main()`, imprime `Gestor iniciado` y ejecuta. No continúes hasta que compile.

## Checkpoint 1 · Colección básica

Crea una `MutableList<String>` con cinco actividades. Agrega una sexta, recorre con `for` y `forEach`, usa `filter`, `map` y `count`.

Debes poder explicar cuándo necesitas `MutableList`, qué retornan `filter` y `map`, y la diferencia entre recorrer y transformar.

## Checkpoint 2 · Detectar deuda de modelado

Representa temporalmente tres actividades con listas paralelas: `titulos`, `categorias`, `completados`.

Responde: ¿qué representa el índice?, ¿qué ocurre si las listas tienen tamaños distintos?, ¿qué tan fácil es mantener la coherencia?, ¿qué concepto de POO podría resolverlo?

## Checkpoint 3 · Primera clase

Crea una clase `Actividad` con `titulo`, `categoria`, `completada` y un método `resumen()`. Crea dos instancias y muestra sus resúmenes.

No avances hasta poder explicar clase, objeto, propiedad y método.

## Checkpoint 4 · Comportamiento y encapsulamiento

Agrega `completar()`. El estado no debe modificarse arbitrariamente desde cualquier parte del programa si puedes evitarlo. Prueba el estado antes y después.

## Checkpoint 5 · Colección de objetos

Reemplaza las listas paralelas por `MutableList<Actividad>`. Agrega al menos cuatro objetos; recorre, filtra pendientes, transforma a títulos y cuenta completadas.

## Checkpoint 6 · Herencia y polimorfismo

Solo cuando herencia ya haya sido trabajada: crea una clase base extensible, dos especializaciones simples, sobrescribe un comportamiento y almacena ambos tipos en una colección general.

Debes poder explicar `open`, `override` y el comportamiento polimórfico.

## Checkpoint 7 · Control de errores

Agrega `completarPorIndice(indice)`. Prueba un índice válido y uno inválido. Resuelve el problema validando el rango o capturando una excepción específica cuando el objetivo sea practicar `try/catch`.

Evita `catch (e: Exception)` como solución genérica sin justificación.

## Checkpoint 8 · `data class`

Cuando este contenido haya sido trabajado, evalúa si `Actividad` debe ser `data class` o si conviene otra estructura de datos. Justifica la decisión.

## Checkpoint 9 · `sealed class`

Si ya fue introducida, modela un resultado cerrado `ResultadoOperacion` con casos de éxito y error, y procésalos mediante `when`.

## Checkpoint 10 · Corrutinas

Solo si el bloque fue realmente cubierto: identifica una operación que podría demorar, explica por qué bloquear sería un problema e implementa únicamente la estructura mínima indicada por el docente. Debes explicar qué significa `suspend`.

Este checkpoint puede quedar pendiente.

## Checkpoint 11 · Transferencia a PocketLog

Solo después de resolver el problema neutral: identifica dónde PocketLog mantiene datos relacionados y aplica el concepto comprendido al proyecto transversal. No copies el laboratorio literalmente.

## Evidencia mínima

- programa Kotlin ejecutable;
- colección básica y colección de objetos;
- clase propia con al menos dos instancias;
- comportamiento y encapsulamiento;
- `filter`, `map` y `count`;
- un error potencial manejado explícitamente;
- herencia/polimorfismo, `data class`, `sealed class` y corrutinas sólo cuando hayan sido trabajados;
- DevLog con aprendizaje, dificultad, error real y siguiente paso.

## Criterio de progresión

El estudiante debe detenerse en el último checkpoint correspondiente al contenido efectivamente trabajado. **Material publicado no equivale a contenido ya cubierto en aula.**
