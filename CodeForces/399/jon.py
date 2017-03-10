n = int(raw_input())
l = map(int, raw_input().strip().split(' '))

l.sort()
first = l[0]
last = l[-1]

count = 0

if n > 2:
    for i in l[1:-1]:
        if i > first and i < last:
            count += 1

print count