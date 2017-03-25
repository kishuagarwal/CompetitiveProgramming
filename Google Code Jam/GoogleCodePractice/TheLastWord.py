t = int(raw_input())

for i in xrange(1, t+1):
    s = raw_input()
    l = []
    taken = [False for j in xrange(len(s))]
    for index, c in enumerate(s):
        if c >= s[0]:
            taken[index] = True
            l.append((c,index))

    l.sort()
    if len(l) == 0:
        print 'Case #{0}: {1}'.format(i,s)
        continue
    l = l[::-1]
    lar = l[0]
    if len(l) > 1:
        for j in l[1:]:
            if j[1] > lar[1]:
                taken[j[1]] = False
            else:
                lar = j

    ans = ''
    rem = ''
    for j in xrange(len(s)-1, -1,-1):
        if taken[j]:
            ans += s[j]
        else:
            rem += s[j]

    rem = rem[::-1]
    ans += rem
    print 'Case #{0}: {1}'.format(i,ans)


