# Laboratorio corto · Resolver en Java y luego en Kotlin

**Duración objetivo:** 15 minutos  
**Modalidad:** individual  
**Requisito:** haber revisado la [guía paso a paso Java → Kotlin](../guia-java-kotlin-paso-a-paso.md)

← [Volver a Semana 01](../README.md)

## Objetivo

Resolver un problema pequeño primero en Java y luego reproducir exactamente el mismo comportamiento en Kotlin, aplicando:

- variables;
- tipos e inferencia;
- `val` y `var`;
- salida por consola;
- `if/else`;
- funciones;
- String templates;
- un dato nullable en Kotlin.

> No se busca desarrollar una aplicación Android. El objetivo es practicar el cambio de sintaxis Java → Kotlin sin cambiar la lógica del problema.

---

## Problema · Control de batería de un teléfono

Un teléfono tiene los siguientes datos:

- modelo: `Galaxy A55`;
- porcentaje de batería: `18`;
- modo ahorro de energía: `false`;
- nombre del propietario: dato opcional.

Debes crear un programa que muestre la información del teléfono y determine el estado de la batería.

### Reglas

Crea una función llamada `obtenerEstadoBateria` que reciba el porcentaje de batería y retorne:

- menos de `20` → `Batería baja`;
- entre `20` y `79` → `Batería suficiente`;
- `80` o más → `Batería alta`.

Además:

- si no existe nombre de propietario, debe mostrarse `Sin propietario`;
- Java y Kotlin deben producir conceptualmente la misma salida.

Ejemplo aproximado:

```text
=== TELÉFONO ===
Modelo: Galaxy A55
Batería: 18%
Estado: Batería baja
Ahorro de energía: false
Propietario: Sin propietario
```

---

# Parte A · Java — 7 minutos

Trabaja en:

```text
src/main/java/cl/duoc/dsy1105/lab/LaboratorioJava.java
```

## Debes implementar

1. Declara las cuatro variables indicadas.
2. Imprime modelo y porcentaje de batería.
3. Crea `obtenerEstadoBateria(int bateria)`.
4. Usa `if/else` para implementar las tres reglas.
5. Muestra el estado retornado.
6. Comprueba si el propietario es `null` antes de mostrarlo.

### Restricciones

- No usar `Scanner`.
- Los datos quedan definidos directamente en el código.
- No crear clases adicionales.
- No buscar una solución Kotlin todavía.

Cuando funcione, ejecútalo y observa la salida.

---

# Parte B · Kotlin — 7 minutos

Ahora reproduce el mismo programa en:

```text
src/main/kotlin/cl/duoc/dsy1105/lab/LaboratorioKotlin.kt
```

No traduzcas carácter por carácter. Piensa en los conceptos vistos en la guía.

## Debes utilizar

- `val` para datos que no cambian;
- inferencia de tipos donde sea fácil de entender;
- String templates al imprimir;
- una función `obtenerEstadoBateria`;
- `String?` para el propietario;
- `?:` para mostrar `Sin propietario` si corresponde.

La función debe mantener exactamente las mismas reglas de la versión Java.

---

# Parte C · Comprobación — 1 minuto

Ejecuta ambos programas y verifica:

- ¿los dos clasifican `18` como `Batería baja`?;
- ¿los dos muestran `Sin propietario`?;
- ¿los datos mostrados son equivalentes?;
- ¿la solución Kotlin utiliza `val`, String templates y null safety?

Luego cambia temporalmente la batería a:

```text
55
```

y después a:

```text
90
```

Comprueba que ambas versiones produzcan respectivamente:

```text
Batería suficiente
Batería alta
```

---

## Si terminas antes

Agrega una variable llamada `cargando`.

Si es `true`, muestra al final:

```text
El teléfono está conectado al cargador
```

Hazlo primero en Java y después en Kotlin.

---

## Criterio de éxito

El laboratorio está completo cuando:

1. ambas versiones ejecutan sin errores;
2. ambas implementan las tres reglas de batería;
3. Kotlin usa correctamente `String?` y `?:`;
4. Java y Kotlin producen resultados equivalentes;
5. puedes explicar al menos **dos diferencias de sintaxis** entre ambas soluciones.

## Importante

No hay solución terminada dentro de esta carpeta. El objetivo es que construyas ambas versiones a partir de lo aprendido en la guía y del ejemplo desarrollado en clases.
