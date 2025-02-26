public class Guerrero extends Heroes {
    protected int fuerza;

    public Guerrero(String nombre, int nivel, int puntosVida, ArmaEspecial armaEspecial, int fuerza) {
        super(nombre, nivel, puntosVida, armaEspecial);
        this.fuerza = fuerza;
    }

    public Guerrero(String nombre, int nivel, int puntosVida, int fuerza) {
        super(nombre, nivel, puntosVida);
        this.fuerza = fuerza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void atacar() {
        System.out.println(nombre + " ataca con un golpe de fuerza usando " + armaEspecial.getNombre());
    }


}
