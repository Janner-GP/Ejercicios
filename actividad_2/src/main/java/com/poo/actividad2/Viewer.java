package com.poo.actividad2;

/**
 * Viewer class, manages all the information related to the viewer
 */
public class Viewer {

    /*Attributes*/
    private String name;
    private int age;
    private double money;
    private double cashBack;

    /*Constructors*/
    public Viewer(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    /*Methods*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getCashBack() {
        return cashBack;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    /**
     * Pays for the cinema ticket
     *
     * @param price
     */
    public boolean pay(double price) {
        return (money - price) >= 0;
    }

    /**
     * Indicates if the viewer is old enough to watch the movie
     *
     * @param minAge
     * @return true if old enough, false otherwise
     */
    public boolean isOldEnough(int minAge) {
        return age >= minAge;
    }

    /**
     * Indicates if the viewer has enough money for the ticket
     *
     * @param ticketPrice
     * @return true if has enough money, false otherwise
     */
    public boolean hasEnoughMoney(double ticketPrice) {
        return money >= ticketPrice;
    }

    public void cashBack(double ticketPrice) {
        this.cashBack = money - ticketPrice;
    }

    @Override
    public String toString() {
        return name + ", edad: " + age + " y tiene " + cashBack + " USD para los mekatos ";
    }
}
