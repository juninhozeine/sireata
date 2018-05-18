/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dv.sireata.algorithms.anexo;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juninho
 */
public class AnexoListarPorAtaDAO implements ListarPorAtaDAO{

    @Override
    public List<Anexo> listarPorAta(int idAta) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        AnexoCarregarObjtDAO anexoCarregarObjeto = new AnexoCarregarObjtDAO();

        try{
                conn = ConnectionDAO.getInstance().getConnection();
                stmt = conn.createStatement();

                rs = stmt.executeQuery("SELECT anexos.* FROM anexos " +
                        "WHERE idAta=" + String.valueOf(idAta) + " ORDER BY anexos.ordem");

                List<Anexo> list = new ArrayList<Anexo>();

                while(rs.next()){
                        list.add((Anexo) anexoCarregarObjeto.carregarObjeto(rs));
                }

                return list;
        }finally{
                if((rs != null) && !rs.isClosed())
                        rs.close();
                if((stmt != null) && !stmt.isClosed())
                        stmt.close();
                if((conn != null) && !conn.isClosed())
                        conn.close();
        }
    }
    
}
