import operator as op
def get_ncr(n, r):
    r = min(r, n-r)
    if r == 0: return 1
    numer = reduce(op.mul, xrange(n, n-r, -1))
    denom = reduce(op.mul, xrange(1, r+1))
    return numer//denom

def get_coefficient(x,y,h):
    h = h - 1- x
    ans = 0
    neg_power = x + 1
    for i in range(x+1):
        if i == 0:
            cur_power = 0
            cur_coeff= 1
        else:
            cur_power = y * i
            cur_coeff = ((-1) ** i) * get_ncr(x,i)
        if cur_power > h :
            break
        rem = h - cur_power
        coeff = get_ncr(neg_power + rem -1, rem)
        ans += cur_coeff * coeff
    return ans 

z = int(raw_input())

for i in range(1, z+1):
    h, s = map(int, raw_input().split())
    spells = map(str, raw_input().split())
    prob = 0.0
    for spell in spells:
        x,yd = spell.split('d')
        if '+' in yd:
            y,d = yd.split('+')
            d = int(d)
        elif '-' in yd:
            y,d = yd.split('-')
            d = -int(d)
        else:
            y = int(yd)
            d = 0
        x = int(x)
        y = int(y)
        h_d = h - d
        # print x,(y*x), h_d
        if x >= h_d:
            prob = 1.0
        elif x < h_d and y * x >= h_d:
            coeff = get_coefficient(x,y,h_d)
            # print 'coeff', coeff
            p = ((y ** x) - coeff) / float(y ** x)
            if p > prob:
                prob = p

    print 'Case #{0}: {1:.6f}'.format(i, prob)
