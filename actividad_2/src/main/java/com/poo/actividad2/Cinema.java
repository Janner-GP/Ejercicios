package com.poo.actividad2;

/**
 * Cinema class, manages all the cinema-related information
 */
public class Cinema {

    /*Attributes*/
    private Seat seats[][];
    private double price;
    private Movie movie;

    /*Constructor*/
    public Cinema(int rows, int columns, double price, Movie movie) {
        seats = new Seat[rows][columns];
        this.price = price;
        this.movie = movie;
        fillSeats();
    }

    /*Methods*/
    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Fills the seats with row and letter
     */
    private void fillSeats() {
        int row = seats.length;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                // Remember that chars can be added
                seats[i][j] = new Seat((char) ('A' + j), row);
            }
            row--; // Decrease the row to update the row
        }
    }

    /**
     * Checks if there is a seat available in the cinema
     *
     * @return true if available, false otherwise
     */
    public boolean hasAvailableSeat() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if (!seats[i][j].isOccupied()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a specific seat is available
     *
     * @param row
     * @param letter
     * @return true if available, false otherwise
     */
    public boolean hasAvailableSeatAt(int row, char letter) {
        return getSeat(row, letter).isOccupied();
    }

    /**
     * Checks if a viewer meets the necessary requirements to enter the cinema
     *
     * @param viewer
     * @return true if meets the requirements, false otherwise
     */
    public boolean canSit(Viewer viewer) {
        return viewer.hasEnoughMoney(price) && viewer.isOldEnough(movie.getMinAge());
    }

    /**
     * Seats a viewer in a specific seat
     *
     * @param row
     * @param letter
     * @param viewer
     */
    public void seatViewer(int row, char letter, Viewer viewer) {
        getSeat(row, letter).setViewer(viewer);
    }

    /**
     * Retrieves a specific seat by row and letter
     *
     * @param row
     * @param letter
     * @return the seat object
     */
    public Seat getSeat(int row, char letter) {
        return seats[seats.length - row - 1][letter - 'A'];
    }

    /**
     * Returns the number of rows in the cinema
     *
     * @return number of rows
     */
    public int getRows() {
        return seats.length;
    }

    /**
     * Returns the number of columns in the cinema
     *
     * @return number of columns
     */
    public int getColumns() {
        return seats[0].length;
    }

    /**
     * Displays the information of the cinema
     */
    public void display() {
        System.out.println("Información del cine:");
        System.out.println("Pelicula: " + movie);
        System.out.println("Precio de entrada: " + price);
        System.out.println("");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                System.out.println(seats[i][j]);
            }
            System.out.println("");
        }
    }
}
