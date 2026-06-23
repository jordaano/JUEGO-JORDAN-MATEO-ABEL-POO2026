/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jordann
 */
public class hechizoEspecial extends habilidad {

    

    public hechizoEspecial() { // <--- AQUÍ agregas el public
        super("Hechizo Especial", 30, 3, 0);
    }

    @Override
    public void ataqueEspecial(personaje usuario, personaje enemigo) {
        int dano = usuario.getPoderEspecial() * 2;
        System.out.println(usuario.getNombre() + " lanza Hechizo Especial");
        enemigo.setVida(enemigo.getVida() - dano);
    }

}
