t = int(raw_input())

for i in xrange(t):
    n,k = map(int, raw_input().split())
    presence = []
    lengths = []
    for j in xrange(n):
        l = map(int, raw_input().split())
        lengths.append(l[0])
        temp = [False for _ in xrange(k+1)]
        for x in l[1:]:
            temp[x] = True
        presence.append(temp)
    ans = 0
    for first in xrange(n):
        for second in xrange(first+1, n):
            if lengths[first] + lengths[second] >= k:
                possible = True
                pf = presence[first]
                ps = presence[second]
                for x in xrange(1,k+1):
                    if not pf[x] and not ps[x]:
                        possible = False
                        break

                if possible:
                    ans += 1

    print ans
