package fr.m2i.projetcruche;

import fr.m2i.projetcruche.logique.Remplisseur;
import fr.m2i.projetcruche.logique.Videur;
import fr.m2i.projetcruche.model.Cruche;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetCrucheApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetCrucheApplication.class, args);

        Cruche cruche = new Cruche();
        Videur videur = new Videur(cruche);
        Videur videur2 = new Videur(cruche);
        Remplisseur remplisseur = new Remplisseur(cruche);
        Remplisseur remplisseur2 = new Remplisseur(cruche);

        new Thread(videur).start();
        new Thread(remplisseur).start();
        new Thread(videur2).start();
        new Thread(remplisseur2).start();

    }

}
