t = int(raw_input().strip())
for i in xrange(t):
    n = int(raw_input().strip())
    a = []
    a.append(raw_input().strip())
    a.append(raw_input().strip())
    count = 1
    pendingTop = False
    pendingBottom = False
    upCount = 0
    DownCount = 0
    bruteChoice = 0
    for j in xrange(n):
        if a[0][j] == '.' and a[1][j] == '.':
                continue

        if a[0][j] == '*' and a[1][j] == '.': 
            upCount += 1
            if pendingTop or pendingBottom:
                bruteChoice += 1
            if not pendingTop: 
                pendingTop = True
                continue
            
            pendingBottom = False
            count += 1
            continue
        

        if a[0][j] == '.' and a[1][j] == '*':
            DownCount += 1
            if pendingTop or pendingBottom:
                bruteChoice += 1
            if not pendingBottom:
                pendingBottom = True
                continue
            
            pendingTop = False
            count += 1
            continue
        

        if a[0][j] == '*' and a[1][j] == '*': 
            upCount += 1
            DownCount += 1
            bruteChoice += 1
            if pendingBottom or pendingTop: 
                count += 1
                continue
            
            pendingTop = True
            pendingBottom = True
            continue
        
        
    if upCount == 0 and DownCount == 0: 
        count = 0
    
    elif upCount + DownCount == 1: 
        count = 0
    
    elif upCount == 0 or DownCount == 0:
        count -= 1

    print min(count, bruteChoice)