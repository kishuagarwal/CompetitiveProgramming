t = int(input())

for i in range(t):
  n = int(input())
  p = input().strip()
  ans = ''
  for c in p:
    if c == 'S':
      ans += 'E'
    else:
      ans += 'S'
  print('Case #' + str(i + 1) + ': ' + ans)
