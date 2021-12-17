Feature: leasing habitacional
  as
    cliente del banco
  i want to
    adquirir un leasing habitacional
  so that
    puedo comprar un apartamento

  Scenario: Adquirir un leasing habitacional
    Given el cliente desea comprar un apartamento
    And no cuentra con el dinero suficiente para comprarlo
    When el cliente solicita un prestamo al banco
    But no quiere un credito hipotecario
    Then el cliente puede optar por un leasing habitacional

  Scenario: Solicitud del leasing habitacional
    Given el cliente desea adquirir un apartamento de 300.000.000 de pesos
    And el banco financia el 80% del valor de apartamento
    When el cliente solicita el prestamo
    Then el banco le presta al cliente 240.000.000 de pesos

  Scenario: Calculo de las cuotas mensuales
    Given el cliente adquiere el leasing a 20 años
    And los intereses mensuales son del 0.68%
    When se realiza el cálculo de las cuotas mensuales
    And se incluye el pago de seguros incluido en el leasing
    Then el cliente debe pagar 2.114.164 pesos mensual

  Scenario: Solicitud del extracto mensual
    Given el cliente requiere saber el valor de la deuda
    When el cliente solicita su extracto
    Then el banco se lo envía al correo electrónico registrado

  Scenario: Definición de la fecha de pago mensual
    Given el banco tiene fecha de corte para los leasing el día 17 de cada mes
    When se emite la facturación al cliente
    Then la fecha de pago se estipula para los primeros 4 días del siguiente mes

  Scenario: Generacion del código para realizar abonos a capital
    Given el cliente requiere realizar abonos a capital independientes
    When el cliente tiene dinero extra
    And desea abonarlo al valor del leasing
    Then el banco genera un codigo para la realizacion del abono

  Scenario: Optar a la opción de compra del apartamento
    Given el cliente ha terminado de pagar sus cuotas
    And las cuotas equivalen al 80% del valor del apartamento
    When el cliente desea optar por la compra del apartamento
    Then el cliente puede realizar el pago del 20% restante del valor del apartamento