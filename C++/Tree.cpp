#include <bits/stdc++.h>
using namespace std;
template <typename T>
class Treenode
{
    public:
    T data;
    vector<Treenode<T>*> children;
    Treenode(T data)
    {
        this->data = data;
    }
};
Treenode<int> *takeInputLevelwise()
{
    int rootdata;
    cout<<"Enter root data "<<endl;
    cin>>rootdata;
    Treenode<int>* root=new Treenode<int>(rootdata);
    queue<Treenode<int>*> pendingChild;
    pendingChild.push(root);
    while(pendingChild.size()!=0)
    {
    Treenode<int>* front=pendingChild.front();
    pendingChild.pop();
    cout<<"Enter number of child of "<<front->data<<" "<<endl;
    int n;
    cin>>n;
    for(int i=0;i<n;i++)
    {
        cout<<"Enter data of "<<i<<" th child of "<<front->data<<" "<<endl;
        int childData;
        cin>>childData;
        Treenode<int>* child=new Treenode<int>(childData);
        front->children.push_back(child);
        pendingChild.push(child);
    }
    }
    return root;
}
void printLevelwise(Treenode<int>* root)
{
    if(root==NULL)
    {
        return;
    }
    queue<Treenode<int>*> printchild;
    printchild.push(root);
    while(printchild.size()!=0)
    {
        Treenode<int>* front=printchild.front();
        printchild.pop();
    cout<<front->data<<":";
    
    for(int i=0;i<front->children.size();i++)
    {
        cout<<root->children[i]->data<<",";
    }
    for (int i = 0; i < front->children.size(); i++)
    {
        /* code */
    printchild.push(front->children[i]);
    }
    
    cout<<endl;
    }

}
void printTree(Treenode<int> *root)
{
    if(root==NULL)
    {
        return;
    }
    cout<<root->data<<":";
    for (int i = 0; i < root->children.size(); i++)
    {
        cout<<root->children[i]->data<<",";
    }
    cout<<endl;
    for (int i = 0; i <root->children.size(); i++)
    {
        printTree(root->children[i]);
    } 
}
Treenode<int> *takeInput()
{
    int rootdata;
    cout<<"Enter root data"<<endl;
    cin>>rootdata;
    Treenode<int>*root=new Treenode<int>(rootdata);
    cout<<"Enter the numbers of child of "<<rootdata<<" ";
    int n;
    cin>>n;
    for(int i = 0; i < n; i++)
    {
        Treenode<int>* child=takeInput();
        root->children.push_back(child);
    }
    return root;
}
int main()
{
// Treenode<int>*root=new Treenode<int>(1);
// Treenode<int>*node1=new Treenode<int>(2);
// Treenode<int>*node2=new Treenode<int>(3);
// root->children.push_back(node1);
// root->children.push_back(node2);
Treenode<int>* root=takeInputLevelwise();
printLevelwise(root);
}