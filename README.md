# Prueba_HackerMan / Juego de Adivinar Números

Juego de escritorio en **Java + Swing** con temática de ciberseguridad, donde puedes jugar en modo *Jugador Adivina* o en modo *PC Encuentra*.

## Características principales
- Interfaz gráfica con menú principal.
- 2 modos de juego:
  - **Jugador Adivina** (la PC genera el número secreto).
  - **PC Encuentra** (la PC intenta descubrir tu número).
- 3 dificultades para *Jugador Adivina*:
  - **Fácil**: número de 1 a 100.
  - **Medio**: número de 3 dígitos (100-999).
  - **Difícil**: número de 4 dígitos (1000-9999).
- Sistema de pistas e intentos.
- Música de fondo y efectos de sonido.

## Requisitos de sistema
- Sistema operativo: Windows, Linux o macOS.
- **JDK 25** (según la configuración actual del proyecto).
- **Apache Ant** (para compilar desde terminal).
- Recomendado: **NetBeans** (incluye soporte para formularios Swing y AbsoluteLayout).

## Requisitos técnicos
- Lenguaje: **Java 100%**.
- UI: **Swing (javax.swing)**.
- Organización del proyecto: formato de proyecto Java SE de NetBeans.
- Recursos embebidos en `src/`:
  - imágenes (`src/Imagenn`)
  - sonidos (`src/Sonidos`)
  - fuente (`src/Fonts`)

## Instrucciones de descarga
1. Abrir una terminal.
2. Clonar el repositorio:

```bash
git clone https://github.com/DAMIANCANO1/ProyectoFinal.git
cd ProyectoFinal
```

## Guía de instalación (paso a paso)

### Opción A (recomendada): NetBeans
1. Instala JDK 25.
2. Instala Apache NetBeans.
3. Abre NetBeans y selecciona **File > Open Project**.
4. Elige la carpeta `ProyectoFinal`.
5. Si NetBeans solicita la clase principal, selecciona:
   - `prueba_hackerman.newpackage.Menu`

### Opción B: Terminal (Ant)
1. Verifica Java y Ant:

```bash
java -version
ant -version
```

2. Compila el proyecto:

```bash
ant clean jar
```

## Cómo ejecutar el juego

### Desde NetBeans
- Ejecuta el proyecto con **Run Project**.

### Desde terminal
Después de compilar, ejecuta la clase principal:

```bash
java -cp "build/classes" prueba_hackerman.newpackage.Menu
```

> Nota: si tu entorno requiere librería de `AbsoluteLayout`, ejecútalo desde NetBeans para evitar problemas de classpath.

## Modos de juego disponibles

### 1) Jugador Adivina
- Tú intentas adivinar el número secreto.
- Seleccionas dificultad: Fácil, Medio o Difícil.
- El juego muestra pistas según coincidencias y controla intentos/tiempo.

### 2) PC Encuentra
- Tú piensas un número de 4 dígitos.
- La PC propone intentos y tú respondes según los aciertos.
- El sistema va filtrando posibilidades hasta encontrar el número.

## Estructura del proyecto

```text
ProyectoFinal/
├── src/
│   ├── prueba_hackerman/newpackage/   # Clases Java (UI, lógica y audio)
│   ├── Imagenn/                        # Recursos gráficos
│   ├── Sonidos/                        # Efectos y música
│   └── Fonts/                          # Tipografías
├── nbproject/                          # Configuración de NetBeans
├── build.xml                           # Build script Ant
└── manifest.mf                         # Manifest JAR
```

## Créditos
- Autor(es): **DAMIANCANO1 / Damian Cano**
- Proyecto académico: **Prueba_HackerMan**

## Licencia
Este proyecto se distribuye bajo la licencia **MIT**. Consulta el archivo [LICENSE](LICENSE).
