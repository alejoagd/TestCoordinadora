# Proyecto de Automatización con Playwright, Cucumber y Java

Este repositorio contiene un proyecto de automatización de pruebas utilizando Playwright, Cucumber y Java.

## Descripción

El proyecto tiene como objetivo automatizar pruebas de un servicio API utilizando Playwright , Cucumber para escribir los escenarios de pruebas en lenguaje Gherkin, y Java para implementar los pasos de prueba.

## Estructura del Proyecto

- **src/test/java**: Contiene el código fuente de las pruebas escritas en Java.
- **src/test/resources**: Contiene los archivos de características de Cucumber escritos en lenguaje Gherkin.
- **target**: Directorio de salida donde se generan los informes de ejecución de Cucumber.

## Configuración del Entorno

Para ejecutar las pruebas en este proyecto, se requiere tener instalado:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)
- [Un navegador web compatible](https://playwright.dev/java/docs/intro#browsers)

## Ejecución de Pruebas

1. Clona este repositorio:

   ```bash
   git clone https://github.com/alejoagd/TestCoordinadora.git

2.Despues de tener instalado lo necesario para el entorno puedes abrir el proyecto en Visual Studio Code 
3.Puedes ejecutar los escenarios de prueba desde la clase TestRunner.java ubicado en la siguiente ruta \src\test\java\runner .
4.Podras visualizar los resultados en la terminal o en el debug console , donde ademas te compartirá el link generado por cucumber para visualizar los reportes de las pruebas realizadas.
