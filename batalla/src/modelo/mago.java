
package modelo;

public class mago extends personaje {
    private int magia;
    public mago(String nombre, String id, int vida, int experiencia) {
        super(nombre, id, vida, experiencia);
        this.magia = 20;
    }
    @Override
    public void atacar(personaje enemigo) {
        System.out.println(nombre + " lanza un hechizo.");
        enemigo.vida -= magia;
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
        System.out.println(nombre + " subió de nivel. NIVEL "+nivel);    }


}
