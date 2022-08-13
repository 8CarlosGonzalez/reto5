package reto5.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5.model.vo.ComprasHomeSalentoVo;
import reto5.util.JDBCUtilities;

public class ComprasHomeSalentoDao {
    public List<ComprasHomeSalentoVo> listar() throws SQLException{
        ArrayList<ComprasHomeSalentoVo> respuesta = new ArrayList<ComprasHomeSalentoVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Compra as id, Constructora, Banco_Vinculado as banco from Compra c join Proyecto p on (c.ID_Proyecto = p.ID_Proyecto) WHERE Proveedor = 'Homecenter' AND Ciudad = 'Salento' ORDER BY id";

        try{
            stm= conn.prepareStatement(consulta);            
            rs= stm.executeQuery();
            while (rs.next()){
                ComprasHomeSalentoVo vo = new ComprasHomeSalentoVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("Constructora"));
                vo.setBanco(rs.getString("banco"));
                respuesta.add(vo);
            }
            
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }     

        }
    return respuesta;
    }
}
