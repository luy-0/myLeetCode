#include <vector>
#include <iostream>
#include <map>
using namespace std;

int getSubBoxNum(int row,int col){
    if(row<3)
        if(col<3)
            return 0;
        else
        if(col>5)
            return 2;
        else
            return 1;
    else
    if(row>5)
        if(col<3)
            return 6;
        else
        if(col>5)
            return 8;
        else
            return 7;
    else
        if(col<3)
            return 3;
        else
        if(col>5)
            return 5;
        else
            return 4;

}

void printmap(map<char,int> mm){
    if (mm.begin()==mm.end())
    {
        cout<<"NoNum!\n";
    }
    
    for (auto it = mm.begin(); it != mm.end(); ++it) {
            cout << it->first << ", " << it->second <<endl;
  }
}

bool checkInMap(char cc,map<char,int>& mm){
    auto it = mm.find(cc);
    if (cc=='1')
    {
        printmap(mm);
    }
    
    if(it==mm.end()){
        mm.insert({cc,1});
        cout<<"Nofind";}
    else{
        cout<<"FIND!";
        return true;
    }
    return false;
}


bool isValidSudoku(vector<vector<char>>& board) {
    map<char,int> colMap[9];
    map<char,int> rawMap[9];
    map<char,int> subMap[9];

    for(int i=0;i<9;i++)
        for(int j=0;j<9;j++){
            char ch = board[i][j];
            if(ch=='.')continue;

            if(checkInMap(ch,rawMap[i]))
                {return false;cout<<i<<","<<j<<','<<ch<<",rawMap,Error"<<endl;}
                else
                    cout<<i<<","<<j<<','<<ch<<",rawMap,OK"<<endl;
            if(checkInMap(ch,colMap[j]))
                {return false;cout<<i<<","<<j<<','<<ch<<",colMap,Error"<<endl;}
                else
                    cout<<i<<","<<j<<','<<ch<<",colMap,OK"<<endl;
            if(checkInMap(ch,subMap[getSubBoxNum(i,j)]))
                {cout<<i<<","<<j<<','<<ch<<",subMap"<<getSubBoxNum(i,j)<<",OK"<<endl;return false;}
                else
                    cout<<i<<","<<j<<','<<ch<<",subMap"<<getSubBoxNum(i,j)<<",OK"<<endl;
        }
    return true;
}


int main(int argc, char const *argv[])
{

    vector<vector<char>> Box160 = {{'5','3','.','.','7','.','.','.','.'},
{'6','.','.','1','9','5','.','.','.'},
{'.','9','8','.','.','.','.','6','.'},
{'8','.','.','.','6','.','.','.','3'},
{'4','.','.','8','.','3','.','.','1'},
{'7','.','.','.','2','.','.','.','6'},
{'.','6','.','.','.','.','2','8','.'},
{'.','.','.','4','1','9','.','.','5'},
{'.','.','.','.','8','.','.','7','9'}};

    isValidSudoku(Box160);
    return 0;
}


