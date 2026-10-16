# 05 · Desafío, evidencia y Definition of Done

[← Verificación](04-verificacion.md) · [Índice](README.md)

## Paso 12 · Desafío individual (posterior al CRUD base)

Añade una **categoría** a cada nota, por ejemplo «Estudio», «Personal» y «Trabajo».

1. Propón el nuevo campo de `Nota`.
2. Ajusta el formulario y la representación en la lista.
3. Implementa un filtro por categoría.
4. Explica qué ocurre con la versión de la base y por qué Room necesita una migración si ya hay registros.

**Importante:** el proyecto de referencia se queda intencionalmente en **una tabla simple y cuatro operaciones CRUD**. La categoría es un desafío separado, no algo que debas incluir al copiar la referencia. Si decides recrear una base de prueba, documenta la pérdida de datos; para conservarlos necesitas migración.

## Paso 13 · DevLog

En tu repositorio `DSY1105-009V-nombre-apellido`, registra:

- ruta y commit del laboratorio;
- captura de la UI con al menos 3 registros;
- demostración de Create, Read, Update y Delete;
- captura de Database Inspector y consulta SQL;
- prueba de cierre y reapertura;
- un error encontrado, diagnóstico y solución;
- una decisión sobre separar UI, ViewModel, DAO y Database.

## Preguntas de cierre

1. ¿Qué diferencia hay entre **SQLite** y **Room**?
2. ¿Qué anotaciones identifican una tabla y su clave primaria?
3. ¿Por qué `obtenerTodas()` devuelve `Flow<List<Nota>>`?
4. ¿Por qué `@Update` debe recibir una nota con el ID correcto?
5. ¿Qué cambiaría si usáramos una lista temporal en lugar de SQLite?
6. ¿Por qué un sonido al tocar «Guardar» no prueba que la operación se completó?

## Definition of Done

- [ ] Creé un proyecto desde cero y sincroniza Gradle.
- [ ] Existe una sola tabla `notas` con `id` y `texto`.
- [ ] Insertar, consultar, actualizar y eliminar funcionan.
- [ ] Se valida el texto vacío.
- [ ] La UI se actualiza por observación del `Flow`.
- [ ] Los registros sobreviven al cierre de la app.
- [ ] Comprobé filas y claves en Database Inspector.
- [ ] Dejé DevLog y evidencias.
- [ ] Puedo explicar el flujo: UI → ViewModel → DAO → SQLite.

## Límites del laboratorio

No incorporar segunda tabla, relaciones, APIs REST, navegación, inyección de dependencias ni arquitectura adicional sin propósito docente. PocketLog y VcM no se modifican.

## Consulta externa

- [Documentación oficial de Room](https://developer.android.com/training/data-storage/room)
- [Versiones de Room](https://developer.android.com/jetpack/androidx/releases/room)
- [KSP, introducción](https://kotlinlang.org/docs/ksp-quickstart.html)
