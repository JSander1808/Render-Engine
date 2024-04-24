package Core;

public class CamObject {

    private Point3D globalPosition;
    private double yaw;
    private double pitch;
    private double roll;

    public CamObject(Point3D globalPosition, double yaw, double pitch, double roll){
        this.globalPosition=globalPosition;
        this.yaw=yaw;
        this.pitch=pitch;
        this.roll=roll;
    }

    public Point3D getGlobalPosition() {
        return globalPosition;
    }

    public double getYaw() {
        return yaw;
    }

    public double getRoll() {
        return roll;
    }

    public double getPitch() {
        return pitch;
    }

    public void setGlobalPosition(Point3D globalPosition) {
        this.globalPosition = globalPosition;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }
}
