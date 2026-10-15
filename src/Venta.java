import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {

    private int codigo;
    private LocalDate fecha;
    private Sucursal sucursal;
    private Vendedor vendedor;
    private Cliente cliente;

    private List<DetalleVenta> listaVentaDetalles;

    public Venta(int codigo, LocalDate fecha, Sucursal sucursal, Vendedor vendedor, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.sucursal = sucursal;
        this.vendedor = vendedor;
        this.cliente = cliente;

        this.listaVentaDetalles = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleVenta> getListaVentaDetalles() {
        return listaVentaDetalles;
    }

    public void setListaVentaDetalles(List<DetalleVenta> listaVentaDetalles) {
        this.listaVentaDetalles = listaVentaDetalles;
    }

    @Override
    public String toString() {
        return "Venta: " +
                "Codigo: " + codigo + " | "+
                "Fecha: " + fecha + " | "+
                "Sucursal: " + sucursal + " | "+
                "Vendedor: " + vendedor + " | "+
                "Cliente: " + cliente;
    }

    public double calcularValorTotal() {
        double totalVenta = 0;

        for (DetalleVenta detalle : listaVentaDetalles) {
            // Obener prenda y el cliente asociados a la venta
            Prenda prenda = detalle.getRegistroInventario().getPrenda();

            // Calcular el precio unitario final
            double precioUnitarioFinal = prenda.calcularPrecioUnitarioFinal(this.cliente);


            totalVenta += precioUnitarioFinal * detalle.getCantidadComprada();
        }

        return totalVenta;
    }
}