a,b,c = map(int, raw_input().strip().split(' '))

count = {}

for i in xrange(a +b + c):
    #first.append(int(raw_input()))
    d = int(raw_input())
    if d not in count:
        count[d] = 1
    else:
        count[d] = count[d] + 1

final  =[] 
for key, value in count.items():
    if value >= 2:
        final.append(key)

final.sort()

print len(final)
for i in final:
    print i

