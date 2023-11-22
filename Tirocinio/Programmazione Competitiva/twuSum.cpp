/*
Problema TwoSum
Dato un array di N interi e un intero K,
trovare una coppia di indici i, j (i!=j) tale che V[i] + V[k] = K
*/
#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    int array[n];
    int k;
    bool continua = true;
    
    for(int i = 0; i < n-1 && continua ; i++){
        for(int j = i+1; j < n && continua; j++){
            if(array[i] + array[j] == k){
                cout<<"Gli indici sono "<<i<<" e "<<j;
                continua = false;
            }
        }
    }

    return 0;
}
