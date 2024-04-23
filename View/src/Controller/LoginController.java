/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.impl.PublicAgentDAOJDBC;

/**
 *
 * @author lucas
 */
public class LoginController {
    public boolean verificarLogin(String login, String senha) {
        PublicAgentDAOJDBC publicAgentDao= new PublicAgentDAOJDBC();
        boolean tem = publicAgentDao.containsUser(login, senha);
        System.out.println(tem);
        
        return tem;
    }
}