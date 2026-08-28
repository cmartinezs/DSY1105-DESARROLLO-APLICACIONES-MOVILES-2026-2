# Portal web del curso

`page/` contiene la capa de navegación web para estudiantes de **DSY1105**.

La web **no reemplaza ni duplica** las fuentes canónicas del repositorio. Su objetivo es reducir fricción de navegación y responder rápidamente:

1. ¿Qué corresponde esta semana?
2. ¿Dónde estudio el contenido?
3. ¿Dónde veo ejemplos?
4. ¿Qué lab debo realizar?
5. ¿Cómo continúo PocketLog?
6. ¿Cómo reviso mi propio progreso y estándar de repositorio?

## Arquitectura de información

La portada refleja las cuatro verticales canónicas:

- `semanas/` → contenido curricular y ampliaciones;
- `labs/` → práctica guiada con checkpoints;
- `examples/` → demostraciones mínimas e independientes;
- `proyecto-formativo/` → proyecto incremental sobre una única base de código viva.

## Archivos

- `index.html` → portada y ruta de trabajo de la semana curricular actual;
- `progreso.html` → checklist personal almacenado sólo en `localStorage`;
- `repositorio-estudiante.html` → resumen navegable del estándar del repositorio personal;
- `styles.css` → sistema visual compartido del portal.

## Reglas de mantenimiento

- priorizar **Esta semana** sobre el catálogo completo;
- actualizar semana actual, periodo, foco, lab y checklist al abrir una nueva semana;
- enlazar siempre a fuentes canónicas de GitHub/Drive;
- no copiar contenido largo desde `semanas/`, `labs/`, `examples/` o `proyecto-formativo/`;
- mantener consistencia visual reutilizando `styles.css`;
- usar componentes como tarjetas, pestañas, acordeones y callouts cuando reduzcan carga cognitiva;
- conservar diseño responsive y navegación usable desde móvil.

## Fuentes principales

- [README principal](../README.md)
- [Índice de semanas](../semanas/README.md)
- [Labs](../labs/README.md)
- [Ejemplos](../examples/README.md)
- [Proyecto formativo](../proyecto-formativo/README.md)
- [Material público en Google Drive](https://drive.google.com/drive/folders/1_Ew_IE0InqJbPY0Ggu8p0cHl4Avv3rYs?usp=sharing)
