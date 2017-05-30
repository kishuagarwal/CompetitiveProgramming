s = int(raw_input().strip())

for i in xrange(s):
    n = int(raw_input().strip())
    h = map(int, raw_input().strip().split(' '))
    if n % 2 == 0:
        print 'no'
        continue

    possible = True
    for j in xrange((n/2) + 1):
        if (j + 1) != h[j]:
            print 'no'
            possible = False
            break

    if not possible:
        continue

    for j in xrange((n/2)+1, n):
        if h[j] != ((n-1) - j + 1):
            print 'no'
            possible = False
            break
    if not possible:
        continue

    print 'yes'