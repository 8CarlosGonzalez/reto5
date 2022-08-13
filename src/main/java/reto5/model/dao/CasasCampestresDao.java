package reto5.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5.model.vo.CasasCampestresVo;
import reto5.util.JDBCUtilities;

public class CasasCampestresDao {
    public List<CasasCampestresVo> listar() throws SQLException{
        ArrayList<CasasCampestresVo> respuesta =new ArrayList<CasasCampestresVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Proyecto as id, Constructora, Numero_Habitaciones as habitaciones, Ciudad from Proyecto p WHERE Clasificacion = 'Casa Campestre' and Ciudad in ('Santa Marta','Cartagena', 'Barranquilla') ORDER BY id";
        try{
            stm = conn.prepareStatement(consulta);
            rs = stm.executeQuery();
            while (rs.next()){
                CasasCampestresVo vo = new CasasCampestresVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setCiudad(rs.getString("ciudad"));                
                vo.setHabitaciones(rs.getInt("habitaciones"));
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
