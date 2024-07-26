package Model.Entities;

import java.util.Objects;

public class Clinic {
    int idClinic;
    String nameOfClinic;
    String address;
    String phoneNumber;
    String email;
    String status;

    public Clinic() {

    }
    public Clinic(int idClinic, String nameOfClinic, String address, String phoneNumber, String email) {
        this.idClinic = idClinic;
        this.nameOfClinic = nameOfClinic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = "ativo";
    }
    
    public Clinic(String nameOfClinic, String address, String phoneNumber, String email) {
        this.nameOfClinic = nameOfClinic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = "ativo";
    }
    
    public Clinic(int idClinic, String nameOfClinic, String address, String phoneNumber, String email,
                  String status) {
        this.idClinic = idClinic;
        this.nameOfClinic = nameOfClinic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
    }

    public Clinic(String nameOfClinic, String address, String status) {
        this.nameOfClinic = nameOfClinic;
        this.address = address;
        this.status = status;
    }

    public int getIdClinic() {
        return idClinic;
    }

    public void setIdClinic(int idClinic) {
        this.idClinic = idClinic;
    }

    public String getNameOfClinic() {
        return nameOfClinic;
    }

    public void setNameOfClinic(String nameOfClinic) {
        this.nameOfClinic = nameOfClinic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  idClinic + ", " + nameOfClinic + ", " + phoneNumber + ", " + address + ", " + status;
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nameOfClinic);
        hash = 31 * hash + Objects.hashCode(this.address);
        hash = 31 * hash + Objects.hashCode(this.phoneNumber);
        hash = 31 * hash + Objects.hashCode(this.email);
        hash = 31 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clinic other = (Clinic) obj;
        if (!Objects.equals(this.nameOfClinic, other.nameOfClinic)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.status, other.status);
    }
    
    
}
