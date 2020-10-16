#include <iostream>
#include <cstdio>
#include <vector>
using namespace std;

int main() {
  freopen("input.txt", "r", stdin);
  //freopen("word.out", "w", stdout);

  int n, k;
  cin >> n >> k;
  string temp;
  string words[n];
  int length[n];
  int ind = 0;
  while (cin >> temp) {
    words[ind] = temp;
    length[ind] = temp.length();
    ind++;
  }
  int cur = 0;
  string tm = "";
  for (int i = 0; i < n; i++) {
    if (cur + length[i] > k) {''
      cur = length[i];
      cout << tm << "\n";
      tm = length[i];
    }
    else {
      tm+= " " + words[i];
      cur+= length[i];
    }
  }
}
