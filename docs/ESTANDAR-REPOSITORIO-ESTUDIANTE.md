# Estándar de repositorio del estudiante · DSY1105-009V

Este documento define cómo organiza y entrega su trabajo el estudiante. **No copia la estructura del repositorio docente.**

## 1. Repositorio único y público

```text
DSY1105-009V-nombre-apellido
```

Ejemplo:

```text
DSY1105-009V-carlos-martinez
```

Reglas:

- un solo repositorio para todo el semestre;
- repositorio **público**, salvo instrucción excepcional del docente;
- nombre y apellido en minúsculas, separados por `-`;
- sin espacios, tildes ni caracteres especiales.

## 2. Estructura oficial

```text
DSY1105-009V-nombre-apellido/
├── README.md
├── .gitignore
├── docs/
│   ├── README.md
│   └── devlog/
│       ├── README.md
│       ├── semana-02.md
│       ├── semana-03.md
│       └── ...
├── practica-kotlin/
├── labs/
├── proyecto-formativo/
│   └── pocketlog/
├── desafios/
└── evaluaciones/
    ├── ep1/
    ├── ep2/
    ├── ep3/
    └── eft/
```

La carpeta `docs/` contiene documentación transversal. `docs/devlog/` registra la evolución semanal del estudiante.

Las semanas no organizan técnicamente el código; **solo el DevLog utiliza semanas porque su función es registrar progreso en el tiempo**.

## 3. DevLog transversal

El DevLog real vive en:

```text
docs/devlog/semana-XX.md
```

Formato mínimo:

```markdown
# DevLog · Semana XX

## Objetivo
...

## Avance
...

## Bloqueo
...

## Aprendizaje
...

## Siguiente
...
```

No mide horas y no exige textos largos. Debe ser breve, específico y coherente con el trabajo real.

Manual:

➡️ [`docs/DEVLOG-ESTUDIANTE.md`](./DEVLOG-ESTUDIANTE.md)

## 4. Package raíz personal

```text
c.martinez → cmartinez → cl.duoc.cmartinez
```

Patrón:

```text
cl.duoc.<usuario-duoc-sin-puntos>
```

## 5. Práctica Kotlin

La práctica corta vive en un único proyecto y se organiza por bloques conceptuales:

```text
practica-kotlin/
└── src/cl/duoc/cmartinez/
    ├── fundamentos/ejercicio01/Main.kt
    ├── nullsafety/ejercicio01/Main.kt
    ├── funciones/...
    └── colecciones/...
```

No crear un proyecto IntelliJ por cada ejercicio de un archivo.

## 6. Laboratorios Kotlin/Android

Cada laboratorio de mayor alcance tiene su propia subcarpeta/proyecto. Un proyecto Android debe conservar todo lo necesario para reproducirlo:

```text
labs/nombre-lab/
├── README.md
├── settings.gradle.kts
├── build.gradle.kts
├── gradlew
├── gradlew.bat
├── gradle/wrapper/
└── app/
```

No versionar `local.properties`, builds, estado del IDE ni secretos.

## 7. Proyecto formativo · PocketLog

```text
proyecto-formativo/
└── pocketlog/
```

Package base sugerido:

```text
cl.duoc.cmartinez.pocketlog
```

PocketLog evoluciona siempre en la misma carpeta. No crear `pocketlog-v2`, `pocketlog-final`, etc.

## 8. Evaluaciones

```text
evaluaciones/
├── ep1/
├── ep2/
├── ep3/
└── eft/
```

Cada evaluación contiene exactamente lo necesario para compilar, ejecutar y revisar la entrega.

## 9. Markdown obligatorio

README mínimo obligatorio en:

```text
/README.md
/docs/README.md
/docs/devlog/README.md
/practica-kotlin/README.md
/labs/README.md
/proyecto-formativo/README.md
/proyecto-formativo/pocketlog/README.md
/desafios/README.md
/evaluaciones/README.md
```

Además, cada laboratorio, desafío o evaluación con identidad propia debe tener su `README.md`.

El README raíz debe enlazar el DevLog:

```markdown
## Seguimiento
- [DevLog](docs/devlog/)
```

Los README especialmente claros, útiles y consistentes pueden recibir bonificación definida por el docente; cumplir el mínimo no genera bonificación automática.

## 10. Qué versionar

Sí:

- código Kotlin/Java;
- `AndroidManifest.xml` y recursos;
- Gradle/Wrapper necesarios;
- README y documentación;
- DevLog;
- configuración necesaria sin secretos.

No:

```text
.idea/
.gradle/
**/build/
local.properties
*.iml
*.log
captures/
.externalNativeBuild/
.cxx/
.env
*.key
*.pem
```

## 11. Flujo Git mínimo

Al comenzar:

```bash
git pull
```

Al terminar:

```bash
git status
git add .
git commit -m "mensaje claro"
git push
```

Debe existir un solo `.git`: el de la raíz del repositorio de la asignatura.

## 12. Relación entre evidencias

```text
Código     → qué construiste
Commits    → cómo fue cambiando
README     → cómo se entiende y ejecuta
DevLog     → qué ocurrió y qué aprendiste
Issues     → qué trabajo quieres abordar, cuando los incorporemos
```

## 13. Checklist

- [ ] Repo público `DSY1105-009V-nombre-apellido`.
- [ ] Package raíz `cl.duoc.<usuario-sin-puntos>`.
- [ ] `docs/devlog/` existe y contiene la entrada semanal.
- [ ] DevLog tiene objetivo, avance, bloqueo, aprendizaje y siguiente.
- [ ] Práctica Kotlin organizada por bloques, no por semanas.
- [ ] PocketLog evoluciona en una sola carpeta.
- [ ] Proyectos Android incluyen archivos necesarios para reproducirse.
- [ ] `local.properties`, builds, IDE y secretos no están versionados.
- [ ] README raíz y carpetas relevantes documentados.
- [ ] Código/app compila y ejecuta según corresponda.
- [ ] Commit y push realizados y verificados en GitHub.

> El repositorio del curso enseña y publica; el repositorio personal conserva tu trabajo, documentación, evolución y evidencia de aprendizaje.
