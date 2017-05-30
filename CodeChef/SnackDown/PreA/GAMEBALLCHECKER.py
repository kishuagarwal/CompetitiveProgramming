import random
moves = []
count = 0
def move_to_top_left(r,c):
    global moves, count
    for i in xrange(r, 0, -1):
        count += 1
        moves.append((i,c,i-1,c))
    for i in xrange(c, 0, -1):
        count += 1
        moves.append((0,i, 0, i-1))


def bring_ball(ball_r, ball_c):
    global moves,count
    if ball_r == 0:
        for i in xrange(ball_c, 2, -1):
            count += 1
            moves.append((0, i, 0,i-1))
        return

    for i in xrange(ball_c, 0, -1):
        count += 1
        moves.append((ball_r, i, ball_r, i-1))

    for i in xrange(ball_r, 1, -1):
        count += 1
        moves.append((i, 0, i-1,0))

    count += 3
    moves.append((0,0,0,1))
    moves.append((0,1,0,2))
    moves.append((1,0,0,0))

def solve_m1(col, n):
    global moves,count
    for i in xrange(2, n):
        count += 3
        moves.append((i,col,i-2,col))
        moves.append((i-2,col,i-1,col))
        moves.append((i-1,col,i,col))
    return True

def solve_m2(n):
    global moves,count
    solve_m1(0,n)
    count += 1
    moves.append((0,1,0,0))
    solve_m1(1,n)
    for i in xrange(n-2):
        count += 1
        moves.append((i,0,i+1,0))

    count += 4
    moves.append((n-1,0,n-3,0))
    moves.append((n-3,0,n-2,0))
    moves.append((n-1,1,n-1,0))
    moves.append((n-1,0,n-3,0))
    return True

def solve(n,m,r,c):
    global moves, count
    if n == 1 and m == 1:
        return False
    if n == 1 and m == 2:
        return True
    if n == 2 and m == 1:
        return True
    if n == 2 and m == 2:
        return False
    move_to_top_left(r,c)
    if m == 1:
        return solve_m1(0,n)
    elif m == 2:
        return solve_m2(n)

    count += 1
    moves.append((0,1,0,0))

    balls_to_remove = n*m - 2
    ball_r = 0
    ball_c = 1
    for i in xrange(balls_to_remove):
        ball_c += 1
        if ball_c > m -1:
            ball_c = 0
            ball_r += 1
        bring_ball(ball_r,ball_c)
        count += 2
        moves.append((0,0,0,1))
        moves.append((0,2,0,0))
    return True


def sol(n, m, x):
    global moves, count
    moves = []
    count = 0
    for j in xrange(n):
        if '.' in x[j]:
            r = j
            c = x[j].index('.')
    possible = solve(n,m,r,c)
    return possible, moves

def test():
    for i in xrange(1,11):
        for j in xrange(1,11):
            l = []
            for r in xrange(i):
                s = '*' * j
                l.append(s)
            r = random.randint(1,i)
            c = random.randint(1,j)
            temp = list(l[r-1])
            temp[c-1] = '.'
            l[r-1] = ''.join(temp)
            possible, moves = sol(i,j,l)
            if possible:
                check(i,j,l,len(moves), moves)

def check(n,m,l,count, moves):
    for i in xrange(n):
        l[i] = list(l[i])
    import copy
    ol = copy.deepcopy(l)
    #print moves
    for i in xrange(count):
        move = moves[i]
        x1,y1,x2,y2 = move[0], move[1],move[2],move[3] 
        if abs(x1 - x2) + abs(y1 - y2) == 1:
            l[x1][y1], l[x2][y2] = l[x2][y2], l[x1][y1]
        else:
            l[x1][y1] = '.'
            l[x2][y2] = '*'
            if x1 == x2:
                l[x1][min(y1,y2) + 1] = '.'
            else:
                l[min(x1,x2) + 1][y1] = '.'
        #print l
        #print
    c = 0
    for i in xrange(n):
        for j in xrange(m):
            if l[i][j] == '*':
                c += 1
    if c != 1:
        print 'Not Passed', n,m,ol
        print moves
        print l

test()