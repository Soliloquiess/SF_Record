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
		
			// 현재 시점에서 최소 거리로 이동할 수 있는 엣지를 꺼냄 
			Edge edge = myPQueue.top();
			myPQueue.pop();
			
			// 꺼낸 엣지를 통해 movedVertex 정점으로 이동해 왔다고 가정함
			int movedVertex = edge.destVertex;
			int movedDist = edge.distance;
			
			// movedVertex에 더 작은 비용으로 왔던 적이 있다면 살펴볼 필요가 없음 
			if(movedDist > dists[movedVertex]) continue;
			
			// movedVertex과 연결된 엣지를 탐색 : 뻗어나가기 
			for(int i = 0; i < graph[movedVertex].size(); i++){
				
				// connectedEdge = movedVertex와 연결된 엣지
				Edge connectedEdge = graph[movedVertex][i];

				// movedVertex와 엣지로 연결된 다른 정점
				int nextVertex = connectedEdge.destVertex;
				
				// nextDist = movedVertex까지 오는 데 쓰인 거리 + 그 정점과 연결된 다른 정점까지의 거리 
				int nextDist = movedDist + connectedEdge.distance;
				
				// 지금 구한 거리가 최소값이라서 갱신해야 하는 경우
				if(nextDist < dists[nextVertex]){
					// edge -> connectedEdge를 거쳐 이동한 거리로 갱신
					dists[nextVertex] = nextDist;
					// 이 엣지를 이용해 다른 노드로 갈 수 있도록 큐에 push  
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


