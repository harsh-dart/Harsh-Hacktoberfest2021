#include<iostream>
#include<algorithm>
using namespace std;

int kthSmallest(int arr[], int l, int r, int k) {
        sort(arr,arr+r+1);  //O(nlogn) complexity
        return arr[k-1];
    }

int main(){

    int arr[]={9,5,3,2,90,100};
    cout<<kthSmallest(arr,0,6,3);
    return 0;
}


