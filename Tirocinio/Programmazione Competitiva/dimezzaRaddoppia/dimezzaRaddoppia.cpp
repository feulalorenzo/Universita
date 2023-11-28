#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){

    vector<int> V;

    for(int i = 0; i < 20; i++){
        cout<<"Dimensione: "<<V.size();
        cout<<"Capacità: "<<V.capacity();
    }

    return 0;

}
