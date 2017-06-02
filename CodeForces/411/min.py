s = raw_input()

b = 0
ans = 0
m = 10 ** 9 + 7

s = s[::-1]

#import ipdb
#ipdb.set_trace()
for index, c in enumerate(s):
    if c == 'b':
        b += 1
    else:
        ans += b
        b *= 2
        if b >= m:
            b = b % m
        if ans >= m:
            ans = ans % m 
print ans % m