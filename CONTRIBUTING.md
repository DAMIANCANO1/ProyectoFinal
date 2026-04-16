# Contribuir a ProyectoFinal

¡Gracias por tu interés en contribuir!

## Flujo recomendado
1. Haz un fork del repositorio.
2. Crea una rama para tu cambio:
   - `feature/nombre-corto` para nuevas funcionalidades.
   - `fix/nombre-corto` para correcciones.
3. Realiza cambios pequeños y claros.
4. Verifica compilación local antes de enviar tu PR.
5. Envía un Pull Request con una descripción clara.

## Requisitos para contribuciones
- Mantener el estilo del código existente (Java/Swing).
- No eliminar recursos (imágenes/sonidos/fuentes) utilizados por la UI.
- Si cambias comportamiento, documenta el cambio en el PR.

## Cómo probar cambios
Desde la raíz del proyecto:

```bash
ant clean jar
```

Si compila correctamente, ejecuta en NetBeans o por terminal:

```bash
java -cp "build/classes" prueba_hackerman.newpackage.Menu
```

## Qué incluir en el Pull Request
- Objetivo del cambio.
- Archivos modificados.
- Pasos para probar.
- (Opcional) Capturas de pantalla si hubo cambios visuales.

## Código de conducta
- Mantén una comunicación respetuosa.
- Aporta sugerencias constructivas y específicas.
