import java.util.ArrayList;
import java.util.List;

public class RegistroInventario {

    private Talla talla;
    private String color;
    private int cantidad;

    private List <DetalleVenta> listaRegistroDetalles;

    public RegistroInventario(Talla talla, String color, int cantidad) {
        this.talla = talla;
        this.color = color;
        this.cantidad = cantidad;

        this.listaRegistroDetalles = new ArrayList<>();
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
        return "RegistroInventario: " + " | "+
                "Talla: " + talla + " | " +
                "Color: " + color +  " | "+
                "Cantidad: " + cantidad;
    }
}

