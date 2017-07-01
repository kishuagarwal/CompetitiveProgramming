t = int(raw_input())

for i in xrange(t):
    p,q,r = map(int, raw_input().strip().split(' '))
    x = map(int, raw_input().strip().split(' '))
    y = map(int, raw_input().strip().split(' '))
    z = map(int, raw_input().strip().split(' '))

    x.sort()
    y.sort()
    z.sort()

    xPos = 0
    zPos = 0
    xSum = 0
    zSum = 0
    ans = 0

    for j in y:
        
        # loop over x
        for temp in xrange(xPos, p):
            if x[temp] > j:
                break
            xSum += x[temp]
            xPos += 1
        
        # loop over z
        for temp in xrange(zPos, r):
            if z[temp] > j:
                break
            zSum += z[temp]
            zPos += 1

        ans += (((j ** 2)) *((zPos * xPos))) 
        ans += ((xSum * j)) * zPos
        ans += ((zSum * j)) * xPos 
        ans += (xSum * zSum)
        
        if ans >= 1000000007:
            ans = ans % 1000000007
    print ans

