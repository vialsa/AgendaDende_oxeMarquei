/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.ClinicaDAOJDBC;
import Modelo.DAO.impl.ConsultaDAOJDBC;
import Modelo.DAO.impl.PacienteDAOJDBC;
import Modelo.DAO.impl.SolicitacaoDAOJDBC;
import Modelo.Entidades.Clinica;
import Modelo.Entidades.Consulta;
import Modelo.Entidades.Paciente;
import Modelo.Entidades.Solicitacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAB118-PC01
 */
public class QueryController {

    public List<Consulta> buscarConsultas() {
        ConsultaDAOJDBC consultaDAOJDBC = new ConsultaDAOJDBC();
        List<Consulta> listaConsulta = consultaDAOJDBC.findAll();
        return listaConsulta;
    }

    public boolean marcarConsulta(Consulta consulta) {
        try {
            ConsultaDAOJDBC consultaDAOJDBC = new ConsultaDAOJDBC();
            consultaDAOJDBC.insert(consulta);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Consulta> buscarConsultar(String nomePaciente) {
        List<Consulta> retorno = new ArrayList<>();
        try {
            ConsultaDAOJDBC consultaDAOJDBC = new ConsultaDAOJDBC();
            List<Consulta> listConsulta = consultaDAOJDBC.findAll();
            SolicitacaoDAOJDBC solicitationDAOJDBC = new SolicitacaoDAOJDBC();
            PacienteDAOJDBC patientDAOJDBC = new PacienteDAOJDBC();

            if (nomePaciente != null) {
                for (Consulta consulta : listConsulta) {
                    Solicitacao solicitacao = solicitationDAOJDBC.findById(consulta.getSolicitation().getIdSolicitation());
                    Paciente paciente = patientDAOJDBC.findById(solicitacao.getPatient().getIdPatient());

                    if (nomePaciente.toLowerCase().equalsIgnoreCase(paciente.getName().toLowerCase())) {
                        retorno.add(consulta);
                    }

                    String[] nomeQuebrado = paciente.getName().split(" ");
                    for (String string : nomeQuebrado) {
                        if (nomePaciente.toLowerCase().equalsIgnoreCase(string.toLowerCase())) {
                            System.out.println(paciente.getName().toLowerCase());
                            retorno.add(consulta);
                        }
                    }
                }

                return retorno;
            } else {
                return listConsulta;
            }
        } catch (Exception e) {
        }
        return retorno;
    }
}
