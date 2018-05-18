/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dv.sireata.algorithms.anexo;

import br.edu.utfpr.dv.sireata.dao.algorithms.CarregarObjtDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;
import br.edu.utfpr.dv.sireata.model.DAOEntity;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juninho
 */
public class AnexoCarregarObjtDAO implements CarregarObjtDAO{

    @Override
    public DAOEntity carregarObjeto(ResultSet rs) throws SQLException {
       Anexo anexo = new Anexo();
		
        anexo.setIdAnexo(rs.getInt("idAnexo"));
        anexo.getAta().setIdAta(rs.getInt("idAta"));
        anexo.setDescricao(rs.getString("descricao"));
        anexo.setOrdem(rs.getInt("ordem"));
        anexo.setArquivo(rs.getBytes("arquivo"));
		
        return (DAOEntity) anexo;
	}
    
}
