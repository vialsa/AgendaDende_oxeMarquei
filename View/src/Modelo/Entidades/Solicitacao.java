package Modelo.Entidades;

public class Solicitacao {
    private Integer idSolicitation;
    private String CRM;
    private String request;
    private String nameOfRequestDoctor;
    private String speciality;
    private Paciente patient;

    public Solicitacao() {

    }
    public Solicitacao(Integer idSolicitation, String CRM, String request, String nameOfRequestDoctor, Paciente patient) {
        this.idSolicitation = idSolicitation;
        this.CRM = CRM;
        this.request = request;
        this.nameOfRequestDoctor = nameOfRequestDoctor;
        this.patient = patient;
    }
    public Solicitacao(String CRM, String request, String nameOfRequestDoctor, Paciente patient) {
        this.CRM = CRM;
        this.request = request;
        this.nameOfRequestDoctor = nameOfRequestDoctor;
        this.patient = patient;
    }

    public Integer getIdSolicitation() {
        return idSolicitation;
    }

    public void setIdSolicitation(Integer idSolicitation) {
        this.idSolicitation = idSolicitation;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getNameOfRequestDoctor() {
        return nameOfRequestDoctor;
    }

    public void setNameOfRequestDoctor(String nameOfRequestDoctor) {
        this.nameOfRequestDoctor = nameOfRequestDoctor;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Paciente getPatient() {
        return patient;
    }

    public void setPatient(Paciente patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "Solicitação: " + this.getIdSolicitation() + "\n" +
                "CRM do Médico Solicitante: " + this.getCRM() + "\n" +
                "Pedido: " + this.getRequest() + "\n" +
                "Nome do Médico do Pedido: " + this.getNameOfRequestDoctor() + "\n" +
                "Especialidade: " + this.getSpeciality();
    }
}
