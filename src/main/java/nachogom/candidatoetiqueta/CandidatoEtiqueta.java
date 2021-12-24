package nachogom.candidatoetiqueta;

public class CandidatoEtiqueta {
    private int candidatoId;
    private int etiquetaId;
    private int nivel;

    public CandidatoEtiqueta(int candidatoId, int etiquetaId, int nivel) {
        this.candidatoId = candidatoId;
        this.etiquetaId = etiquetaId;
        this.nivel = nivel;
    }

    public int getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(int candidatoId) {
        this.candidatoId = candidatoId;
    }

    public int getEtiquetaId() {
        return etiquetaId;
    }

    public void setEtiquetaId(int etiquetaId) {
        this.etiquetaId = etiquetaId;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
