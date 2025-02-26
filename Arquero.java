public class Arquero extends Heroes {
    protected int precision;

    public Arquero(String nombre, int nivel, int puntosVida, ArmaEspecial armaEspecial, int precision) {
        super(nombre, nivel, puntosVida, armaEspecial);
        this.precision = precision;
    }

    public Arquero(String nombre, int nivel, int puntosVida, int precision) {
        super(nombre, nivel, puntosVida);
        this.precision = precision;
    }

    public int getPrecision() {
        return precision;
    }

    public void disparar() {
        System.out.println(nombre + " dispara con su arco " + armaEspecial.getNombre() + " con una precisión de " + precision);
    }
}
