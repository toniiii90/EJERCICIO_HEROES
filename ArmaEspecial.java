public class ArmaEspecial {
    protected String nombre;
    protected int dano;

    public ArmaEspecial(String nombre, int dano) {
        this.nombre = nombre;
        this.dano = dano;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDano() {
        return dano;
    }
}
