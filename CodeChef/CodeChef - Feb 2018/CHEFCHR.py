t = int(input())
for i in range(t):
    s = input()
    ways = 0
    for j in range(len(s)-3):
        subs = s[j:j+4]
        if sorted(subs) == list('cefh'):
            ways += 1
    if ways == 0:
        print('normal')
    else:
        print('lovely', ways)
