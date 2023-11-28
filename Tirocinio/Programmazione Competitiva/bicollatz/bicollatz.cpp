#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    int a,b,cont = 0;
    cin>>a;
    cin>>b;

    while(a != 1 || b != 1){
        if(a%2==0 && b%2==0){
            a = a/2;
            b = b/2;
        }
        else{
            if(a%2==1 && b%2==1){
                a = a*3+1;
                b = b*3+1;
            }
            else{
                if(a%2==1)
                    a = a+3;
                else
                    b = b+3;
            }
        }
        cont++;
    }
    cout<<cont;
    return 0;
}
