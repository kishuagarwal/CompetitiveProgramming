def gcd(a, b):
    if b = 0
       return a 
    else
       return gcd(b, a % b)
       
n,m,z = map(int ,raw_input().split())
g = gcd(n,m)
l = (n * m) / g
print z / l
