#include <bits/stdc++.h>

using namespace std;

struct locknum {
  int a, b, c;
};
int n;
int countforone(int a, int b) {
  bool check = (a==n && b==1) ||(a==1 && b==n) || (a==n-1 && b==1) ||(a==n-1 && b==1) ||(a==n && b==2) ||(a==2 && b==n);
  if (check || abs(b-a)<=2) {
    return 1;
  }

  return 0;
}
bool comparelocks(locknum on, locknum tw) {
  int count = countforone(on.a, tw.a);
  count+=countforone(on.b, tw.b);
  count+=countforone(on.c, tw.c);
  return count == 3;
}
int main() {
  // freopen("input.txt", "r", stdin);
  freopen("combo.in", "r", stdin);
  freopen("combo.out", "w", stdout);
  cin >> n;
  int ainp, binp, cinp; cin >> ainp >> binp >> cinp;
  locknum one = {ainp, binp, cinp};
  cin >> ainp >> binp >> cinp;
  locknum two = {ainp, binp, cinp};

  // cout << one.a << " " << one.b << " " << one.c << endl;
  // cout << two.a << " " << two.b << " " << two.c << endl;
  int counter = 0;
  for (int a = 1; a<= n; a++){
    for (int b = 1; b<= n; b++){
      for (int c = 1; c<= n; c++){
        locknum temp = {a, b, c};

        if (comparelocks(temp, one) || comparelocks(temp, two)) {
          counter++;

        }

      }
    }
  }

  cout << counter;


}
