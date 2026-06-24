package modelo;

public class mago extends personaje {
    private int magia;

    public mago(String nombre, String id, int vida, int experiencia) {
        super(nombre, id, vida, experiencia);
        this.magia = 20;
    }

    @Override
    public void atacar(personaje enemigo) {
        // 1. Procesa los efectos del mago al comenzar su turno
        boolean puedeAtacar = this.procesarEstadosDelTurno();
        
        if (!puedeAtacar) {
            return; // No ataca si está aturdido
        }

        int magiaCalculada = this.magia;
        if (tieneEstado("potenciado")) {
            magiaCalculada += 10;
        }

        System.out.println(nombre + " lanza un hechizo causando " + magiaCalculada + " de daño.");
        enemigo.vida -= magiaCalculada;

        // 2. Efecto Alterado de su Habilidad: Al atacar mete QUEMADURA al rival por 2 turnos
        if (Math.random() < 0.40) {
            System.out.print("[" + nombre + " EXTRA] ");
            enemigo.aplicarEstado("quemado", 2);
        }
        
        // 3. Auto-Buff eventual: El mago tiene posibilidad de activar REGENERACIÓN sobre sí mismo
        if (Math.random() < 0.25) {
            System.out.print("[" + nombre + " AUTOBÚFF] ");
            this.aplicarEstado("regeneración", 2);
        }
    }

    @Override
    public void defender() {
        System.out.println(nombre + " crea un escudo mágico."); 
    }

    @Override
    public void mostrarInfo() {
        System.out.println("MAGO");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Vida: " + vida);
        System.out.println("Experiencia: " + experiencia);
    }

    @Override
    public void subNivel() {
        nivel += 1;
        experiencia += 10;
        vida += 15;
        magia += 10;
        System.out.println(nombre + " subió de nivel. NIVEL " + nivel);    
    }
}
