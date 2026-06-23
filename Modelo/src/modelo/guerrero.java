package modelo;

public class guerrero extends personaje {

    private int fuerza;

    public guerrero(String nombre, String id, int vida, int experiencia) {
        super(nombre, id, vida, experiencia);
        this.fuerza = 15;
    }

    @Override
    public void atacar(personaje enemigo) {
        // 1. Procesa los efectos nocivos o beneficiosos que tenga el guerrero antes de su acción
        boolean puedeAtacar = this.procesarEstadosDelTurno();
        
        if (!puedeAtacar) {
            return; // Se salta el ataque si está aturdido
        }

        // 2. Cálculo de daño alterado por estados (Buff Potenciado o Debuff Quemado)
        int fuerzaCalculada = this.fuerza;
        if (tieneEstado("potenciado")) {
            fuerzaCalculada += 10; // Aumento por Buff
        }
        if (tieneEstado("quemado")) {
            fuerzaCalculada -= 5;  // Reducción por Debuff
        }

        System.out.println(nombre + " ataca con espada infligiendo " + fuerzaCalculada + " de daño.");
        enemigo.vida -= fuerzaCalculada;

        // 3. Efecto Alterado de su Habilidad: 30% de probabilidad de ATURDIR al enemigo por 1 turno
        if (Math.random() < 0.35) {
            System.out.print("[" + nombre + " EXTRA] ");
            enemigo.aplicarEstado("aturdido", 1);
        }
    }

    @Override
    public void defender() {
        System.out.println(nombre + " bloquea con escudo.");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("GUERRERO");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Vida: " + vida);
        System.out.println("Experiencia: " + experiencia);
    }

    @Override
    public void subNivel() {
        nivel += 1;
        experiencia += 10;
        vida += 20;
        fuerza += 5;
        System.out.println(nombre + " subió de nivel. NIVEL " + nivel);
    }
}