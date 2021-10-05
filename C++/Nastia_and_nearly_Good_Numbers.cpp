
#include <bits/stdc++.h>
using namespace std;
#define ll long long int

#define mp make_pair
#define theminv 1e9
const int maxn=1e5+10;
 typedef pair<int, int>pii;
#define fast ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
 

int32_t main(){
fast
int i=0,j=0;
ll t=1;
cin>>t;
while(t--){
    ll n,x;
    cin>>n>>x;
    ll div=n*x;
    ll re=0;
     bool got=false;
    for(ll i=n*x+1;i<10000000;i++)
    {
        if(i%div==0)
        {
            re=i;
             got=true;
            break;
        }
        }
    if(x==1)
    {
        cout<<"NO"<<endl;
    }
    else
    {
    ll re1=re/2;
    ll re2=re1+n;
    ll re3=re1-n;
    if((re2+re3)==re) 
    {
    cout<<"YES"<<endl;
    cout<<re2<<" ";
    cout<<re3<<" ";
    cout<<re<<endl;
    }
}
}
return 0;
}