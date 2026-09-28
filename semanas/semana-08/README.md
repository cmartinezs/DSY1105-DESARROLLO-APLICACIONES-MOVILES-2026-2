# Semana 8 · Formularios, validaciones e interacción entre pantallas

**Periodo:** 28 de septiembre al 3 de octubre de 2026  
**Asignatura:** DSY1105 Desarrollo de Aplicaciones Móviles  
**Experiencia:** EA2 · Desarrollando componentes visuales y funcionalidades nativas para aplicaciones móviles

← [Volver al índice](../README.md)

## Foco curricular

La maleta institucional contempla:

- **2.3.1** Formularios, validaciones y componentes interactivos – Parte I.
- **2.3.2** Formularios, validaciones y componentes interactivos – Parte II.
- **2.3.3** Guía 11 – Formularios, validaciones y paso de información.

La semana toma la navegación construida en Semana 7 y agrega captura de datos, validación, feedback e interacción dinámica entre destinos.

```text
pantallas navegables
→ formulario
→ estado de formulario
→ validación
→ feedback
→ acción
→ paso de información
→ pantalla actualizada
```

## Objetivos de aprendizaje

Al finalizar la semana, el estudiante debe poder:

1. construir formularios Compose con campos controlados;
2. modelar datos y errores mediante `data class`;
3. almacenar estado con `MutableStateFlow` en el ViewModel;
4. observar estado con `collectAsState` desde Compose;
5. validar antes de ejecutar una acción y mostrar errores específicos;
6. navegar sólo cuando `validarFormulario()` indique éxito;
7. compartir el mismo ViewModel entre Registro y Resumen;
8. explicar la relación UI → evento → ViewModel → StateFlow → UI.

## Ruta de aprendizaje

### Parte A · Formularios y validaciones
→ [Contenido normal](./01-formularios-validaciones.md)  
→ [Profundización](./01-formularios-validaciones/README.md)

### Parte B · Interacción y paso de información
→ [Contenido normal](./02-interaccion-pantallas.md)  
→ [Profundización](./02-interaccion-pantallas/README.md)

## Ejemplos guiados

1. [Campo controlado](../../examples/semana-08/campo-controlado/)
2. [Validación visible](../../examples/semana-08/validacion-visible/)
3. [UiState + modelo de errores](../../examples/semana-08/formulario-uistate/)
4. [MutableStateFlow + ViewModel](../../examples/semana-08/formulario-viewmodel/)
5. [Registro → Resumen con ViewModel compartido](../../examples/semana-08/formulario-navegacion/)

→ [Ruta completa de ejemplos](../../examples/semana-08/)

## Ejercicio focalizado

→ [PerfilContacto](./ejercicios-basicos.md)

Formulario pequeño con validación y navegación a resumen. No persistencia, red ni hardware.

## Laboratorio independiente

→ [ReservaSimple](../../labs/semana-08-reserva-simple/README.md)

Aplicación construida desde cero con formulario, validación, feedback y navegación. El laboratorio es independiente de PocketLog.

## Proyecto transversal · PocketLog v0.8

→ [PocketLog · Semana 08](../../proyecto-formativo/semana-08/README.md)

La navegación de v0.7 se mantiene y ahora se incorpora un formulario real para crear registros con validación explícita.

## Miniapps nativas

Las miniapps iniciadas en Semana 7 **no incorporan hardware real todavía**. Pueden aprovechar esta semana para mejorar formularios/configuración o estados interactivos si ello aporta al flujo, pero la evolución hacia APIs nativas queda reservada a la semana curricular correspondiente.

→ [Serie de miniapps nativas](../../labs/miniapps-nativas/)

## Seguimiento VcM · jueves

Semana 7 dejó pendiente el primer checkpoint formal de proyecto. Se ejecuta durante esta semana, idealmente el **jueves**, junto con la revisión técnica inicial.

La revisión sigue esta cadena:

```text
contexto
→ problemática
→ requerimientos
→ alcance
→ MR normalizado
→ mockups
→ pantallas / navegación
→ avance Android
```

### Qué se revisará

- coherencia entre problema y funcionalidades;
- alcance viable para máximo dos integrantes;
- requerimientos priorizados;
- MR coherente con la información necesaria;
- navegación coherente con los mockups;
- primeras pantallas implementadas en Android Studio;
- dudas abiertas que requieran canal CITT;
- repositorio GitHub con evolución real;
- participación de ambos integrantes;
- capacidad del equipo de justificar decisiones.

El objetivo no es entregarles la solución, sino detectar temprano incoherencias y sobrealcance.

## GitHub y colaboración

A esta altura el repositorio del equipo debe mostrar:

- commits progresivos;
- participación de ambos integrantes;
- ramas de trabajo cuando corresponda;
- integración periódica;
- documentación actualizada;
- ausencia de una única carga monolítica al final.

La revisión de GitHub forma parte del seguimiento del proceso, no sólo de la entrega.

## Próximo hito

El **Parcial 2 se entrega en Semana 11**. Semanas 8–10 deben mostrar construcción progresiva y feedback temprano.

## Qué NO incorporar todavía por defecto

- Room/SQLite si aún no corresponde curricularmente;
- DataStore como requisito de esta semana;
- Retrofit/REST;
- hardware real de las miniapps;
- DI;
- complejidad arquitectónica que no sea necesaria para explicar el flujo.

`StateFlow` sí forma parte explícita de la Guía 11 y se trabaja esta semana. `DataStore` y `Room` quedan para su momento posterior dentro de EA2.

## Evidencia mínima de cierre

- formulario funcional;
- al menos dos validaciones justificadas;
- feedback visible;
- `MutableStateFlow` administrado desde ViewModel;
- `collectAsState` observando el formulario;
- navegación posterior a una validación correcta;
- segunda pantalla observando el mismo ViewModel compartido;
- lab terminado o equivalente;
- PocketLog v0.8 avanzado;
- checkpoint VcM realizado o registrado como pendiente justificado;
- DevLog actualizado.
