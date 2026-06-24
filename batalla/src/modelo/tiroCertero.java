package modelo;

/**
 * @author Jordann
 */
public class tiroCertero extends habilidad {

    public tiroCertero() { 
        // Nombre, Costo de Energía, Cooldown Máximo (1 turno), Cooldown Inicial (0 = Disponible)
        super("Tiro Certero", 15, 1, 0);
    }

    @Override
    public void ataqueEspecial(personaje usuario, personaje enemigo) {
        int dano = usuario.getPoderEspecial() * 2;
        System.out.println("¡" + usuario.getNombre() + " usa su habilidad especial: Tiro Certero!");
        enemigo.setVida(enemigo.getVida() - dano);
        
        // ACTIVAR COOLDOWN: Asigna el turno de espera
        this.setCooldownAct(this.getCooldown());
    }
}