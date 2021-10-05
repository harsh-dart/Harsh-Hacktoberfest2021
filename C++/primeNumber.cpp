#include<iostream>
#include<cmath>
using namespace std;

bool checkPrime(int n){
    int count=0;
    if(n==0 || n==1){
        return false;
    }
    for(int i=2;i<=sqrt(n);i++){
        if(n%i==0){
            count++;
            break;
        }
    }
    return count==0?true:false;
}
int main(){

    int num=5;
    if(checkPrime(num))
        cout<<"It is Prime"<<endl;
    else    
         cout<<"It is NOT Prime"<<endl;
    return 0;
}