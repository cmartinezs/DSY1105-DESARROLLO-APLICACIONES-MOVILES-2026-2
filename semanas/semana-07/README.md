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
3. usar Window Size Classes para distinguir contextos Compact, Medium y Expanded;
4. construir variantes visuales cuando la estructura realmente deba cambiar;
5. definir destinos y rutas reutilizables;
6. implementar navegación entre al menos tres pantallas;
7. integrar TopAppBar, NavigationDrawer o NavigationBar cuando representen una necesidad real;
8. enviar un identificador simple a una pantalla de detalle;
9. explicar la diferencia entre estado de UI y estado de navegación.

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
3. [Window Size Classes](../../examples/semana-07/window-size-classes/)
4. [Scaffold y estructura](../../examples/semana-07/scaffold-estructura/)
5. [Navegación entre dos destinos](../../examples/semana-07/navegacion-dos-destinos/)
6. [Inicio → Lista → Detalle](../../examples/semana-07/navegacion-simple/)

→ [Ver ruta completa de ejemplos](../../examples/semana-07/)

Cada ejemplo agrega una idea principal y contiene contexto, qué observar, una modificación propuesta y una pregunta conceptual.

### Práctica corta
→ [Ejercicio de la semana](./ejercicios-basicos.md)

### Laboratorio independiente
→ [Laboratorio Semana 7 · RutaLocal](../../labs/semana-07-rutalocal/README.md)

RutaLocal es un proyecto pequeño y autocontenido. Practica diseño adaptable y navegación desde cero; no continúa ChecklistDiaria ni forma parte de PocketLog.

### Serie de laboratorios · miniapps nativas · etapa maqueta

Semana 7 también construye la **maqueta funcional completa** de cinco futuras miniapps de hardware:

1. [GeoTrack · GPS](../../labs/miniapps-nativas/gps/maqueta/)
2. [PhotoProof · Cámara](../../labs/miniapps-nativas/camara/maqueta/)
3. [QRAction · Lector QR](../../labs/miniapps-nativas/qr/maqueta/)
4. [ShakeLab · Acelerómetro](../../labs/miniapps-nativas/acelerometro/maqueta/)
5. [OrientApp · Orientación / giroscopio](../../labs/miniapps-nativas/orientacion/maqueta/)

En esta etapa **no se usa hardware real**. Cada miniapp implementa pantallas, navegación, estados, feedback y una fuente simulada separada de la UI.

```text
Semana 7
maqueta completa + fuente simulada
              ↓
semana futura habilitada curricularmente
misma miniapp + hardware real
```

Esto permite diseñar primero la experiencia y después incorporar permisos, listeners y APIs nativas sin rehacer el producto.

→ [Estrategia completa de capacidades nativas](../../docs/CAPACIDADES-NATIVAS-MINIAPPS.md)

### Proyecto formativo transversal
→ [PocketLog · Semana 07](../../proyecto-formativo/semana-07/README.md)

PocketLog evoluciona en paralelo como producto acumulativo. Aplica los conceptos de la semana sobre el estado heredado de versiones anteriores.

## Secuencia sugerida de clase

1. observar una pantalla funcional pero visualmente plana;
2. identificar problemas de jerarquía, densidad, alineación y lectura;
3. recorrer jerarquía, layouts flexibles y Window Size Classes;
4. comparar Compact, Medium y Expanded mediante previews o dispositivos;
5. incorporar Scaffold y estructuras de navegación visual;
6. modelar la app como destinos y rutas reutilizables;
7. recorrer navegación de dos destinos;
8. completar Inicio → Lista → Detalle con argumento por ID;
9. resolver el ejercicio individual;
10. construir RutaLocal como laboratorio independiente;
11. desarrollar las maquetas de miniapps nativas, concentrándose en flujo y estados;
12. aplicar por separado los mismos aprendizajes a PocketLog v0.7.

## Seguimiento del proyecto VcM

Durante esta semana correspondía comenzar un seguimiento más concreto del proyecto VcM, verificando coherencia entre:

```text
problemática
→ requerimientos
→ alcance MVP
→ Modelo Relacional normalizado
→ mockups / prototipos
→ pantallas y navegación
```

El seguimiento no busca validar una solución única ni entregar una arquitectura de referencia. Cada equipo debe sostener su propia propuesta y justificar sus decisiones.

### Estado real de la sección 009V

El checkpoint formal de seguimiento **no se realizó durante Semana 7**. Se registra como pendiente operativo y se traslada al **jueves de Semana 8**, sin alterar retrospectivamente el avance real.

En ese checkpoint se revisará principalmente:

- que el problema elegido responda al contexto;
- que el alcance sea viable para un equipo de máximo dos integrantes;
- que requerimientos, datos, mockups y navegación sean coherentes entre sí;
- que las dudas externas estén identificadas y no resueltas mediante supuestos;
- que GitHub muestre trabajo progresivo y participación real;
- que el equipo pueda justificar por qué está construyendo lo que está construyendo.

→ [Acompañamiento del proyecto VcM](../../docs/ACOMPANAMIENTO-PROYECTO-VCM.md)  
→ [Uso de GenAI y defensa de decisiones](../../docs/USO-GENAI-Y-DEFENSA.md)

## Límites de alcance

Esta semana **no** necesita todavía:

- formularios complejos ni validación avanzada;
- Room/SQLite;
- Retrofit/REST;
- acceso real a cámara, GPS, QR, acelerómetro o giroscopio;
- permisos asociados a esas capacidades;
- inyección de dependencias;
- arquitecturas adaptativas avanzadas;
- Navigation 3.

Las miniapps de esta semana son **maquetas funcionales**: simulan el dato o evento de hardware, pero implementan de verdad la UI, los estados y la navegación.

Se utiliza **Navigation Compose 2.10.1**, suficiente para el objetivo pedagógico de rutas, back stack y argumentos simples.

## Evidencia mínima de cierre

- aplicación con al menos tres destinos;
- navegación hacia adelante y retorno;
- un destino de detalle que recibe un identificador;
- jerarquía visual explícita;
- adaptación demostrable mediante Window Size Classes o una decisión equivalente justificada entre Compact, Medium y Expanded;
- código de navegación separado de las pantallas;
- al menos una miniapp puede explicar claramente la frontera fuente simulada → futura fuente nativa;
- DevLog con una decisión visual y una decisión de navegación explicadas.

## Próxima semana

Semana 8 incorpora **formularios, validaciones y paso de información**. La navegación debe quedar estable para que los formularios se agreguen sobre una estructura comprensible.

Las miniapps quedan preparadas para recibir hardware real **cuando la ruta curricular habilite recursos nativos**; no se adelanta esa implementación sólo por existir la maqueta.
