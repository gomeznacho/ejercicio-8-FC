package nachogom;


import nachogom.candidato.Candidato;
import nachogom.candidato.CandidatosList;
import nachogom.candidato.Presencialidad;
import nachogom.etiqueta.Etiqueta;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        CandidatosList.addCandidato(new Candidato(1,"cand1", "Madrid", "España", "666666", "email@email.email", true, Presencialidad.REMOTO, 2,new ArrayList<Etiqueta>()));
        CandidatosList.addCandidato(new Candidato(2,"cand2", "Valencia","España", "666777", "email2@email.email", false, Presencialidad.MIXTO, 1, new ArrayList<Etiqueta>()));
        CandidatosList.addCandidato(new Candidato(3,"cand3", "Madrid", "España", "666888", "email3@email.email", true, Presencialidad.REMOTO, 1, new ArrayList<Etiqueta>()));
        CandidatosList.addCandidato(new Candidato(4,"cand4", "Barcelona", "España", "666999", "email4@email.email", true, Presencialidad.REMOTO, 3, new ArrayList<Etiqueta>()));
        CandidatosList.addCandidato(new Candidato(5,"cand5", "Barcelona","España", "666999", "email5@email.email", true, Presencialidad.REMOTO, 3, new ArrayList<Etiqueta>()));
        CandidatosList.addCandidato(new Candidato(6,"cand6", "Sevilla","España", "666666", "email6@email.email", true, Presencialidad.REMOTO, 2,new ArrayList<Etiqueta>()));
        CandidatosList.addCandidato(new Candidato(7,"cand7", "Medellín", "Colombia", "666777", "email7@email.email", false, Presencialidad.MIXTO, 1, new ArrayList<Etiqueta>()));
        CandidatosList.addCandidato(new Candidato(8,"cand8", "Kansas", "USA", "666888", "email8@email.email", true, Presencialidad.REMOTO, 1, new ArrayList<Etiqueta>()));
        CandidatosList.addCandidato(new Candidato(9,"cand9", "Madrid", "España", "666999", "email9@email.email", true, Presencialidad.REMOTO, 3, new ArrayList<Etiqueta>()));
        CandidatosList.addCandidato(new Candidato(10,"cand10", "Ciudad de Mexico", "Mexico", "666999", "email10@email.email", true, Presencialidad.REMOTO, 3, new ArrayList<Etiqueta>()));


        CandidatosList.imprimeCiudadesTop();
        CandidatosList.imprimePaisesTop();

    }
}
