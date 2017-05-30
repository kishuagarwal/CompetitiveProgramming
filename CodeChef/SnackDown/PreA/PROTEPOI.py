t = int(raw_input())

def find_min(snakes,start,end):
    num = len(snakes)
    required = 1
    if num == 0:
        return -1
    l = [0]
    if snakes[0][0] > start:
        return -1
    for i in xrange(1,num):
        if snakes[i][0] > (snakes[l[-1]][1] + 1):
            return -1
        if snakes[i][1] <= snakes[l[-1]][1]:
            continue
        if snakes[i][0] == snakes[l[-1]][0]:
            l[-1] = i
            continue
        if required > 1 and snakes[i][0] <= (snakes[l[-2]][1]+1):
            l[-1] = i
            continue
        required += 1
        l.append(i)
    if snakes[l[-1]][1] < end:
        return -1
    return required

for i in xrange(t):
    n,k,m = map(int, raw_input().strip().split(' '))
    rows = []
    cols = []
    start = ((n - k)/2) + 1 
    end = start + k - 1
    for j in xrange(m):
        c = map(int, raw_input().strip().split(' '))
        if c[0] == c[2]: # row snakes
            a = min(c[1], c[3])
            b = max(c[1], c[3])
            if not (b < start or a > end):
                a = max(start, a)
                b = min(end, b)
                rows.append([a,b])
            if c[0] >= start and c[0] <= end:
                cols.append([c[0], c[0]])
        if c[1] == c[3]: # col snakes
            a = min(c[0], c[2])
            b = max(c[0], c[2])
            if not (b < start or a > end):
                a = max(start, a)
                b = min(end, b)
                cols.append([a,b])
            if c[1] >= start and c[1] <= end:
                rows.append([c[1], c[1]])
    rows.sort()
    cols.sort()
    ans = 0
    temp = find_min(rows, start,end)
    if temp == -1:
        print -1
        continue
    ans += temp
    temp = find_min(cols, start, end)
    if temp == -1:
        print -1
        continue

    ans += temp
    print ans
