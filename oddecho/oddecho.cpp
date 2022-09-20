#include <iostream>
#include <string>
using namespace std;
 
int main(){
    int n;
    cin >> n;
    string word;
    for (int i = 0; i < n; i++) {
        cin >> word;
        if(i % 2 == 0){
            cout << word << "\n";
        }
    }
    return 0;
}