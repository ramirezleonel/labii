package Naval;

import java.util.Scanner;

public class Proyecto {

    public static char matriz[][] = new char[8][8];
    public static int contador = 0;
    public static Scanner tec;

    public static int recorrerTablero() {
        int contador = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j] == '1') {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static void dimensiones(int pos1, int pos2) {
        char teclado;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz[pos1][pos2] == '1') {
                    System.out.println("Quiere que las dimensiones del barco se"
                            + "extienda horizontal o vertical:'H' O 'V'");
                    teclado = tec.next().toLowerCase().charAt(0);
                    if (teclado == 'h') {
                        System.out.println("si quiere arriba presione :'Y' o sino 'N'");
                        teclado = tec.next().toLowerCase().charAt(0);
                        if (teclado == 'y') {
                            matriz[2][3] = '1';
                        } else if (teclado == 'n') {
                               matriz[pos1][pos2 + 1] = '1';     
                        }
                    }
                }
            }
        }

    }

    public static boolean encontrado(int pos1, int pos2) {
        if (matriz[pos1][pos2] == '1') {
            return true;
        } else {
            return false;
        }
    }

    public static void mostrarTablero() {
        System.out.println(" --0--1--2--3--4--5--6--7--");
        char a = 'A';
        for (int i = 0; i < 8; i++) {
            if (i != 0) {
                System.out.println("||");
            }
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j] == '1') {
                }
                if (j == 0) {
                    System.out.print(a);
                    a++;
                }
                System.out.print("||" + matriz[i][j]);
            }
        }
        System.out.println("||");
    }

    public static void atacarJugador2() {
        int pos1, pos2;
        System.out.println("Jugador 2: Ataque a su oponente:");
        pos1 = tec.nextInt();
        pos2 = tec.nextInt();
        if (matriz[pos1][pos2] == '1') {
            System.out.println("haz dado en el blanco");
            matriz[pos1][pos2] = 'x';
        } else if (matriz[pos1][pos2] == 0) {
            System.out.println("Erraste,seguí intentandolo");
            matriz[pos1][pos2] = '-';
        }
        mostrarTablero();
    }

    public static void posicionBarco() {
        int p = 4, pos1, pos2;

        while (p > 0) {
            System.out.println("jugador escoja la posicion del barco:");
            tec = new Scanner(System.in);
            pos1 = tec.nextInt();
            System.out.println("jugador escoja la 2 posicion del barco:");
            pos2 = tec.nextInt();
            if (encontrado(pos1, pos2) == false) {

                for (int i = 0; i <= 7; i++) {
                    for (int j = 0; j <= 7; j++) {
                        matriz[pos1][pos2] = '1';
                    }
                }
                p--;
            } else {
                System.out.print("Ya existe un barco en esa posicion \n");
            }
        }
    }

    public static void main(String[] args) {

        Proyecto proy = new Proyecto();
        proy.mostrarTablero();
        proy.posicionBarco();
        proy.mostrarTablero();
        contador = proy.recorrerTablero();
        while (contador > 0) {

            proy.atacarJugador2();
            contador = proy.recorrerTablero();

        }
        System.out.println("HAZ GANADO");
    }
}
