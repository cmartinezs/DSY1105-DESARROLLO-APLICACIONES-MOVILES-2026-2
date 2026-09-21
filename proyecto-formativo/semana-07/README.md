# PocketLog · Semana 07 · v0.7 · Diseño + navegación

## RECIBE

PocketLog v0.6 ya es una aplicación Android con:

- Compose;
- `ViewModel`;
- `UiState`;
- registros en memoria;
- agregar;
- completar;
- filtrar;
- contadores.

## REQUERIMIENTO

PocketLog ya tenía múltiples capacidades, pero toda la interacción estaba concentrada en una sola pantalla.

Esta semana necesitamos que el producto tenga una estructura navegable y que sus pantallas sean visualmente más claras.

## APRENDEMOS

- jerarquía visual;
- layout adaptable;
- `Scaffold`;
- ancho máximo razonable;
- Navigation Compose;
- rutas;
- back stack;
- argumentos simples.

## PROBLEMA

La v0.6 funciona, pero:

```text
toda la aplicación
      ↓
una sola pantalla larga
```

Eso dificulta distinguir exploración, lista y detalle.

## DECISIÓN

Separar la experiencia en tres destinos:

```text
Inicio → Registros → Detalle
```

La lógica existente no se reescribe.

## PASO A PASO

1. agregar Navigation Compose;
2. mover el armado del flujo a `PocketLogNavigation`;
3. crear una pantalla Inicio;
4. conservar la pantalla principal de registros;
5. hacer cada tarjeta seleccionable;
6. navegar mediante el ID del registro;
7. crear pantalla Detalle;
8. permitir retorno mediante back stack;
9. limitar ancho visual para mejorar lectura en ventanas amplias;
10. verificar que agregar, completar y filtrar siguen funcionando.

## DESCUBRE TÚ

Antes de mirar el checkpoint final:

- decide qué información del registro merece aparecer en la lista;
- decide qué información debería enfatizarse en Detalle;
- prueba dos anchos distintos;
- identifica qué código debe conocer `NavController` y cuál no.

## COMPRUEBA

- Inicio abre;
- Inicio → Registros;
- seleccionar tarjeta → Detalle;
- Detalle recibe el ID correcto;
- volver regresa;
- completar y filtrar siguen funcionando;
- el ViewModel no conoce rutas;
- el dominio no conoce Navigation.

## CHECKPOINT

→ [PocketLog v0.7](../checkpoints/semana-07/android/)

## DEJA ABIERTO

Semana 8 trabajará formularios y validaciones de forma explícita. La deuda que dejamos es mejorar el flujo de creación/edición sobre una navegación ya estable.
