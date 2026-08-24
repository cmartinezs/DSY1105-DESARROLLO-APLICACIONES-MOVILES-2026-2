# 4 · Laboratorio · De datos sueltos a objetos

## Parte A · colecciones

Construye una lista mutable de cinco actividades. Permite agregar una sexta, recorre con `for`, vuelve a recorrer con `forEach`, filtra por una condición definida por ti, transforma los títulos y cuenta elementos.

## Parte B · detectar deuda de modelado

Representa temporalmente tres registros con tres listas paralelas: `titulos`, `categorias`, `completados`. Responde: ¿qué ocurre si una lista tiene distinta longitud?, ¿qué representa el índice?, ¿cómo se mantiene la coherencia?

## Parte C · objeto

Crea una clase `Registro` que agrupe esos datos y tenga `completar()` y `resumen()`. Reemplaza las tres listas por `MutableList<Registro>`.

## Parte D · consultas

Obtén pendientes con `filter`, títulos con `map` y cantidad completada con `count`. Muestra los resultados.

## Parte E · control de error

Agrega una operación que reciba un índice o dato potencialmente inválido. Resuélvelo de manera explícita sin un `catch Exception` general.

## Parte F · PocketLog

Transfiere la idea al proyecto formativo **solo después** de completar las partes neutrales. No copies una solución objetivo sin poder explicar cada pieza.

## Evidencia

README con instrucciones de ejecución, código, salida de ejemplo y respuestas de diseño. DevLog con: concepto más claro, concepto más difícil, un error real, cómo se diagnosticó y siguiente paso.

## Criterios de logro

- [ ] Sé construir y modificar una colección.
- [ ] Sé recorrerla sin depender de operaciones avanzadas.
- [ ] Entiendo `filter`, `map` y `count`.
- [ ] Puedo explicar por qué una clase mejora el modelo.
- [ ] Mi colección contiene objetos coherentes.
- [ ] No oculto errores con capturas genéricas.
- [ ] PocketLog refleja solo conceptos realmente comprendidos.