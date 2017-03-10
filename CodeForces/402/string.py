t = raw_input()
p = raw_input()
o = map(int, raw_input().strip().split(' '))


length = len(o)
l = 0
h = length - 1

for i in xrange(length):
    o[i] -= 1

freq = [0 for i in xrange(26)]
total = len(p)
for c in p:
    ordinal = ord(c) - ord('a')
    freq[ordinal] += 1

present = None
def check():
    pos = 0
    for index in xrange(length):
        if present[index]:
            if t[index] == p[pos]:
                pos += 1
                if pos == total:
                    break
    if pos == total:
        return True
    else:
        return False


while l < h:
    m = (l + h) / 2
    present = [True for i in xrange(length)]
    for i in xrange(m+1):
        present[o[i]] = False

    isPossible = check()
    if not isPossible:
        h = m
    else:
        l = m + 1

print l