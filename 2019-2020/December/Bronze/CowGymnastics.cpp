#include <bits/stdc++.h>

using namespace std;
int n, k;
int counter = 0;
int arr[11][21];

bool isBef(int one, int two, int ind) {
  for (int i = 0; i < n; i++) {
    if (arr[ind][i] == two) return false;
    if (arr[ind][i] == one) return true;
  }
  return false;
}
bool test(int one, int two) {
  for (int i = 0; i < k; i++) {
    if (!isBef(one, two, i)) {
      return false;
    }
  }
  return true;
}


int main() {
  // freopen("input.txt", "r", stdin);
  freopen("gymnastics.in", "r", stdin);
  freopen("gymnastics.out", "w", stdout);
  cin >> k >> n;
  for (int i = 0; i < k; i++) {
    for (int j = 0; j < n; j++) {
      cin >> arr[i][j];
    }
  }

  for (int i = 1; i <= n; i++) {
    for (int j = 1; j<= n;j++) {
      if (test(i, j)) {
        counter++;
      }
    }
  }
  cout << counter;
}
