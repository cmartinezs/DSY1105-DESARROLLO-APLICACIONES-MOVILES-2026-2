# Uso de GenAI y defensa de decisiones · DSY1105

## Criterio docente

La IA generativa puede utilizarse como **herramienta de apoyo** en DSY1105.

Su uso no disminuye la responsabilidad del estudiante sobre lo que entrega. Código, modelos, documentación, consultas o propuestas producidas con apoyo de GenAI deben ser comprendidos, revisados y defendibles por el equipo.

El objetivo no es determinar quién escribió mecánicamente cada línea. El objetivo es comprobar que existe aprendizaje, criterio técnico y capacidad de transferencia.

## Qué se evalúa

Se prioriza evidencia de:

- comprensión del problema;
- análisis y delimitación del alcance;
- decisiones técnicas y de diseño;
- justificación de alternativas;
- comprensión del código y de sus responsabilidades;
- relación entre requerimientos, datos, UI y comportamiento;
- capacidad de identificar riesgos y limitaciones;
- capacidad de adaptar la solución cuando cambia una condición;
- participación real y evolución observable en GitHub.

Una solución funcional que el equipo no puede explicar no demuestra por sí sola los resultados de aprendizaje esperados.

## Responsabilidad sobre artefactos asistidos por IA

Si una herramienta genera una respuesta, el estudiante debe poder:

1. explicar qué hace;
2. identificar por qué es apropiada para su problema;
3. reconocer sus supuestos;
4. detectar errores o limitaciones;
5. modificarla cuando cambie el requerimiento;
6. relacionarla con el resto de su solución.

«Lo generó la IA» no es una justificación técnica.

## Preguntas de defensa

Durante revisiones o defensas pueden aparecer preguntas como:

- ¿Por qué esta responsabilidad vive en el ViewModel y no en el Composable?
- ¿Por qué eligieron este modelo de datos?
- ¿Qué alternativa descartaron?
- ¿Qué ocurre si el usuario niega este permiso?
- ¿Qué se rompe si la aplicación queda sin conexión?
- ¿Por qué usan ubicación continua y no una lectura puntual?
- ¿Qué cambiaría si ahora modificamos este requisito?
- ¿Dónde se valida este dato y por qué?
- ¿Qué parte de la solución consideran deuda técnica?

Las preguntas no buscan memorizar una respuesta. Buscan observar el razonamiento.

## Cambios controlados durante la revisión

Una estrategia válida de evaluación es modificar una condición pequeña y pedir al equipo que analice el impacto.

Ejemplo:

```text
"Ahora esta funcionalidad debe operar sin conexión."
```

No siempre será necesario implementar el cambio durante la revisión. Identificar correctamente qué capas, datos, flujos o decisiones se ven afectados ya entrega evidencia significativa de comprensión.

## GitHub y proceso

El historial esperado debe mostrar trabajo incremental y distribuido. Se evita considerar como evidencia suficiente:

- un único commit con toda la entrega;
- grandes bloques incorporados sin evolución observable;
- actividad concentrada exclusivamente en un integrante.

GenAI puede acelerar producción; **no reemplaza la trazabilidad del proceso ni la capacidad de defenderlo**.

## Principio

> No evaluamos sólo qué construyeron. Evaluamos qué decisiones tomaron, por qué las tomaron y si pueden sostenerlas técnicamente.
