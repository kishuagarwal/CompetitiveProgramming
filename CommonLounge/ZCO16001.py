s = raw_input().strip().split(' ')
n = int(s[0])
k = int(s[1])
s = s[2:]
first = map(int, s[:n])
second = map(int, s[n:])


if k >= n:
    s.sort(reverse=True)
    print s[0] + s[n]
else:
    first.sort(reverse=True)
    second.sort(reverse=True)
    if max(first) > max(second):
        first, second = second, first
    print first
    print second
    for i in xrange(k):
        if second[i] > first[n-i-1]:
            second[i], first[n-i-1] = first[n-i-1], second[i]
        else:
            break
    print first
    print second
    print max(first) + max(second)
