package Core;

import Gui.Gui;

import java.io.*;
import java.util.ArrayList;

public class ObjectWrapper {

    public static ObjectMesh wrapOBJ(File objFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(objFile));
        ArrayList<String> readed = new ArrayList<String>();

        String t = null;
        while((t = reader.readLine()) != null){
            readed.add(t);
        }

        ArrayList<Point3D> edges = new ArrayList<Point3D>();
        for(String e : readed){
            if(e.startsWith("v ")){
                String[] d = removeEmptyStrings(e.split(" "));
                if(d.length == 4){
                    Point3D g = new Point3D(Double.valueOf(d[1]), Double.valueOf(d[2]), Double.valueOf(d[3]));
                    edges.add(g);
                }else{
                    System.out.println(d.length+" - "+e);
                }
            }
        }

        ArrayList<Surface> surfaces = new ArrayList<Surface>();
        for(String e : readed){
            if(e.startsWith("f ")){
                String[] d = e.split(" ");
                if(d.length >= 4){
                    ArrayList<Integer> h = new ArrayList<Integer>();
                    for(int i = 1;i<d.length;i++){
                        h.add(Integer.valueOf(d[i].split("/")[0]));
                    }
                    Surface s = new Surface(h);
                    surfaces.add(s);
                }
            }
        }

        ObjectMesh objMesh = new ObjectMesh(edges, surfaces);
        System.out.println("Wrapped OBJ:   Edges:"+edges.size()+"       Surfaces:"+surfaces.size());
        return objMesh;
    }

    private static String[] removeEmptyStrings(String[] arr){
        ArrayList<String> t = new ArrayList<String>();
        for(String d :arr){
            if(!d.isEmpty()){
                t.add(d);
            }
        }

        String[] b = new String[t.size()];
        for(int i = 0;i<t.size();i++){
            b[i] = t.get(i);
        }

        return b;
    }
}
