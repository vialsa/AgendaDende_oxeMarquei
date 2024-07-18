package Model.Entities;

public class Solicitation {
    private Integer idSolicitation;
    private String CRM;
    private String request;
    private String nameOfRequestDoctor;
    private String speciality;
    private Patient patient;

    public Solicitation() {

    }
    public Solicitation(Integer idSolicitation, String CRM, String request, String nameOfRequestDoctor, Patient patient) {
        this.idSolicitation = idSolicitation;
        this.CRM = CRM;
        this.request = request;
        this.nameOfRequestDoctor = nameOfRequestDoctor;
        this.patient = patient;
    }
    public Solicitation(String CRM, String request, String nameOfRequestDoctor, Patient patient) {
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
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
