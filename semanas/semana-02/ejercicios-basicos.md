# Ejercicios básicos · Semana 2

**Propósito:** practicar Kotlin básico en ejercicios pequeños antes de integrar varios conceptos en el laboratorio semanal.

> Esta práctica es independiente de PocketLog. Primero se aprende el concepto en problemas neutrales; después puede transferirse al proyecto transversal.

## Regla de trabajo

- un ejercicio = un problema pequeño;
- ejecutar después de cada cambio;
- usar solo contenidos ya trabajados;
- no usar colecciones funcionales (`filter`, `map`, etc.) antes de comprender recorridos básicos.

---

## Ejercicio 1 · Datos personales simples

Declara y muestra:

- nombre;
- edad;
- carrera;
- promedio.

Usa `val` por defecto y String templates.

---

## Ejercicio 2 · Operadores

Con dos números enteros, muestra:

- suma;
- resta;
- multiplicación;
- división;
- si el primero es mayor al segundo;
- si ambos son positivos.

---

## Ejercicio 3 · Condicionales

Con una nota `5.3`, muestra:

- `Aprobado` si es mayor o igual a `4.0`;
- `Reprobado` en caso contrario.

Luego prueba `3.9` y `4.0`.

---

## Ejercicio 4 · `when`

Declara un número de día entre 1 y 7 y muestra su nombre.

Si el número está fuera de rango, muestra `Día inválido`.

---

## Ejercicio 5 · Ciclo `for`

Muestra los números del 1 al 10.

Luego muestra solo los pares.

---

## Ejercicio 6 · `while`

Comienza con `contador = 5` y muestra una cuenta regresiva hasta 1.

Al terminar imprime `¡Inicio!`.

---

## Ejercicio 7 · Función

Crea:

```text
calcularDescuento(precio, porcentaje)
```

Debe retornar el monto final a pagar.

Prueba con precio `10000` y descuento `20`.

---

## Ejercicio 8 · Null safety

Declara:

```kotlin
val correo: String? = null
```

Muestra el correo si existe o `Correo no registrado` si es `null`.

Luego asigna un correo real y vuelve a probar.

---

## Ejercicio 9 · Primera `List`

Cuando colecciones ya hayan sido introducidas, crea una lista inmutable con cinco lenguajes.

- muestra la lista;
- muestra el primer elemento;
- muestra la cantidad de elementos;
- recórrela con `for`.

---

## Ejercicio 10 · `MutableList`

Crea una lista mutable con tres tareas.

- agrega una cuarta;
- elimina una;
- recorre el resultado.

Explica por qué aquí sí necesitas una colección mutable.

---

## Ejercicio 11 · `forEach`

Recorre una lista de nombres usando `forEach`.

Luego resuelve lo mismo con `for` y explica cuál te resulta más claro.

---

## Ejercicio 12 · `filter`, `map` y `count`

Solo después de haber trabajado estas operaciones:

Con la lista:

```text
12, 5, 18, 3, 21, 10
```

obtén:

- valores mayores o iguales a 10 con `filter`;
- cada valor multiplicado por 2 con `map`;
- cantidad de valores mayores a 15 con `count`.

No encadenes todo en una sola expresión: guarda cada resultado y muéstralo.

---

## Cierre

Antes del laboratorio semanal deberías poder:

1. declarar datos con `val` y `var` conscientemente;
2. resolver decisiones con `if` o `when`;
3. repetir con `for` y `while`;
4. escribir y llamar una función;
5. manejar un `String?` sencillo;
6. crear y recorrer `List` y `MutableList` cuando ese contenido ya haya sido visto;
7. explicar con palabras qué hacen `filter`, `map` y `count`.
