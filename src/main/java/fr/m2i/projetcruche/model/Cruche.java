package fr.m2i.projetcruche.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Cruche {

    private int capacity;
    private int contents;

    public Cruche() {
        this.capacity = 100;
        this.contents = 0;
    }

    public void add(int number) {
        this.setContents(this.getContents() + number);
    }

    public void remove(int number) {
        this.setContents(this.getContents() - number);
    }

    public boolean isFull() {
        return (this.getCapacity() == this.getContents());
    }

}
