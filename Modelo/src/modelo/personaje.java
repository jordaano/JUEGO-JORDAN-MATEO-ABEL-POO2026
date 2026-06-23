package modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class personaje {

    protected String nombre;
    protected String id;
    protected int vida;
    protected int experiencia;
    protected int nivel;
    
    // CONTROL DE ESTADOS ALTERADOS (Tu parte del trabajo)
    // Guardamos el nombre del estado y cuántos turnos le quedan de duración
    protected Map<String, Integer> estadosActivos;

    public personaje(String nombre, String id, int vida, int experiencia) {
        this.nombre = nombre;
        this.id = id;
        this.vida = vida;
        this.experiencia = experiencia;
        this.nivel = 1;
        this.estadosActivos = new HashMap<>(); // Inicializa el mapa vacío
    }

    // Método para aplicar un estado con su respectiva duración en turnos
    public void aplicarEstado(String estado, int turnos) {
        estadosActivos.put(estado, turnos);
        System.out.println("¡" + nombre + " ahora está bajo el efecto de: [" + estado + "] por " + turnos + " turnos!");
    }

    // Verifica si el personaje tiene un estado activo específico
    public boolean tieneEstado(String estado) {
        return estadosActivos.containsKey(estado);
    }

    /**
     * Procesa los daños por segundo o penalizaciones de estado.
     * Se manda a llamar al inicio del ataque en el flujo automático.
     * Retorna FALSE si el personaje está aturdido y no puede atacar.
     */
    public boolean procesarEstadosDelTurno() {
        if (this.vida <= 0) return false;

        Iterator<Map.Entry<String, Integer>> iterator = estadosActivos.entrySet().iterator();
        boolean puedeAtacar = true;

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entrada = iterator.next();
            String estado = entrada.getKey();
            int turnosRestantes = entrada.getValue();

            // Lógica pura en consola de los efectos por turno
            switch (estado.toLowerCase()) {
                case "envenenado":
                    this.vida -= 8;
                    System.out.println("[EFECTO] " + nombre + " pierde 8 de vida por Veneno. (Vida actual: " + vida + ")");
                    break;
                case "quemado":
                    this.vida -= 5;
                    System.out.println("[EFECTO] " + nombre + " pierde 5 de vida por Quemadura. (Vida actual: " + vida + ")");
                    break;
                case "aturdido":
                    System.out.println("[EFECTO] " + nombre + " está ATURDIDO y pierde su oportunidad de atacar.");
                    puedeAtacar = false;
                    break;
                case "regeneración":
                case "regeneracion":
                    this.vida += 10;
                    System.out.println("[EFECTO] " + nombre + " recupera 10 de vida por Regeneración. (Vida actual: " + vida + ")");
                    break;
            }

            // Reducir duración del estado
            turnosRestantes--;
            if (turnosRestantes <= 0) {
                System.out.println("-> El estado [" + estado + "] ha terminado en " + nombre + ".");
                iterator.remove();
            } else {
                entrada.setValue(turnosRestantes);
            }
        }
        return puedeAtacar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public abstract void atacar(personaje enemigo);

    public abstract void defender();

    public abstract void subNivel();

    public abstract void mostrarInfo();

}
