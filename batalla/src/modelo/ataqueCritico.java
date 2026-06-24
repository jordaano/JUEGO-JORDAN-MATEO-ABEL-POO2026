package modelo;

public class ataqueCritico extends habilidad {

    public ataqueCritico() { // <--- AQUÍ agregas el public
        super("Ataque Critico", 20, 2, 0);
    }

    @Override
    public void ataqueEspecial(personaje usuario, personaje enemigo) {
        int dano = usuario.getPoderEspecial() * 2;
        System.out.println(usuario.getNombre() + " usa Ataque Crítico");
        enemigo.setVida(enemigo.getVida() - dano);
    }

 
}
