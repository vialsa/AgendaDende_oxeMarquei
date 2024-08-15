/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.AgentePublicoDAOJDBC;
import Modelo.Entidades.AgentePublico;
import java.util.ArrayList;
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
    
    public List<AgentePublico> buscarAgente(String nomeAgente) {
        List<AgentePublico> retorno = new ArrayList<>();
        try {
            AgentePublicoDAOJDBC agentePublicoDAOJDBC = new AgentePublicoDAOJDBC();
            List<AgentePublico> listAgente = agentePublicoDAOJDBC.findAll();
            
            for (AgentePublico agentePublico : listAgente) {
                
                if (nomeAgente.toLowerCase().equalsIgnoreCase(agentePublico.getName().toLowerCase())) {
                    retorno.add(agentePublico);
                }
                
                String[] nomeQuebrado = agentePublico.getName().split(" ");
                for (String string : nomeQuebrado) {
                    if (nomeAgente.toLowerCase().equalsIgnoreCase(string.toLowerCase())) {
                        retorno.add(agentePublico);
                    }
                }
            }
        } catch (Exception e) {
        }
        return retorno;
    }
    
    public void atualizarAgente(Integer idPublicAgent,String email,String user,String password) {
     
        try {
            AgentePublicoDAOJDBC agentePublicoDAOJDBC = new AgentePublicoDAOJDBC();
            agentePublicoDAOJDBC.updateAgente(idPublicAgent, email, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
