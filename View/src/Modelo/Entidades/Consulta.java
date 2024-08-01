package Modelo.Entidades;

import java.time.LocalDateTime;
public class Consulta {

    private Integer idQuery;
    private Solicitacao solicitation;
    private AgentePublico publicAgent;
    private Clinica clinic;
    private Medico doctor;
    private LocalDateTime dateAndTimeConsultation;

    public Consulta() {

    }

    public Consulta(Integer idQuery, Solicitacao solicitation, AgentePublico publicAgent, Clinica clinic,
                 Medico doctor, LocalDateTime dateAndTimeConsultation) {
        this.idQuery = idQuery;
        this.solicitation = solicitation;
        this.publicAgent = publicAgent;
        this.clinic = clinic;
        this.doctor = doctor;
        this.dateAndTimeConsultation = dateAndTimeConsultation;
    }

    public Consulta(Solicitacao solicitation, AgentePublico publicAgent, Clinica clinic,
                 Medico doctor, LocalDateTime dateAndTimeConsultation) {
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

    public Solicitacao getSolicitation() {
        return solicitation;
    }

    public void setSolicitation(Solicitacao solicitation) {
        this.solicitation = solicitation;
    }

    public AgentePublico getPublicAgent() {
        return publicAgent;
    }

    public void setPublicAgent(AgentePublico publicAgent) {
        this.publicAgent = publicAgent;
    }

    public Clinica getClinic() {
        return clinic;
    }

    public void setClinic(Clinica clinic) {
        this.clinic = clinic;
    }

    public Medico getDoctor() {
        return doctor;
    }

    public void setDoctor(Medico doctor) {
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

    public void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
