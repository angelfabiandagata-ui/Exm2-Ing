package com.ulp;

import java.time.Duration;
import java.time.LocalDate;
import java.util.function.Supplier;
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
public class usuarioTest {
    
    private static usuario usr;
    private static int contadorTest = 1;
    
    public usuarioTest() {
    }
    
    @BeforeAll
   public static void antesDeTodo() {
        usr = new usuario("Juanjo", 1212);
        System.out.println("TEST de usuario");
    }
    
    @AfterAll
    public static void despuesDeTodo() {
        LocalDate ayer = LocalDate.now().minusDays(1);
        System.out.println("Fin de las pruebas " + ayer);
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("----------------------------------------");
        System.out.println("Ejecutando Test Numero: " + contadorTest);
        contadorTest++;
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("----------------------------------------");
    }

    @Test
    public void testValidarUsr() {
        System.out.println("validarPassword");
        boolean resultado = usr.validarPassword(2222);
        assertTrue(resultado); 
    }

    @Test
    public void testValidarEmail() {
        String email = "juanjo@gmail.com"; 
        boolean tieneArrobaYPuntoYMenosDe20 = email.contains("@") && email.contains(".") && email.length() < 20;
        assertTrue(tieneArrobaYPuntoYMenosDe20);
    }
    
    
    
    @Test
    public void testCambioPass() {
        System.out.println("cambiopass");
        String newPass = "1234";
        usr.cambioPassword(newPass);
        assertEquals(1234, usr.getPass());
    }

    @Test
    public void testDelay() {
        System.out.println("delay");
        
        assertTimeoutPreemptively(Duration.ofMillis(30), () -> {
            usr.delay(50); 
        });
    }

    @Test
    public void testUsuariosDiferentes() {
        usuario u1 = new usuario("Pedro", 5555);
        usuario u2 = new usuario("Ana", 7777);
        
        boolean sonDiferentes = u1.usuariosDiferentes(u2);
        
        assertNotSame(u1, u2, "mismo usuario"); 
        
        System.out.println("UsuariosDiferentes? " + !sonDiferentes);
    }
}


    

