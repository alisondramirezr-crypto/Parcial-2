public class Cliente extends Persona{
    private String codigoAfiliacion;
    private CategoriaCliente categoriaCliente;

    private Cliente (String documentoIdentidad, String nombreCompleto, String correoElectronico, String telefono, String codigoAfiliacion, CategoriaCliente categoriaCliente){
        super(documentoIdentidad, nombreCompleto, correoElectronico, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.categoriaCliente = categoriaCliente;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public CategoriaCliente getCategoriaCliente() {
        return categoriaCliente;
    }

    public void setCategoriaCliente(CategoriaCliente categoriaCliente) {
        this.categoriaCliente = categoriaCliente;
    }

    @Override
    public String toString() {
        return "Cliente:" +
                super.toString()+
                "Codigo afiliacion=" + codigoAfiliacion + '|' +
                "Categoria cliente=" + categoriaCliente;
    }

}
