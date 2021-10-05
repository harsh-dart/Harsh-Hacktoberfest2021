# include <iostream>
# include <string.h>

using namespace std;

int main()
{
    char str[200];
    cout<<"Enteer a string : ";
    gets(str);

    int count = 0;

    int len = strlen(str);

    for(int i = 0; i < len; i++)
    {
        if(str[i] == ' ')
        {
            count++;
        }
    }

    cout<<count+1<<endl;

    return 0;
}
