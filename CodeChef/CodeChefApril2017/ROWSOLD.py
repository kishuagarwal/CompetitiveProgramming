t = int(raw_input())

for i in xrange(t):
    s = raw_input().strip()
    l = len(s)
    count = 0
    prev = ' '
    ans = 0
    ones = 0
    for j in xrange(l-1, -1,-1):
        if s[j] == '0':
            if j == l-1 or prev != '0':
                count += 1
        else:
            ans += count + l-1 - ones- j
            ones += 1
        #print
        #print j, s[j], prev, count, ones, ans
        prev = s[j]

    print ans
