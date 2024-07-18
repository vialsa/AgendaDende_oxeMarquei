package Model.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Patient extends Person {

    private int idPatient;
    private String SIGTAP;

    public Patient() {

    }
    public Patient(int idPatient, String name, String CPF, String RG, String phoneNumber1,
                   String phoneNumber2, LocalDate dateOfBirth, String address, String email, String SIGTAP) {
        super(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, address, email);
        this.idPatient = idPatient;
        this.SIGTAP = SIGTAP;
    }

    public Patient(String name, String CPF, String RG, String phoneNumber1,
                   String phoneNumber2, LocalDate dateOfBirth, String address, String email, String SIGTAP) {
        super(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, address, email);
        this.SIGTAP = SIGTAP;
    }
    public Patient(String name, String CPF, String RG, String phoneNumber1,
                   LocalDate dateOfBirth, String address, String email, String SIGTAP) {
        super(name, CPF, RG, phoneNumber1, dateOfBirth, address, email);
        this.SIGTAP = SIGTAP;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getSIGTAP() {
        return SIGTAP;
    }

    public void setSIGTAP(String SIGTAP) {
        this.SIGTAP = SIGTAP;
    }

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "Paciente: " + this.getIdPatient() + "\n" +
                "Nome: " + this.getName() + "\n" +
                "CPF:" + this.getCPF() + "\n" +
                "SIGTAP: " + this.getSIGTAP() + "\n" +
                "Número de Telefone: " + this.getPhoneNumber1() + "\n" +
                "E-mail: " + this.getEmail() + "\n";
    }
}
