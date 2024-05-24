package org.example.view;

import org.example.model.Real;

import java.util.List;

public class RealView {



        public void afficheReals(List<Real> reals) {
            System.out.println("\n Liste des Reals:");
            for (Real real : reals) {
                System.out.println("ID: " + real.getId() +
                        ", Prenom: " + real.getPrenom() +
                        ", Nom: " + real.getNom());
            }
            System.out.println("\n");
        }


}
