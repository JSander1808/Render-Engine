package Core;

import java.util.ArrayList;

public class Surface {

    private ArrayList<Integer> edgeIndexes = new ArrayList<Integer>();

    public Surface(ArrayList<Integer> edgeIndexes){
        this.edgeIndexes=edgeIndexes;
    }

    public ArrayList<Integer> getEdgeIndexes() {
        return edgeIndexes;
    }

    public void setEdgeIndexes(ArrayList<Integer> edgeIndexes) {
        this.edgeIndexes = edgeIndexes;
    }
}
