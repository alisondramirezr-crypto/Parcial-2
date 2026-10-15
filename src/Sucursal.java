import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    private int codigo;
    private String nombre;
    private String direccion;
    private String ciudad;

    private List<Vendedor> listaSucursalVendedores;
    private List <RegistroInventario> listaSucursalRegistros;
    private List <Venta> listaSucursalVentas;

    public Sucursal(int codigo, String nombre, String direccion, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;

        this.listaSucursalVendedores = new ArrayList<>();
        this.listaSucursalRegistros = new ArrayList<>();
        this.listaSucursalVentas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Vendedor> getListaSucursalVendedores() {
        return listaSucursalVendedores;
    }

    public void setListaSucursalVendedores(List<Vendedor> listaSucursalVendedores) {
        this.listaSucursalVendedores = listaSucursalVendedores;
    }

    public List<RegistroInventario> getListaSucursalRegistros() {
        return listaSucursalRegistros;
    }

    public void setListaSucursalRegistros(List<RegistroInventario> listaSucursalRegistros) {
        this.listaSucursalRegistros = listaSucursalRegistros;
    }

    public List<Venta> getListaSucursalVentas() {
        return listaSucursalVentas;
    }

    public void setListaSucursalVentas(List<Venta> listaSucursalVentas) {
        this.listaSucursalVentas = listaSucursalVentas;
    }

    @Override
    public String toString() {
        return "Sucursal: " +
                "Codigo: " + codigo + " | "+
                "Nombre: " + nombre + " | "+
                "Direccion: '" + direccion + " | "+
                "Ciudad: " + ciudad;
    }

    public boolean verificarVendedor (String documentoIdentidad){
        boolean existe = false;
        for (Vendedor vendedor: listaSucursalVendedores){
            if (documentoIdentidad.equalsIgnoreCase(vendedor.getDocumentoIdentidad())){
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarVendedor (Vendedor vendedor){
        boolean registrado = false;
        boolean existe = verificarVendedor(vendedor.getDocumentoIdentidad());
        if (!existe){
            listaSucursalVendedores.add(vendedor);
            registrado = true;
        }
        return registrado;
    }

    public Vendedor buscarVendedor (String codigoEmpleado){
        for (Vendedor vendedor: listaSucursalVendedores){
            if (vendedor.getCodigoEmpleado().equals(codigoEmpleado)){
                return vendedor;
            }
        }
        return null;
    }

    public RegistroInventario buscarRegistro (Prenda prenda, Talla talla, String color){
        RegistroInventario encontrado = null;

        for (RegistroInventario registro: listaSucursalRegistros) {
            boolean mismaPrenda = registro.getPrenda().getCodigo().equals(prenda.getCodigo());
            boolean mismaTalla = registro.getTalla() == talla;
            boolean mismoColor = registro.getColor().equalsIgnoreCase(color);

            if (mismaPrenda && mismaTalla && mismoColor) {
                encontrado = registro;
            }

        }
        return encontrado;
    }

    public boolean registrarExistencias (Prenda prenda, Talla talla, String color, int cantidad){
        boolean registrado = false;

        boolean tallaValida = prenda.admitirTalla(talla);
        boolean cantidadValida = cantidad > 0;
        boolean yaExiste = buscarRegistro(prenda, talla, color) == null;

        if (tallaValida && cantidadValida && yaExiste) {
            RegistroInventario registro = new RegistroInventario (prenda, this, talla, color, cantidad);
            listaSucursalRegistros.add (registro);
            prenda.getListaPrendaRegistros().add(registro);
            registrado = true;
        }
        return registrado;
    }

    public List<RegistroInventario> consultarDisponibles (){
        List <RegistroInventario> disponibles = new ArrayList<>();

        for (RegistroInventario registro: listaSucursalRegistros){
            if (registro.getCantidad() > 0) {
                disponibles.add(registro);
            }
        }
        return disponibles;
    }

    public boolean verificarVenta (int codigoVenta){
        boolean existe = false;
        for (Venta venta: listaSucursalVentas){
            if (codigoVenta == venta.getCodigo()){
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarVenta (Venta venta){
        boolean registrado = false;
        boolean existe = verificarVenta(venta.getCodigo());
        if (!existe){
            listaSucursalVentas.add(venta);
            registrado = true;
        }
        return registrado;
    }

    public Venta buscarVenta (int codigoVenta){
        for (Venta venta: listaSucursalVentas){
            if (codigoVenta == venta.getCodigo()){
                return venta;
            }
        }
        return null;
    }
}
