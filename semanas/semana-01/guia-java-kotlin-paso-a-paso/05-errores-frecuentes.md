# Errores frecuentes al venir desde Java

## 1. Traducir carácter por carácter

Kotlin no busca ser Java con menos punto y coma. Conviene conservar el concepto y luego expresar la solución con las herramientas del lenguaje.

## 2. Usar `var` para todo

En Kotlin es preferible comenzar con `val` y utilizar `var` cuando existe una necesidad real de reasignación.

## 3. Pensar que inferencia significa ausencia de tipos

El compilador sigue trabajando con tipos concretos. La diferencia es que no siempre tienes que escribirlos.

## 4. Forzar `!!` ante cualquier nullable

`!!` puede reintroducir el mismo tipo de fallo que null-safety intenta evitar. Primero evalúa `?.`, `?:`, validaciones o un mejor modelado del dato.

## 5. Copiar getters/setters sin preguntarse si hacen falta

Kotlin posee propiedades y genera buena parte de la infraestructura que en Java suele escribirse explícitamente. Más adelante veremos cuándo personalizar ese comportamiento.

## 6. Confundir código corto con código mejor

Una expresión de una línea puede ser excelente o puede esconder demasiado. Durante el aprendizaje, la prioridad es poder explicar qué hace cada parte.

## Pregunta guía

Cuando conviertas un ejemplo Java a Kotlin, pregúntate:

> ¿Estoy traduciendo sintaxis o estoy expresando el mismo concepto usando Kotlin?
