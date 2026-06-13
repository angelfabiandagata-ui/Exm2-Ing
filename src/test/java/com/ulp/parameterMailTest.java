/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ulp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class parameterMailTest {


    static Stream<Object[]> datosMail() {
        return Stream.of(
            new Object[]{ "jorgesys@tototita.com", true },   
            new Object[]{ "jorgesys@tototitacom", false },   
            new Object[]{ "jorgesystototita.com", false },   
            new Object[]{ "@jorgesystototita.com", false },  
            new Object[]{ ".jorgesystototita@com", false }   
        );
    }


    public static boolean ValidarMail(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)(\\.[A-Za-z]{2,})?$"); 
        Matcher mather = pattern.matcher(email); 
        return mather.find();
    }


    @ParameterizedTest
    @MethodSource("datosMail") 
    public void testValidarEmail(String email, boolean resultadoEsperado) {
        System.out.println("Validando Mail: " + email + "  "+ resultadoEsperado);
        assertEquals(resultadoEsperado, ValidarMail(email)); 
    }
}