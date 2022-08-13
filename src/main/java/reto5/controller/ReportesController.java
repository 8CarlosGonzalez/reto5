package reto5.controller;

import java.sql.SQLException;
import java.util.List;

import reto5.model.dao.InfoLiderDao;
import reto5.model.dao.ComprasHomeSalentoDao;
import reto5.model.dao.CasasCampestresDao;
import reto5.model.vo.InfoLiderVo;
import reto5.model.vo.ComprasHomeSalentoVo;
import reto5.model.vo.CasasCampestresVo;

public class ReportesController {
    private InfoLiderDao infoLiderDao;
    private ComprasHomeSalentoDao comprasHomeSalentoDao;
    private CasasCampestresDao casasCampestresDao;

    public ReportesController(){
        casasCampestresDao = new CasasCampestresDao();
        comprasHomeSalentoDao = new ComprasHomeSalentoDao();
        infoLiderDao = new InfoLiderDao();
    }

    public List<CasasCampestresVo> listarCasasCampestres() throws SQLException{
        return casasCampestresDao.listar();

    }
    public List<ComprasHomeSalentoVo> listarComprasHomeSalento() throws SQLException{
        return comprasHomeSalentoDao.listar();
    }
    public List<InfoLiderVo> listarInfoLider() throws SQLException{
        return infoLiderDao.listar();
    }
    
}
