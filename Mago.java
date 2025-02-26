public class Mago extends Heroes {
    protected int mana;

    public Mago(String nombre, int nivel, int puntosVida, ArmaEspecial armaEspecial, int mana) {
        super(nombre, nivel, puntosVida, armaEspecial);
        this.mana = mana;
    }

    public Mago(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void hechizar() {
        System.out.println(nombre + " hechiza usando " + armaEspecial.getNombre() + " con " + mana + " puntos de maná.");
    }

}
