# Capacidades nativas · estrategia de miniapps monofoco

## Propósito

Las capacidades del dispositivo no se enseñan como una lista de APIs que deben aparecer todas juntas.

Cada capacidad se trabaja primero mediante una **mini aplicación monofoco** que permita explorarla en varias facetas y convertir una señal o recurso físico del teléfono en comportamiento interactivo.

La pregunta no es:

> ¿Cómo uso esta API?

La pregunta es:

> ¿Qué experiencia puedo construir con esta capacidad, qué decisiones implica y qué condiciones reales debo manejar?

## Regla de diseño

Una miniapp debe tener:

- una capacidad nativa principal;
- un problema o interacción reconocible;
- varios escenarios de uso de esa capacidad;
- manejo de permisos cuando corresponda;
- estados normales y casos límite;
- feedback visible para el usuario;
- suficiente profundidad para comprender el comportamiento del dispositivo.

Se evita crear una app con cámara + GPS + QR + sensores + notificaciones sólo para demostrar que las APIs fueron llamadas.

## GPS

Una miniapp centrada en ubicación puede explorar progresivamente:

- lectura de ubicación actual;
- permisos;
- precisión disponible;
- distancia entre puntos;
- actualización de posición;
- seguimiento cuando el problema realmente lo requiera;
- comportamiento cuando no existe ubicación disponible.

El foco no es «mostrar latitud y longitud», sino construir interacción a partir de posición y contexto.

## Cámara

Una miniapp de cámara puede trabajar:

- permisos;
- captura;
- preview;
- aceptación o descarte de una imagen;
- asociación de evidencia a una entidad;
- almacenamiento temporal o permanente cuando corresponda;
- comportamiento frente a errores o ausencia de permiso.

## Lectura de QR

Una miniapp de QR puede explorar:

- lectura;
- validación del payload;
- contenido inválido;
- códigos con distintos tipos de información;
- acciones diferentes según el contenido;
- feedback y recuperación cuando no existe lectura válida.

El QR debe desencadenar una interacción, no limitarse a imprimir el texto leído.

## Acelerómetro

Una miniapp centrada en movimiento puede trabajar:

- lectura de ejes;
- variaciones y ruido;
- umbrales;
- detección de sacudida o movimiento brusco;
- eventos interactivos;
- calibración simple para evitar falsos positivos.

## Giroscopio y orientación

Puede utilizarse para explorar:

- rotación del dispositivo;
- cambios de postura;
- orientación espacial;
- relación entre movimiento y respuesta de la interfaz;
- diferencias entre una medición puntual y una secuencia temporal.

## Notificaciones y otras capacidades

También pueden trabajarse miniapps centradas en:

- notificaciones locales;
- programación;
- compartir contenido;
- conectividad;
- almacenamiento;
- otros recursos nativos cuando exista un objetivo pedagógico claro.

## Aplicación integradora

Después de comprender capacidades aisladas puede aparecer una aplicación de ejemplo que combine varias.

Una buena integración nace de una necesidad funcional. Por ejemplo, una aplicación de terreno podría:

```text
registrar posición
→ identificar una estación mediante QR
→ capturar evidencia
→ reaccionar a un evento del dispositivo
→ conservar un registro de la actividad
```

La aplicación integradora no debe convertirse en un catálogo de hardware. Cada capacidad debe poder defenderse con la pregunta:

> ¿Qué necesidad del usuario desaparecería o empeoraría si quitamos esta capacidad?

Si no existe una respuesta convincente, probablemente esa integración no es necesaria.

## Relación con ejemplos, labs y proyectos

```text
ejemplo
→ aísla una idea

miniapp nativa
→ profundiza una capacidad del dispositivo

lab
→ construye una experiencia completa y guiada

proyecto transversal
→ integra aprendizajes de distintas semanas

proyecto del estudiante
→ decide autónomamente cuáles capacidades tienen sentido
```

Una miniapp nativa no debe transformarse automáticamente en requisito para PocketLog ni para el caso VcM.
