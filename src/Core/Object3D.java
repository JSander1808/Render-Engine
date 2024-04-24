package Core;

import java.util.ArrayList;

public class Object3D {

    private Point3D globalPosition;
    private ObjectMesh objectMesh;
    private double yaw;
    private double pitch;
    private double roll;

    public Object3D(Point3D globalPosition, ObjectMesh objectMesh, double yaw, double pitch, double roll){
        this.globalPosition=globalPosition;
        this.objectMesh=objectMesh;
        this.yaw=yaw;
        this.pitch=pitch;
        this.roll=roll;
    }

    public double getPitch() {
        return pitch;
    }

    public double getRoll() {
        return roll;
    }

    public ObjectMesh getObjectMesh() {
        return objectMesh;
    }

    public double getYaw() {
        return yaw;
    }

    public Point3D getGlobalPosition() {
        return globalPosition;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public void setGlobalPosition(Point3D globalPosition) {
        this.globalPosition = globalPosition;
    }

    public void setObjectMesh(ObjectMesh objectMesh) {
        this.objectMesh = objectMesh;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }
}
