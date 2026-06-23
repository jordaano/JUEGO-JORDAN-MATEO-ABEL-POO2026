package modelo;

import java.util.ArrayList;

public class arquero extends personaje {

    private int precision;
    private ArrayList<Objeto> inventario;  // NUEVO
    private Objeto objetoEquipado;         // NUEVO

    public arquero(String nombre, String id, int vida, int experiencia) {
        super(nombre, id, vida, experiencia);
        this.precision = 10;
        this.inventario = new ArrayList<>();
        this.objetoEquipado = null;
    }

    // NUEVO: agrega un objeto al inventario
    public void agregarObjeto(Objeto o) {
        inventario.add(o);
        System.out.println(nombre + " recibió en su inventario: " + o.getNombre());
    }

    // NUEVO: equipa un objeto del inventario
    public void equipar(Objeto o) {
        if (inventario.contains(o)) {
            this.objetoEquipado = o;
            System.out.println(nombre + " equipó: " + o.getNombre());
        } else {
            System.out.println("El objeto no está en el inventario de " + nombre);
        }
    }

    // MODIFICADO: suma modificador del arma equipada
    @Override
    public void atacar(personaje enemigo) {
        int danioTotal = precision;
        if (objetoEquipado instanceof Arma) {
            danioTotal += objetoEquipado.getModificador();
            System.out.println(nombre + " dispara una flecha con " + objetoEquipado.getNombre());
        } else {
            System.out.println(nombre + " dispara una flecha.");
        }
        enemigo.vida -= danioTotal;
        System.out.println("  Daño causado: " + danioTotal);
    }

    // MODIFICADO: menciona armadura si está equipada
    @Override
    public void defender() {
        if (objetoEquipado instanceof Armadura) {
            System.out.println(nombre + " esquiva el ataque con agilidad gracias a " + objetoEquipado.getNombre()
                    + " (reduce " + objetoEquipado.getModificador() + " de daño)");
        } else {
            System.out.println(nombre + " esquiva el ataque.");
        }
    }

    @Override
    public void mostrarInfo() {
        System.out.println("ARQUERO");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Vida: " + vida);
        System.out.println("Experiencia: " + experiencia);
        System.out.println("Inventario (" + inventario.size() + " objeto/s):");
        if (inventario.isEmpty()) {
            System.out.println("  (vacío)");
        } else {
            for (Objeto o : inventario) {
                o.descripcion();
            }
        }
        System.out.println("Equipado: " + (objetoEquipado != null ? objetoEquipado.getNombre() : "Ninguno"));
    }

    @Override
    public void subNivel() {
        nivel += 1;
        experiencia += 10;
        vida += 10;
        precision += 5;
        System.out.println(nombre + " subió de nivel. NIVEL " + nivel);
    }
}
