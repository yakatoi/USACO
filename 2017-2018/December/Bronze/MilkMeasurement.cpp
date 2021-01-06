#include <bits/stdc++.h>

using namespace std;


int main() {
  // freopen("input.txt", "r", stdin);
  freopen("measurement.in", "r", stdin);
  freopen("measurement.out", "w", stdout);
  int n; cin >> n;
  int arr[3];
  arr[0] = arr[1] = arr[2] = 7;
  int counter = 0;
  set<int> winners;
  winners.insert(0);winners.insert(1);winners.insert(2);
  vector<pair<int, pair<string, int>>> vec;
  for (int i = 0; i < n; i++) {
    int day; cin >> day;
    string name; cin >> name;
    int inc; cin >> inc;
    vec.push_back({day, {name, inc}});
  }
  sort(vec.begin(), vec.end());
  // for (auto ele : vec) {
  //   int a = ele.first;
  //   cout << a  << ": " << ele.second.first <<" "<< ele.second.second << endl;
  // }
  for (auto ele : vec) {
    auto p = ele.second;
    if (p.first == "Mildred") arr[0]+=p.second;
    if (p.first == "Elsie") arr[1]+=p.second;
    if (p.first == "Bessie") arr[2]+=p.second;
    set<int> temp;
    int max = *max_element(arr, arr+3);
    for (int i = 0; i < 3; i++) {
      if (max==arr[i]) temp.insert(i);
    }
    if (temp!= winners) {
      counter++;
      winners.clear();
      for (int ele: temp) winners.insert(ele);
    }
  }
  cout << counter;
}
