/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.impl.QueryDAOJDBC;
import java.util.List;

/**
 *
 * @author LAB118-PC01
 */
public class QueryController {
    public List buscarConsultas(){
        QueryDAOJDBC queryDAOJDBC = new QueryDAOJDBC();
        List listaConsulta = queryDAOJDBC.findAll();
        return listaConsulta;
    }
    
}
