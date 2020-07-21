#include <vector>
#include <iostream>
using namespace std;

void print_vector(vector<int>& v){
    for (int i:v)
    {
        cout<<i<<'\t';
    }
    cout<<endl;
}
int removeDuplicates(vector<int>& nums) {
        int length = nums.size();
        auto last = nums.end();
        int j =1;
        for (auto it = nums.begin()+1; it!=last; ){
            j++;
            if(*it == *(it-1))
            {
                cout<<"Now is "<<j<<",Same"<<endl;
                nums.erase(it);
                length--;
                last--;
            }else
            {
                cout<<"Now is "<<j<<",Diff"<<endl;
                it++;
            }
        }
        return length;
}
int main(int argc, char const *argv[])
{
    vector<int> v;
    // v.push_back(1);
    // v.push_back(2);
    // v.push_back(2);
    // v.push_back(4);
    // v.push_back(5);
    print_vector(v);
    cout<<"Next"<<endl;
    auto it1 = v.begin()+1;
    auto it2 = v.end();
    if (it1==it2)
    {
        cout<<"Same!"<<endl;
    }
    
    // auto last = v.end();
    // cout<<"last:"<<*(last-1)<<endl;
    // print_vector(v);
    // v.
    // v.erase(v.begin()+4);
    // cout<<"last:"<<*(last-3)<<endl;
    // print_vector(v);
    // removeDuplicates(v);
    // // // auto i = v.begin()+2;
    // // // v.erase(i);
    print_vector(v);
    // std::vector<char> characters;
 
    // characters.assign(5, 'a');
 
    // for (char c : characters) {
    //     std::cout << c << ' ';
    // } 
 
    // characters.assign({'\n', 'C', '+', '+', '1', '1', '\n'});
 
    // for (char c : characters) {
    //     std::cout << c;
    // }
    return 0;
}
