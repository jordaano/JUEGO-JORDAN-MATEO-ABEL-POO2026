package modelo;

/**
 * @author Jordann
 */
public class hechizoEspecial extends habilidad {

    public hechizoEspecial() { 
        // Nombre, Costo de Energía, Cooldown Máximo (3 turnos), Cooldown Inicial (0 = Disponible)
        super("Hechizo Especial", 30, 3, 0);
    }

    @Override
    public void ataqueEspecial(personaje usuario, personaje enemigo) {
        int dano = usuario.getPoderEspecial() * 2;
        System.out.println("¡" + usuario.getNombre() + " lanza su habilidad especial: Hechizo Especial!");
        enemigo.setVida(enemigo.getVida() - dano);
        
        // ACTIVAR COOLDOWN: Asigna los 3 turnos de espera
        this.setCooldownAct(this.getCooldown());
    }
}