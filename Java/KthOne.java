package Segment_trees;

import java.util.Scanner;



public class KthOne {

	
	static int n=100002;
	static int a[]=new int[n];
	static int tree[]=new int[4*n];
	
	
	static void build(int node,int s,int e)
	{
		if(s==e)
		{
			tree[node]=a[s];
		return;
		}	
		int mid=(s+e)/2;
		build(2*node,s,mid);
		build(2*node+1,mid+1,e);
		tree[node]=(tree[2*node]+ tree[2*node +1]);
		
		
	}
	 static void update(int node,int s,int e,int ind)
		{
			if(s==e)
			{
				if(a[s]==0)
				{
					a[s]=1;
					tree[node]=1;
				}
				else
				{
					a[s]=0;
					tree[node]=0;
				}
				return;
			}
			int mid=(s+e)/2;
			if(ind<=mid)
			{
				update(2*node,s,mid,ind);
			}
			else
				update(2*node+1,mid+1,e,ind);
			tree[node]=tree[2*node]+tree[2*node+1];
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);

		int n = s.nextInt();
		int m = s.nextInt();
		for(int i=0;i<n;i++) 
		    a[i]=s.nextInt();
		 build(1,0,n-1);
		 for(int i=0;i<m;i++)
		 {
			 int type=s.nextInt();
			 if(type==1)
			 {
				 int ind=s.nextInt();
				 
				 update(1,0,n-1,ind);
			 }
			 else {
				 int k=s.nextInt();
				 int ans=query(1,0,n-1,k);
				 System.out.println(ans);
			 }
		 }

}
	private static int query(int node, int s, int e, int k) {
		// TODO Auto-generated method stub
		if(s==e)
			return s;
		int m=(s+e)/2;
		if(k<tree[2*node])
		{
			return query(2*node,s,m,k);
		}
		else
			return query(2*node+1,m+1,e,k-tree[2*node]);
		
	}
}
