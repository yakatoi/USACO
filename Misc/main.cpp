#include <bits/stdc++.h>
using namespace std;
int compute(int x, string type) {
  if (x==0) {
    if (type == "R") return 1;
    else return 0;
  }
  if (type == "R") return compute(x-1, "Y") + compute(x-1, "B");
  if (type == "Y") return compute(x-1, "R") + compute(x-1, "B");
  return compute(x-1, "Y") + compute(x-1, "R");

}
int main() {
  cout << compute(11, "R");
}
