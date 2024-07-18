package Model.Entities;
import java.time.LocalDate;

public class Doctor extends Person{
    int idDoctor;
    String CRM;
    String speciality;
    String status;
    Clinic clinic;

    public Doctor() {

    }
    public Doctor(int idDoctor, String CRM, String speciality, String status, Clinic clinic) {
        this.idDoctor = idDoctor;
        this.CRM = CRM;
        this.speciality = speciality;
        this.status = status;
        this.clinic = clinic;
    }

    public Doctor(String name, String CPF, String RG, String phoneNumber1,
                  String phoneNumber2, LocalDate dateOfBirth, String address, String email,
                  int idDoctor, String CRM, String speciality, String status, Clinic clinic) {
        super(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, address, email);
        this.idDoctor = idDoctor;
        this.CRM = CRM;
        this.speciality = speciality;
        this.status = status;
        this.clinic = clinic;
    }

    public Doctor(String name, String CPF, String RG, String phoneNumber1,
                  LocalDate dateOfBirth, String address, String email, int idDoctor,
                  String CRM, String speciality, String status, Clinic clinic) {
        super(name, CPF, RG, phoneNumber1, dateOfBirth, address, email);
        this.idDoctor = idDoctor;
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

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", CRM='" + CRM + '\'' +
                ", speciality='" + speciality + '\'' +
                ", status='" + status + '\'' +
                ", clinic=" + clinic +
                '}';
    }
}
