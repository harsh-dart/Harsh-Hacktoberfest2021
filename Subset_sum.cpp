#include<bits/stdc++.h>
#define ll long long
#define pb push_back
using namespace std;
 
bool subsetsum(int sum,int ar[],int  n)
{
    bool t[n+1][]
    if(sum==0)
    {
        return true;
    }
    if(n==0)
    {
        return false;
    }
    if(ar[n-1]<=sum)
    {
    return (subsetsum(sum-ar[n-1],ar,n-1) || subsetsum(sum,ar,n-1));
    }
    else
    {
        return subsetsum(sum,ar,n-1);
    }
}
int main()
{
  ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int sum=10;
    int numbers[]={11,24,5,5};
    int n=sizeof(numbers)/sizeof(int);
    cout<<subsetsum(sum,numbers,n);
}
