Feature: Solicitud recogida
    Validación de campos en el formulario de solicitud de recogida


    Scenario: Validar campos obligatorios y tipo alfanumérico
    Given que el usuario accede al formulario de solicitud de recogida
    When el usuario no completa los campos obligatorios o ingresa datos inválidos
    Then se muestra un mensaje de error indicando que los campos son obligatorios y deben ser tipo alfanumérico


    Scenario: Validar formato y restricciones de fecha de recogida
    Given que el usuario accede al formulario de solicitud de recogida
    When el usuario ingresa una fecha de recogida fuera del formato yyyy-mm-dd
    Then se muestra un mensaje de error indicando que el formato de fecha es incorrecto


    Given que el usuario accede al formulario de solicitud de recogida
    When el usuario ingresa una fecha de recogida que es una fecha pasada
    Then se muestra un mensaje de error indicando que la fecha de recogida debe ser una fecha futura
    
    Given que el usuario accede al formulario de solicitud de recogida
    When el usuario ingresa una fecha de recogida que es más de 5 días hábiles en el futuro
    Then se muestra un mensaje de error indicando que la fecha de recogida no puede ser más de 5 días hábiles en el futuro


    Scenario: Validar duplicación de solicitud con la misma dirección y fecha
    Given que existe una solicitud de recogida previa con la misma dirección y fecha
    When el usuario intenta crear una nueva solicitud con la misma dirección y fecha
    Then se muestra un mensaje de error indicando que ya existe una solicitud de recogida para esa dirección y fecha