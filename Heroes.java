import java.util.ArrayList;

public class Heroes {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected ArmaEspecial armaEspecial;
    protected ArrayList<ArmaEspecial> armasDisponibles;

    public Heroes(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.armasDisponibles = new ArrayList<>();
    }

    public Heroes(String nombre, int nivel, int puntosVida, ArmaEspecial armaEspecial) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.armaEspecial = armaEspecial;
        this.armasDisponibles = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public ArmaEspecial getArmaEspecial() {
        return armaEspecial;
    }

    public void setArmaEspecial(ArmaEspecial arma) {
        this.armaEspecial = arma;
    }

    public ArrayList<ArmaEspecial> getArmas() {
        return armasDisponibles;
    }

    @Override
    public String toString() {
        String detalleArsenal = "";
        for (ArmaEspecial arma : armasDisponibles) {
            detalleArsenal = detalleArsenal + arma.getNombre() + ",";
        }
        return "Heroes -> " +
                "Nombre: " + nombre +
                ", Nivel: " + nivel +
                ", Puntos de vida: " + puntosVida +
                ", Armas disponibles: " + detalleArsenal +
                " Arma especial: " + armaEspecial.getNombre() + " (Daño: " + armaEspecial.getDano() + " )";
    }

    public void atacar(Heroes heroe) {
        System.out.println(heroe + " ataca con un golpe fuerte.");
    }

    public ArmaEspecial buscarArma(String nombre) {
        for (ArmaEspecial arma : armasDisponibles) {
            if (arma.getNombre().equalsIgnoreCase(nombre)) {
                return arma;
            }
        }
        return null;
    }

    public boolean anadirArmaDisponible(ArmaEspecial arma) {
        if (buscarArma(arma.getNombre()) == null) {
            armasDisponibles.add(arma);
            System.out.println("Arma añadida: " + arma.getNombre());
            return true;
        } else {
            System.out.println("Ya existe un arma con ese nombre.");
            return false;
        }
    }
}