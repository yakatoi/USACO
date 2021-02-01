#include <bits/stdc++.h>
using namespace std;

int n, k;
map<int, set<int>> pos;
map<int, set<int>> m;
int arr[100000];
int comp[100000];
int counter = 1 ;

void dfs(int ind) {
comp[ind] = counter;
if (comp[arr[ind]] ==0) {
  dfs(arr[ind]);
}
}

int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0);cout.tie(0);

   cin >> n >> k;
   for (int i =0; i< n; i++) arr[i] = i;
   for (int i =0; i< n; i++) m[i].insert(i);
   for (int i = 0; i < k; i++) {
     int a, b;
     cin >> a>> b;
     a--;b--;
     m[arr[a]].insert(b);
     m[arr[b]].insert(a);
     int temp = arr[a];
     arr[a] = arr[b];
     arr[b] = temp;
   }

   for (int i = 0; i < n; i++) {
     if (comp[i] ==0 ) {
       dfs(i);
       counter++;
     }
   }
   for (int i = 0; i < n; i++) {
     pos[comp[i]].insert(m[i].begin(), m[i].end());
   }
   for (int i = 0; i < n; i++) {
     cout << pos[comp[i]].size() << '\n';
   }
}
