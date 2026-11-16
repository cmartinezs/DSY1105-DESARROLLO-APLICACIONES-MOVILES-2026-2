# Semana 14 · Pruebas unitarias en aplicaciones móviles

**DSY1105 · Desarrollo de Aplicaciones Móviles · 2026-2**

> **Periodo y ejecución:** pendientes de conciliación con el cronograma y la coordinación institucional. Este material prepara el contenido; no acredita una clase realizada ni modifica actividades o evaluaciones oficiales.

## Qué aprender

Comprender por qué automatizamos pruebas en una aplicación Android y cómo seleccionar una estrategia según la unidad que queremos verificar. Al terminar podrás:

- distinguir pruebas locales JVM e instrumentadas;
- identificar qué conviene probar en funciones, clases, ViewModels, repositorios y componentes Compose;
- escribir pruebas legibles con preparación, ejecución y verificación;
- aislar dependencias mediante fakes o mocks;
- controlar corrutinas y flujos de estado sin pausas artificiales;
- ejecutar pruebas desde Android Studio o Gradle.

## Ruta de estudio y práctica

1. [Pruebas unitarias en Android](01-pruebas-unitarias-android.md): conceptos, alcance, estrategia y herramientas.
2. [Profundización](01-pruebas-unitarias-android/README.md): configuración, JUnit y Compose UI Test, dobles de prueba y corrutinas.
3. [Laboratorio guiado · Testea tu App Móvil](../../labs/semana-14-pruebas-unitarias/README.md): construir y ejecutar pruebas para lógica, ViewModel y UI.

## Estrategia de trabajo

Comienza por las pruebas locales: son rápidas y permiten verificar reglas de negocio y estados sin iniciar un emulador. Reserva las pruebas instrumentadas para comprobar interacciones reales con la interfaz Compose o capacidades del dispositivo.

La práctica usa un caso pequeño e independiente. No modifica PocketLog ni resuelve una evaluación sumativa o el proyecto VcM.

## Evidencia sugerida

En el DevLog registra:

- qué comportamiento probaste y por qué;
- qué casos válidos y límites cubriste;
- qué dependencia reemplazaste con un fake o mock;
- resultado de la ejecución;
- un defecto o supuesto que la prueba permitió detectar.

## Fuentes

- [Android Developers · Fundamentos de las pruebas](https://developer.android.com/training/testing/fundamentals?hl=es-419).
- [Android Developers · Pruebas locales](https://developer.android.com/training/testing/local-tests).
- [Android Developers · Pruebas instrumentadas](https://developer.android.com/training/testing/instrumented-tests).
- [Android Developers · Pruebas de UI en Compose](https://developer.android.com/develop/ui/compose/testing).

Los códigos RA/IL y el periodo específico se mantienen pendientes hasta contrastarlos con la fuente institucional correspondiente.
