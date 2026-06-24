
package modelo;

public class arquero extends personaje{
    private int precision;

    public arquero(String nombre, String id, int vida, int experiencia, habilidad habilidadEspecial) {
        super(nombre, id, vida, experiencia, habilidadEspecial); // Se envía al padre
        this.precision = 10;
    }

    

    @Override
    public void atacar(personaje enemigo) {
        System.out.println(nombre + " dispara una flecha.");
        enemigo.vida -= precision;
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
        System.out.println(nombre + " subió de nivel. NIVEL "+nivel);
    }
    @Override
    public int getPoderEspecial() {
    return precision;
    }


    
}
