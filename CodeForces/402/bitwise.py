n,m = map(int, raw_input().strip().split(' '))

v = {}
va = []
for i in xrange(n):
    s = raw_input()
    s = s.split(' ')
    if len(s) == 3:
        v[s[0]] = [s[2]]
    else:
        v[s[0]] = [s[2], s[3], s[4]]

mamx = '0' * m
minm = '0' * m
for i in xrange(m):
    for j in v.keys():

print maxm
print minm