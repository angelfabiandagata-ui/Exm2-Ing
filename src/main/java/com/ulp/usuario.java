
package com.ulp;


public class usuario {
    private String user;
    private int pass;

    public usuario(String user, int pass) {
        this.user = user;
        this.pass = pass;
    }

    public usuario() {
    }

    //Compara ambas contraseñas
    public boolean validarPassword(int contra) {
        return this.pass == contra;
    }

    //Convierte a entero newPass y lo asigna al actual
    public void cambioPassword(String newPass) {
        this.pass = Integer.parseInt(newPass);
        System.out.println("Nuevo Pass " + this.pass);
    }

    // Pone un hilo a dormir. Maneja InterruptedException
    public void delay(int mili) {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            System.out.println("Delay de " + mili + " milisegundos");
        }
    }

    //Retorna si dos objetos usuario son diferentes
    public boolean usuariosDiferentes(usuario u2) {
        if (u2 == null) return true;
        return !this.user.equals(u2.getUser()) || this.pass != u2.getPass();
    }

    public String getUser() { return user; }
    public int getPass() { return pass; }
}