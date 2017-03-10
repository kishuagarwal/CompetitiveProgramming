n, l = map(int ,raw_input().split(' '))
a = map(int ,raw_input().split(' '))
b = map(int ,raw_input().split(' '))

start = a[0]
for i in xrange(n-1):
    a[i] = a[i+1] - a[i]

a[n-1] = l - a[n-1] + start


start = b[0]
for i in xrange(n-1):
    b[i] = b[i+1] - b[i]

b[n-1] = l + start - b[n-1]


isPossible = False
for _ in xrange(n):
    isPossible = True
    for i in xrange(n):
        if a[i] != b[i]:
            isPossible = False

    if isPossible:
        break

    start = b[0]
    for i in xrange(1,n):
        b[i-1] = b[i]

    b[n-1] = start


if isPossible:
    print 'YES'
else:
    print 'NO'