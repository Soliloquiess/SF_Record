package inflearn;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _80_dijkstra {

	

	struct Edge {
		
		int destVertex;
		int distance;
		
		Edge(int dest, int weight){
			destVertex = dest;
			distance = weight;
		}
		
		bool operator < (const Edge &edge) const {
			return distance > edge.distance; // minimum heap
		}
		
	};

	int main(int argc, char** argv) {
		
		freopen("input.txt", "rt", stdin);
		
		int vertexSize, edgeSize;
		
		cin >> vertexSize >> edgeSize;
		vector<Edge> graph[vertexSize + 1];
		
		for(int i = 0; i < edgeSize; i++){
			
			int source, dest, cost;
			cin >> source >> dest >> cost; 
			graph[source].push_back(Edge(dest, cost));
				
		}
		
		vector<int> dists(vertexSize + 1, INT_MAX);
		priority_queue<Edge> myPQueue;
		myPQueue.push(Edge(1, 0));
		dists[1] = 0;
		
		while(!myPQueue.empty()){
		
			// ���� �������� �ּ� �Ÿ��� �̵��� �� �ִ� ������ ���� 
			Edge edge = myPQueue.top();
			myPQueue.pop();
			
			// ���� ������ ���� movedVertex �������� �̵��� �Դٰ� ������
			int movedVertex = edge.destVertex;
			int movedDist = edge.distance;
			
			// movedVertex�� �� ���� ������� �Դ� ���� �ִٸ� ���캼 �ʿ䰡 ���� 
			if(movedDist > dists[movedVertex]) continue;
			
			// movedVertex�� ����� ������ Ž�� : ������� 
			for(int i = 0; i < graph[movedVertex].size(); i++){
				
				// connectedEdge = movedVertex�� ����� ����
				Edge connectedEdge = graph[movedVertex][i];

				// movedVertex�� ������ ����� �ٸ� ����
				int nextVertex = connectedEdge.destVertex;
				
				// nextDist = movedVertex���� ���� �� ���� �Ÿ� + �� ������ ����� �ٸ� ���������� �Ÿ� 
				int nextDist = movedDist + connectedEdge.distance;
				
				// ���� ���� �Ÿ��� �ּҰ��̶� �����ؾ� �ϴ� ���
				if(nextDist < dists[nextVertex]){
					// edge -> connectedEdge�� ���� �̵��� �Ÿ��� ����
					dists[nextVertex] = nextDist;
					// �� ������ �̿��� �ٸ� ���� �� �� �ֵ��� ť�� push  
					myPQueue.push(Edge(nextVertex, nextDist));
				}	
			}
		}
		
		for(int i = 2; i <= vertexSize; i++){
			if(dists[i] != INT_MAX)
				cout << i << " : " << dists[i] << "\n";
			else cout << i << " : impossible" << "\n";	
		}
		
		return 0;
	}
}


