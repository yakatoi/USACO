#include <bits/stdc++.h>
using namespace std;

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0); cout.tie(0);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
	set<pair<int, int>> se;
	for (int a = 3; a <= 1000; a++) {
		if (3*a*a %(a-2) == 0) {
			int frac = 3*a*a/(a-2);
			cout << a << " " << frac << endl;
		}
	}
}
