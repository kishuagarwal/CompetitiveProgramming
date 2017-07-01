t = int(raw_input())

for i in xrange(t):
    n = int(raw_input())
    l = map(int, raw_input().split())
    l.sort()
    ans = -1e18
    neg = 0
    pos = 0
    count = 0
    if l[0] >= 0:
        print sum(l) * len(l)
    elif l[-1] < 0:
        print sum(l)
    else:
        total = sum(l)
        for j in l[::-1]:
            count += 1
            if j >= 0:
                pos += j
            else:
                neg += j
                if count * (pos + neg) < (count - 1) * (pos + neg - j):
                    ans = (count - 1) * (pos + neg - j) + total - (pos + neg - j) 
                    break
                ans = count * (pos + neg) + total - (pos + neg)

        print ans




