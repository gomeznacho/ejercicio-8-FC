package nachogom.candidato;

import nachogom.etiqueta.Etiqueta;
import nachogom.repositories.CandidatosRepo;

import java.util.*;

public class CandidatosList {
    public static void addCandidato(Candidato candidato){
        CandidatosRepo.candidatosRepository.add(candidato);
    }

    public static void deleteCandidatoById(int id){
       Candidato c = CandidatosRepo.findById(id);
       CandidatosRepo.candidatosRepository.remove(c);
    }

    public ArrayList<Candidato> filtrar(String ciudad){
        ArrayList<Candidato> porCiudad = new ArrayList<>();
        for(Candidato c : CandidatosRepo.candidatosRepository){
            if (c.getCiudad().equals(ciudad))
                porCiudad.add(c);
        }
        return porCiudad;
    }


    public static ArrayList<Candidato> filtrar(boolean tipoTraslado){
        ArrayList<Candidato> porMovilidad = new ArrayList<>();
        for(Candidato c : CandidatosRepo.candidatosRepository){
            if (c.isMovilidad())
                porMovilidad.add(c);
        }
        return porMovilidad;
    }
    public static ArrayList<Candidato> filtrarPresen(String presencialidad){
        ArrayList<Candidato> porPresencialidad = new ArrayList<>();
        for(Candidato c : CandidatosRepo.candidatosRepository){
            if(c.getPresencialidad().toString().contains(presencialidad))
                porPresencialidad.add(c);
        }

        return porPresencialidad;
    }

    public static ArrayList<Candidato> filtrar(Etiqueta etiqueta){
        ArrayList<Candidato> porEtiqeta = new ArrayList<>();
        for(Candidato c : CandidatosRepo.candidatosRepository) {
            if (c.etiquetas.contains(etiqueta))
                porEtiqeta.add(c);
        }
        return porEtiqeta;
    }

    public static ArrayList<Candidato> filtrar(String ciudad, String presencialidad, boolean tipoTraslado){
        ArrayList<Candidato> porCiudadPresenTras = new ArrayList<>();
        String presen= "Presencialidad." + presencialidad.toUpperCase();
        for(Candidato c : CandidatosRepo.candidatosRepository){
            if ((c.getCiudad().equals(ciudad) && c.getPresencialidad().equals(presen)) || c.isMovilidad())
                porCiudadPresenTras.add(c);
        }
        return porCiudadPresenTras;
    }

    public static Candidato buscarEmail(String email) {
        for (Candidato c : CandidatosRepo.candidatosRepository) {
            if (c.getEmail().equals(email)) ;
            System.out.println(c);
            return c;
        }
        System.out.println("No existe un candidato con ese email");
        return null;
    }
    public static Candidato buscarTelefono(String telefono) {
        for (Candidato c : CandidatosRepo.candidatosRepository) {
            if (c.getTelefono().equals(telefono)) ;
            return c;
        }
        System.out.println("No existe un candidato con ese teléfono");
        return null;
    }

    public static void imprimeCiudadesTop(){
        String ciudadesContadas = "";
        HashMap<String, Integer> ciudadesTop = new HashMap<>();
        for(int i = 0; i<CandidatosRepo.candidatosRepository.size(); i++){
            String ciudad = CandidatosRepo.candidatosRepository.get(i).getCiudad();
            if(!ciudadesContadas.contains(ciudad)){
                int cuenta = 0;
                ciudadesContadas = ciudadesContadas + ciudad;
                for(Candidato c : CandidatosRepo.candidatosRepository){
                    if(c.getCiudad().equals(ciudad)){
                        cuenta++;
                    }
                }
                ciudadesTop.put(ciudad, cuenta);
            }

            }
        System.out.println("lista de ciudades top: \n");
        HashMap<String, Integer> finalMap = ordenarMapa(ciudadesTop);
        for (Map.Entry<String, Integer> en : finalMap.entrySet()) {
            System.out.println(en.getKey() + " => " + en.getValue());
        }
        System.out.println("====================================");


    }
    public static void imprimePaisesTop(){
        String paisesContado = "";
        HashMap<String, Integer> paisesTop = new HashMap<>();
        for(int i = 0; i<CandidatosRepo.candidatosRepository.size(); i++){
            String pais = CandidatosRepo.candidatosRepository.get(i).getPais();
            if(!paisesContado.contains(pais)){
                int cuenta = 0;
                paisesContado = paisesContado + pais;
                for(Candidato c : CandidatosRepo.candidatosRepository){
                    if(c.getPais().equals(pais)){
                        cuenta++;
                    }
                }
                paisesTop.put(pais, cuenta);
            }

        }
        System.out.println("Lista de países top: \n");
        HashMap<String, Integer> finalMap = ordenarMapa(paisesTop);
        for (Map.Entry<String, Integer> en : finalMap.entrySet()) {
            System.out.println(en.getKey() + " => " + en.getValue());
        }
        System.out.println("========================");
    }

    public static int totalRemotos(){
        int cuenta = 0;
        for(Candidato c : CandidatosRepo.candidatosRepository){
            if(c.getPresencialidad() == Presencialidad.REMOTO)
                cuenta++;
        }
        return cuenta;
    }

    public static int totalPosibilidadTraslado(){
        int cuenta = 0;
        for(Candidato c : CandidatosRepo.candidatosRepository){
            if(c.isMovilidad())
                cuenta++;
        }
        return cuenta;
    }
    public static int totalPresencialSinTraslado(){
        int cuenta = 0;
        for(Candidato c : CandidatosRepo.candidatosRepository){
            if(c.getPresencialidad() == Presencialidad.PRESENCIAL && !c.isMovilidad())
                cuenta++;
        }
        return cuenta;
    }

    public static HashMap<String, Integer> ordenarMapa(HashMap<String, Integer> hashMap){

        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(hashMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> hshMap2 = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            hshMap2.put(aa.getKey(), aa.getValue());
        }
        return hshMap2;
    }
}
