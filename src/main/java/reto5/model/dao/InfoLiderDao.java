package reto5.model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import reto5.model.vo.InfoLiderVo;
import reto5.util.JDBCUtilities;

public class InfoLiderDao {
    public List<InfoLiderVo> listar() throws SQLException{
        ArrayList<InfoLiderVo> respuesta = new ArrayList<InfoLiderVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Lider as id , Nombre, Primer_Apellido as apellido, Ciudad_Residencia as ciudad FROM Lider l order by Ciudad_Residencia";
        
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                InfoLiderVo vo = new InfoLiderVo();
                vo.setId(rs.getInt("id"));
                vo.setNombre(rs.getString("Nombre"));
                vo.setApellido(rs.getString("apellido"));
                vo.setCiudad(rs.getString("ciudad"));
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
