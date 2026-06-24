package modelo;

public class arquero extends personaje {
    private int precision;

    public arquero(String nombre, String id, int vida, int experiencia) {
        super(nombre, id, vida, experiencia);
        this.precision = 10;
    }

    @Override
    public void atacar(personaje enemigo) {
        // 1. Procesa los efectos del arquero antes de disparar
        boolean puedeAtacar = this.procesarEstadosDelTurno();
        
        if (!puedeAtacar) {
            return; 
        }

        int precisionCalculada = this.precision;
        if (tieneEstado("potenciado")) {
            precisionCalculada += 12; // Las flechas hacen mucho más daño enfocadas
            System.out.println("¡El ataque enfocado de " + nombre + " va con daño extra!");
        }

        System.out.println(nombre + " dispara una flecha certera causando " + precisionCalculada + " de daño.");
        enemigo.vida -= precisionCalculada;

        // 2. Efecto Alterado de su Habilidad: Impregna flechas con VENENO por 3 turnos al enemigo
        if (Math.random() < 0.50) {
            System.out.print("[" + nombre + " EXTRA] ");
            enemigo.aplicarEstado("envenenado", 3);
        }

        // 3. Posibilidad de entrar en estado POTENCIADO para el siguiente turno
        if (Math.random() < 0.30) {
            System.out.print("[" + nombre + " ENFOQUE] ");
            this.aplicarEstado("potenciado", 2);
        }
    }

    @Override
    public void defender() {
        System.out.println(nombre + " esquiva el ataque.");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("ARQUERO");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Vida: " + vida);
        System.out.println("Experiencia: " + experiencia);
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
