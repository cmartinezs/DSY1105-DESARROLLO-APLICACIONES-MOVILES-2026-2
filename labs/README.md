# Laboratorios · DSY1105 Desarrollo de Aplicaciones Móviles

`labs/` es la fuente canónica de los laboratorios guiados de la asignatura.

## Laboratorios disponibles

- [Semana 01 · Control de batería Java → Kotlin](./semana-01-java-kotlin/)
- [Semana 02 · Analizador de temperaturas](./semana-02-analizador-temperaturas/)
- [Semana 03 · De datos sueltos a objetos](./semana-03-de-datos-a-objetos/)
- [Semana 04 · Mi primera app Android](./semana-04-primer-app-android/)
- Semana 05 · pausa por EP1
- [Semana 06 · ChecklistDiaria: Compose + estado + ViewModel desde cero](./semana-06-checklist-diaria/)
- [Semana 07 · RutaLocal: diseño adaptable y navegación](./semana-07-rutalocal/)
- [Semana 08 · RegistroUsuario: StateFlow, validación y resumen](./semana-08-registro-usuario/)
- [Serie de miniapps nativas](./miniapps-nativas/) — maquetas completas en Semana 7 y evolución posterior hacia hardware real.

### Miniapps nativas · etapa maqueta

- [GeoTrack · GPS](./miniapps-nativas/gps/maqueta/)
- [PhotoProof · Cámara](./miniapps-nativas/camara/maqueta/)
- [QRAction · Lector QR](./miniapps-nativas/qr/maqueta/)
- [ShakeLab · Acelerómetro](./miniapps-nativas/acelerometro/maqueta/)
- [OrientApp · Orientación / giroscopio](./miniapps-nativas/orientacion/maqueta/)

## Contrato

Cada laboratorio es un **proyecto pequeño, autocontenido e independiente** cuyo propósito es practicar contenido en un contexto acotado.

Por diseño:

- un lab no continúa el lab de la semana anterior;
- un lab no es una versión preliminar de PocketLog;
- un lab no depende de checkpoints de PocketLog;
- cada lab debe poder iniciarse desde cero con conocimientos ya enseñados;
- cada lab debe organizar la implementación en pasos secuenciales y checkpoints explícitos;
- el dominio puede cambiar para obligar a transferir aprendizaje y no sólo repetir código.

### Excepción deliberada · miniapps nativas

Cada miniapp nativa **sí evoluciona sobre sí misma**:

```text
maqueta
→ hardware real
```

Esto no viola la independencia entre laboratorios: GeoTrack no continúa PhotoProof ni ShakeLab. Cada una conserva su propia identidad y reemplaza progresivamente su fuente simulada por una capacidad real del dispositivo.

PocketLog **no es un laboratorio**. Es el proyecto formativo transversal de la asignatura y evoluciona de manera acumulativa durante el semestre.

`semanas/` puede enlazar labs, miniapps y PocketLog como superficies distintas de práctica, pero no debe presentarlos como etapas del mismo proyecto.
