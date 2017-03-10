def getSum(bit, i):
    if i < 0 or i >= n:
        return 0
    s = 0
    i = i+1
    while i > 0:
        s += bit[i]
        i -= i & (-i)
    return s


def updatebit(bit, n, i, v):
    i += 1
    while i <= n:
        bit[i] += v
        i  += i & (-i)

def construct(n):
    bit = [0]*(n+1)
    for i in xrange(n):
        updatebit(bit,n,i,1)
    return bit


t = int(raw_input())
for i in xrange(t):
    n,m = map(int,raw_input().split())
    w1,aw,bw = map(int, raw_input().split())
    d1,ad,bd = map(int, raw_input().split())
    s1,aas,bs = map(int, raw_input().split())
    w = [0 for _ in xrange(m)]
    d = [0 for _ in xrange(m)]
    s = [0 for _ in xrange(m)]
    z = [0 for _ in xrange(m)]
    w[0] = w1
    d[0] = d1
    s[0] = s1
    for j in xrange(1,m):
        w[j] = ((aw * w[j-1] + bw) % n) + 1
    for j in xrange(1,m):
        d[j] = ((ad * d[j-1] + bd) % 3)
    for j in xrange(m):
        z[j] = max(1, min(n,w[j]+d[j]-1))
    for j in xrange(1,m):
        s[j] = ((aas * s[j-1] + bs) % 1000000000) + 1
    bit = construct(n)
    total_ways = 0
    wands = [[0, 1, 0] for _ in xrange(n)]
    for j in xrange(m):
        ways = total_ways
        w[j] -= 1
        z[j] -= 1
        if z[j] == w[j]:
            left = max(getSum(bit,w[j]-1),1)
            right = max(getSum(bit,n-1)-getSum(bit,w[j]+1),1)
            adjacent = 1
            if w[j] != n-1:
                adjacent = wands[w[j]+1][1]
            other_ways = left* adjacent * right
            new_ways = s[j]* other_ways
            updatebit(bit,n,w[j],new_ways)
        if z[j] == w[j]-1:
            left = max(getSum(bit,w[j]-2),1)
            right = max(1,getSum(bit,n-1)-getSum(bit,w[j]+1))
            adjacent = 1
            if w[j] != n-1:
                adjacent = wands[w[j]+1][1]
            other_ways = left* adjacent * right
            new_ways = s[j]* other_ways*wands[z[j]][2]
            updatebit(bit,n,w[j],new_ways)
        if z[j] == w[j]+1:
            left = max(getSum(bit,w[j]-1),1)
            right = max(getSum(bit,n-1)-getSum(bit,w[j]+2),1)
            adjacent = 1
            if z[j] != n-1:
                adjacent = wands[z[j]+1][1]
            other_ways = left* adjacent * right
            new_ways = s[j]* other_ways*wands[z[j]][0]
            updatebit(bit,n,z[j],new_ways)

        if z[j] > w[j]:
            wands[w[j]][2] += s[j]
        elif z[j] == w[j]:
            wands[w[j]][1] += s[j]
        else:
            wands[w[j]][0] += s[j]
        ways += new_ways
        #print 'Case ',i
        #print j, ways
        total_ways += ways


    print 'Case #{0} {1}'.format(i+1, total_ways)