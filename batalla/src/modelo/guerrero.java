package modelo;

public class guerrero extends personaje {

    private int fuerza;

public guerrero(String nombre, String id, int vida, int experiencia, habilidad habilidadEspecial) {
        super(nombre, id, vida, experiencia, habilidadEspecial); // Se envía al padre
        this.fuerza = 15;
    }

    
    
    

    @Override
    public void atacar(personaje enemigo) {
        System.out.println(nombre + " ataca con espada");
        enemigo.vida -= fuerza;
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
        System.out.println(nombre + " subió de nivel. NIVEL "+nivel);
    }
    
    @Override
    public int getPoderEspecial() {
        return fuerza;
    }


}
