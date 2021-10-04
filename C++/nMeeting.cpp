/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include<bits/stdc++.h>
using namespace std;

struct meeting{
    int start,end,pos;
};

bool comparator(struct meeting m1, meeting m2){
    if(m1.end < m2.end) return true;
    else if(m1.end>m2.end) return false;
    else if(m1.pos <m2.pos) return true;
    return false;
}

void maxMeeting(int s[],int e[],int n){
    struct meeting meet[n];
    for(int i=0;i<n;i++){
        meet[i].start=s[i];
        meet[i].end=e[i];
        meet[i].pos=i+1;
    }
    
    sort(meet, meet+n, comparator);
    
    int limit=meet[0].end;
    
    vector<int>answers;
    answers.push_back(meet[0].pos);
    for(int i=1;i<n;i++){
        if(meet[i].start > limit){
            limit=meet[i].end;
            answers.push_back(meet[i].pos);
        }
        
    }
    for(int i=0;i<answers.size();i++){
        cout<<answers[i]<<" ";
    }
}


int main(){
    int n;
    cin>>n;
    int s[n],f[n];
    for(int i=0;i<n;i++){
        cin>>s[i];
    }
    for(int i=0;i<n;i++){
        cin>>f[i];
    }
    maxMeeting(s,f,n);
}

