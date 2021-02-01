#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
//10271
  int t; cin >> t;
  while (t-->0) {
    int n; cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) cin >> arr[i];
    set<int> se;
    for (int ele : arr) se.insert(ele);
    map<int, int> ma;
    int x = 0;
    for (int ele :arr) {
      ma[ele]++;
    }
    vector<int> vec;
    for (int ele : se) {
      vec.push_back(ma[ele]);
      // cout << ele << " " << ma[ele] << endl;
    }
    sort(vec.begin(), vec.end(), greater<int>());
    // for (int ele : vec) cout << ele << " ";
    for (int i = 1; i < vec.size(); i++) {
      if (vec[i] >= vec[i-1]) vec[i] = vec[i-1]-1;
    }// 4 3  4
    for (int i = 0; i < vec.size(); i++) {
      if (vec[i]<0) vec[i] = 0;
    }

    int sum = accumulate(vec.begin(), vec.end(), 0);

    // cout << endl;
    // cout << endl;
    cout << sum << endl;
  }
}
