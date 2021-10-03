// Problem Statement: Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.
// Description: https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
//Solution:

class Solution{
  public:
  int i=0;
    void VecToTree(vector<int>& p, Node* &root)
    {
        if(i>=p.size() || root==NULL)
            return;
            
        // if(i<p.size())
        VecToTree(p, root->left);
        
        root->data = p[i];
        i++;
        // i++
        // if(i<p.size())
        VecToTree(p, root->right);
        // i++;
        return;
        
    }
    void treeToVec(Node* root, vector<int>& v)
    {
        if(root==NULL)
        return;
        treeToVec(root->left, v);
        v.push_back(root->data);
        treeToVec(root->right, v);
        return;
    }
    Node *binaryTreeToBST (Node *root)
    {
        if(root==NULL)
        return NULL;
        vector<int>v;
        treeToVec(root, v);
        sort(v.begin(), v.end());
        int i=0;
        VecToTree(v, root);
        return root;
        
    }
};
