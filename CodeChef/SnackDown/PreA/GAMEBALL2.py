t = int(raw_input())
moves = []
def move_to_top_left(r,c):
    global moves
    for i in xrange(r, 0, -1):
        moves.append((i-1,c,i,c))
    for i in xrange(c, 0, -1):
        moves.append((0,i-1, 0, i))


def bring_ball(ball_r, ball_c):
    global moves
    if ball_r == 0:
        for i in xrange(ball_c, 2, -1):
            moves.append((0, i, 0,i-1))
        return

    for i in xrange(ball_c, 0, -1):
        moves.append((ball_r, i, ball_r, i-1))

    for i in xrange(ball_r, 1, -1):
        moves.append((i, 0, i-1,0))

    moves.append((0,0,0,1))
    moves.append((0,1,0,2))
    moves.append((1,0,0,0))

def solve_m1(col, n):
    global moves
    for i in xrange(2, n):
        moves.append((i,col,i-2,col))
        moves.append((i-2,col,i-1,col))
        moves.append((i-1,col,i,col))
    return True

def solve_m2(n):
    global moves
    solve_m1(0,n)
    moves.append((0,1,0,0))
    solve_m1(1,n)
    for i in xrange(n-2):
        moves.append((i,0,i+1,0))

    moves.append((n-1,0,n-3,0))
    moves.append((n-3,0,n-2,0))
    moves.append((n-1,1,n-1,0))
    moves.append((n-1,0,n-3,0))
    return True

def solve(n,m,r,c):
    global moves
    if n <= 1 and m <= 1:
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
        moves.append((0,0,0,1))
        moves.append((0,2,0,0))
    return True


for i in xrange(t):
    n, m = map(int, raw_input().strip().split(' '))
    moves = []
    for j in xrange(n):
        l = raw_input().strip()
        if '.' in l:
            r = j
            c = l.index('.')
    possible = solve(n,m,r,c)
    if possible:
        count = len(moves)
        print count
        for j in xrange(count):
            print moves[j][0]+1, moves[j][1]+1, moves[j][2]+1, moves[j][3]+1
    else:
        print -1