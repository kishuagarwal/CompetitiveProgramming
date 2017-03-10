n = int(raw_input())
k = raw_input()

ans = 0
l = len(k)
power = 0

def greedy(k):
    global ans
    global power
    length = len(k)
    s = k[-1]
    i = length - 2
    while i >= 0 and int(k[i] + s) < n:
        s =  k[i] + s
        i -= 1
    ans += int(s) * (n ** power)
    power += 1
    if i>=0:
        if int(s) == 0:
            return k[:-1]
        else:
            while i + 1 < length and k[i+1] == '0':
                i += 1
            return k[:i+1]
    else:
        return ''

while len(k) != 0:
    k = greedy(k)

print ans