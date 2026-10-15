public enum Talla {
    XS (false),
    S (false),
    M (false),
    L (false),
    XL (false),
    T35 (true),
    T36 (true),
    T37 (true),
    T38 (true),
    T39 (true),
    T40 (true),
    T41 (true),
    T42 (true),
    T43 (true),
    T44 (true);

    private final boolean calzado;

    Talla (boolean calzado){
        this.calzado = calzado;
    }

    public boolean esCalzado (){
        return calzado;
    }
}
