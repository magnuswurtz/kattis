#include <iostream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;

int main() {
    string numberStr;
    int n;
    getline(cin,numberStr); //Read in the number as a string from cin

    stringstream intNumber(numberStr); //intermediate - convert to a stringstream
    intNumber >> n; //write the string stream to the integer
    string str;
    for(int i = 0; i < n; i++)
    {   
        vector<string> line;
        getline(cin,str);
        stringstream ss(str);
        string s;
        while(getline(ss,s,' ')){
            line.push_back(s);
        }       
        if(line[0] == "Simon" && line[1] == "says"){
             for (vector<string>::size_type i = 2; i < line.size(); i++)
             {
                cout << line[i] << ' '; 
             }
             cout << "\n";
        }    
    }
    return 0;
}