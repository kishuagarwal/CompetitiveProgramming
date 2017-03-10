t = int(raw_input())
for i in range(t):
    c, d, l = map(int, raw_input().split())
    if l < 4*d: 
        print 'no'
    else:
        rem = l - 4*d
        if rem % 4 != 0:
            print 'no'
        else:
            c_s = rem / 4
            if c_s > c:
                print 'no'
            else:
                if (c - c_s) <= (d * 2):
                    print 'yes'
                else:
                    print 'no'