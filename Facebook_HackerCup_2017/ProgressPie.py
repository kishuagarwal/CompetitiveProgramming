import math
t = int(raw_input())

for i in range(1,t+1):
    p,x,y = map(float, raw_input().split())

    if p == 0:
        print 'Case #{0}: white'.format(i)
        continue
        
    dist_from_center = math.sqrt((x - 50) ** 2 + (y - 50) ** 2)
    if dist_from_center > 50.0:
        print 'Case #{0}: white'.format(i)
        continue

    dy = x - 50;
    dx = y - 50;
    radians = math.atan2(dy,dx)
    if radians < 0:
        radians += 2*math.pi

    progress_radians = (p * 2 * math.pi) / 100.0

    if radians > progress_radians:
        print 'Case #{0}: white'.format(i)
    else:
        print 'Case #{0}: black'.format(i)
