n = int(raw_input())
l = map(int, raw_input().split(' '))
for i in xrange(n/2):
    if i % 2 == 0:
        l[i],l[n-i-1] = l[n-i-1],l[i]

l = [str(i) for i in l]
print ' '.join(l)