#include <bits/stdc++.h>

using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  int n;
  cin >> n;
  int arr[n+1];
  int pre[n+1];
  arr[0] = pre[0] = 0;
  for (int i = 1; i <= n; i++) {
    cin >> arr[i];
    pre[i] = 0;
  }
  for (int i = 1; i <= n; i++) {
    pre[i]= pre[i-1] + arr[i];
  }
  int counter = 0;
  for(int i = 1; i <= n; i++) {
    for(int j = i; j <= n; j++) {
      int sum = pre[j] - pre[i-1];
      // for(int a = i; a <= j; a++) {
      //   sum += arr[a];
      // }
      bool isFlower = false;
      for(int a = i; a <= j; a++) {
        if(arr[a] * (j-i+1) == sum) {
          isFlower = true;
        }
      }
      if(isFlower) {
        counter++;
      }
    }
  }
  cout << counter;


}
