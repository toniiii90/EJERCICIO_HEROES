

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void gestionAltaHeroe(Heroes heroe, String nombreHeroe, ArrayList<ArmaEspecial> listaArmasGremio) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(nombreHeroe + " ha sido añadido al gremio sin armas. Vamos a elegiarlas: ");
        boolean heroeCompletado = false;
        boolean numeroDeArmasCorrecta = false;
        int numeroDeArmas = -1;
        do {
            System.out.println("¿Cuántas armas quieres que tenga " + nombreHeroe + "?: ");
            if (scanner.hasNextInt()) {
                numeroDeArmas = scanner.nextInt(); // El array de armas empieza en 0
                scanner.nextLine(); // Limpio el buffer
            } else {
                System.out.println("Debes ingresar un número válido.");
                scanner.nextLine();
                continue;
            }

            if (numeroDeArmas == 0) {
                System.out.println("Tienes que añadir al menos un arma");
                continue;
            }

            if (numeroDeArmas > listaArmasGremio.size()) {
                System.out.println("No existen tantos armas disponibles");
                continue;
            }
            numeroDeArmasCorrecta = true;
        } while(!numeroDeArmasCorrecta);
        boolean arsenalCompletado = false;
        do {
            for (int i = 0; i < numeroDeArmas; ) {

                System.out.println("Elige un arma para " + nombreHeroe + ": ");

                for (int j = 0; j < listaArmasGremio.size(); j++) {
                    System.out.println((j + 1) + ". " + listaArmasGremio.get(j).getNombre() + " (Daño: " + listaArmasGremio.get(j).getDano() + ")");
                }
                // Valido la selección de armas
                int opcionArma = -1;
                if (scanner.hasNextInt()) {
                    opcionArma = scanner.nextInt() - 1; // El array de armas empieza en 0
                    scanner.nextLine(); // Limpio el buffer
                } else {
                    System.out.println("Debes ingresar un número válido.");
                    scanner.nextLine();
                    continue;
                }
                // Verifico que la opción sea válido
                if (opcionArma < 0 || opcionArma >= listaArmasGremio.size()) {
                    System.out.println("Debes elegir un número de la lista.");
                    continue;
                }
                ArmaEspecial armaElegidaParaArsenal = listaArmasGremio.get(opcionArma);
                boolean armaAnyadidaAlArsenal = heroe.anadirArmaDisponible(armaElegidaParaArsenal);
                if (armaAnyadidaAlArsenal) {
                    System.out.println(nombreHeroe + " ha añadido a su arsenal el arma " + armaElegidaParaArsenal.getNombre() + "!");
                    i++;
                }
            }
            arsenalCompletado = true;
        } while(!arsenalCompletado);
        do {
            ArrayList<ArmaEspecial> listaArmasGuerrero = heroe.getArmas();

            System.out.println("Elige el arma principal para " + nombreHeroe + ": ");

            for (int i = 0; i < listaArmasGuerrero.size(); i++) {
                System.out.println((i + 1) + ". " + listaArmasGuerrero.get(i).getNombre() + " (Daño: " + listaArmasGuerrero.get(i).getDano() + ")");
            }

            // Valido la selección de armas
            int opcionArmaFavorita = -1;
            if (scanner.hasNextInt()) {
                opcionArmaFavorita = scanner.nextInt() - 1; // El array de armas empieza en 0
                scanner.nextLine(); // Limpio el buffer
            } else {
                System.out.println("Debes ingresar un número válido.");
                scanner.nextLine();
                continue;
            }
            // Verifico que la opción sea válido
            if (opcionArmaFavorita < 0 || opcionArmaFavorita >= listaArmasGuerrero.size()) {
                System.out.println("Debes elegir un número de la lista.");
                continue;
            }
            // Asigno el arma favorita
            ArmaEspecial armaElegidaFavorita = listaArmasGuerrero.get(opcionArmaFavorita);
            heroe.setArmaEspecial(armaElegidaFavorita);

            System.out.println(nombreHeroe + " ha sido añadido al gremio con su " + armaElegidaFavorita.getNombre() + "!");
            heroeCompletado = true;
        } while (!heroeCompletado);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        String[] tiposDeHeroes = new String[4];
        tiposDeHeroes[0] = "Guerrero/a";
        tiposDeHeroes[1] = "Mago/a";
        tiposDeHeroes[2] = "Arquero/a";
        tiposDeHeroes[3] = "Asesino/a";
        String[] atributosHeroe = new String[4];
        atributosHeroe[0] = "fuerza";
        atributosHeroe[1] = "maná";
        atributosHeroe[2] = "precision";
        atributosHeroe[3] = "sigilo";
        Gremio gremio = new Gremio();
        gremio.anadirArma(new ArmaEspecial("Bastón Arcano", 50));
        gremio.anadirArma(new ArmaEspecial("Orbe Místico", 60));
        gremio.anadirArma(new ArmaEspecial("AK-47", 70));
        gremio.anadirArma(new ArmaEspecial("Desert Deagle", 80));

        do {
            System.out.println("-----BIENVENIDO A HÉROES 1J-----");
            System.out.println("1. Añadir héroe.");
            System.out.println("2. Añadir arma.");
            System.out.println("3. Eliminar héroe por su nombre.");
            System.out.println("4. Buscar héroe y mostrar sus detalles.");
            System.out.println("5. Listar todos los héroes registrados en el gremio.");
            System.out.println("0. Salir.");
            System.out.println("Elige una opción: ");

            // Validación de la entrada
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpio el buffer
            } else {
                System.out.println("Debes ingresar una opción válida.");
                scanner.nextLine(); // Limpio la entrada incorrecta
                continue; // Vuelvo a pedir la opción
            }

            switch (opcion) {
                case 0: // SALIR
                    System.out.println("Hasta luego!");
                    break;
                case 1: // Añadir Heroe
                    System.out.println("¿Qué tipo de héroe deseas añadir?");
                    System.out.println("1. Guerrero/a");
                    System.out.println("2. Mago/a");
                    System.out.println("3. Arquero/a");
                    System.out.println("4. Asesino/a");
                    System.out.println("5. Cancelar");
                    System.out.println("Elige una subopción: ");

                    int subopcion = -1;
                    if (scanner.hasNextInt()) {
                        subopcion = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Debes ingresar una opción válida.");
                        scanner.nextLine();
                        continue;
                    }
                    ArrayList<ArmaEspecial> listaArmasGremio = gremio.getArmas();

                    System.out.println("Nombre del " + tiposDeHeroes[subopcion - 1] + ": ");
                    String nombreHeroe = scanner.nextLine();

                    if (nombreHeroe.isEmpty()) {
                        System.out.println("Debes ingresar un nombre.");
                        continue;
                    }

                    System.out.println("Nivel: ");
                    int nivelHeroe = scanner.nextInt();
                    scanner.nextLine();

                    if (nivelHeroe < 0) {
                        System.out.println("El nivel debe ser mayor que 0.");
                        continue;
                    }

                    System.out.println("Puntos de vida: ");
                    int puntosVidaHeroe = scanner.nextInt();
                    scanner.nextLine();

                    if (puntosVidaHeroe < 0) {
                        System.out.println("Los puntos de vida no deben ser negativos.");
                        continue;
                    }

                    System.out.println(atributosHeroe[subopcion - 1] + ": ");
                    int atributoHeroe = scanner.nextInt();
                    scanner.nextLine();

                    if (atributoHeroe < 0) {
                        System.out.println("La " + atributosHeroe[subopcion - 1] + "debe ser mayor que 0.");
                        continue;
                    }

                    // Creo el Guerrero todavía sin armas
                    switch (subopcion) {
                        case 1:
                            Guerrero guerrero = new Guerrero(nombreHeroe, nivelHeroe, puntosVidaHeroe, atributoHeroe);
                            gremio.anadirHeroe(guerrero);
                            gestionAltaHeroe(guerrero, nombreHeroe, listaArmasGremio);
                            break;
                        case 2:
                            Mago mago = new Mago(nombreHeroe, nivelHeroe, puntosVidaHeroe, atributoHeroe);
                            gremio.anadirHeroe(mago);
                            gestionAltaHeroe(mago, nombreHeroe, listaArmasGremio);
                            break;
                        case 3:
                            Arquero arquero = new Arquero(nombreHeroe, nivelHeroe, puntosVidaHeroe, atributoHeroe);
                            gremio.anadirHeroe(arquero);
                            gestionAltaHeroe(arquero, nombreHeroe, listaArmasGremio);
                            break;
                        case 4:
                            Asesino asesino = new Asesino(nombreHeroe, nivelHeroe, puntosVidaHeroe, atributoHeroe);
                            gremio.anadirHeroe(asesino);
                            gestionAltaHeroe(asesino, nombreHeroe, listaArmasGremio);
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    break;
                case 2: // Añadir arma al arsenal
                    System.out.println("Nombre del arma: ");
                    String nombreArma = scanner.nextLine();

                    System.out.println("Daño que hace: ");
                    int danoArma = scanner.nextInt();
                    scanner.nextLine();

                    if (nombreArma.isEmpty()) {
                        System.out.println("Debes indicar el nombre del arma.");
                        continue;
                    }
                    if (danoArma <= 0) {
                        System.out.println("El arma debe hacer al menos 1 de daño.");
                        continue;
                    }

                    // Creo el objeto
                    ArmaEspecial nuevaArma = new ArmaEspecial(nombreArma, danoArma);

                    // Añado el arma al gremio
                    gremio.anadirArma(nuevaArma);

                    System.out.println("El arma " + nombreArma + " ha sido añadida correctamente al gremio con un daño de " + danoArma);
                    break;
                case 3: // Eliminar heroe
                    System.out.println("Nombre del héroe que deseas eliminar: ");
                    String nombreHeroeEliminar = scanner.nextLine();

                    Heroes heroeEliminar = gremio.buscarHeroes(nombreHeroeEliminar);
                    if (heroeEliminar == null) {
                        System.out.println("No se puede eliminar el héroe porque no existe.");
                        break;
                    }
                    if (gremio.eliminarHeroePorNombre(nombreHeroeEliminar)) {
                        System.out.println("Héroe eliminado correctamente.");
                    }
                    break;
                case 4: // Buscar Heroe
                    System.out.println("Nombre del héroe que quieres buscar: ");
                    String nombreHeroeBuscar = scanner.nextLine();

                    Heroes heroeBuscar = gremio.buscarHeroes(nombreHeroeBuscar);
                    if (heroeBuscar == null) {
                        System.out.println("El héroe no existe en el gremio.");
                        break;
                    } else {
                        System.out.println("Héroe encontrado: ");
                        System.out.println(heroeBuscar);
                    }
                    break;
                case 5: // Listar todos los heroes
                    gremio.mostrarHeroes();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
