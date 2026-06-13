/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ulp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class parameterUserTest_1 {

    static Stream<Object[]> datosPass() {
        return Stream.of(
            new Object[]{ "1234", 1234 },   
            new Object[]{ "123", 1234 },   
            new Object[]{ "'1234'", 1234 }  
        );
    }

    @ParameterizedTest
    @MethodSource("datosPass") 
    public void testCambioPass(String valorActual, int valorEsperado) {
        System.out.println("Probando cambio de contraseña con parametro: " + valorActual);
        
        usuario usr = new usuario("Juanjo", 1212);
        
        usr.cambioPassword(valorActual);
        
        assertEquals(valorEsperado, usr.getPass());
    }
}