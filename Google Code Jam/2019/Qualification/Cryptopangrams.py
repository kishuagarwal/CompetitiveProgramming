import string
t = int(input())

def gcd(a, b):
  while(b):
    a, b = b, a % b
  return a

for i in range(t):
  n, l = list(map(int, input().strip().split(' ')))
  l = list(map(int, input().strip().split(' ')))
  primes = [0 for _ in range(len(l) + 1)]

  for index in range(1, len(l)):
    if l[index] == l[index - 1]:
          # GCD  1
          # Check we can get the value from the previous value
          if primes[index - 1] != 0:
            primes[index] = l[index - 1] // primes[index - 1]
          else:
            continue
    else:
     primes[index] = gcd(l[index-1], l[index])
    # backtrack to fill any empty values
    for index2 in range(index-1, -1, -1):
        if primes[index2] != 0:
            break
        primes[index2] = l[index2] // primes[index2 + 1]
    
  if primes[-2] != 0:
    primes[-1] = l[-1] // primes[-2]
 
  m = {}
  s = set(primes)
  s.discard(0)
  s = sorted(s)

  for index, c in enumerate(string.ascii_uppercase):
    m[s[index]] = c
  
  ans = ''
  for p in primes:
    ans += m[p]

  print('Case #' + str(i + 1) + ': ' + ans) 
      
  

