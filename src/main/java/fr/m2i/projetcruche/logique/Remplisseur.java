package fr.m2i.projetcruche.logique;

import fr.m2i.projetcruche.model.Cruche;

public class Remplisseur implements Runnable {

    private NumberRandom numberRandom;
    private Cruche cruche;

    public Remplisseur(Cruche cruche) {
        this.cruche = cruche;
        this.numberRandom = new NumberRandom();
    }

    public void run() {
        while(true) {
            synchronized (this.cruche) {
                if(this.cruche.isFull()) {
                    try {
                        this.cruche.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    addWater();
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addWater() {
        int number =number();
        if((this.cruche.getContents() + number) <= this.cruche.getCapacity()) {
            this.cruche.add(number);
            System.out.println("Remplissage - capacité à : " + this.cruche.getContents());
        } else {
            this.cruche.setContents(100);
            System.out.println("Remplissage - capacité bloqué à 100");
        }
    }

    private int number() {
        return this.numberRandom.calcul();
    }

}
