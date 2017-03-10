def f_m(a,n,m,d):
    if n == 1:
        return ((10 ** d) % m, a % m)
    l,r  = f_m(a,n/2, m,d)
    r = (l * r + r ) % m
    l = (l * l) % m
    if n % 2 == 1:
        l = (10 ** d) * l
        r = (10 ** d) * r + a
    return l%m,r%m

t = int(raw_input())
for _ in xrange(t):
    a,n,m = map(int,raw_input().split())
    am = a % m
    d = len(str(a))
    l,r = f_m(a,n,m,d)
    print r % m