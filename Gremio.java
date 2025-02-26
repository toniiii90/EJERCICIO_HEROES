import java.util.ArrayList;

public class Gremio {
    protected ArrayList<Heroes> heroes;
    protected ArrayList<ArmaEspecial> armas;

    public Gremio() {
        this.heroes = new ArrayList<>();
        this.armas = new ArrayList<>();
    }

    public ArrayList<ArmaEspecial> getArmas() {
        return armas;
    }

    public Heroes buscarHeroes(String nombre) {
        for (Heroes heroe : heroes) {
            if (heroe.getNombre().equalsIgnoreCase(nombre)) {
                return heroe;
            }
        }
        return null;
    }

    public boolean anadirHeroe(Heroes heroe) {
        if (buscarHeroes(heroe.getNombre()) == null) {
            heroes.add(heroe);
            System.out.println("Héroe añadido: " + heroe.getNombre());
            return true;
        } else {
            System.out.println("Ya existe un héroe con ese nombre.");
            return false;
        }
    }

    public boolean anadirArma(ArmaEspecial arma) {
        if (buscarArma(arma.getNombre()) == null) {
            armas.add(arma);
            System.out.println("Arma añadida: " + arma.getNombre());
            return true;
        } else {
            System.out.println("Ya existe un arma con ese nombre.");
            return false;
        }
    }

    public boolean eliminarHeroePorNombre(String nombre) {
        Heroes heroe = buscarHeroes(nombre);

        if (heroe == null) {
            System.out.println("La criatura no existe.");
            return false;
        } else {
            heroes.remove(heroe);
            System.out.println("Héroe eliminado: " + heroe.getNombre());
            return true;
        }
    }

    public void mostrarHeroes() {
        if (heroes.isEmpty()) {
            System.out.println("No hay héroes registrados en el gremio.");
        } else {
            System.out.println("Héroes registrados: ");
            for (Heroes heroe : heroes) {
                System.out.println(heroe);
            }
        }
    }

    public ArmaEspecial buscarArma(String nombre) {
        for (ArmaEspecial arma : armas) {
            if (arma.getNombre().equalsIgnoreCase(nombre)) {
                return arma;
            }
        }
        return null;
    }


}
