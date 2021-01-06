#include <bits/stdc++.h>

using namespace std;


int main() {
  // freopen("input.txt", "r", stdin);
  freopen("triangles.in", "r", stdin);
  freopen("triangles.out", "w", stdout);
  int n; cin >> n;
  pair<int, int> arr[n];
  for (int i = 0; i < n; i++) {
    int a, b; cin >> a >> b;
    arr[i] = {a, b};
  }
  int area = 0;
  for (int a= 0; a < n; a++) {
    for (int b= a+1; b < n; b++) {
      for (int c= b+1; c < n; c++) {
        int x1 = arr[a].first; int y1 = arr[a].second;
        int x2 = arr[b].first; int y2 = arr[b].second;
        int x3 = arr[c].first; int y3 = arr[c].second;
        set<int> one;
        set<int> two;
        one.insert(x1); one.insert(x2); one.insert(x3);
        two.insert(y1); two.insert(y2); two.insert(y3);
        if (one.size() == 2 && two.size() == 2) {
          int newArea = abs((x1*y2+x2*y3+x3*y1)-(x2*y1+x3*y2+x1*y3));
          area = max(area, newArea);
        }
      }
    }
  }
  cout<< area;

}
