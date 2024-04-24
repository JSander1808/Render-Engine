package Core;

import java.util.ArrayList;

public class ObjectMesh {

    private ArrayList<Point3D> edges = new ArrayList<Point3D>();
    private ArrayList<Surface> surfaces = new ArrayList<Surface>();

    public ObjectMesh(ArrayList<Point3D> edges, ArrayList<Surface> surfaces){
        this.edges=edges;
        this.surfaces=surfaces;
    }

    public ArrayList<Point3D> getEdges() {
        return edges;
    }

    public ArrayList<Surface> getSurfaces() {
        return surfaces;
    }

    public void setEdges(ArrayList<Point3D> edges) {
        this.edges = edges;
    }

    public void setSurfaces(ArrayList<Surface> surfaces) {
        this.surfaces = surfaces;
    }
}
