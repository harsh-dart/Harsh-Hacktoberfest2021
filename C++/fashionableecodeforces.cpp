#include <bits/stdc++.h>
using namespace std;
 
int main()
{
    int t,i,n;
    cin>>t;
    for(i=0;i<t;i++){
        cin>>n;
        if(n%4==0){
            cout<<"YES\n";
        }
        else{
            cout<<"NO\n";
        }
    }
    return 0;
}