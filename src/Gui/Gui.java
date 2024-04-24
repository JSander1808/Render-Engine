package Gui;

import Core.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Gui {

    public static JFrame frame;
    public static JPanel viewport;

    public Gui() throws IOException {
        frame = new JFrame("3D - Render");
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        viewport = new Viewport();
        viewport.setBounds(0,0,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);

        frame.add(viewport);
        frame.setVisible(true);

        ObjectMesh mesh = ObjectWrapper.wrapOBJ(new File("D:\\Dokumente\\Development\\Render-Engine\\temp\\cube.obj"));
        Object3D obj = new Object3D(new Point3D(5.0, 0.0, 0.0), mesh, 0.0, 0.0, 0.0);
        ViewportManager.addObj(obj);
    }

}
