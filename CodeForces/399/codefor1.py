n,l,r = map(long, raw_input().split())

ans = 0
if n > 1:
    rem = []
    while n > 1:
        rem.append(n % 2)
        n = n / 2
    length = len(rem)
    for i in xrange(l,r+1):
        bit_set = 0
        while (i >> bit_set) & 1 != 1:
            bit_set += 1
        if bit_set == 0:
            ans += 1
        else:
            if bit_set > length:
                ans += 0
            else:
                ans += rem[-bit_set]
else:
    ans = n
print ans