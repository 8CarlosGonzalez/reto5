package reto5.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import reto5.controller.ReportesController;
import reto5.model.vo.InfoLiderVo;
import reto5.model.vo.ComprasHomeSalentoVo;
import reto5.model.vo.CasasCampestresVo;

public class ReportesView extends JFrame implements ActionListener{
    private ReportesController controller;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem i1, i2, i3;
    private DefaultTableModel modelo;
    private JTable table;
    private JLabel labelTit, labelCons, labelIns;
    

    public ReportesView(){
        controller = new ReportesController();
        menu();
        etiqueta1();  
        etiqueta3();      
        tabla();
        etiqueta2();
        
    }
    public void etiqueta1(){
        labelTit= new JLabel("Aplicativo para consultas",SwingConstants.CENTER);
        labelTit.setPreferredSize(new Dimension(600, 40));
        labelTit.setFont(new Font("Arial", Font.BOLD, 20));
        add(labelTit);
    }
    public void etiqueta2(){
        labelCons= new JLabel();
        labelCons.setPreferredSize(new Dimension(600, 40));
        labelCons.setFont(new Font("Arial", Font.ITALIC, 15));
        add(labelCons);
    }
    public void etiqueta3(){
        labelIns= new JLabel("Seleccione en el menú superior, la consulta que desea realizar.");
        labelIns.setPreferredSize(new Dimension(600, 40));
        labelIns.setFont(new Font("Arial", Font.ITALIC, 15));
        add(labelIns);
    }

    public void tabla(){
        table = new JTable(modelo);
        table.setPreferredScrollableViewportSize(new Dimension(600, 300));
        add(table);
        JScrollPane pane = new JScrollPane(table);
        add(pane);
    }

    public void menu(){
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Consultas");
        menuBar.add(menu);
        i1 = new JMenuItem("Líderes");
        i2 = new JMenuItem("Proyectos");
        i3 = new JMenuItem("Compras");
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);


    }
   

    public void casasCampestres() {       
                  
            try{
                List<CasasCampestresVo> campestres = controller.listarCasasCampestres();                
                modelo = new DefaultTableModel();
                modelo.addColumn("Id");
                modelo.addColumn("Constructora");
                modelo.addColumn("Habitaciones");
                modelo.addColumn("Ciudad");
                for (CasasCampestresVo camp: campestres){
                    Object[] fila = new Object[4];
                    fila[0]=camp.getId();
                    fila[1]=camp.getConstructora();
                    fila[2]=camp.getHabitaciones();
                    fila[3]=camp.getCiudad();
                    modelo.addRow(fila);                    
                }
                table.setModel(modelo);
                modelo.fireTableDataChanged();           
                
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            
        }
    

    public void comprasHomeSalento() {
        try{
            List<ComprasHomeSalentoVo> compras = controller.listarComprasHomeSalento();                
            modelo = new DefaultTableModel();            
            modelo.addColumn("Id Compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco Vinculado");
            for (ComprasHomeSalentoVo comp: compras){
                Object[] fila = new Object[3];
                fila[0]=comp.getId();
                fila[1]=comp.getConstructora();
                fila[2]=comp.getBanco();
                modelo.addRow(fila);
                
            }
            table.setModel(modelo);
            modelo.fireTableDataChanged(); 
        }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());      

            }
        
    }

    public void infoLider() {
        try {
            List<InfoLiderVo> compras = controller.listarInfoLider();
            modelo = new DefaultTableModel();            
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");
            for (InfoLiderVo com: compras){
                Object[] fila = new Object[4];
                fila[0]=com.getId();
                fila[1]=com.getNombre();
                fila[2]=com.getApellido();
                fila[3]=com.getCiudad();
                modelo.addRow(fila);
                
            }
            table.setModel(modelo);
            modelo.fireTableDataChanged(); 

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==i1){
            infoLider();
            labelTit.setText("Consulta Líderes");
            labelCons.setText("Tabla 1: Información de los líderes.");            
        }
        if (e.getSource()==i2){
            casasCampestres(); 
            labelTit.setText("Consulta Proyectos");
            labelCons.setText("Tabla 2: Proyectos de Casas Campestres en Santa Marta, Barranquilla y Cartagena.");           
        }
        if (e.getSource()==i3){
            comprasHomeSalento();  
            labelTit.setText("Consulta Compras");
            labelCons.setText("Tabla 3: Compras a Homecenter en Salento.");
        }
        
        }
}
