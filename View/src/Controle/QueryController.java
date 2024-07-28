/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.ConsultaDAOJDBC;
import java.util.List;

/**
 *
 * @author LAB118-PC01
 */
public class QueryController {
    public List buscarConsultas(){
        ConsultaDAOJDBC queryDAOJDBC = new ConsultaDAOJDBC();
        List listaConsulta = queryDAOJDBC.findAll();
        return listaConsulta;
    }
    
}
