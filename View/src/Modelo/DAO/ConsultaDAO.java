package Modelo.DAO;

import Modelo.Entidades.Consulta;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaDAO {
    void insert(Consulta query);
    void update(LocalDateTime dateAndTimeOfConsultation, Integer idQuery);

    Consulta findById(Integer idQuery);
    List<Consulta> findAll();
}
