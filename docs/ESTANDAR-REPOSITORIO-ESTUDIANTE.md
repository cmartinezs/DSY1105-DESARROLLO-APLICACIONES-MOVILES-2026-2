# Estándar de repositorio del estudiante · DSY1105-009V

Este documento define **cómo entrega y organiza su trabajo el estudiante**. No copia la estructura interna del repositorio docente.

## 1. Nombre obligatorio

```text
DSY1105-009V-nombre-apellido
```

Ejemplo:

```text
DSY1105-009V-carlos-martinez
```

Nombre y apellido en minúsculas, separados por guion, sin espacios, tildes ni caracteres especiales.

## 2. Un repositorio para todo el semestre

```text
DSY1105-009V-nombre-apellido/
├── README.md
├── .gitignore
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

Las semanas pertenecen a la planificación docente; **no es obligatorio replicarlas en la estructura técnica del estudiante**.

## 3. Package raíz personal

Usa tu usuario Duoc sin puntos:

```text
c.martinez → cmartinez → cl.duoc.cmartinez
```

Patrón:

```text
cl.duoc.<usuario-duoc-sin-puntos>
```

## 4. Práctica Kotlin

La práctica corta puede vivir en un único proyecto `practica-kotlin/`, organizada por bloques conceptuales.

```text
practica-kotlin/
└── src/
    └── cl/duoc/cmartinez/
        ├── fundamentos/
        │   ├── ejercicio01/Main.kt
        │   └── ejercicio02/Main.kt
        ├── nullsafety/
        ├── funciones/
        └── colecciones/
```

Ejemplo:

```kotlin
package cl.duoc.cmartinez.fundamentos.ejercicio01
```

No crear un proyecto IntelliJ completo por cada ejercicio de un archivo.

## 5. Laboratorios Android/Kotlin

Cada laboratorio de mayor alcance tiene su propia subcarpeta/proyecto:

```text
labs/
└── nombre-lab/
    ├── README.md
    ├── settings.gradle.kts
    ├── build.gradle.kts
    ├── gradlew
    ├── gradlew.bat
    ├── gradle/wrapper/
    └── app/
        ├── build.gradle.kts
        └── src/main/
            ├── AndroidManifest.xml
            ├── java/cl/duoc/cmartinez/...
            └── res/
```

En un proyecto Android **sí se incluyen** los archivos Gradle/Wrapper necesarios para poder construirlo desde otra máquina.

No se incluye `local.properties`, porque normalmente contiene rutas locales del SDK.

## 6. Proyecto formativo · PocketLog

```text
proyecto-formativo/
└── pocketlog/
```

Package base sugerido:

```text
cl.duoc.cmartinez.pocketlog
```

PocketLog evoluciona siempre dentro de la misma carpeta. No crear `pocketlog-final`, `pocketlog-v2`, etc.; Git mantiene el historial.

## 7. Evaluaciones

```text
evaluaciones/
├── ep1/
├── ep2/
├── ep3/
└── eft/
```

Cada evaluación contiene exactamente lo necesario para compilar, ejecutar y revisar la entrega. Si corresponde a una app Android, debe conservar la estructura completa reproducible del proyecto.

## 8. Qué subir / qué no subir

### Sí subir

- código fuente Kotlin/Java;
- `AndroidManifest.xml`;
- `res/` y recursos necesarios;
- `settings.gradle.kts`, `build.gradle.kts` y archivos de módulo;
- `gradlew`, `gradlew.bat` y `gradle/wrapper/`;
- README;
- configuraciones de aplicación necesarias que no sean secretas.

### No subir

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

Nunca subir tokens, passwords, API keys ni credenciales.

## 9. Markdown obligatorio

Aprenderemos a documentar con Markdown. El repositorio debe explicarse a sí mismo.

README mínimo obligatorio en:

```text
/README.md
/practica-kotlin/README.md
/labs/README.md
/proyecto-formativo/README.md
/proyecto-formativo/pocketlog/README.md
/desafios/README.md
/evaluaciones/README.md
```

Además, cada laboratorio, desafío o evaluación con identidad propia debe tener su `README.md`.

No hace falta un README por cada `Main.kt`.

### README mínimo de una carpeta/proyecto

```markdown
# Nombre

## Objetivo
Qué se practica o resuelve.

## Contenido
Qué archivos, módulos o funcionalidades contiene.

## Ejecución
Cómo abrir, compilar y ejecutar.

## Notas
Decisiones, restricciones o aprendizajes relevantes.
```

### README mínimo de la raíz

```markdown
# DSY1105-009V · Desarrollo de Aplicaciones Móviles

**Estudiante:** Nombre Apellido  
**Usuario Duoc:** c.martinez  
**Package raíz:** cl.duoc.cmartinez  
**Semestre:** 2026-2

## Contenido
- [Práctica Kotlin](practica-kotlin/)
- [Laboratorios](labs/)
- [Proyecto formativo](proyecto-formativo/)
- [Desafíos](desafios/)
- [Evaluaciones](evaluaciones/)
```

Los README que superen claramente el mínimo por **claridad, estructura, utilidad, uso correcto de Markdown y capacidad de explicar decisiones propias** podrán recibir una compensación o bonificación definida por el docente. No es automática.

## 10. Git

Al comenzar en cualquier computador:

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

## 11. Checklist

- [ ] Repo `DSY1105-009V-nombre-apellido`.
- [ ] Package raíz `cl.duoc.<usuario-sin-puntos>`.
- [ ] Práctica Kotlin organizada por bloques, no por semanas.
- [ ] Proyectos Android incluyen Gradle Wrapper y recursos necesarios.
- [ ] `local.properties`, builds, IDE y secretos no están versionados.
- [ ] README raíz y README de cada carpeta/entrega relevante.
- [ ] Proyecto compila/ejecuta.
- [ ] Commit y push realizados y verificados en GitHub.

> La organización docente y la estructura de entrega del estudiante son conceptos distintos.