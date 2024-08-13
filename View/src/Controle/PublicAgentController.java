/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.AgentePublicoDAOJDBC;
import Modelo.Entidades.AgentePublico;
import java.util.List;

/**
 *
 * @author LAB118-PC01
 */
public class PublicAgentController {
    public List buscarUsuarios(){
        AgentePublicoDAOJDBC publicAgentDAOJDBC = new AgentePublicoDAOJDBC();
        List listaUsuario = publicAgentDAOJDBC.findAll();
        return listaUsuario;
    }
    
    public AgentePublico buscarAgente(int idAgente) {
        try {
            AgentePublicoDAOJDBC agentePublicoDAOJDBC = new AgentePublicoDAOJDBC();
            AgentePublico agente = agentePublicoDAOJDBC.findById(idAgente);

            return agente;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void atualizarAgente(int id) {
     
        try {
            AgentePublicoDAOJDBC agentePublicoDAOJDBC = new AgentePublicoDAOJDBC();
            AgentePublico agente = agentePublicoDAOJDBC.findById(id);
            agentePublicoDAOJDBC.update(agente.getIdPublicAgent(),agente.getEmail(),agente.getUser(),agente.getPassword());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
