package com.poo.actividad2;

import java.util.Scanner;

/**
 * Main class, contains the main method to run the program
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Movie movie = new Movie("BeeKeeper", 105, 16, "Amazom MGM Studios");

        System.out.println("Introduce el número de filas del cine:");
        int rows = scanner.nextInt();

        System.out.println("Introduce el número de columnas del cine:");
        int columns = scanner.nextInt();

        System.out.println("Introduce el precio de la entrada de cine en USD:");
        double price = scanner.nextDouble();

        Cinema cinema = new Cinema(rows, columns, price, movie);

        System.out.println("Introduce el número de espectadores a crear:");
        int numViewers = scanner.nextInt();
        System.out.println(numViewers);

        System.out.println("Espectadores generados:");
        for (int i = 0; i < numViewers && cinema.hasAvailableSeat(); i++) {
            Viewer viewer = new Viewer(Utils.names[Utils.generateRandomInteger(0, Utils.names.length - 1)],
                                       Utils.generateRandomInteger(12, 30),
                                       Utils.generateRandomInteger(10, 100));
            // La siguiente linea es en caso de validar uno a uno los espectadores
            // System.out.println(viewer);
            viewer.cashBack(price);

            int row, col;
            do {
                row = Utils.generateRandomInteger(0, cinema.getRows() - 1);
                col = Utils.generateRandomInteger(0, cinema.getColumns() - 1);
            } while (cinema.hasAvailableSeatAt(row, (char) ('A' + col)));

            if (cinema.canSit(viewer)) {
                boolean isValid = viewer.pay(cinema.getPrice());
                if (isValid) {
                    cinema.seatViewer(row, (char) ('A' + col), viewer);
                }
            }
        }

        System.out.println("");
        cinema.display();

        System.out.println("Fin del programa");

        scanner.close();
    }
}
