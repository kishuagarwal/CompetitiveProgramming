def times(x,y):
    if n == 1:
        rounds = k / m
        left = k - rounds * m
        if left >= y:
            rounds += 1
        return rounds
    rounds = k / ((n-1)*m)
    left = k - (rounds * (n-1)* m)
    if x == 1:
        if rounds % 2 == 1:
            t = (rounds / 2) + 1 
        else:
            t = rounds / 2 
    elif x == n:
        t = rounds / 2
    else:
        t = rounds
    if rounds % 2 == 0:
        # from top
        if (left >= ((x - 1) * m + y)):
            t += 1  
    else:
        # from bottom
        if (left >= ((n-x) * m + y)):
            t += 1
    return t


n,m,k,x,y = map(long, raw_input().split())
maximum = 0
minimum = k
for i in xrange(1,n+1):
    for j in xrange(1,m+1):
        ans = times(i,j)
        if ans > maximum:
            maximum = ans
        if ans < minimum:
            minimum = ans

print maximum, minimum, times(x,y)
