/*
Problem Statement:-
	You are given an integer n and you will be asked q queries
	for each each query you will be given a number x(x<=n) and
	you have to print its prime factorization
*/

#include<iostream>
#include<vector>

using namespace std;

int main()
{
	int n;
	cout<<"\nEnter upper bound for number : ";
	cin>>n;
	vector<int> prime(n+1);
	for(int i=0;i<=n;i++)
		prime[i]=i;
	prime[0]=prime[1]=-1;

	for(int i=4;i<=n;i+=2)
		prime[i]=2;
	for(int i=3;i*i<=n;i+=2)
		if(prime[i]==i)
			for(int j=i*i;j<=n;j+=i)
				if(prime[j]==j)
					prime[j]=i;
	
	cout<<"\nEnter number of query : ";
	int q;
	cin>>q;
	while(q--)
	{
		cout<<"\nEnter a number : ";
		int x;
		cin>>x;
		if(x<=1)
		{
			cout<<"\nCan't calculate prime factor";
			continue;
		}
		if(x>n)
		{
			cout<<"\nInvalid number\n";
			continue;
		}
		cout<<"\nPrime factorization for "<<x<<" is : ";
		while(x!=1)
		{
			cout<<prime[x]<<" ";
			x/=prime[x];
		}
		cout<<endl;
	}

	return 0;
}
