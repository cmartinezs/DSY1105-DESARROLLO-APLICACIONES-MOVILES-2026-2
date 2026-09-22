# Semana 7 · Diseño visual profesional, adaptabilidad y navegación estructurada

**Periodo:** 21 al 26 de septiembre de 2026  
**Asignatura:** DSY1105 Desarrollo de Aplicaciones Móviles  
**Módulo:** Desarrollando componentes visuales y funcionalidades nativas para aplicaciones móviles

← [Volver al índice](../README.md)

## Foco curricular

El cronograma institucional establece:

- **2.2.1 Diseño visual profesional, jerárquico y adaptable**.
- **2.2.2 Guía 9 · Adaptabilidad del diseño**.
- **2.2.3 Diseño e implementación de flujo de navegación en aplicaciones móviles**.
- **2.2.4 Guía 10 · Navegación y estructura visual en aplicaciones**.

No hay evaluación sumativa esta semana.

## Objetivo pedagógico

La Semana 6 dejó una aplicación Android ejecutable con Compose y separación inicial de responsabilidades. Esta semana el foco no es agregar lógica de negocio nueva, sino transformar una pantalla funcional en una aplicación móvil legible, adaptable y multipantalla.

```text
pantalla única funcional
→ jerarquía visual
→ layout adaptable
→ destinos claros
→ navegación
→ aplicación con estructura
```

Al terminar la semana el estudiante debe poder:

1. reconocer y construir jerarquía visual mediante tamaño, peso, espaciado y agrupación;
2. evitar layouts rígidos que dependan de medidas arbitrarias;
3. usar contenedores Compose adecuados para distribuir contenido;
4. definir destinos y rutas de navegación;
5. implementar navegación entre al menos tres pantallas;
6. enviar un identificador simple a una pantalla de detalle;
7. explicar la diferencia entre estado de UI y estado de navegación.

## Ruta de aprendizaje

### Parte A · Diseño visual y adaptabilidad
→ [Contenido normal](./01-diseno-visual-adaptable.md)  
→ [Profundización opcional](./01-diseno-visual-adaptable/README.md)

### Parte B · Navegación estructurada
→ [Contenido normal](./02-navegacion-compose.md)  
→ [Profundización opcional](./02-navegacion-compose/README.md)

### Ejemplos guiados
Antes de la práctica larga, recorre la progresión completa:

1. [Jerarquía visual](../../examples/semana-07/jerarquia-visual/)
2. [Layout adaptable](../../examples/semana-07/layout-adaptable/)
3. [Scaffold y estructura](../../examples/semana-07/scaffold-estructura/)
4. [Navegación entre dos destinos](../../examples/semana-07/navegacion-dos-destinos/)
5. [Inicio → Lista → Detalle](../../examples/semana-07/navegacion-simple/)

→ [Ver ruta completa de ejemplos](../../examples/semana-07/)

Cada ejemplo agrega una idea principal y contiene contexto, qué observar, una modificación propuesta y una pregunta conceptual.

### Práctica corta
→ [Ejercicio de la semana](./ejercicios-basicos.md)

### Laboratorio independiente
→ [Laboratorio Semana 7 · RutaLocal](../../labs/semana-07-rutalocal/README.md)

RutaLocal es un proyecto pequeño y autocontenido. Practica diseño adaptable y navegación desde cero; no continúa ChecklistDiaria ni forma parte de PocketLog.

### Proyecto formativo transversal
→ [PocketLog · Semana 07](../../proyecto-formativo/semana-07/README.md)

PocketLog evoluciona en paralelo como producto acumulativo. Aplica los conceptos de la semana sobre el estado heredado de versiones anteriores.

## Secuencia sugerida de clase

1. observar una pantalla funcional pero visualmente plana;
2. identificar problemas de jerarquía, densidad, alineación y lectura;
3. recorrer los ejemplos de jerarquía, adaptabilidad y Scaffold;
4. probar la misma pantalla en más de un tamaño/orientación;
5. modelar la app como destinos, no como funciones que “cambian de pantalla”;
6. recorrer navegación de dos destinos;
7. completar Inicio → Lista → Detalle con argumento por ID;
8. resolver el ejercicio individual;
9. construir RutaLocal desde cero como laboratorio independiente;
10. aplicar por separado los mismos aprendizajes a PocketLog v0.7.

## Límites de alcance

Esta semana **no** necesita:

- formularios complejos ni validación avanzada;
- Room/SQLite;
- Retrofit/REST;
- cámara u otros recursos nativos;
- inyección de dependencias;
- arquitecturas adaptativas avanzadas;
- Navigation 3.

Se utiliza **Navigation Compose 2.10.1**, suficiente para el objetivo pedagógico de rutas, back stack y argumentos simples.

## Evidencia mínima de cierre

- aplicación con al menos tres destinos;
- navegación hacia adelante y retorno;
- un destino de detalle que recibe un identificador;
- jerarquía visual explícita;
- layout usable en al menos dos tamaños/orientaciones;
- código de navegación separado de las pantallas;
- DevLog con una decisión visual y una decisión de navegación explicadas.

## Próxima semana

Semana 8 incorpora **formularios, validaciones y paso de información**. La navegación debe quedar estable esta semana para que los formularios se agreguen sobre una estructura ya comprensible.
