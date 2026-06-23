/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jordann
 */
public class tiroCertero extends habilidad {

    // AHORA

    public tiroCertero() { // <--- AQUÍ agregas el public
        super("Tiro Certero", 15, 1, 0);
    }

    @Override
    public void ataqueEspecial(personaje usuario, personaje enemigo) {
        int dano = usuario.getPoderEspecial() * 2;
        System.out.println(usuario.getNombre() + " usa Tiro Certero");
        enemigo.setVida(enemigo.getVida() - dano);
    }
}

    

