import math
n,m = map(int, raw_input().split())
p = []
for i in range(n):
    a,b = map(float, raw_input().split())
    a = math.sqrt(a ** 2  + b ** 2)
    p.append(a)

l = 0
h = 1200

while l <= h:
    r = (l + h) / 2.0
    
    points = 0
    exact = False
    for distance in p:
        if distance <= r:
            points += 1
            if abs(distance - r) <= 0.000001:
                exact = True
    print l,h,r,points
    if points == m and exact:
        break
    if points >= m :
        h = r - 0.0001
    else:
        l = r + 0.0001

print r
