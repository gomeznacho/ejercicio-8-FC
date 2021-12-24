package nachogom.repositories;

import nachogom.candidato.Candidato;

import java.util.ArrayList;

public class CandidatosRepo {
    public static ArrayList<Candidato> candidatosRepository = new ArrayList<>();
    public static Candidato findById(int id){
        for(Candidato c : candidatosRepository){
            if(c.getCandidatoId() == id)
                return c;
        }
        return null;
    }
}
