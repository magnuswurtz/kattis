#include <iostream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;

int main(){
    string numberString;
    getline(cin,numberString);
    stringstream ss(numberString);
    string s;
    int comp[] = {1,1,2,2,2,8};
    int i = 0;
    while(getline(ss,s,' ')){
        int n;
        stringstream sss(s);
        sss >> n;
        cout << comp[i]-n << " ";
        i++;
    }
    return 0;
}