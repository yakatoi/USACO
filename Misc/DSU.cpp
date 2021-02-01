#include <bits/stdc++.h>
using namespace std;
int parent[500000];
void initialize(int n) {
  for (int i = 0; i < n; i++) {
    parent[i] = i;
  }
}
int find(int x) {
  if(x == parent[x]) {
    return x;
  }
  else {
    return parent[x] = find(parent[x]);
  }
void unite(int a, int b) {
  int c = find(a);
  int d = find(b);
  if(c != d) {
    parent[d] = c;
  }
}
int main() {

}
