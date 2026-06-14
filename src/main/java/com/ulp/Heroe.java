/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ulp;

/**
 *
 * @author angel
 */
public class Heroe {
private int nivelEnergia;

    public Heroe(int x, int y, int nivelEnergia, int numeroVidas, int capacidadOfensiva) {
        this.nivelEnergia = nivelEnergia;
    }

    public void ataque(int dano, Enemigo enemigo) {
        int nuevaVida = enemigo.getNivelEnergia() - dano;
        enemigo.setNivelEnergia(nuevaVida);
    }

    public void curarVida(Comida comida) {
        if (comida == null) throw new NullPointerException();
        this.nivelEnergia += comida.getCantidadVidaCurada();
    }

    public int getNivelEnergia() { return nivelEnergia; }
}