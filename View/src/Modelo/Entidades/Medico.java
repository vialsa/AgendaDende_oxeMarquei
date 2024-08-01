package Modelo.Entidades;
import java.time.LocalDate;

public class Medico extends Pessoa{
    int idDoctor;
    String CRM;
    String speciality;
    String status;
    Clinica clinic;

    public Medico() {

    }
    public Medico(int idDoctor, String CRM, String speciality, String status, Clinica clinic) {
        this.idDoctor = idDoctor;
        this.CRM = CRM;
        this.speciality = speciality;
        this.status = status;
        this.clinic = clinic;
    }

    public Medico(String name, String CPF, String RG, String phoneNumber1,
                  String phoneNumber2, LocalDate dateOfBirth, String email,
                  int idDoctor, String CRM, String speciality, String status, Clinica clinic) {
        super(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, email);
        this.idDoctor = idDoctor;
        this.CRM = CRM;
        this.speciality = speciality;
        this.status = status;
        this.clinic = clinic;
    }

    public Medico(String name, String CPF, String RG, String phoneNumber1,
                  LocalDate dateOfBirth, String email, int idDoctor,
                  String CRM, String speciality, String status, Clinica clinic) {
        super(name, CPF, RG, phoneNumber1, dateOfBirth, email);
        this.idDoctor = idDoctor;
        this.CRM = CRM;
        this.speciality = speciality;
        this.status = status;
        this.clinic = clinic;
    }
    
    public Medico(String name, String CPF, String RG, String phoneNumber1,
                  String phoneNumber2, LocalDate dateOfBirth, String email,
                  String CRM, String speciality, String status, Clinica clinic) {
        super(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, email);
        this.CRM = CRM;
        this.speciality = speciality;
        this.status = status;
        this.clinic = clinic;
    }

    public Medico(String name, String CPF, String RG, String phoneNumber1,
                  LocalDate dateOfBirth, String email, String CRM, String speciality, 
                  String status, Clinica clinic) {
        super(name, CPF, RG, phoneNumber1, dateOfBirth, email);
        this.CRM = CRM;
        this.speciality = speciality;
        this.status = status;
        this.clinic = clinic;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Clinica getClinic() {
        return clinic;
    }

    public void setClinic(Clinica clinic) {
        this.clinic = clinic;
    }

    @Override
    public String toString() {
        return  idDoctor + ", " + CRM + ", " + speciality + ", " + status + ", " + clinic;
    }
}
