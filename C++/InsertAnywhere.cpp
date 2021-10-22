#include <iostream>
using namespace std;
struct node
{
    int data;
    node *ptr;
};
struct node *head = NULL;
void insert(int a)
{
    node *temp = new node;
    temp->data = a;
    temp->ptr = head;
    head = temp;
}
// 10->20->40
void insert_between(int add, int pos)
{
    node *temp = new node;
    temp->data = add;
    temp->ptr = NULL;
    node *temp1 = head;
    while (temp1 != NULL && temp1->data != pos)
        temp1 = temp1->ptr;
    temp->ptr = temp1->ptr;
    temp1->ptr = temp;
}
void display()
{
    if (head)
    {
        node *temp = head;
        while (temp != NULL)
        {
            cout << "Data is :" << temp->data << endl;
            temp = temp->ptr;
        }
    }
}
int main()
{
    insert(1);
    insert(2);
    insert(4);
    insert(5);
    insert(7);
    display();
    insert_between(6, 5);
    display();
    return 0;
}
