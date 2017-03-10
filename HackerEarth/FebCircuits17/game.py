t = int(raw_input())
for i in xrange(t):
    n ,q = map(int, raw_input().split())
    obs = []
    for j in xrange(q):
        obs.append(map(int, raw_input().split()))
    obs.sort()
    count = 0
    max_row = n
    a,b,c = True, True, True
    current_row = 1
    ca,cb,cc = True,True,True
    for j in xrange(q):
        if obs[j][0] == current_row:
            col = obs[j][1]
            if col == 1:
                cc = (b or c) and cc
                cb = (a or b or c) and cb
                ca = False 
            elif col == 2:
                ca = (a or b) and ca
                cc = (b or c) and cc
                cb = False

            else:
                ca = (a or b) and ca
                cb = (a or b or c) and cb
                cc = False
        else:
            a,b,c = ca,cb,cc
            ca,cb,cc = True, True, True
            if obs[j][0] == current_row + 1:
                col = obs[j][1]
                if col == 1:
                    cc = (b or c) and cc
                    cb = (a or b or c) and cb
                    ca = False 
                elif col == 2:
                    ca = (a or b) and ca
                    cc = (b or c) and cc
                    cb = False

                else:
                    ca = (a or b) and ca
                    cb = (a or b or c) and cb
                    cc = False
                current_row = obs[j][0]
            elif obs[j][0] == current_row + 2:
                a = a or b
                b = a or b or c
                c = b or c
                col = obs[j][1]
                if col == 1:
                    cc = (b or c) and cc
                    cb = (a or b or c) and cb
                    ca = False 
                elif col == 2:
                    ca = (a or b) and ca
                    cc = (b or c) and cc
                    cb = False

                else:
                    ca = (a or b) and ca
                    cb = (a or b or c) and cb
                    cc = False
                current_row = obs[j][0]
            else:
                a,b,c = True, True, True
                col = obs[j][1]
                if col == 1:
                    cc = (b or c) and cc
                    cb = (a or b or c) and cb
                    ca = False 
                elif col == 2:
                    ca = (a or b) and ca
                    cc = (b or c) and cc
                    cb = False

                else:
                    ca = (a or b) and ca
                    cb = (a or b or c) and cb
                    cc = False
                current_row = obs[j][0]
        print a,b,c
        print ca,cb,cc
        if not ca and not cb and not cc:
            max_row = current_row - 1
            break
    print max_row