# Semana 1 · Panorama del desarrollo de aplicaciones

**Periodo:** 10 al 15 de agosto de 2026  
**Actividad institucional:** 1.1 Panorama del desarrollo de aplicaciones

← [Volver al índice de semanas](../README.md)

## Objetivo de la semana

Comprender el panorama general del desarrollo de aplicaciones móviles, distinguiendo plataformas, tipos de aplicaciones, lenguajes, frameworks/toolkits e IDE, para contextualizar el rol de Kotlin y Android dentro del curso.

Durante la semana se incorpora además un **puente breve Java → Kotlin**, pensado como transición desde conocimientos previos y no como reemplazo de los contenidos formales de Kotlin de las semanas siguientes. También se inicia la **Guía 1** y la organización de las parejas del proyecto semestral.

## Distribución real de la semana · sección 009V

La sección dispone de **5 bloques pedagógicos** esta semana:

- **Lunes 10 de agosto · 19:01–21:10 · 3 bloques** → [detalle de la clase](./lunes-10.md)
- **Jueves 13 de agosto · 21:11–22:30 · 2 bloques** → [detalle de la clase](./jueves-13.md)

La planificación se ajusta al avance efectivo de la sección; no se asume que todo lo planificado inicialmente haya sido realizado.

## Avance efectivo

### Lunes 10 · realizado

Se trabajó en:

1. presentación general de la asignatura;
2. revisión de fechas, evaluaciones, ponderaciones y reglas de trabajo;
3. explicación general de la dinámica del semestre;
4. revisión de la PPT **1.1.1 Ecosistema de Aplicaciones Móviles**.

**No se alcanzó a trabajar el puente Java → Kotlin**, por lo que ese contenido pasa a la sesión del jueves.

### Jueves 13 · planificación ajustada

Dado que la sesión tiene solo dos bloques, se prioriza:

1. **Puente Java → Kotlin**, con equivalencias básicas: `val` / `var`, tipos, inferencia, String templates, null safety y funciones simples.
2. **Aclaración conceptual** entre plataforma, lenguaje, framework/toolkit e IDE.
3. **Inicio de la Guía 1**, explicando criterios de comparación y uso de fuentes oficiales.
4. **Organización inicial de parejas** del proyecto semestral o registro de incidencias para quienes aún no tengan compañero/a.

La Guía 1 puede quedar **iniciada y no necesariamente terminada durante la clase**; la prioridad es que el estudiante comprenda qué debe investigar, con qué criterios y usando qué tipo de fuentes.

## Contenidos de la semana

### 1.1.1 · Ecosistema de Aplicaciones Móviles

- aplicaciones nativas;
- web móvil y PWA;
- aplicaciones híbridas;
- desarrollo multiplataforma;
- Android e iOS;
- lenguajes y herramientas nativas;
- frameworks y toolkits multiplataforma;
- distribución y criterios de elección tecnológica.

### Puente Java → Kotlin

Se trabaja únicamente como transición inicial:

- `final` / variables mutables → `val` / `var`;
- tipos explícitos e inferencia;
- interpolación mediante String templates;
- introducción a null safety;
- funciones simples;
- diferencias de sintaxis relevantes para comenzar a leer Kotlin.

### 1.1.2 · Guía 1: investigación de lenguajes y frameworks móviles

La comparación debe considerar, según corresponda:

- rendimiento;
- acceso a hardware y APIs del dispositivo;
- experiencia y curva de aprendizaje del equipo;
- time-to-market;
- mantenibilidad;
- costos y ecosistema;
- soporte y documentación oficial.

## Material original de la asignatura

📚 [**Biblioteca pública del curso**](https://drive.google.com/drive/folders/1_Ew_IE0InqJbPY0Ggu8p0cHl4Avv3rYs?usp=sharing)  
📁 [**Semana 01 · 10 al 15 de agosto**](https://drive.google.com/drive/folders/1ieL6EOF475qNxCErYrQfjqw8EL-GXeiV)

Actualmente se encuentra publicado:

- `1.1.1 Ecosistema de Aplicaciones Moviles.pptx`

> La Guía 1 está referenciada por el cronograma institucional, pero en la carpeta recibida se encuentra dentro del archivo global `Experiencias_DSY1105.zip`. Ese archivo supera el límite de descarga del conector, por lo que continúa pendiente extraer y publicar únicamente el recurso correspondiente a esta semana.

## Aclaraciones importantes

### Lenguaje, framework, plataforma e IDE no son lo mismo

- **Plataforma:** Android, iOS, web móvil.
- **Lenguaje:** Kotlin, Java, Swift, Dart, JavaScript/TypeScript.
- **Framework / toolkit:** Flutter, React Native, Ionic, Kotlin Multiplatform, Jetpack Compose según el contexto.
- **IDE / herramienta de desarrollo:** Android Studio, Xcode, IntelliJ IDEA, VS Code.

### Kotlin y Android

Kotlin será el lenguaje principal del curso porque forma parte del ecosistema moderno de desarrollo Android. Su sintaxis es más concisa que Java y mantiene interoperabilidad con el ecosistema JVM.

### Elección tecnológica

No existe una tecnología móvil universalmente mejor. La decisión depende de restricciones técnicas, experiencia del equipo, acceso a hardware, time-to-market, costo, mantenibilidad y estrategia de producto.

## Evidencia mínima de aprendizaje de la semana

Al finalizar la semana el estudiante debería poder:

1. distinguir una aplicación nativa de una híbrida, multiplataforma, PWA o web móvil;
2. diferenciar plataforma, lenguaje, framework/toolkit e IDE;
3. explicar por qué Kotlin es relevante para Android;
4. reconocer equivalencias sintácticas básicas entre Java y Kotlin;
5. iniciar una comparación técnica utilizando criterios explícitos y fuentes oficiales;
6. tener pareja de proyecto definida o una incidencia registrada para su resolución.

## Trabajar con el repositorio

```bash
git clone https://github.com/cmartinezs/DSY1105-DESARROLLO-APLICACIONES-MOVILES-2026-2.git
cd DSY1105-DESARROLLO-APLICACIONES-MOVILES-2026-2
```

Si ya tienes el repositorio:

```bash
git pull
```
