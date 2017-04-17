t = int(raw_input())

for i in xrange(t):
    n, k = map(int, raw_input().strip().split(' '))
    ing = []
    count = [0 for j in xrange(k+1)]
    for j in xrange(n):
        ing.append(map(int,raw_input().strip().split(' ')))
        for x in ing[j][1:]:
            count[x] += 1
    possible = True
    essential = True
    for j in xrange(1,k+1):
        if count[j] == 0:
            possible = False

    if possible:
        for j in xrange(n):
            neccessary = False
            for x in ing[j][1:]:
                if count[x] == 1:
                    neccessary = True
                    break
            if not neccessary:
                essential = False
                break
    if not possible:
        print 'sad'
    elif not essential:
        print 'some'
    else:
        print 'all'