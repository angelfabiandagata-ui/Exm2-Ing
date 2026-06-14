/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ulp;

/**
 *
 * @author angel
 */
public class Enemigo {
private int nivelEnergia;

    public Enemigo(int x, int y, int nivelEnergia, int numeroVidas, int capacidadOfensiva) {
        this.nivelEnergia = nivelEnergia;
    }

    public int getNivelEnergia() { return nivelEnergia; }
    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = Math.max(0, nivelEnergia);
    }
}