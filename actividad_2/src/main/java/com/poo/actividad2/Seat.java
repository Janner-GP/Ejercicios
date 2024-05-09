package com.poo.actividad2;
/**
 * Seat class, used to manage all the information related to the seat
 */
public class Seat {

    /*Attributes*/
    private char letter;
    private int row;
    private Viewer viewer; // Information of the viewer sitting, null if empty

    /*Constructors*/
    public Seat(char letter, int row) {
        this.letter = letter;
        this.row = row;
        this.viewer = null; // When initializing the seat, no one will be sitting on it
    }

    /*Methods*/
    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    /**
     * Indicates if the seat is occupied
     *
     * @return true if occupied, false otherwise
     */
    public boolean isOccupied() {
        return viewer != null;
    }

    @Override
    public String toString() {
        if (isOccupied()) {
            return "Asiento: " + row + letter + " asignado a " + viewer;
        }

        return "Asiento: " + row + letter + " está vacío";
    }
}
