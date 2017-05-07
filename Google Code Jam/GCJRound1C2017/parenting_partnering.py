import heapq

t = int(raw_input())

for i in xrange(t):
    ca, ja = map(int, raw_input().strip().split(' '))
    all_act = []
    for j in xrange(ca):
        a,b = map(int, raw_input().strip().split(' '))
        all_act.append((a,b,0))
    for j in xrange(ja):
        a, b = map(int, raw_input().strip().split(' '))
        all_act.append((a,b,1))

    all_act.sort()
    ans = 0
    ja_free = 720
    ca_free = 720

    a,b,c = all_act[0]
    a,b = a + 1440, b + 1440
    all_act.append((a,b,c))

    #import ipdb
    #if i == 1:
    #ipdb.set_trace()
    for start, end, owner in all_act[:-1]:
        if owner == 0:
            ja_free -= (end - start)
        else:
            ca_free -= (end - start)

    total_act = ca + ja + 1
    ca_gaps = []
    ja_gaps = []
    for j in xrange(1, total_act):
        if all_act[j][2] != all_act[j-1][2]:
            ans += 1
        else:
            if all_act[j][2] == 0:
                heapq.heappush(ca_gaps, (all_act[j][0] - all_act[j-1][1]))
            else:
                heapq.heappush(ja_gaps, (all_act[j][0] - all_act[j-1][1]))

    while len(ca_gaps) > 0:
        temp = heapq.heappop(ca_gaps)
        if temp <= ja_free:
            ja_free -= temp
        else:
            heapq.heappush(ca_gaps, temp)
            break

    ans += 2 * len(ca_gaps)

    while len(ja_gaps) > 0:
        temp = heapq.heappop(ja_gaps)
        if temp <= ca_free:
            ca_free -= temp
        else:
            heapq.heappush(ja_gaps, temp)
            break

    ans += 2 * len(ja_gaps)


    print 'Case #{0}: {1}'.format(i+1, ans)

