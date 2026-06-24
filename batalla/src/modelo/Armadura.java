package modelo;

public class Armadura extends Objeto {

    private String tipoProteccion;

    public Armadura(String nombre, int modificador, String tipoProteccion) {
        super(nombre, modificador);
        this.tipoProteccion = tipoProteccion;
    }

    public String getTipoProteccion() {
        return tipoProteccion;
    }

    @Override
    public void descripcion() {
        System.out.println("  [ARMADURA] " + nombre + " | Defensa extra: +" + modificador + " | Tipo: " + tipoProteccion);
    }
}
