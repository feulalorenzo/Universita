#include <iostream>

using namespace std;

int main()
{
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);

    int n = 0, cont = 1;
    cin>>n;

    while(n!=1){
        if(n%2 == 0)
            n = n/2;
        else
            n = n*3 + 1;
        cont++;
    }

    cout<<cont;
    return 0;
}
