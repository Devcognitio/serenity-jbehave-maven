# serenity-jbehave-maven
Base para trabajo con Serenity, JBehave y Maven

Es una demostración simple de un proyecto con pruebas para la aplicación: http://todomvc.com/examples/angularjs/#/.

-------------
### Requisitos

El proyecto corre usando JDK 1.8 y Maven. 


Antes de ejecutar el proyecto se debe descargar el driver de tu elección.
Posteriormente modificar el archivo serenity.properties para que use el driver descargado y cambias la ruta donde instalaste el driver:

```
webdriver.driver = chrome
webdriver.chrome.driver = miRuta/chromedriver
```

Tambien puedes eliminar la ruta del driver del archivo y configurarla en el path de tu Sistema Operativo.
(Opción recomendada por la documentación de SerenityBDD)
-------------

### Ejecución
Para ejecutar el proyecto, lanzar en consola:

```
mvn clean verify
```

El reporte de Serenity es generado en el directorio `target/site/serenity`.
