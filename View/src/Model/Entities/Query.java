package Model.Entities;

import java.time.LocalDateTime;
public class Query {

    private Integer idQuery;
    private Solicitation solicitation;
    private PublicAgent publicAgent;
    private Clinic clinic;
    private Doctor doctor;
    private LocalDateTime dateAndTimeConsultation;

    public Query() {

    }

    public Query(Integer idQuery, Solicitation solicitation, PublicAgent publicAgent, Clinic clinic,
                 Doctor doctor, LocalDateTime dateAndTimeConsultation) {
        this.idQuery = idQuery;
        this.solicitation = solicitation;
        this.publicAgent = publicAgent;
        this.clinic = clinic;
        this.doctor = doctor;
        this.dateAndTimeConsultation = dateAndTimeConsultation;
    }

    public Query(Solicitation solicitation, PublicAgent publicAgent, Clinic clinic,
                 Doctor doctor, LocalDateTime dateAndTimeConsultation) {
        this.solicitation = solicitation;
        this.publicAgent = publicAgent;
        this.clinic = clinic;
        this.doctor = doctor;
        this.dateAndTimeConsultation = dateAndTimeConsultation;
    }

    public Integer getIdQuery() {
        return idQuery;
    }

    public void setIdQuery(Integer idQuery) {
        this.idQuery = idQuery;
    }

    public Solicitation getSolicitation() {
        return solicitation;
    }

    public void setSolicitation(Solicitation solicitation) {
        this.solicitation = solicitation;
    }

    public PublicAgent getPublicAgent() {
        return publicAgent;
    }

    public void setPublicAgent(PublicAgent publicAgent) {
        this.publicAgent = publicAgent;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDateAndTimeConsultation() {
        return dateAndTimeConsultation;
    }

    public void setDateAndTimeConsultation(LocalDateTime dateAndTimeConsultation) {
        this.dateAndTimeConsultation = dateAndTimeConsultation;
    }

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "Consulta: " + this.getIdQuery() + "\n" +
                "Nome do Paciente: " + this.solicitation.getPatient().getName() + "\n" +
                "Motivo do Pedido: " + this.solicitation.getRequest() + "\n" +
                "Nome do Médico do Pedido: " + this.solicitation.getNameOfRequestDoctor()+ "\n" +
                "CRM do Médico do Pedido: " + this.solicitation.getCRM() + "\n" +
                "Clinica: " + this.clinic.getNameOfClinic() + "\n" +
                "Endereco: " + this.clinic.getAddress() + "\n" +
                "Data e Hora da Consulta: " + this.getDateAndTimeConsultation() + "\n" +
                "Médico da Consulta: " + this.getDoctor().getName() + "\n" +
                "Especialidade: " + this.solicitation.getRequest();
    }
}
