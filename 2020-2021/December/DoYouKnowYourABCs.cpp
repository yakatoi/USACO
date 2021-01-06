#include <bits/stdc++.h>

using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  int arr[7];
  cin >> arr[0] >> arr[1] >> arr[2] >> arr[3] >> arr[4] >> arr[5] >> arr[6];
  sort(arr, arr+7);
  if (arr[6] == arr[0] + arr[1] + arr[2]) {
    cout << arr[0] << " " << arr[1] << " " << arr[2];
  }
  else {
    cout << arr[0] << " "  << arr[1] << " " << arr[3];
  }

}
