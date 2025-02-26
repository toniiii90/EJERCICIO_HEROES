public class Asesino extends Heroes {
    protected int sigilo;

    public Asesino(String nombre, int nivel, int puntosVida, ArmaEspecial armaEspecial, int sigilo) {
        super(nombre, nivel, puntosVida, armaEspecial);
        this.sigilo = sigilo;
    }

    public Asesino(String nombre, int nivel, int puntosVida, int sigilo) {
        super(nombre, nivel, puntosVida);
        this.sigilo = sigilo;
    }

    public int getSigilo() {
        return sigilo;
    }

    public void asesinar() {
        System.out.println(nombre + " asesina en las sombras con " + armaEspecial.getNombre() + " y un sigilo de " + sigilo);
    }
}
