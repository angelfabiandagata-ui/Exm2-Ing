/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ulp;

import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class Mochila {
 private int capacidadMaxima = 3;
    private ArrayList<Object> contenido = new ArrayList<>();

    public boolean guardarEnMochila(Object cosa) {
        if (contenido.size() < capacidadMaxima) {
            contenido.add(cosa);
            return true;
        }
        return false;
    }

    public void ampliarCapacidad(int nuevaCapacidad) {
        this.capacidadMaxima = nuevaCapacidad;
    }

    public int getCantidadActual() { return contenido.size(); }
}