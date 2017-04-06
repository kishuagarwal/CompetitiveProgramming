n = int(raw_input())

lead = 0
winner = 0
first = 0
second = 0
for i in xrange(n):
    f, s = map(int, raw_input().strip().split(' '))
    first += f
    second += s
    if abs(second - first) >= lead:
        lead = int(abs(second-first))
        winner = 1 if (first > second) else 2

print winner, lead 