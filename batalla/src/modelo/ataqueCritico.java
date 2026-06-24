package modelo;

public class ataqueCritico extends habilidad {

    public ataqueCritico() { 
        // Nombre, Costo de Energía, Cooldown Máximo (2 turnos), Cooldown Inicial (0 = Disponible)
        super("Ataque Critico", 20, 2, 0);
    }

    @Override
    public void ataqueEspecial(personaje usuario, personaje enemigo) {
        // 1. Calculamos el daño bicantenario
        int dano = usuario.getPoderEspecial() * 2;
        System.out.println("¡" + usuario.getNombre() + " usa su habilidad especial: Ataque Crítico!");
        
        // 2. Aplicamos el daño al enemigo
        enemigo.setVida(enemigo.getVida() - dano);
        
        // 3. CRUCIAL: Activamos el cooldown para que no pueda usarlo el próximo turno
        // Le asignamos el cooldown máximo (en este caso, 2)
        this.setCooldownAct(this.getCooldown()); 
        
        // Nota: Asegúrate de que en tu clase Personaje, el método usarHabilidadEspecial 
        // también le reste los 20 de energía (this.getCostoEnergia()) al usuario.
    }
}