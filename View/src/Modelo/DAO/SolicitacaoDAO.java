package Modelo.DAO;

import java.util.List;

import Modelo.Entidades.Solicitacao;

public interface SolicitacaoDAO {
    Solicitacao insert(Solicitacao solicitation);
    Solicitacao findById(Integer id);
    List<Solicitacao> findAll();
}
