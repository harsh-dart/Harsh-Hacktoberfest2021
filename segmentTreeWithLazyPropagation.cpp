#include <bits/stdc++.h>

using namespace std;

const int NMAX = 1e6;
typedef long long int ll;

ll st[NMAX], lazy[NMAX];
ll n;

void update(ll p, ll l, ll r, ll a, ll b, ll v) {
    if (lazy[p] != 0) {
        st[p] += (r - l + 1) * lazy[p];

        if (l != r) {
            lazy[p<<1] += lazy[p];
            lazy[(p<<1)+1] += lazy[p];
        }

        lazy[p] = 0;
    }

    if (r < a || l > b) return;

    if (a <= l && b >= r)
    {
        st[p] += (r - l + 1) * v;
        if (l != r){
            lazy[p<<1] += v;
            lazy[(p<<1) + 1] += v;
        }
        return;
    }

    ll mid = (l + r) >> 1;

    update(p<<1, l, mid, a, b, v);
    update((p<<1) + 1, mid+1, r, a, b, v);

    st[p] = st[p<<1] + st[(p<<1) + 1];

}

ll query(ll p, ll l, ll r, ll a, ll b) {
    if (lazy[p] != 0) {
        st[p] += (r - l + 1) * lazy[p];
        if (l != r) {
            lazy[p<<1] += lazy[p];
            lazy[(p<<1) + 1] += lazy[p];
        }
        lazy[p] = 0;
    }

    if (r < a || l > b) return 0;

    if (a <= l && b >= r) {
        return st[p];
    }

    ll mid = (r+l) >> 1;

    return query(p<<1, l, mid, a, b) + query((p<<1) + 1, mid+1, r, a, b);

}

int main() {
    ll tc;
    scanf("%lld", &tc);
    while (tc--) {
        ll q;
        scanf("%lld %lld", &n, &q);
        memset(st, 0, sizeof(st));
        memset(lazy, 0, sizeof(lazy));
        
        ll a, b, v;
        while (q--) {
            ll x;
            scanf("%lld %lld %lld", &x, &a, &b);
            if(x) {
                printf("%lld\n", query(1, 1, n, a, b));
            } else {
                scanf("%lld", &v);
                update(1, 1, n, a, b, v);
            }
        }
    }
}

/*Problem:
0 p q v - you have to add v to all numbers in the range of p to q (inclusive), where p and q are two indexes of the array.
1 p q - output a line containing a single integer which is the sum of all the array elements between p and q (inclusive).
In the first line you'll be given T, number of test cases.
Each test case will start with N(quantity of numbers)  and C(number of commands).
After that you'll be given C commands in the format as mentioned above. */
