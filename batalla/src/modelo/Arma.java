package modelo;

public class Arma extends Objeto {

    private String tipoDano;

    public Arma(String nombre, int modificador, String tipoDano) {
        super(nombre, modificador);
        this.tipoDano = tipoDano;
    }

    public String getTipoDano() {
        return tipoDano;
    }

    @Override
    public void descripcion() {
        System.out.println("  [ARMA] " + nombre + " | Daño extra: +" + modificador + " | Tipo: " + tipoDano);
    }
}
