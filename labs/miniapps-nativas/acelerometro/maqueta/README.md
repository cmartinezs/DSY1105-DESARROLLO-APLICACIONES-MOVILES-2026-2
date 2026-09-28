# ShakeLab · Maqueta Semana 7

**Capacidad futura:** Acelerómetro  
**Etapa actual:** maqueta funcional sin hardware real

## Objetivo

Construir la experiencia completa antes de conectar el dispositivo.

```text
Inicio → Monitor → Evento → Historial
```

La miniapp debe poder recorrerse de principio a fin usando datos/eventos simulados.

## Estados mínimos

- reposo
- movimiento leve
- sacudida
- evento descartado
- evento registrado

## Paso 0 · Crear y ejecutar

1. crear Empty Activity con Compose;
2. ejecutar el template;
3. agregar Navigation Compose;
4. confirmar que compila antes de avanzar.

## Paso 1 · Modelar el estado

Crear un `UiState` que represente únicamente lo necesario para esta miniapp.

No usar hardware todavía.

## Paso 2 · Crear fuente simulada

Crear una clase o función responsable de producir datos/eventos de prueba.

La UI no debe inventar esos datos directamente.

```text
UI
→ ViewModel / controlador de estado
→ fuente simulada
```

## Paso 3 · Pantalla Inicio

Debe explicar:

- qué problema resuelve la miniapp;
- qué capacidad utilizará más adelante;
- qué puede hacer hoy la maqueta;
- botón para comenzar.

## Paso 4 · Pantalla principal

Implementar la interacción específica:

- simular valores X/Y/Z;
- mostrar magnitud aproximada;
- aplicar un umbral simple;
- distinguir movimiento leve de sacudida;
- registrar eventos detectados.

## Paso 5 · Resultado y feedback

El usuario debe poder distinguir visualmente:

- estado actual;
- resultado exitoso;
- error o condición no disponible;
- acción para continuar o reintentar.

## Paso 6 · Navegación

Usar destinos explícitos y callbacks. Las pantallas no deben recibir `NavController` directamente salvo una justificación didáctica puntual.

## Paso 7 · Adaptabilidad

Probar al menos:

1. teléfono vertical;
2. teléfono horizontal o ventana de mayor ancho.

Mantener jerarquía y legibilidad.

## Paso 8 · Casos manuales

Probar al menos:

- flujo normal completo;
- un estado de error/no disponible;
- volver al destino anterior;
- repetir la interacción;
- cambio de orientación/tamaño sin pérdida absurda de legibilidad.

## Paso 9 · DevLog

Registrar:

- estados diseñados;
- qué parte hoy es simulada;
- qué parte se conservará con hardware real;
- una decisión visual;
- una decisión de navegación;
- una decisión de separación de responsabilidades.

## Evolución futura

Los valores simulados se sustituirán por eventos reales del acelerómetro; el filtrado y los umbrales deben poder evolucionar.

La regla es **evolucionar esta misma miniapp**, no crear otra desde cero.

## Criterio de término

La maqueta está terminada cuando puede demostrarse el flujo completo y el estudiante puede señalar exactamente dónde se reemplazará la simulación por hardware real.
