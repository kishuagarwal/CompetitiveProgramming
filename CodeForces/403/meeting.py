e = 1e-14
tol = 1e-7

n = int(raw_input())
pos = map(int, raw_input().strip().split(' '))
speed = map(int, raw_input().strip().split(' '))

x0 = min(pos)
x1 = max(pos)
while True:
    mid = (x0 + x1) / 2.0;
    f = 0.0;
    fd = 0;
    for i in xrange(n):
        if (mid >= pos[i]):
            f += (mid - pos[i]) / speed[i]
            fd += 1.0 / speed[i]
        else:
            f += (pos[i]-mid) / speed[i]
            fd += -1.0 / speed[i]
    print x0,x1, f, fd
    if (abs(fd) < e):
        break;
    if (abs(x1 - x0) <= tol):
        break;
    if (fd > 0):
        x1 = mid
    else:
        x0 = mid
    
f = 0
for i in xrange(n):
    if (x0 >= pos[i]):
        f += (x0 - pos[i]) / float(speed[i])
    else:
        f += (pos[i]-x0) / float(speed[i])
print f