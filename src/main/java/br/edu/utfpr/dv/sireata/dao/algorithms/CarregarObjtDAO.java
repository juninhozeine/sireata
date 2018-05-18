package br.edu.utfpr.dv.sireata.dao.algorithms;

import br.edu.utfpr.dv.sireata.model.DAOEntity;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CarregarObjtDAO {
    
    public DAOEntity carregarObjeto(ResultSet rs) throws SQLException;
    
}
