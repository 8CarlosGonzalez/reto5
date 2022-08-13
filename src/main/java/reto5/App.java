package reto5;

import javax.swing.JFrame;
import java.awt.*;

import reto5.view.ReportesView;

public class App 
{
    public static void main( String[] args )
    {
        var reportesView2 = new ReportesView(); 
        FlowLayout flowLayout = new FlowLayout();
        reportesView2.setLayout(flowLayout);
        reportesView2.setMinimumSize(new Dimension(640,520));
        reportesView2.setVisible(true);
        reportesView2.setResizable(false);
        reportesView2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportesView2.setLocationRelativeTo(null);
         
    }
}
