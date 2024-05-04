@Solicitud
Feature: Solicitud recogida
    Validación de campos en el formulario de solicitud de recogida

    Background: Ingreso de datos en formulario
    Given que el usuario accede al formulario de solicitud de recogida

    @Validacion
    Scenario: Validar formato de fecha de recogida
    When el usuario ingresa una fecha de recogida fuera del formato yyyy-mm-dd
    Then se muestra un mensaje de error indicando que el formato de fecha es incorrecto
    
    @Fecha
    Scenario: Validar restricciones de fecha de recogida
    When el usuario ingresa una fecha de recogida que es una fecha pasada
    Then se muestra un mensaje de error indicando que la fecha de recogida debe ser una fecha pasado los 5 dias habiles siguientes
    
    @duplicidad
    Scenario: Validar duplicación de solicitud con la misma dirección y fecha
    When el usuario intenta crear una nueva solicitud con la misma dirección y fecha ya creadas
    Then se muestra un mensaje de error indicando que ya existe una solicitud de recogida para esa dirección y fecha