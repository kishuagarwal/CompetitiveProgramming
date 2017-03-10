import operator as op
mod = 1000000007


fact= [1 for _ in xrange(2010)]
for i in xrange(2,2010):
    fact[i] = (fact[i-1] * i) % mod

def power(a,b):
    ans = 1
    y = a
    while b > 0:
        if b % 2 == 1:
            ans = ans * y
            if ans > mod:
                ans %= mod
        y = y * y
        if y > mod:
            y %= mod
        b /= 2
    return ans

def inverse(n):
    return power(n,mod-2)

def ncr(n,r):
    if r == 0 or r == n:
        return 1
    numer = 1
    for i in xrange(n-r+1,n+1):
        numer *= i
        if numer > mod:
            numer = numer % mod
    denom = fact[r]
    ans = (numer * inverse(denom)) % mod
    return ans



def get_ncr(n, r):
    r = min(r, n-r)
    if r == 0: return 1
    numer = reduce(op.mul, xrange(n, n-r, -1))
    denom = reduce(op.mul, xrange(1, r+1))
    return numer//denom

t = int(raw_input())
for i in xrange(t):
    n, m = map(int, raw_input().split(' '))
    r = [int(raw_input()) for _ in xrange(n)]
    total_ways = 0
    if n == 1:
        total_ways = m % mod
    if n <= m and n >= 2:
        s = sum(r)
        for left in xrange(n):
            for right in xrange(left+1,n):
                # print left,right
                ways = 0
                covered = 2 * s - r[left] - r[right]
                if (covered <= (m-1)):
                    ways += 2 * fact[n-2]
                    if ways >= mod:
                        ways = ways % mod
                    left_over_space = m- 1 - covered
                    ways *= ncr(left_over_space + n, n)
                    if ways >= mod:
                        ways = ways % mod
                total_ways += ways
                if total_ways >= mod:
                    total_ways = total_ways % mod

    print 'Case #{0}: {1}'.format(i+1, total_ways % mod)