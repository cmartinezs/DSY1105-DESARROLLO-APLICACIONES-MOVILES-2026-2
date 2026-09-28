# Miniapps nativas · Línea de laboratorios DSY1105

## Propósito

Esta familia prepara el trabajo con capacidades reales del dispositivo mediante miniapps independientes.

Cada miniapp evoluciona en dos etapas:

```text
maqueta funcional
→ misma aplicación
→ capacidad nativa real
```

La maqueta de Semana 7 implementa navegación, estados, jerarquía visual e interacción completa usando una fuente simulada. Cuando el contenido curricular habilite la API real, no se crea otra app: se reemplaza la fuente simulada por una implementación Android.

## Miniapps

- [GeoTrack · GPS](./gps/maqueta/)
- [PhotoProof · Cámara](./camara/maqueta/)
- [QRAction · Lector QR](./qr/maqueta/)
- [ShakeLab · Acelerómetro](./acelerometro/maqueta/)
- [OrientApp · Orientación / giroscopio](./orientacion/maqueta/)

## Contrato común

Todas deben incluir:

- pantalla de introducción;
- pantalla de interacción principal;
- estados visibles;
- resultado o feedback;
- navegación real;
- al menos un caso normal y un caso límite;
- una fuente simulada claramente separada de la UI;
- explicación de qué cambiará cuando llegue hardware real.

## Regla

No se trata de llamar una API. La capacidad debe producir comportamiento de producto.

```text
fuente simulada
→ evento/dato
→ estado
→ UI

más adelante

hardware Android
→ evento/dato
→ estado
→ UI
```

## Integración futura

Después de trabajar las capacidades aisladas se construirá una aplicación integradora. Esa app combinará varias capacidades sólo cuando exista una necesidad funcional que lo justifique.
