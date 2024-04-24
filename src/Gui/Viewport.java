package Gui;

import Core.CamObject;
import Core.Point3D;
import Core.ViewportManager;

import javax.swing.*;
import java.awt.*;

public class Viewport extends JPanel {

    public CamObject camObj = new CamObject(new Point3D(0.0,0.0,0.0), -20.0, 0.0, 0.0);

    @Override
    protected void paintComponent(Graphics g){
        Gui.viewport.setBounds(0,0,Gui.frame.getWidth(), Gui.frame.getHeight());

        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0,0,Gui.frame.getWidth(), Gui.frame.getHeight());

//        Polygon poly = new Polygon();
//        poly.addPoint(0,0);
//        poly.addPoint(100,0);
//        poly.addPoint(0,100);
//        poly.addPoint(100,100);
//
//        g.setColor(Color.RED);
//        g.drawPolygon(poly);


        ViewportManager.render(camObj, g, 300);





        repaint();
    }
}
