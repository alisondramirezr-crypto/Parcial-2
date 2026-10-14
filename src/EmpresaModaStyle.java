import java.util.ArrayList;
import java.util.List;

public class EmpresaModaStyle {
    private String nombreComercial;
    private String NIT;
    private String direccionPrincipal;

    private List <Sucursal> listaEmpresaSucursales;
    private List <Prenda> listaEmpresaPrendas;
    private List <Cliente> listaEmpresaClientes;

    public EmpresaModaStyle(String nombreComercial, String NIT, String direccionPrincipal) {
        this.nombreComercial = nombreComercial;
        this.NIT = NIT;
        this.direccionPrincipal = direccionPrincipal;

        this.listaEmpresaSucursales = new ArrayList<>();
        this.listaEmpresaPrendas = new ArrayList<>();
        this.listaEmpresaClientes = new ArrayList<>();
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(String direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public List<Sucursal> getListaEmpresaSucursales() {
        return listaEmpresaSucursales;
    }

    public void setListaEmpresaSucursales(List<Sucursal> listaEmpresaSucursales) {
        this.listaEmpresaSucursales = listaEmpresaSucursales;
    }

    public List<Prenda> getListaEmpresaPrendas() {
        return listaEmpresaPrendas;
    }

    public void setListaEmpresaPrendas(List<Prenda> listaEmpresaPrendas) {
        this.listaEmpresaPrendas = listaEmpresaPrendas;
    }

    public List<Cliente> getListaEmpresaClientes() {
        return listaEmpresaClientes;
    }

    public void setListaEmpresaClientes(List<Cliente> listaEmpresaClientes) {
        this.listaEmpresaClientes = listaEmpresaClientes;
    }
}

