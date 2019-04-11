t = int(input())

for i in range(t):
    n = input().strip()
    a = ''
    b = ''
    isFirstChar = True
    for c in n:
        if c != '4':
            a += c
            if not isFirstChar:
                b += '0'
        else:
            a += '3'
            b += '1'
            isFirstChar = False
            
    print('Case #' + str(i + 1) + ": " + a + ' ' + b)
        
