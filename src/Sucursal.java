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
}
