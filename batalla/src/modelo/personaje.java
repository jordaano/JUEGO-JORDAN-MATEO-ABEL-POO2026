package modelo;

public abstract class personaje {

    protected String nombre;
    protected String id;
    protected int vida;
    protected int experiencia;
    protected int nivel;

    public personaje(String nombre, String id, int vida, int experiencia) {
        this.nombre = nombre;
        this.id = id;
        this.vida = vida;
        this.experiencia = experiencia;
        this.nivel = 1;
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
