package test;


import java.util.ArrayList;
import java.util.List;

public class Demo {

	private static final int NODE = 8;
	private static final int HAVESIDES = NODE - 1;
	private static final int Max_int = 65535;
	private static final double Max_Weight = 200;
	
	
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
		//Dijkstra(graph);
		System.out.println(CountRoute(graph));
	}
	
	public static int CountRoute(double graph[][]){
		
		int routeCounter = 0;
		double tempCount = 0; 
		double count = 0;
		Boolean[] visited = {false,false,false,false,false,false,false,false};
		
		for(int i=0 ; i < NODE; i++){
			tempCount = count;
			for(int j=0; j<NODE; j++){
				tempCount = count;
				if(visited[0] == false && graph[i][j] != 0 && visited[j] == false){
					count += graph[i][j];
					visited[j] = true;
					for(int k=0; k<NODE; k++){
						tempCount = count;
						if(visited[0] == false && graph[j][k] != 0 && visited[k] == false){
							count += graph[j][k];
							visited[k] = true;
							for(int l=0; l<NODE; l++){
								tempCount = count;
								if(visited[0] == false && graph[k][l] != 0 && visited[l] == false){
									count += graph[k][l];
									visited[l] = true;
									for(int n=0; n<NODE; n++){
										tempCount = count;
										if(visited[0] == false && graph[l][n] != 0 && visited[n] == false){
											count += graph[l][n];
											visited[n] = true;
											for(int m=0; m<NODE; m++){
												tempCount = count;
												if(visited[0] == false && graph[n][m] != 0 && visited[m] == false){
													count += graph[n][m];
													visited[m] = true;
													for(int o=0; o<NODE; o++){
														tempCount = count;
														if(visited[0] == false && graph[m][o] != 0 && visited[o] == false){
															count += graph[m][o];
															visited[o] = true;
															for(int p=0; p<NODE; p++){
																tempCount = count;
																if(visited[0] == false && graph[o][p] != 0 && visited[p] == false){
																	count += graph[o][p];
																	visited[p] = true;
																			if(count <= Max_Weight){
																				routeCounter ++;
																			}
																
																	
																}
																visited[p] = true;
																count = tempCount;
															}
														}
														visited[o] = true;
														count = tempCount;
													}
												}
												visited[m] = true;
												count = tempCount;
											}
										}
										visited[n] = true;
										count = tempCount;
									}
								}
								visited[l] = true;
								count = tempCount;
							}
						}
						visited[k] = true;
						count = tempCount;
					}
				}
				visited[j] = true;
				count = tempCount;
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
			System.out.println(outputString);
	}


	
}
