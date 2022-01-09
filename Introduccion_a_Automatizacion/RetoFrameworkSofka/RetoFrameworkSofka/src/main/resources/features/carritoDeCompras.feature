# language: es
  @FeatureName:carritoDeCompras
  Característica: Carrito de compras
    Como cliente en línea
    necesito acceder al carrito de compras
    para poder almacenar los productos que deseo comprar.

  Antecedentes:
    Dado que el cliente ingresa a la página de inicio y se ha logueado de forma exitosa


  @ScenarioName:AgregarProductosAlCarrito
  Escenario: Agregar productos al carrito.
    Cuando el cliente elige productos que desea comprar y los agrega al carrito
    Entonces como resultado el cliente verá los productos almacenados en su carrito.

  @ScenarioName:VaciarElCarrito
  Escenario: Vaciar el carrito.
    Cuando el cliente agrega productos al carrito pero decide eliminarlos
    Entonces como resultado el usuario verá su carrito vacío.