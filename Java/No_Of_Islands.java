package GFG;

import java.util.ArrayList;

public class No_Of_Islands {
	class Islands {
	     int findIslands(ArrayList<ArrayList<Integer>> A, int R, int C) {
	        int M[][]=new int[R][C];
	        for(int i=0;i<R;i++){
	            for(int j=0;j<C;j++){
	                M[i][j]=A.get(i).get(j);
	            }
	        }
	        Islands g=new Islands();
	        return g.countIsland(M,R,C);
	    }
	    boolean isSafe(int M[][],int r,int c,boolean visited[][],int ROW,int COL) {
			return (r>=0) && (r<ROW) && (c>=0) && (c<COL) && (M[r][c]==1) && (!visited[r][c]);
		}
		void DFS(int M[][],int r,int c,boolean visited[][],int ROW,int COL) {
			int dx[]= {-1,-1,-1,0,0,1,1,1};
			int dy[]= {-1,0,1,-1,1,-1,0,1};
			visited[r][c]=true;
			for(int k=0;k<8;k++)
				if(isSafe(M,r+dx[k],c+dy[k],visited,ROW,COL))
					DFS(M,r+dx[k],c+dy[k],visited,ROW,COL);
		}
		int countIsland(int M[][],int ROW,int COL) {
			boolean visited[][]=new boolean[ROW][COL];
			int count=0;
			for(int i=0;i<ROW;i++) {
				for(int j=0;j<COL;j++) {
					if((M[i][j]==1) && !visited[i][j]) {
						DFS(M,i,j,visited,ROW,COL);
						++count;
					}
				}
			}
			return count;
		}
	}
}
