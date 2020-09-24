package akupeta;

public class STPGraph extends Graph {

    private int[] distance, Blackened, pathlength, parent;

    public STPGraph(String _source, String _destination) {
        super(_source, _destination);
        distance = new int[TotCity];
        Blackened = new int[TotCity];
        pathlength = new int[TotCity];
        parent = new int[TotCity];
    }

    @Override
    public void searchPath() {
        int i, u, v, count;
        parent[source] = NILL;
        for (i = 0; i < TotCity; i++)
            distance[i] = INFINITY;
        distance[source] = 0;
        for (count = 0; count < TotCity - 1; count++) {
            u = MinDistance();
            if (u == INFINITY)
                break;
            else {
                Blackened[u] = 1;
                for (v = 0; v < TotCity; v++) {
                    if (Blackened[v] == 0 && MAPGraph[u][v] != 0
                            && distance[u] + MAPGraph[u][v] < distance[v]) {
                        parent[v] = u;
                        pathlength[v] = pathlength[parent[v]] + 1;
                        distance[v] = distance[u] + MAPGraph[u][v];
                    }
                    else if (Blackened[v] == 0 && MAPGraph[u][v] != 0
                            && distance[u] + MAPGraph[u][v] == distance[v]
                            && pathlength[u] + 1 < pathlength[v]) {
                        parent[v] = u;
                        pathlength[v] = pathlength[u] + 1;
                    }
                }
            }
        }
    }

    @Override
    public void printPath() {
        if (distance[destination] != INFINITY) {
            searchToPrint(parent, destination);
            System.out.println("\nTotal Jarak Terpendek Yang Ditemukan : " + distance[destination] + " KM");
        }
        else {
            System.out.println("Tidak Menemukan Jalan Dari Kota " + source + " Ke " + destination);
        }
    }

    private void searchToPrint(int[] parent, int _destination) {
        if (parent[_destination] == NILL) {
            System.out.print(getCityWithCode(_destination).getCityName().toUpperCase());
            return;
        }
        searchToPrint(parent, parent[_destination]);
        System.out.print(" -> " + getCityWithCode(_destination).getCityName().toUpperCase());
    }

    public int MinDistance() {
        int min = INFINITY, min_index = -1, v;
        for (v = 0; v < TotCity; v++)
            if (Blackened[v] == 0 && distance[v] < min) {
                min = distance[v];
                min_index = v;
            }
        return min == INFINITY ? INFINITY : min_index;
    }


}
