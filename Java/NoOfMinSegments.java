package Segment_trees;

import java.util.Scanner;


public class NoofMininSegment {

 static class pair{
    int first;
    int second;
}
	static int n= (int)Math.pow(10, 5) + 2;
	 static int MOD = (int)Math.pow(10, 9) + 7;
	static pair tree[]=new pair[4*n];
	
	static int arr[]=new int[n];

	static void build(int node,int s,int e)
	{
		if(s==e)
		{
			tree[node].first=arr[s];
			tree[node].second=1;
		return;
		}	
		int mid=(s+e)/2;
		build(2*node,s,mid);
		build(2*node+1,mid+1,e);
		if(tree[2*node].first < tree[2*node +1].first){
			tree[node].first=tree[2*node].first;
			tree[node].second=tree[2*node].second;
		}
		else if(tree[2*node+1].first < tree[2*node +1].first){
			tree[node].first=tree[2*node+1].first;
			tree[node].second=tree[2*node+1].second;
		}
		else
		{
			tree[node].first=tree[2*node+1].first;
			tree[node].second=tree[2*node+1].second+tree[2*node].second;
			
		}
		
	}
	 static pair query(int  node,int s,int e,int l,int r)
	{
		if(s>r|| e<l)
		{
		     pair p =new pair();
	            p.first =MOD;
	            p.second = -1;
	            return p;
		}
		if(l<=s && e<=r)
			return tree[node];
	int mid=(s+e)/2;
	pair q1=query(2*node,s,mid,l,r);
	pair q2=query(2*node+1,mid+1,e,l,r);
    pair q=new pair();
    if(q1.first<q2.first)
    {
    q=q1;
    }
    else if(q2.first<q1.first)
    q=q2;
    else
    	q.first=q1.first;
    q.second=q1.second+q2.second;
    return q;
    
	}
	 static void update(int node,int s,int e,int ind,int val)
	{
		if(s==e)
		{
			arr[s]=val;
			tree[node].first=val;
			tree[node].second=1;
			return;
		}
		int mid=(s+e)/2;
		if(ind<=mid)
		{
			update(2*node,s,mid,ind,val);
		}
		else
			update(2*node+1,mid+1,e,ind,val);
		if(tree[2*node].first < tree[2*node +1].first){
			tree[node].first=tree[2*node].first;
			tree[node].second=tree[2*node].second;
		}
		else if(tree[2*node+1].first < tree[2*node +1].first){
			tree[node].first=tree[2*node+1].first;
			tree[node].second=tree[2*node+1].second;
		}
		else
		{
			tree[node].first=tree[2*node+1].first;
			tree[node].second=tree[2*node+1].second+tree[2*node].second;
			
		} 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner s=new Scanner(System.in);

int n = s.nextInt();
int m = s.nextInt();

int arr[] = new int[n];
for(int i=0;i<n;i++) {
    arr[i]=s.nextInt();
}
for(int i=0;i<4*n;i++)
    tree[i] = new pair();


build(1,0,n-1);

while(m-->0) {
    int type = s.nextInt();
    if(type == 1) {
        int idx = s.nextInt();
        int val = s.nextInt();
        update(1,0,n-1,idx,val);
    }else if(type == 2) {
        int l = s.nextInt();
        int r = s.nextInt();
        pair ans = query(1,0,n-1,l,r-1);
        System.out.println(ans.first +" " + ans.second);
    }
}

	}

}
