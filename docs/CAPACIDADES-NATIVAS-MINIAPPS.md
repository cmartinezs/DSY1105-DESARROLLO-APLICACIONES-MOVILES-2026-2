# Capacidades nativas · estrategia de miniapps monofoco

## Propósito

Las capacidades del dispositivo no se enseñan como una lista de APIs que deben aparecer todas juntas.

Cada capacidad se trabaja mediante una **mini aplicación monofoco** que permita explorarla en varias facetas y convertir una señal o recurso físico del teléfono en comportamiento interactivo.

La pregunta no es:

> ¿Cómo uso esta API?

La pregunta es:

> ¿Qué experiencia puedo construir con esta capacidad, qué decisiones implica y qué condiciones reales debo manejar?

## Evolución en dos etapas

Cada miniapp tiene una única identidad y una única línea de evolución:

```text
Etapa A · maqueta funcional
UI + navegación + estados + interacción + fuente simulada
                     ↓
Etapa B · capacidad nativa real
misma UI / mismo flujo + proveedor Android real
```

No se crean dos aplicaciones distintas. La maqueta se convierte posteriormente en la miniapp real.

La etapa A puede adelantarse durante una semana de diseño y navegación porque **no utiliza todavía la API de hardware**. Esto permite diseñar la experiencia antes de introducir permisos, listeners, sensores o SDK específicos.

## Serie canónica

La primera serie está compuesta por cinco laboratorios:

1. **GeoTrack** · GPS / ubicación.
2. **PhotoProof** · cámara.
3. **QRAction** · lectura QR.
4. **ShakeLab** · acelerómetro.
5. **OrientApp** · orientación / giroscopio.

→ [Abrir línea de miniapps en labs](../labs/miniapps-nativas/)

## Contrato común de la maqueta

Todas las miniapps deben tener:

- una capacidad futura principal;
- un problema o interacción reconocible;
- navegación completa;
- estados normales y casos límite;
- feedback visible;
- datos o eventos simulados;
- una fuente simulada separada de la UI;
- adaptabilidad básica;
- explicación explícita de qué componente se reemplazará cuando llegue hardware real.

La maqueta **no debe pedir permisos ni acceder todavía al hardware**.

## Regla arquitectónica

El objetivo de la maqueta es hacer visible esta frontera:

```text
UI
↓
estado / comportamiento
↓
fuente simulada
```

Más adelante:

```text
UI
↓
estado / comportamiento
↓
fuente Android real
↓
hardware / servicio del dispositivo
```

Cambiar la fuente no debería obligar a rediseñar toda la experiencia.

## GPS · GeoTrack

La maqueta trabaja:

- ubicación simulada;
- coordenadas;
- precisión/estado disponible o no disponible;
- cambios de posición;
- inicio/detención de seguimiento;
- distancia acumulada simulada.

La etapa nativa podrá incorporar lectura puntual y seguimiento real.

## Cámara · PhotoProof

La maqueta trabaja:

- intención de captura;
- preview;
- confirmar/descartar;
- asociación de evidencia;
- error de captura.

La etapa nativa reemplazará la captura simulada por cámara real manteniendo el flujo.

## QR · QRAction

La maqueta trabaja:

- lectura simulada;
- payload válido e inválido;
- tipos diferentes de contenido;
- validación;
- acción derivada;
- reintento.

La etapa nativa reemplazará el origen del payload por un lector QR real.

## Acelerómetro · ShakeLab

La maqueta trabaja:

- valores X/Y/Z simulados;
- magnitud;
- ruido conceptual;
- umbral;
- movimiento leve;
- sacudida;
- historial de eventos.

La etapa nativa reemplazará los valores simulados por eventos reales del sensor.

## Orientación / giroscopio · OrientApp

La maqueta trabaja:

- ángulo simulado;
- cambios de orientación;
- interpretación por rangos;
- respuesta visual;
- transición temporal entre estados.

La etapa nativa reemplazará el control manual por señales reales del dispositivo.

## Aplicación integradora

Después de comprender capacidades aisladas puede aparecer una aplicación de ejemplo que combine varias.

Una buena integración nace de una necesidad funcional. Por ejemplo:

```text
registrar posición
→ identificar una estación mediante QR
→ capturar evidencia
→ reaccionar a movimiento/orientación
→ conservar el registro
```

La integradora no debe convertirse en un catálogo de hardware. Cada capacidad incorporada debe responder:

> ¿Qué necesidad del usuario desaparecería o empeoraría si quitamos esta capacidad?

## Relación con las otras superficies

```text
ejemplo
→ aísla una idea

ejercicio focalizado
→ comprueba comprensión inmediata

lab semanal
→ experiencia guiada de la materia

miniapp nativa
→ profundiza una capacidad física en dos etapas

PocketLog
→ integración longitudinal docente

proyecto VcM
→ transferencia autónoma del equipo
```

Las miniapps no definen qué hardware debe utilizar PocketLog ni el proyecto VcM.
