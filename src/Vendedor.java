import java.time.LocalDate;

public class Vendedor extends Persona{
    private String codigoEmpleado;
    private LocalDate fechaContratacion;
    private double salarioBasico;

    Vendedor (String documentoIdentidad, String nombreCompleto, String correoElectronico, String telefono, String codigoEmpleado, LocalDate fechaContratacion, double salarioBasico){
        super(documentoIdentidad, nombreCompleto, correoElectronico, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    @Override
    public String toString() {
        return "Vendedor:" +
                super.toString() +
                "Codigo empleado= " + codigoEmpleado + '|' +
                "Fecha contratacion= " + fechaContratacion + '|' +
                "Salario basico= " + salarioBasico;
    }
}
