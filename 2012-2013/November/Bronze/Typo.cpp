#include <bits/stdc++.h>

using namespace std;

int main() {
  freopen("input.txt", "r", stdin);
  //freopen("template.in", "r", stdin);
  //freopen("template.out", "w", stdout);
  string str; cin >> str;
  int count = 0;
  for (int i = 0; i < str.size(); i++) {
    if (str.substr(i, i+1).compare("(") == 0) {
      count++;
    }
  }
  if (count < str.size()/2) {
    reverse(str.begin(), str.end());
  }
  int prefix[str.size()];
  for (int i = 0; i < str.size(); i++) {
    if (str.substr(i, i+1).compare("(")==0) {
      count++;
      prefix[i] = 1;
    }
    else {
      prefix[i] = -1;
    }
  }
  for (int i = 1; i < str.size(); i++) {
    prefix[i]+=prefix[i-1];
  }

  int counter = 0;
  for (int i = 0; i <str.size(); i++) {
    if (str.substr(i, i+1).compare(")")==0) {
      counter++;
      if (prefix[i] < 0) {
        break;
      }
    }
  }
  cout << counter;


}
