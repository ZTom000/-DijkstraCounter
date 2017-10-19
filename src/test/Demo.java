package test;


import java.util.ArrayList;
import java.util.List;

public class Demo {

	private static final int NODE = 8;
	private static final int HAVESIDES = NODE - 1;
	private static final int Max_int = 65535;
	private static final double Max_Weight = 500;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		double[][] graph = {{0, 120.067, 95.4468, 77.5722, 70.9837, 70.5830, 31.9725, 51.482},
							{120.067, 0, 36.0624, 69.3485, 52.08650, 50.4242, 88.2558, 75.4184},
							{95.4468, 36.0624,0, 33.373, 24.9195, 37.9739, 66.06, 45.2832},
							{77.5722, 69.3485, 33.373, 0, 29.2674, 49.8704, 55.9165, 28.3099},
							{70.9837, 52.0865, 24.9125, 29.2674, 0, 20.7171, 41.1413, 23.342},
							{70.5703, 50.4242, 37.9739, 49.8704, 20.7171, 0, 38.6079, 35.7202},
							{31.9725, 88.2588, 66.06, 55.9165, 41.1413, 38.6079, 0, 27.6479},
							{51.482, 75.4184, 45.2832, 28.3099, 23.342, 35.7202, 27.6479,0}};
		Dijkstra(graph);
		System.out.println(CountRoute(graph));
	}
	
	public static int CountRoute(double graph[][]){
		
		int routeCounter = 0;
		double tempCount = 0; 
		double count = 0;
		Boolean[] visited = {false,false,false,false,false,false,false,false};
		
		for(int a = 1; a < NODE; a++){
			tempCount = count;
			if(visited[a] == false){
				visited[a] = true;
				count += graph[0][a];
				for(int b = 1; b < NODE; b++){
					tempCount = count;
					if(visited[b] == false && graph[a][b] != 0){
						visited[b] = true;
						count += graph[a][b];
						for(int c = 1; c < NODE; c++){
							tempCount = count;
							if(visited[c] == false && graph[b][c] != 0){
								visited[c] = true;
								count += graph[b][c];
								for(int d = 1; d < NODE; d++){
									tempCount = count;
									if(visited[d] == false && graph[c][d] != 0){
										visited[d] = true;
										count += graph[c][d];
										for(int e = 1; e < NODE; e++){
											tempCount = count;
											if(visited[e] == false && graph[d][e] != 0){
												visited[e] = true;
												count += graph[d][e];
												for(int f = 1; f < NODE; f++){
													tempCount = count;
													if(visited[f] == false && graph[d][f] != 0){
														visited[f] = true;
														count += graph[d][f];
														for(int g = 1; g < NODE; g++){
															tempCount = count;
															if(visited[g] == false && graph[f][g] != 0){
																visited[g] = true;
																count += graph[f][g];
																count += graph[g][0];
																if(count <= Max_Weight){
																	System.out.println(count);
																	routeCounter ++;
																}
															}
															if(visited [g] == true){
																visited [g] = false;
															}
															count = tempCount;
														}
													}
													if(visited [f] == true){
														visited [f] = false;
													}
													count = tempCount;
												}
											}
											if(visited [e] == true){
												visited [e] = false;
											}
											count = tempCount;
										}
									}
									if(visited [d] == true){
										visited [d] = false;
									}
									count = tempCount;
								}
							}
							if(visited [c] == true){
								visited [c] = false;
							}
							count = tempCount;
						}
					}
					if(visited [b] == true){
						visited [b] = false;
					}
					count = tempCount;
				}
			}
			if(visited [a] == true){
				visited [a] = false;
			}
			count = tempCount;
		}
		return routeCounter;
	}
	
	public static void Dijkstra(double graph[][]){
		String[] word = {"H","A","B","C","D","E","F","G"};
		Boolean[] visited = {false,false,false,false,false,false,false,false};
		String outputString ="H";
		Graph connectedGraphraph = new Graph();
		
		connectedGraphraph.setMatrix(graph);
		connectedGraphraph.setNode(NODE);
		connectedGraphraph.setSide(NODE * HAVESIDES);
		
			double count = 0;
			for(int i=0; i<NODE; i++){
				int jTemp = 0;
				double min = Max_int;		//可以设置为最大的double值
				for(int j=0; j<HAVESIDES + 1; j++){
				if(connectedGraphraph.getMatrix()[i][j] != 0 && count < Max_Weight){
					if(visited[j] != true){
						if(connectedGraphraph.getMatrix()[i][j] < min){
							min = connectedGraphraph.getMatrix()[i][j];
							jTemp = j;
							}
					}
				}
				if(j == HAVESIDES){
					count += min;
					visited[jTemp] = true;
					outputString += word[jTemp];
					i = jTemp - 1;
				}
				}
				if(visited[0] == true){
					break;
				}
			}
			System.out.println(count);
			System.out.println(outputString);
	}


	
}
