package Core;

import Gui.Gui;

import java.awt.*;
import java.util.ArrayList;

public class ViewportManager {

    public static ArrayList<Object3D> objects = new ArrayList<Object3D>();

    public static void addObj(Object3D obj){
        objects.add(obj);
    }

    public static void removeObj(Object3D obj){
        objects.remove(obj);
    }

    public static void render(CamObject camObj, Graphics g, double f){
        g.setColor(Color.RED);
        for(Object3D obj : objects){
            Object3D newObj = rotateViewport(obj, camObj.getYaw(), camObj.getPitch(), camObj.getRoll());
            for(Surface s : newObj.getObjectMesh().getSurfaces()){
                Polygon polygon = renderPolygon(newObj.getObjectMesh().getEdges(), s, newObj.getGlobalPosition(), camObj.getGlobalPosition(), f);
                g.drawPolygon(polygon);
            }
        }
    }

    public static Polygon renderPolygon(ArrayList<Point3D> points, Surface surface, Point3D globalSurfacePosition, Point3D camPosition, double f){
        ArrayList<Point3D> surfacePoints = getSurfacePoints(points, surface);
        ArrayList<Point> polygonPoints = new ArrayList<Point>();

        for(Point3D p : surfacePoints){
            double x = globalSurfacePosition.getX() + camPosition.getX() + p.getX();
            double y = globalSurfacePosition.getY() + camPosition.getY() + p.getY();
            double z = globalSurfacePosition.getZ() + camPosition.getZ() + p.getZ();

            double ScreenX = (y*f)/x + Gui.frame.getWidth()/2;
            double ScreenY = (z*f)/x + Gui.frame.getHeight()/2;

            polygonPoints.add(new Point((int) ScreenX, (int) ScreenY));
        }

        Polygon polygon = new Polygon();
        for(Point p : polygonPoints){
            polygon.addPoint(p.x, p.y);
        }

        return polygon;
    }

    public static Object3D rotateViewport(Object3D object, double yaw, double pitch, double roll){
        ObjectMesh mesh = object.getObjectMesh();
        ArrayList<Point3D> rPoints = new ArrayList<Point3D>();
        for(Point3D p : mesh.getEdges()){
            if(roll!=0){
                double x = p.getX();
                double y = p.getY();
                double z = p.getZ();
                double yr = (y*Math.cos(Math.toRadians(roll)))+(z*Math.sin(Math.toRadians(roll)));
                double zr = (y*-Math.sin(Math.toRadians(roll)))+(z*Math.cos(Math.toRadians(roll)));
                p = new Point3D(x,yr,zr);
            }
            if(pitch!=0){
                double x = p.getX();
                double y = p.getY();
                double z = p.getZ();
                double xr = (x*Math.cos(Math.toRadians(pitch)))+(z*Math.sin(Math.toRadians(pitch)));
                double zr = (x*-Math.sin(Math.toRadians(pitch)))+(z*Math.cos(Math.toRadians(pitch)));
                p = new Point3D(xr,y,zr);
            }
            if(yaw!=0){
                double x = p.getX();
                double y = p.getY();
                double z = p.getZ();
                double xr = (x*Math.cos(Math.toRadians(yaw)))+(y*Math.sin(Math.toRadians(yaw)));
                double yr = (x*-Math.sin(Math.toRadians(yaw)))+(y*Math.cos(Math.toRadians(yaw)));
                p = new Point3D(xr,yr,z);
            }
            rPoints.add(p);
        }

        ObjectMesh newMesh = new ObjectMesh(rPoints, mesh.getSurfaces());
        Object3D newObj = new Object3D(object.getGlobalPosition(),newMesh, yaw, pitch, roll);
        return newObj;
    }

    public static ArrayList<Point3D> getSurfacePoints(ArrayList<Point3D> points, Surface surface){
        ArrayList<Point3D> tmpPoints = new ArrayList<Point3D>();

        for(int p : surface.getEdgeIndexes()){
            tmpPoints.add(points.get(p-1));
        }

        return tmpPoints;
    }















    public static ArrayList<Object3D> getObjects() {
        return objects;
    }

    public static void setObjects(ArrayList<Object3D> objects) {
        ViewportManager.objects = objects;
    }
}
