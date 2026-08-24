# Ejercicios básicos · Semana 3

**Propósito:** practicar en problemas pequeños los conceptos de colecciones pendientes, POO en Kotlin y control de errores antes del laboratorio integrador.

> Los ejercicios son neutrales e independientes de PocketLog. PocketLog aplica después lo aprendido; no reemplaza los ejemplos ni la práctica de contenido.

## Orden recomendado

```text
colecciones pendientes
→ clase y objeto
→ propiedades y métodos
→ encapsulamiento
→ herencia / override
→ polimorfismo
→ control de errores
→ data class / sealed class
→ corrutinas, si corresponde
```

---

## Ejercicio 1 · Cerrar colecciones

Crea una `MutableList<String>` con cuatro nombres de aplicaciones.

- agrega una quinta;
- recorre con `for`;
- recorre con `forEach`;
- filtra nombres de más de 6 caracteres;
- transforma todos los nombres a mayúsculas;
- cuenta cuántos comienzan con `A`.

Debes poder explicar `filter`, `map` y `count` sin leer la documentación.

---

## Ejercicio 2 · Primera clase

Crea una clase:

```text
Producto
```

con:

- `nombre`;
- `precio`;
- método `mostrarResumen()`.

Crea dos objetos distintos y ejecuta el método en ambos.

### Criterio

Debes distinguir claramente **clase** de **objeto**.

---

## Ejercicio 3 · Estado y comportamiento

Crea una clase `Contador` con un valor inicial `0` y un método `incrementar()`.

Crea un objeto, llama tres veces al método y muestra el valor final.

### Pregunta

¿Por qué el valor pertenece al objeto y no a una variable suelta en `main`?

---

## Ejercicio 4 · Encapsulamiento

Crea una clase `CuentaPuntos` cuyo puntaje pueda consultarse, pero no modificarse directamente desde `main`.

Agrega:

- `sumarPuntos(cantidad)`;
- `reiniciar()`.

Evita que `main` pueda escribir arbitrariamente el puntaje.

---

## Ejercicio 5 · Herencia simple

Crea una clase base `Notificacion` con un método `enviar()`.

Crea:

- `NotificacionEmail`;
- `NotificacionPush`.

Sobrescribe `enviar()` con un mensaje distinto en cada subclase.

Recuerda que en Kotlin debes habilitar explícitamente lo que se podrá heredar o sobrescribir.

---

## Ejercicio 6 · Polimorfismo

Crea una lista de tipo general que contenga una notificación email y una push.

Recorre la lista y llama `enviar()`.

### Pregunta

¿Por qué se ejecuta un comportamiento distinto si la colección usa el mismo tipo general?

---

## Ejercicio 7 · Validación preventiva

Crea una función `calcularPromedio(total: Double, cantidad: Int)`.

Evita dividir por cero mediante una validación explícita.

No uses `try/catch` si el problema se puede prevenir con una condición clara.

---

## Ejercicio 8 · `try/catch` específico

Convierte este texto a entero:

```text
"123"
```

y luego prueba con:

```text
"abc"
```

Controla el error de conversión de manera específica. Evita `catch (e: Exception)` como solución genérica.

---

## Ejercicio 9 · `data class`

Cuando haya sido trabajada, modela:

```text
Usuario(id, nombre, correo)
```

como `data class`.

Crea dos instancias con los mismos datos y compara su igualdad.

### Pregunta

¿Qué comportamiento útil entrega Kotlin automáticamente en una `data class`?

---

## Ejercicio 10 · `sealed class`

Cuando corresponda, modela un resultado cerrado:

```text
Resultado
├── Exito
└── Error
```

Crea una función que reciba un `Resultado` y use `when` para producir un mensaje.

---

## Ejercicio 11 · Corrutina mínima conceptual

Solo si corrutinas ya fueron introducidas:

1. identifica una operación que conceptualmente demore;
2. explica por qué no conviene bloquear el hilo principal;
3. reconoce qué significa que una función sea `suspend`.

La prioridad aquí es la comprensión. No copies una plantilla de corrutinas que no puedas explicar.

---

## Cierre

Antes del laboratorio integrador deberías poder explicar:

1. por qué una clase agrupa datos y comportamiento;
2. qué protege el encapsulamiento;
3. para qué sirven `open` y `override`;
4. qué significa polimorfismo;
5. cuándo validar y cuándo capturar una excepción;
6. cuándo una `data class` resulta apropiada;
7. qué problema intenta resolver una corrutina, si ese bloque ya fue alcanzado.
