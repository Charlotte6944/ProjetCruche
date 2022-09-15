package fr.m2i.projetcruche.logique;

import fr.m2i.projetcruche.model.Cruche;

public class Videur implements Runnable {

    private NumberRandom numberRandom;
    private Cruche cruche;

    public Videur(Cruche cruche) {
        this.cruche = cruche;
        this.numberRandom = new NumberRandom();
    }

    public void run() {
        while(true) {
            synchronized (this.cruche) {
                if(this.cruche.isFull()) {
                    remove();
                    this.cruche.notifyAll();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void remove() {
        int number =number();
        this.cruche.remove(number);
        System.out.println("Vidange - capacité à : " + this.cruche.getContents());
    }

    private int number() {
        return this.numberRandom.calcul();
    }
}
