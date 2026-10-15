import java.util.ArrayList;
import java.util.List;

public class RegistroInventario {

    private Prenda prenda;
    private Sucursal sucursal;
    private Talla talla;
    private String color;
    private int cantidad;

    private List <DetalleVenta> listaRegistroDetalles;

    public RegistroInventario(Prenda prenda, Sucursal sucursal, Talla talla, String color, int cantidad) {
        this.prenda = prenda;
        this.sucursal = sucursal;
        this.talla = talla;
        this.color = color;
        this.cantidad = cantidad;

        listaRegistroDetalles = new ArrayList<>();
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<DetalleVenta> getListaRegistroDetalles() {
        return listaRegistroDetalles;
    }

    public void setListaRegistroDetalles(List<DetalleVenta> listaRegistroDetalles) {
        this.listaRegistroDetalles = listaRegistroDetalles;
    }

    @Override
    public String toString() {
        return "RegistroInventario: " +
                "Prenda: " + prenda + " | "+
                "Sucursal: " + sucursal + " | "+
                "Talla: " + talla + " | " +
                "Color: " + color + " | " +
                "Cantidad: " + cantidad + " | ";
    }
}
