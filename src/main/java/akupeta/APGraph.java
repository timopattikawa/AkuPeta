package akupeta;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class APGraph extends Graph{

    Vector path = new Vector();
    ArrayList<ArrayList> resPath = new ArrayList<>(9999);
    int sizeres = 0;
    public APGraph(String source, String destination) {
        super(source, destination);
    }

    @Override
    public void searchPath() {
        Queue<Vector> q = new LinkedList<>();
        path.add(source);
        q.add(path);
        while (!q.isEmpty()) {
            path = q.peek();
            q.remove();
            int last = (int) path.get(path.size() - 1);
            if (last == destination) {
                addPath();
            }
            for (int i=0; i < MAPGraph[last].length ; i++) {
                if (isNotVisited(i) && MAPGraph[last][i] != INFINITY) {
                    Vector newPath = new Vector(path);
                    newPath.add(i);
                    q.add(newPath);
                }
            }
        }

    }

    public void addPath() {
        resPath.add(new ArrayList(path));
        sizeres++;
    }

    @Override
    public void printPath() {
        int size = resPath.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < resPath.get(i).size(); j++) {
                System.out.print(city.get((int) resPath.get(i).get(j)).getCityName().toUpperCase());
                if (j != resPath.get(i).size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    public boolean isNotVisited(int x) {
        int size = path.size();
        for (int i = 0; i < size; i++)
            if (path.get(i).equals(x))
                return false;
        return true;
    }
}


