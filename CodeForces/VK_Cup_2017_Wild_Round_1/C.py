n = int(raw_input())
count = [6,2,5,5,4,5,6,3,7,6]

ans = ''
while n > 0:
    minimum = 10
    pos = 10
    for i in xrange(0, 10):
        if count[i] <= n and count[i] < minimum:
            minimum = count[i]
            pos = i
    if minimum != 10:
        ans = str(pos) + ans
        n -= minimum
    else:
        break

found = False
if n == 1:
    length = len(ans)
    for j in xrange(length):
        if count[int(ans[j])] < 7:
            for i in xrange(9, -1,-1):
                if count[i] == count[int(ans[j])] + 1:
                    ans = ans[:j] + str(i) + ans[j+1:]
                    found = True
                    break
        if found:
            break

print ans