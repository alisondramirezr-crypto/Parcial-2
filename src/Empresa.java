import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombreComercial;
    private String NIT;
    private String direccionPrincipal;

    private List <Sucursal> listaEmpresaSucursales;
    private List <Prenda> listaEmpresaPrendas;
    private List <Cliente> listaEmpresaClientes;

    public Empresa(String nombreComercial, String NIT, String direccionPrincipal) {
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

    public boolean verificarPrenda (String codigoPrenda) {
        boolean existe = false;
        for (Prenda prenda: listaEmpresaPrendas){
            if (prenda.getCodigo().equals(codigoPrenda)){
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarPrenda (Prenda prenda){
        boolean registrada = false;
        boolean existe = verificarPrenda(prenda.getCodigo());
        if (!existe){
            listaEmpresaPrendas.add(prenda);
            registrada = true;
        }
        return registrada;
    }

    public Prenda buscarPrenda (String codigoPrenda){
        for (Prenda prenda: listaEmpresaPrendas){
            if (prenda.getCodigo().equals(codigoPrenda)){
                return prenda;
            }
        }
        return null;
    }

    public boolean verificarCliente (String documentoIdentidad){
        boolean existe = false;
        for (Cliente cliente: listaEmpresaClientes){
            if (documentoIdentidad.equalsIgnoreCase(cliente.getDocumentoIdentidad())){
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarCliente (Cliente cliente){
        boolean registrado = false;
        boolean existe = verificarCliente(cliente.getDocumentoIdentidad());
        if (!existe){
            listaEmpresaClientes.add(cliente);
            registrado = true;
        }
        return registrado;
    }

    public Cliente buscarCliente (String codigoAfiliacion){
        for (Cliente cliente: listaEmpresaClientes){
            if (cliente.getCodigoAfiliacion().equals(codigoAfiliacion)){
                return cliente;
            }
        }
        return null;
    }

    public boolean verificarSucursal (int codigoSucursal){
        boolean existe = false;
        for (Sucursal sucursal: listaEmpresaSucursales){
            if (codigoSucursal == sucursal.getCodigo()){
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarSucursal (Sucursal sucursal){
        boolean registrado = false;
        boolean existe = verificarSucursal(sucursal.getCodigo());
        if (!existe){
            listaEmpresaSucursales.add(sucursal);
            registrado = true;
        }
        return registrado;
    }

    public Sucursal buscarSucursal(int codigo) {
        for (Sucursal sucursal : listaEmpresaSucursales) {
            if (sucursal.getCodigo() == codigo) {
                return sucursal;
            }
        }
        return null;
    }

    public boolean verificarDocumento(String documento) {
        boolean existeDocumento = false;
        for (Cliente cliente : listaEmpresaClientes) {
            if (cliente.getDocumentoIdentidad().equals(documento)) {
                existeDocumento = true;
            }
        }
        for (Sucursal sucursal : listaEmpresaSucursales) {
            if (sucursal.verificarVendedor(documento)) {
                existeDocumento = true;
            }
        }
        return existeDocumento;
    }

}
