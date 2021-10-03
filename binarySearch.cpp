#include <iostream>
using namespace std;
int main(){

    int array[10];
    int key,l=0,r=9,mid,n;
    for (int i = 0; i < 10; i++)
    {   
        cin>>n;
        array[i]=n;
    }
    
    printf("Enter value you want to search : ");
    cin>>key;

    while(l<=r){
        
        mid=(r+l)/2;
        if (array[mid] == key){
            cout<<"Found at :"<<mid;
            break;}
        // If x greater, ignore left half
        if (array[mid] < key)
            l = mid + 1;
 
        // If x is smaller, ignore right half
        else
            r = mid - 1;
    }
    if(array[mid]!=key){
        cout<<"Not Found";
    }
    
    return 0;
}