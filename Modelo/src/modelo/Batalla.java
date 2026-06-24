package controlador;

import modelo.arquero;
import modelo.guerrero;
import modelo.mago;
import modelo.personaje;
import java.util.Scanner;

public class Batalla {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("JUEGO BATALLA CAMPAL");
        System.out.println("====================");
        System.out.println("Cuantos luchadores desea ingresar");
        int n = sc.nextInt();
        System.out.println("CREACION DE PERSONAJES");
        System.out.println("======================");
        personaje[] listaPersonajes = new personaje[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPersonaje " + (i + 1));
            System.out.println("1. Guerrero");
            System.out.println("2. Mago");
            System.out.println("3. Arquero");
            int opcion = sc.nextInt();
            sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Vida: ");
            int vida = sc.nextInt();

            System.out.print("Experiencia: ");
            int experiencia = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    listaPersonajes[i] = new guerrero(nombre, id, vida, experiencia);
                    break;

                case 2:
                    listaPersonajes[i] = new mago(nombre, id, vida, experiencia);
                    break;

                case 3:
                    listaPersonajes[i] = new arquero(nombre, id, vida, experiencia);
                    break;

                default:
                    System.out.println("Opción inválida");
                    i--;
            }

        }

        System.out.println("\n=================================");
        System.out.println("   INFORMACIÓN DE LOS LUCHADORES  ");
        System.out.println("=================================");

        for (int i = 0; i < listaPersonajes.length; i++) {
            System.out.print("[" + i + "] "); 
            listaPersonajes[i].mostrarInfo();  
            System.out.println("---------------------------------");
        }

        System.out.print("\nSeleccione el número del primer luchador: ");
        int p1 = sc.nextInt();
        System.out.print("Seleccione el número del segundo luchador: ");
        int p2 = sc.nextInt();

        personaje luchador1 = listaPersonajes[p1];
        personaje luchador2 = listaPersonajes[p2];

        System.out.println("\n===== INICIA LA BATALLA =====");

        while (luchador1.getVida() > 0 && luchador2.getVida() > 0) {

            luchador1.atacar(luchador2);

            System.out.println(luchador2.getNombre()
                    + " tiene "
                    + luchador2.getVida()
                    + " puntos de vida.");

            if (luchador2.getVida() <= 0) {
                break;
            }

            luchador2.atacar(luchador1);

            System.out.println(luchador1.getNombre()
                    + " tiene "
                    + luchador1.getVida()
                    + " puntos de vida");
        }

        System.out.println("\n===== RESULTADO =====");

        if (luchador1.getVida() > 0) {
            System.out.println("Ganador: " + luchador1.getNombre());
            luchador1.subNivel();
        } else {
            System.out.println("Ganador: " + luchador2.getNombre());
            luchador2.subNivel();
        }

    }
}
