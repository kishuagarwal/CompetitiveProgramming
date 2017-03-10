t  = int(raw_input())

for i in xrange(t):
    n, r = map(int, raw_input().split())
    points = []
    for j in xrange(n):
        a,b = map(int, raw_input().split())
        points.append((a,b))
    points.sort()
    bestPoints = None
    bestCount = 0
    ans = 0
    maximum = 0
    for left in xrange(n):
        right = 0
        while right < n and points[right][0] <= points[left][0] + r:
            right += 1
        pointsInsideColumn = points[left:right]
        pointsInsideColumn.sort(cmp=lambda x,y: x[1] - y[1])
        length = len(pointsInsideColumn)
        for top in xrange(length):
            bottom = 0
            while bottom < length and pointsInsideColumn[bottom][1] <= pointsInsideColumn[top][1] + r:
                bottom += 1
            if bottom - top > bestCount:
                bestCount = bottom -top
                bestPoints = pointsInsideColumn[top: bottom]
            if bottom == length:
                break
        if right == n:
            break
    bestSet = set(bestPoints)
    secondBestCount = 0
    secondBestPoints = 0
    for left in xrange(n):
        right = 0
        while right < n and points[right][0] <= points[left][0] + r:
            right += 1
        pointsInsideColumn = points[left:right]
        pointsInsideColumn.sort(cmp=lambda x,y: x[1] - y[1])
        length = len(pointsInsideColumn)
        for top in xrange(length):
            bottom = 0
            while bottom < length and pointsInsideColumn[bottom][1] <= pointsInsideColumn[top][1] + r:
                bottom += 1
            thisOneSet = set(pointsInsideColumn[top:bottom])
            thisPointsExclude = thisOneSet - bestSet
            if len(thisPointsExclude) > secondBestCount:
                secondBestCount = len(thisPointsExclude)
            if bottom == length:
                break
        if right == n:
            break
    ans = bestCount + secondBestCount
    print 'Case #{0}: {1}'.format(i+1, ans)