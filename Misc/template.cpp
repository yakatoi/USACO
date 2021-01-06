#include <bits/stdc++.h>

using namespace std;

#define x first
#define y second

const int N = 100009;

pair<int, int> st, fi;
int n;
string s;

string mv = "UDLR";
int diffx[] = {0, 0, -1, 1};
int diffy[] = {1, -1, 0, 0};

pair<int, int> d[N];

int main(){
	cin >> st.x >> st.y >> fi.x >> fi.y;
	cin >> n >> s;

	for(int i = 0; i < n; ++i){
		int id = -1;
		for(int j = 0; j < 4; ++j)
			if(mv[j] == s[i])
				id = j;
		assert(id != -1);
		d[i + 1] = make_pair(d[i].x + diffx[id], d[i].y + diffy[id]);
	}

	long long l = 0, r = 1e18;
	while(r - l > 1){
		long long mid = (l + r) / 2;
		long long cnt = mid / n, rem = mid % n;
		long long x = st.x + d[rem].x + cnt *  1LL * d[n].x;
		long long y = st.y + d[rem].y + cnt *  1LL * d[n].y;
		long long dist = abs(x - fi.x) + abs(y - fi.y);
		if(dist <= mid)
			r = mid;
		else
			l = mid;
	}

	if(r > 5e17) r = -1;
	cout << r << endl;

	return 0;
}
