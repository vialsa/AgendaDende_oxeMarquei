package Model.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Person {

    private String name;
    private String CPF;
    private String RG;
    private String phoneNumber1;
    private String phoneNumber2;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;
    private String address;
    private String email;

    public Person(){

    }
    public Person(String name, String CPF, String RG, String phoneNumber1,
                  String phoneNumber2, LocalDate dateOfBirth, String address, String email) {
        this.name = name;
        this.CPF = CPF;
        this.RG = RG;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = LocalDateTime.now();
        this.address = address;
        this.email = email;
    }

    public Person(String name, String CPF, String RG, String phoneNumber1,
                  LocalDate dateOfBirth, String address, String email) {
        this.name = name;
        this.CPF = CPF;
        this.RG = RG;
        this.phoneNumber1 = phoneNumber1;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = LocalDateTime.now();
        this.address = address;
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "Nome: " + this.getName() + "\n" +
                "CPF:" + this.getCPF() + "\n" +
                "Numero de Telefone 1: " + this.getPhoneNumber1() + "\n" +
                "Número de Telefone 2: " + this.getPhoneNumber2() + "\n" +
                "Endereço: " + this.getAddress() + "\n" +
                "E-mail: " + this.getEmail() + "\n";
    }

}
