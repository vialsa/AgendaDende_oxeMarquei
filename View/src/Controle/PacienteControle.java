/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.ClinicaDAOJDBC;
import java.sql.Date;
import java.time.LocalDate;

import Modelo.DAO.impl.PacienteDAOJDBC;
import Modelo.Entidades.Clinica;
import Modelo.Entidades.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class PacienteControle {

    public boolean cadastroPaciente(Paciente paciente) {
        try {
            PacienteDAOJDBC pacienteDAO = new PacienteDAOJDBC();
            pacienteDAO.insert(paciente);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void atualizarPaciente(String nome, String phoneNumber1, String phoneNumber2, String address, String email, Integer idPatient) {
        try {
            PacienteDAOJDBC pacienteDAO = new PacienteDAOJDBC();
            pacienteDAO.update(nome, phoneNumber1, phoneNumber2, address, email, idPatient);
        } catch (Exception e) {
        }
    }

    public List<Paciente> findByName(String nome, Integer codigo, String sigtap) {
        try {
            PacienteDAOJDBC pacienteDAO = new PacienteDAOJDBC();
            List<Paciente> listPaciente = pacienteDAO.findAll();
            List<Paciente> retorno = new ArrayList<>();

            if (!nome.equals("")) {
                for (Paciente paciente : listPaciente) {
                    String[] nomeQuebrado = paciente.getName().split(" ");

                    if (paciente.getName().toLowerCase().equalsIgnoreCase(nome.toLowerCase())) {
                        retorno.add(paciente);
                    }

                    for (String string : nomeQuebrado) {
                        if (string.toLowerCase().equalsIgnoreCase(nome.toLowerCase())) {
                            retorno.add(paciente);
                        }
                    }
                }
            } else {
                return listPaciente;
            }

            return retorno;
        } catch (Exception e) {
        }
        return null;
    }

    public List<Paciente> buscarPaciente(String nomePaciente) {
        List<Paciente> retorno = new ArrayList<>();
        try {
            PacienteDAOJDBC pacienteDAOJDBC = new PacienteDAOJDBC();
            List<Paciente> listPaciente = pacienteDAOJDBC.findAll();

            if (!nomePaciente.equals("")) {
                for (Paciente paciente : listPaciente) {
                    if (nomePaciente.toLowerCase().equalsIgnoreCase(paciente.getName().toLowerCase())) {
                        retorno.add(paciente);
                    }

                    String[] nomeQuebrado = paciente.getName().split(" ");
                    for (String string : nomeQuebrado) {
                        if (nomePaciente.toLowerCase().equalsIgnoreCase(string.toLowerCase())) {
                            retorno.add(paciente);
                        }
                    }
                }
            } else {
                return listPaciente;
            }

        } catch (Exception e) {
        }
        return retorno;
    }

    public List buscarPacientes() {
        PacienteDAOJDBC pacienteDAO = new PacienteDAOJDBC();
        List listPatient = pacienteDAO.findAll();
        return listPatient;
    }

    public Paciente buscarPaciente(int idPaciente) {
        try {
            PacienteDAOJDBC pacienteDAOJDBC = new PacienteDAOJDBC();
            Paciente paciente = pacienteDAOJDBC.findById(idPaciente);

            return paciente;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
