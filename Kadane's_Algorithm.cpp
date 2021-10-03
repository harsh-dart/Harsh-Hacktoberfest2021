#include<iostream>
using namespace std;

long long maxSubarraySum(int arr[], int n){
        
        long long  maxSum=0;
        long long  curSum=0;
        long long negativeMax=INT32_MIN;
        
        for(int i=0;i<n;i++){
            curSum+=arr[i];
            if(curSum>maxSum){
                maxSum=curSum;
            }
            if(curSum<0){
                if(curSum>=negativeMax)
                    negativeMax=curSum;
                curSum=0;
            }
        }
        return maxSum==0 && curSum==0?negativeMax:maxSum;
        
    }

int main(){
    int arr[]={1,2,-5,4,2,6,-8,1};
    cout<<maxSubarraySum(arr,8)<<endl;
    return 0;
}
    