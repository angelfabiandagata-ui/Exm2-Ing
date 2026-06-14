/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ulp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author angel
 */
public class HeroeTest {

    //PERSONAJE COMBATE CON OTRO Y RESTA VIDA
    //CASO A
    @Test
    public void testGolpeRestaVidaSinMorir() {
        Heroe heroe = new Heroe(0, 0, 100, 1, 0);
        Enemigo enemigo = new Enemigo(0, 0, 100, 1, 0); 
        
        heroe.ataque(20, enemigo); 
        
        assertEquals(80, enemigo.getNivelEnergia());
    }
    //CASO B
    @Test
    public void testGolpeMataEnemigo() {
        Heroe heroe = new Heroe(0, 0, 100, 1, 0);
        Enemigo enemigo = new Enemigo(0, 0, 30, 1, 0); 
        
        heroe.ataque(30, enemigo); 
        
        assertEquals(0, enemigo.getNivelEnergia());
    }
    //CASO C
    @Test
    public void testGolpeExcesivoNoBajaDeCero() {
        Heroe heroe = new Heroe(0, 0, 100, 1, 0);
        Enemigo enemigo = new Enemigo(0, 0, 10, 1, 0); 
        
        heroe.ataque(50, enemigo); 
        
        assertEquals(0, enemigo.getNivelEnergia());
    }
    //CASO D
    @Test
    public void testCurarVida() {
        Heroe heroe = new Heroe(0, 0, 30, 1, 0); 
        Comida manzana = new Comida(0, 0, 15, 1); 
        
        heroe.curarVida(manzana);
        
        assertEquals(45, heroe.getNivelEnergia());
    }
    //CASO E
    @Test
    public void testNoPuedeCurarse() {
        Heroe heroe = new Heroe(0, 0, 30, 1, 0);
        Comida comidaNula = null; 
        
        assertThrows(NullPointerException.class, () -> {
            heroe.curarVida(comidaNula);
        });
    }

    //GUARDAR OBJETO EN MOCHILA (N=3)

    //CASO A
    @Test
    public void testGuardarObjetosHastaLímite() {
        Mochila mochila = new Mochila(); 
        Comida item1 = new Comida(0, 0, 10, 1);
        Comida item2 = new Comida(0, 0, 10, 1);
        Comida item3 = new Comida(0, 0, 10, 1);
        
        assertTrue(mochila.guardarEnMochila(item1));
        assertTrue(mochila.guardarEnMochila(item2));
        assertTrue(mochila.guardarEnMochila(item3));
    }
    //CASO B
    @Test
    public void testRechazarGuardarAlSuperarLímite() {
        Mochila mochila = new Mochila();
        Comida item1 = new Comida(0, 0, 10, 1);
        Comida item2 = new Comida(0, 0, 10, 1);
        Comida item3 = new Comida(0, 0, 10, 1);
        Comida item4 = new Comida(0, 0, 10, 1);
        
        mochila.guardarEnMochila(item1);
        mochila.guardarEnMochila(item2);
        mochila.guardarEnMochila(item3); 
        
        boolean resultadoCuarto = mochila.guardarEnMochila(item4);
        
        assertFalse(resultadoCuarto); 
        assertEquals(3, mochila.getCantidadActual()); 
    }
    //CASO C
    @Test
    public void testAmpliarCapacidadPermiteMasObjetos() {
        Mochila mochila = new Mochila();
        Comida item1 = new Comida(0, 0, 10, 1);
        Comida item2 = new Comida(0, 0, 10, 1);
        Comida item3 = new Comida(0, 0, 10, 1);
        Comida item4 = new Comida(0, 0, 10, 1);
        
        mochila.guardarEnMochila(item1);
        mochila.guardarEnMochila(item2);
        mochila.guardarEnMochila(item3); 
        
        mochila.ampliarCapacidad(5); 
        
        assertTrue(mochila.guardarEnMochila(item4)); 
        assertEquals(4, mochila.getCantidadActual()); 
    }
}