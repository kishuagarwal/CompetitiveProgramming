t = int(raw_input())

def is_vertical_t_shape(x1,y1,x2,y2,x3,y3,x4,y4):
    if x1 == x2 and y3 == y4:
        if (x1 == x3 and y1 == y3) or (x1 == x4 and y1 == y4):
            return True
        if (x2 == x3 and y2 == y3) or (x2 == x4 and y2 == y4):
            return True
    return False


def is_horizontal_t_shape(x1,y1,x2,y2,x3,y3,x4,y4):
    if y1 == y2 and x3 == x4:
        if (x1 == x3 and y1 == y3) or (x1 == x4 and y1 == y4):
            return True
        if (x2 == x3 and y2 == y3) or (x2 == x4 and y2 == y4):
            return True

    return False

def are_same(a,b,c,d):
    a,b = min(a,b), max(a,b)
    c,d = min(c,d), max(c,d)

    if a <= c:
        if b < c:
            return False
        else:
            return True
    else:
        if d < a:
            return False
        else:
            return True

for i in xrange(t):
    x1,y1,x2,y2= map(int, raw_input().strip().split(' '))
    x3,y3,x4,y4= map(int, raw_input().strip().split(' '))

    # Same Row
    if x1 == x2 and x3 == x4 and x1 == x3:
        if are_same(y1,y2,y3,y4):
            print 'yes'
            continue
        else:
            print 'no'
            continue
    # Same Column
    elif y1 == y2 and y3 == y4 and y1 == y3:
        if are_same(x1,x2,x3,x4):
            print 'yes'
            continue
        else:
            print 'no'
            continue
    
    # First snake in row, second in col
    if is_vertical_t_shape(x1,y1,x2,y2,x3,y3,x4,y4):
        print 'yes'
        continue

    # Second snake in row, second in col
    if is_vertical_t_shape(x3,y3,x4,y4,x1,y1,x2,y2):
        print 'yes'
        continue

    print 'no'