package org.example.controller;

import org.example.model.Real;
import org.example.model.RealDAO;
import org.example.view.RealView;

import java.util.List;

public class RealController {

        private RealView viewReal;
        private RealDAO realDAO;

        public RealController(){
            this.viewReal = new RealView();;
            this.realDAO = new RealDAO();
        }

        public void afficherReals(){
            List<Real> reals = RealDAO.getReals();
            viewReal.afficheReals(reals);
        }
    }


