n = int(raw_input())
l = map(int, raw_input().strip().split(' '))

l.sort()

count = 0
for i in xrange(2, n):
    if l[i-2] + l[i-1] > l[i]:
        count += 1

if  count > 0:
    print 'YES'
else:
    print 'NO'