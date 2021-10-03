#include<iostream>
using namespace std;

int main() {

    int n1, n2, n3;
    cout<<"Enter number of rows and columns of matrix: ";
    cin>>n1>>n2>>n3;

    int A[n1][n2], B[n2][n3], C[n1][n3];

    cout<<"Enter elements of matrix A: "<<endl;
    for(int i=0; i<n1; i++) {
        for(int j=0; j<n2; j++) {
            cin>>A[i][j];
        }
    }

    cout<<"Enter elements of matrix B: "<<endl;
    for(int i=0; i<n2; i++) {
        for(int j=0; j<n3; j++) {
            cin>>B[i][j];
        }
    }

    for(int i=0; i<n1; i++) {
        for(int j=0; j<n3; j++) {
            C[i][j] = 0;
        }
    }

    for(int i=0; i<n1; i++) {
        for(int j=0; j<n3; j++) {
            for(int k=0; k<n2; k++) {
                C[i][j] += A[i][k] * B[k][j];
            } 
        }
    }
    
    cout<<"The resultant matrix C: "<<endl;
    for(int i=0; i<n1; i++) {
        for(int j=0; j<n3; j++) {
            cout<<C[i][j]<<" ";
        }
        cout<<endl;
    }

    return 0;
}