import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {

    static void main() {

        Scanner sc = new Scanner(System.in);

        Empresa empresa = new Empresa("ModaStyle", "0000005678", "Avenida las Américas #27-85");

        Sucursal sucursal1 = new Sucursal(123, "ModaStyle - Armenia (Norte)", "Centro Comercial Unicentro Local 12-21", "Armenia, Quindío");

        Sucursal sucursal2 = new Sucursal(456,"ModaStyle - Pereira (Sur)", "Centro Comercial Arboleda Local 03-04", "Pereira, Risaralda" );

        Sucursal sucursal3 = new Sucursal(789, "ModaStyle - Manizales (Centro)", "Carrera 27, Calle 18 #40-22", "Manizales, Caldas");

        empresa.registrarSucursal(sucursal1);
        empresa.registrarSucursal(sucursal2);
        empresa.registrarSucursal(sucursal3);

        int opcion = 0;
        do {
            System.out.println("========== ModaStyle - Shop ===========");
            System.out.println("1. Registrar prendas de vestir en el catálogo de la empresa");
            System.out.println("2. Registrar clientes o vendedores");
            System.out.println("3. Registrar existencias de prendas en en una sucursal");
            System.out.println("4. Consultar las prendas disponibles en una sucursal determinada");
            System.out.println("5. Registrar venta");
            System.out.println("6. Calcular el precio unitario final de cada prenda");
            System.out.println("7. Calcular el valor total de una venta");
            System.out.println("8. Consultar las prendas agotadas");
            System.out.println("9. Consultar las ventas realizadas por un vendedor");
            System.out.println("10. Consultar las compras realizadas por un cliente");
            System.out.println("11. Calcular los ingresos totales generados por una sucursal");
            System.out.println("12. Identificar la referencia de prenda con mayor cantidad de unidades vendidas en toda la empresa");
            System.out.println("0. Salir");

            System.out.print("Seleccione la opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("----Registrar prendas en el catálogo----");

                    System.out.println("Ingrese el código de la prenda que desee registrar");
                    String codigoPrenda = sc.nextLine();

                    System.out.println("Ingrese el nombre de la prenda");
                    String nombrePrenda = sc.nextLine();

                    System.out.println("Ingrese la marca de la prenda");
                    String marcaPrenda = sc.nextLine();

                    System.out.println("Ingrese el precio base de la prenda");
                    double precioBasePrenda = sc.nextDouble();

                    System.out.println("Seleccione la categoría de la prenda: (1. Camiseta, 2. Pantalón, 3. Vestido, 4. Chaqueta, 5. Calzado)");
                    int opcionCategoriaPrenda = sc.nextInt();
                    CategoriaPrenda categoriaPrenda = CategoriaPrenda.CAMISETA;
                    if (opcionCategoriaPrenda == 2) categoriaPrenda = CategoriaPrenda.PANTALON;
                    else if (opcionCategoriaPrenda == 3) categoriaPrenda = CategoriaPrenda.VESTIDO;
                    else if (opcionCategoriaPrenda == 4) categoriaPrenda = CategoriaPrenda.CHAQUETA;
                    else if (opcionCategoriaPrenda == 5) categoriaPrenda = CategoriaPrenda.CALZADO;



                    Prenda prenda = new Prenda(codigoPrenda, nombrePrenda, marcaPrenda, precioBasePrenda, categoriaPrenda);
                    if (empresa.registrarPrenda(prenda)){
                        System.out.println("La prenda ha sido registrada con éxito.");
                    } else {
                        System.out.println("Error (La prenda ya está registrada).");
                    }
                    break;
                case 2:
                    System.out.println("----Registrar vendedor o cliente----");
                    System.out.println("Ingrese el documento de identidad ");
                    String documentoIdentidadPersona = sc.nextLine();


                    if (empresa.verificarDocumento(documentoIdentidadPersona)){
                        System.out.println("Error (ya existe una persona con ese documento).");
                        break;
                    }

                    System.out.println("Ingrese el nombre completo de la persona");
                    String nombrePersona = sc.nextLine();

                    System.out.println("Ingrese el correo electrónico");
                    String correoElectronicoPersona = sc.nextLine();

                    System.out.println("Ingrese el teléfono");
                    String telefonoPersona = sc.nextLine();

                    System.out.println("Seleccione el rol de la persona a registrar: (1. Vendedor, 2. Cliente)");
                    int opcionRol = sc.nextInt();
                    sc.nextLine();

                    if (opcionRol == 1){
                        System.out.println("---Registro de vendedor: ");
                        System.out.println("Ingrese el código de la sucursal");
                        int codigoSucursal = sc.nextInt();
                        sc.nextLine();
                        Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);

                        if (sucursal == null) {
                            System.out.println("Error (la sucursal no existe).");
                            break;
                        }

                        System.out.println("Ingrese el código del empleado");
                        String codigoVendedor = sc.nextLine();

                        System.out.println("Ingrese la fecha de contratación");
                        System.out.println("Año (####): ");
                        int anioContrato = sc.nextInt();

                        System.out.println("Mes 1-12 (##)");
                        int mesContrato = sc.nextInt();

                        System.out.println("Día 1-31 (##)");
                        int diaContrato = sc.nextInt();

                        LocalDate fechaContratacionVendedor = LocalDate.of(anioContrato, mesContrato, diaContrato);

                        System.out.println("Ingrese el salario básico");
                        double salarioBasicoVendedor = sc.nextDouble();

                        Vendedor vendedor = new Vendedor(documentoIdentidadPersona, nombrePersona, correoElectronicoPersona, telefonoPersona, codigoVendedor, fechaContratacionVendedor, salarioBasicoVendedor, sucursal);

                        if (sucursal.registrarVendedor(vendedor)) {
                            System.out.println("El vendedor ha sido registrado con éxito.");
                        } else {
                            System.out.println("Error (no se pudo registrar el vendedor).");
                        }


                    } else if (opcionRol == 2){
                        System.out.println("---Registro de cliente");
                        System.out.println("Ingresa el codigo de afiliación");
                        String codigoAfiliacionCliente = sc.nextLine();

                        System.out.println("Seleccione la categoría del cliente (1. Bronce, 2. Plata, 3. Oro)");
                        int opcionCategoriaCliente = sc.nextInt();
                        sc.nextLine();

                        CategoriaCliente categoriaCliente = CategoriaCliente.BRONCE;
                        if (opcionCategoriaCliente == 2) categoriaCliente = CategoriaCliente.PLATA;
                        else if (opcionCategoriaCliente == 3) categoriaCliente = CategoriaCliente.ORO;

                        Cliente cliente = new Cliente (documentoIdentidadPersona, nombrePersona, correoElectronicoPersona, telefonoPersona, codigoAfiliacionCliente, categoriaCliente);

                        if (empresa.registrarCliente(cliente)){
                            System.out.println("El cliente ha sido registrado");
                        } else {
                            System.out.println("Error (no se pudo registrar el cliente).");
                        }

                    } else {
                        System.out.println("Debe seleccionar una opción válida");
                    }
                    break;
                case 3: {
                    System.out.println("----Registrar existencias en una sucursal----");

                    System.out.println("Ingrese el código de la sucursal");
                    int codigoSucursal = sc.nextInt();
                    sc.nextLine();

                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Error (la sucursal no existe).");
                        break;
                    }

                    System.out.println("Ingrese el código de la prenda");
                    String codigoPrenda3 = sc.nextLine();
                    Prenda prenda2 = empresa.buscarPrenda(codigoPrenda3);
                    if (prenda2 == null) {
                        System.out.println("Error (la prenda no está en el catálogo).");
                        break;
                    }

                    Talla talla = null;

                    if (prenda2.getCategoriaPrenda() == CategoriaPrenda.CALZADO) {
                        System.out.println("Ingrese la talla (35 a 44):");
                        int numeroTalla = sc.nextInt();
                        sc.nextLine();

                        if (numeroTalla == 35) talla = Talla.T35;
                        else if (numeroTalla == 36) talla = Talla.T36;
                        else if (numeroTalla == 37) talla = Talla.T37;
                        else if (numeroTalla == 38) talla = Talla.T38;
                        else if (numeroTalla == 39) talla = Talla.T39;
                        else if (numeroTalla == 40) talla = Talla.T40;
                        else if (numeroTalla == 41) talla = Talla.T41;
                        else if (numeroTalla == 42) talla = Talla.T42;
                        else if (numeroTalla == 43) talla = Talla.T43;
                        else if (numeroTalla == 44) talla = Talla.T44;
                    } else {
                        System.out.println("Seleccione la talla: (1. [XS], 2. [S], 3. [M], 4. [L], 5. [XL])");
                        int opcionTalla = sc.nextInt();
                        sc.nextLine();

                        if (opcionTalla == 1) talla = Talla.XS;
                        else if (opcionTalla == 2) talla = Talla.S;
                        else if (opcionTalla == 3) talla = Talla.M;
                        else if (opcionTalla == 4) talla = Talla.L;
                        else if (opcionTalla == 5) talla = Talla.XL;
                    }

                    if (talla == null) {
                        System.out.println("Error (la talla no es válida).");
                        break;
                    }

                    System.out.println("Ingrese el color");
                    String color = sc.nextLine();

                    System.out.println("Ingrese la cantidad");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    if (cantidad <= 0) {
                        System.out.println("Error (la cantidad debe ser mayor a 0).");
                        break;
                    }

                    if (sucursal.registrarExistencias(prenda2, talla, color, cantidad)) {
                        System.out.println("Las existencias han sido registradas con éxito.");
                    } else {
                        System.out.println("Error (ya existe esa combinación de prenda, talla y color en la sucursal).");
                    }
                    break;
                }
                case 4:
                    System.out.println("-----Consultar prendas disponibles en una sucursal");
                    System.out.println("Ingrese el código de la sucursal");
                    int codigoSucursal = sc.nextInt();
                    sc.nextLine();

                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Error (la sucursal no existe).");
                        break;
                    }

                    List <RegistroInventario> disponible = sucursal.consultarDisponibles();
                    if (disponible.isEmpty()){
                        System.out.println("Esta prenda no está disponible en la sucursal ingresada");
                    } else {
                        System.out.println("Prendas disponibles en la sucursal "+sucursal.getNombre());

                        for (RegistroInventario registroInventario : disponible){
                            System.out.println("- "+registroInventario.getPrenda().getCodigo() +
                                    " | Talla: "+registroInventario.getTalla() +
                                    " | Color: "+registroInventario.getColor() +
                                    " | Cantidad: "+registroInventario.getCantidad());
                        }
                    }
                    break;
                case 5:
                    System.out.println("----Registrar una venta----");
                    System.out.println("Ingrese el código de la sucursal");
                    int codigoSucursal2 = sc.nextInt();
                    sc.nextLine();

                    Sucursal sucursal4 = empresa.buscarSucursal(codigoSucursal2);
                    if (sucursal4 == null) {
                        System.out.println("Error (la sucursal no existe).");
                        break;
                    }

                    System.out.println("Ingrese el código del empleado que realizó la venta");
                    String codigoEmpleado = sc.nextLine();

                    Vendedor vendedor = sucursal4.buscarVendedor(codigoEmpleado);
                    if (vendedor == null){
                        System.out.println("Error (el vendedor no existe).");
                        break;
                    }

                    System.out.println("Ingrese el código del cliente que realizó la compra");
                    String codigoAfiliacionCliente = sc.nextLine();

                    Cliente cliente = empresa.buscarCliente(codigoAfiliacionCliente);
                    if (cliente == null){
                        System.out.println("Error (el cliente no existe).");
                    }

                    System.out.println("Ingrese un código único para la venta: ");
                    int codigoVenta = sc.nextInt();
                    sc.nextLine();

                    Venta venta = sucursal4.buscarVenta(codigoVenta);
                    if (venta != null){
                        System.out.println("Error (ya hay una venta registrada con ese código).");
                        break;
                    }

                    System.out.println("Ingrese la fecha de la venta:");
                    System.out.println("Año (####): ");
                    int anioVenta = sc.nextInt();
                    System.out.println("Mes 1-12 (##): ");
                    int mesVenta = sc.nextInt();
                    System.out.println("Día 1-31 (##): ");
                    int diaVenta = sc.nextInt();
                    sc.nextLine();

                    LocalDate fechaVenta = LocalDate.of(anioVenta, mesVenta, diaVenta);

                    Venta venta1 = new Venta(codigoVenta, fechaVenta, sucursal4, vendedor, cliente);

                    boolean agregarMas = true;
                    boolean ventaExitosa = true;

                    // Ciclo para agregar múltiples productos a la venta
                    while (agregarMas) {
                        System.out.println("--- Agregar producto a la venta ---");
                        System.out.println("Ingrese el código de la prenda:");
                        String codigoPrendaVenta = sc.nextLine();
                        Prenda prendaVenta = empresa.buscarPrenda(codigoPrendaVenta);

                        if (prendaVenta == null) {
                            System.out.println("Error (la prenda no existe en el catálogo).");
                            ventaExitosa = false;
                            break;
                        }

                        // Solicitar talla de la misma manera que en el case 3
                        Talla tallaVenta = null;
                        if (prendaVenta.getCategoriaPrenda() == CategoriaPrenda.CALZADO) {
                            System.out.println("Ingrese la talla (35 a 44):");
                            int numeroTalla = sc.nextInt();
                            sc.nextLine();

                            if (numeroTalla == 35) tallaVenta = Talla.T35;
                            else if (numeroTalla == 36) tallaVenta = Talla.T36;
                            else if (numeroTalla == 37) tallaVenta = Talla.T37;
                            else if (numeroTalla == 38) tallaVenta = Talla.T38;
                            else if (numeroTalla == 39) tallaVenta = Talla.T39;
                            else if (numeroTalla == 40) tallaVenta = Talla.T40;
                            else if (numeroTalla == 41) tallaVenta = Talla.T41;
                            else if (numeroTalla == 42) tallaVenta = Talla.T42;
                            else if (numeroTalla == 43) tallaVenta = Talla.T43;
                            else if (numeroTalla == 44) tallaVenta = Talla.T44;
                        } else {
                            System.out.println("Seleccione la talla: (1. [XS], 2. [S], 3. [M], 4. [L], 5. [XL])");
                            int opcionTalla = sc.nextInt();
                            sc.nextLine();

                            if (opcionTalla == 1) tallaVenta = Talla.XS;
                            else if (opcionTalla == 2) tallaVenta = Talla.S;
                            else if (opcionTalla == 3) tallaVenta = Talla.M;
                            else if (opcionTalla == 4) tallaVenta = Talla.L;
                            else if (opcionTalla == 5) tallaVenta = Talla.XL;
                        }

                        if (tallaVenta == null) {
                            System.out.println("Error (la talla no es válida).");
                            break;
                        }

                        System.out.println("Ingrese el color:");
                        String colorVenta = sc.nextLine();

                        // Buscar el registro en el inventario de la sucursal
                        RegistroInventario registroInventario = sucursal4.buscarRegistro(prendaVenta, tallaVenta, colorVenta);
                        if (registroInventario == null) {
                            System.out.println("Error (no hay registro de inventario con esa combinación en la sucursal).");
                            ventaExitosa = false;
                            break;
                        }

                        System.out.println("Ingrese la cantidad a comprar (Disponibles: " + registroInventario.getCantidad() + "):");
                        int cantidadComprada = sc.nextInt();
                        sc.nextLine();

                        if (cantidadComprada <= 0 || cantidadComprada > registroInventario.getCantidad()) {
                            System.out.println("Error (cantidad no válida o excede el stock disponible).");
                            ventaExitosa = false;
                            break;
                        }


                        DetalleVenta detalle = new DetalleVenta(cantidadComprada, 0.0, 0.0, registroInventario, venta1);

                        venta1.getListaVentaDetalles().add(detalle);
                        registroInventario.getListaRegistroDetalles().add(detalle);

                        registroInventario.setCantidad(registroInventario.getCantidad() - cantidadComprada);

                        System.out.println("¿Desea agregar otro producto a esta venta? (1. Sí, 2. No)");
                        int continuar = sc.nextInt();
                        sc.nextLine();
                        if (continuar != 1) {
                            agregarMas = false;
                        }
                    }

                    if (ventaExitosa && !venta1.getListaVentaDetalles().isEmpty()) {

                        sucursal4.getListaSucursalVentas().add(venta1);
                        vendedor.getListaVendedorVentas().add(venta1);

                        System.out.println("¡La venta ha sido registrada con éxito!");
                    } else {
                        System.out.println("La venta fue cancelada debido a un error en los datos ingresados.");
                    }
                    break;
                case 6:
                    System.out.println("----Calcular el precio unitario final de una prenda----");

                    System.out.println("Ingrese el código de la prenda:");
                    String codigoPrenda2 = sc.nextLine();
                    Prenda prenda2 = empresa.buscarPrenda(codigoPrenda2);

                    if (prenda2 == null) {
                        System.out.println("Error (la prenda no existe en el catálogo).");
                        break;
                    }

                    System.out.println("Ingrese el código de afiliación del cliente:");
                    String codigoAfiliacion = sc.nextLine();
                    Cliente cliente2 = empresa.buscarCliente(codigoAfiliacion);

                    if (cliente2 == null) {
                        System.out.println("Error (el cliente no existe).");
                        break;
                    }

                    // Calcular el precio unitario final usando el método de la clase Prenda
                    double precioFinal = prenda2.calcularPrecioUnitarioFinal(cliente2);

                    System.out.println("----------------------------------------");
                    System.out.println("Prenda: " + prenda2.getNombre() + " (Marca: " + prenda2.getMarca() + ")");
                    System.out.println("Precio base: $" + prenda2.getPrecioBase());
                    System.out.println("Categoría de prenda (" + prenda2.getCategoriaPrenda() + ") con recargo.");
                    System.out.println("Cliente categoría: " + cliente2.getCategoriaCliente());
                    System.out.println("El **Precio Unitario Final** es: $" + precioFinal);
                    System.out.println("----------------------------------------");
                    break;
                case 7:
                    System.out.println("----Calcular el valor total de una compra----");
                    System.out.println("Ingrese el código de la sucursal");
                    int codigoSucursal3 = sc.nextInt();
                    sc.nextLine();

                    Sucursal sucursal5 = empresa.buscarSucursal(codigoSucursal3);
                    if (sucursal5 == null) {
                        System.out.println("Error (la sucursal no existe).");
                        break;
                    }
                    System.out.println("Ingrese el código de la venta");
                    int codigoVenta2 = sc.nextInt();
                    sc.nextLine();

                    Venta ventaEncontrada = null;
                    for (Venta venta2: sucursal5.getListaSucursalVentas()){
                        if (venta2.getCodigo() == codigoVenta2) {
                            ventaEncontrada = venta2;
                            break;
                        }
                    }

                    double valorTotal = ventaEncontrada.calcularValorTotal();

                    System.out.println("----------------------------------------");
                    System.out.println("Venta N°: " + ventaEncontrada.getCodigo());
                    System.out.println("Sucursal: " + ventaEncontrada.getSucursal());
                    System.out.println("Cliente: " + ventaEncontrada.getCliente());
                    System.out.println("Vendedor: "+ ventaEncontrada.getVendedor());


                    System.out.println("El valor total de la venta es: $" + valorTotal);

                    break;
                case 8:
                    System.out.println("----Consultar las prendas agotadas----");

                    boolean hayAgotadas = false;
                    for (Sucursal sucursalAgotadas : empresa.getListaEmpresaSucursales()) {
                        for (RegistroInventario registroAgotado : sucursalAgotadas.getListaSucursalRegistros()) {
                            if (registroAgotado.getCantidad() == 0) {
                                hayAgotadas = true;
                                System.out.println("- " + registroAgotado.getPrenda().getCodigo() +
                                        " | " + registroAgotado.getPrenda().getNombre() +
                                        " | Talla: " + registroAgotado.getTalla() +
                                        " | Color: " + registroAgotado.getColor() +
                                        " | Sucursal: " + sucursalAgotadas.getNombre());
                            }
                        }
                    }
                    if (!hayAgotadas) {
                        System.out.println("No hay prendas agotadas.");
                    }
                    break;
                case 9:
                    System.out.println("----Consultar las ventas realizadas por un vendedor----");
                    System.out.println("Ingrese el código de la sucursal");
                    int codigoSucursalVendedor = sc.nextInt();
                    sc.nextLine();

                    Sucursal sucursalVendedor = empresa.buscarSucursal(codigoSucursalVendedor);
                    if (sucursalVendedor == null) {
                        System.out.println("Error (la sucursal no existe).");
                        break;
                    }

                    System.out.println("Ingrese el código del empleado");
                    String codigoEmpleadoConsulta = sc.nextLine();

                    Vendedor vendedorConsulta = sucursalVendedor.buscarVendedor(codigoEmpleadoConsulta);
                    if (vendedorConsulta == null) {
                        System.out.println("Error (el vendedor no existe).");
                        break;
                    }

                    if (vendedorConsulta.getListaVendedorVentas().isEmpty()) {
                        System.out.println("El vendedor no tiene ventas registradas.");
                    } else {
                        System.out.println("Ventas realizadas por " + vendedorConsulta.getNombreCompleto() + ":");
                        for (Venta ventaVendedor : vendedorConsulta.getListaVendedorVentas()) {
                            System.out.println("- Venta N° " + ventaVendedor.getCodigo() +
                                    " | Fecha: " + ventaVendedor.getFecha() +
                                    " | Cliente: " + ventaVendedor.getCliente().getNombreCompleto() +
                                    " | Total: $" + ventaVendedor.calcularValorTotal());
                        }
                    }
                    break;
                case 10:
                    System.out.println("----Consultar las compras realizadas por un cliente----");
                    System.out.println("Ingrese el código de afiliación del cliente");
                    String codigoAfiliacionConsulta = sc.nextLine();

                    Cliente clienteConsulta = empresa.buscarCliente(codigoAfiliacionConsulta);
                    if (clienteConsulta == null) {
                        System.out.println("Error (el cliente no existe).");
                        break;
                    }

                    // Las compras del cliente se buscan en las ventas de todas las sucursales
                    boolean hayCompras = false;
                    System.out.println("Compras realizadas por " + clienteConsulta.getNombreCompleto() + ":");
                    for (Sucursal sucursalCompras : empresa.getListaEmpresaSucursales()) {
                        for (Venta ventaCliente : sucursalCompras.getListaSucursalVentas()) {
                            if (ventaCliente.getCliente() == clienteConsulta) {
                                hayCompras = true;
                                System.out.println("- Venta N° " + ventaCliente.getCodigo() +
                                        " | Fecha: " + ventaCliente.getFecha() +
                                        " | Sucursal: " + sucursalCompras.getNombre() +
                                        " | Total: $" + ventaCliente.calcularValorTotal());
                            }
                        }
                    }
                    if (!hayCompras) {
                        System.out.println("El cliente no tiene compras registradas.");
                    }
                    break;
                case 11:
                    System.out.println("----Calcular los ingresos totales de una sucursal----");
                    System.out.println("Ingrese el código de la sucursal");
                    int codigoSucursalIngresos = sc.nextInt();
                    sc.nextLine();

                    Sucursal sucursalIngresos = empresa.buscarSucursal(codigoSucursalIngresos);
                    if (sucursalIngresos == null) {
                        System.out.println("Error (la sucursal no existe).");
                        break;
                    }

                    double ingresosTotales = 0;
                    for (Venta ventaIngreso : sucursalIngresos.getListaSucursalVentas()) {
                        ingresosTotales += ventaIngreso.calcularValorTotal();
                    }

                    System.out.println("Sucursal: " + sucursalIngresos.getNombre());
                    System.out.println("Ventas realizadas: " + sucursalIngresos.getListaSucursalVentas().size());
                    System.out.println("Ingresos totales: $" + ingresosTotales);
                    break;
                case 12:
                    System.out.println("----Referencia de prenda con mayor cantidad de unidades vendidas----");

                    Prenda prendaMasVendida = null;
                    int maxUnidades = 0;

                    for (Prenda prendaRevisada : empresa.getListaEmpresaPrendas()) {
                        int unidadesVendidas = 0;
                        for (RegistroInventario registroPrenda : prendaRevisada.getListaPrendaRegistros()) {
                            for (DetalleVenta detallePrenda : registroPrenda.getListaRegistroDetalles()) {
                                unidadesVendidas += detallePrenda.getCantidadComprada();
                            }
                        }
                        if (unidadesVendidas > maxUnidades) {
                            maxUnidades = unidadesVendidas;
                            prendaMasVendida = prendaRevisada;
                        }
                    }

                    if (prendaMasVendida == null) {
                        System.out.println("Aún no se han registrado ventas.");
                    } else {
                        System.out.println("Referencia: " + prendaMasVendida.getCodigo() +
                                " | Nombre: " + prendaMasVendida.getNombre() +
                                " | Marca: " + prendaMasVendida.getMarca());
                        System.out.println("Unidades vendidas: " + maxUnidades);
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }

        } while (opcion != 0);
        sc.close();
    }
}
