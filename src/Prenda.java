import java.util.ArrayList;
import java.util.List;

public class Prenda {

    private String codigo;
    private String nombre;
    private String marca;
    private double precioBase;
    private CategoriaPrenda categoriaPrenda;

    private List<RegistroInventario> listaPrendaRegistros;

    public Prenda(String codigo, String nombre, String marca, double precioBase, CategoriaPrenda categoriaPrenda) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precioBase = precioBase;
        this.categoriaPrenda = categoriaPrenda;

        this.listaPrendaRegistros = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public CategoriaPrenda getCategoriaPrenda() {
        return categoriaPrenda;
    }

    public void setCategoriaPrenda(CategoriaPrenda categoriaPrenda) {
        this.categoriaPrenda = categoriaPrenda;
    }

    public List<RegistroInventario> getListaPrendaRegistros() {
        return listaPrendaRegistros;
    }

    public void setListaPrendaRegistros(List<RegistroInventario> listaPrendaRegistros) {
        this.listaPrendaRegistros = listaPrendaRegistros;
    }

    @Override
    public String toString() {
        return "Prenda: " +
                "Codigo: " + codigo + " | " +
                "Nombre: " + nombre + " | " +
                "Marca: " + marca + " | " +
                "PrecioBase: " + precioBase + " | "+
                "Categoria Prenda: " + categoriaPrenda;
    }

    public boolean admitirTalla (Talla talla){
        if (categoriaPrenda == CategoriaPrenda.CALZADO) {
            return talla.esCalzado();
        } else {
            return !talla.esCalzado();
        }
    }

    public double calcularPrecioUnitarioFinal(Cliente cliente) {
        double precioConRecargo = precioBase + (precioBase * categoriaPrenda.getRecargo());

        double descuento = cliente.getCategoriaCliente().getDescuento();

        double precioFinal = precioConRecargo - (precioConRecargo * descuento);

        return precioFinal;
    }


}
