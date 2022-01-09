# language: es
@FeatureName:contactanos
Característica: Sección Contactanos
  Como cliente en línea
  necesito hacer uso de la sección contactanos
  para poder comunicarme con el equipo de la tienda.

  Antecedentes:
    Dado que el cliente se encuentra en la página de inicio


  @ScenarioName:EnviarMensajesAServicioAlCliente
  Escenario: Enviar mensajes a servicio al cliente
    Cuando el cliente se ha dirige a la sección contactanos y envía un mensaje al equipo de soporte
    Entonces como resultado el cliente verá un mensaje de éxito.

  @ScenarioName:EnviarMensajesAlWebmaster
  Escenario: Enviar mensajes al webmaster.
    Cuando el cliente se ha dirige a la sección contactanos y envía un mensaje al Webmaster
    Entonces como resultado el usuario verá un mensaje exitoso.