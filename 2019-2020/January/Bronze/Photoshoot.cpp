#include <bits/stdc++.h>

using namespace std;

int n;
int arr[1000];
set<string> se;
void simulate(int ind) {
  int tempp[n];
  tempp[0] = ind;
  for (int i = 1; i < n; i++) {
    tempp[i]  = arr[i-1] - tempp[i-1];
  }
  set<int> sett;
  for (int ele : tempp) sett.insert(ele);
  if (sett.size() ==n) {
    string st = "";
    for (int ele : tempp) st+=to_string(ele);
    se.insert(st);
  }
}
int main() {
  // freopen("input.txt", "r", stdin);
  freopen("photo.in", "r", stdin);
  freopen("photo.out", "w", stdout);
  cin >> n;
  for (int i = 0; i < n-1; i++) {
    cin >> arr[i];
  }
  for (int i = 1; i < arr[0]; i++) {
    simulate(i);
  }
  char c[n];
  string str = *se.begin();
  str.copy(c, str.size());
  for (int i = 0; i < n; i++) {
    if (i < n-1) {
      cout << c[i] <<" ";
    }
    else {
      cout << c[i];
    }
  }
}
