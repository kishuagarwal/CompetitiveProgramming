s = raw_input()
k = int(raw_input())

freq = [0 for _ in xrange(26)]
for c in s:
    freq[ord(c) - ord('a')] += 1

t = []
for c in s:
    if freq[ord(c) - ord('a')] >= k:
        t.append(c)

t = ''.join(t)
print t