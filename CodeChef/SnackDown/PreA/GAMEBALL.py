t = int(raw_input())
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

def move_to_leftmost(r,c):
    global moves, count
    for i in xrange(c, 0, -1):
        count += 1
        moves.append((r, i, r, i-1))

def move_to_uppermost(r,c):
    global moves, count
    for i in xrange(r, 0, -1):
        count += 1
        moves.append((i, c, i-1, c))


def traverse_row(row,m):
    global moves,count
    # Assume whole row is with balls, with empty slot is at leftmost cell
    for i in xrange(0,m,2):
        if i + 2 > m - 1:
            break
        count += 1
        moves.append((row, i+2,row,i))

    for i in xrange(0,m,2):
        if i + 4 > m - 1:
            break
        count += 2
        moves.append((row, i+2, row, i+1))
        moves.append((row, i, row, i+2))
    if m % 2 == 1:
        move_to_leftmost(row, m - 3)
    else:
        count += 3
        moves.append((row, m-4, row, m-3))
        moves.append((row, m-3, row, m-2))
        moves.append((row, m-1, row, m-3))
        move_to_leftmost(row, m - 3)


def traverse_col(col,n):
    global moves,count
    # Assume whole row is with balls, with empty slot is at leftmost cell
    for i in xrange(0,n,2):
        if i + 2 > n - 1:
            break
        count += 1
        moves.append((i+2, col,i, col))

    for i in xrange(0,n,2):
        if i + 4 > n - 1:
            break
        count += 2
        moves.append((i+2, col, i+1, col))
        moves.append((i, col, i+2, col))
    if n % 2 == 1:
        move_to_uppermost(n-3, col)
    else:
        count += 3
        moves.append((n-4, col, n-3, col))
        moves.append((n-3, col, n-2, col))
        moves.append((n-1, col, n-3, col))
        move_to_uppermost(n - 3, col)


def solve(n,m,r,c, on, om):
    global moves, count
    if n == 1 and m == 1:
        return False
    move_to_top_left(r,c)
    if n == 1 and m == 2:
        count += 1
        moves.append((0,1,0,0))
        return True
    if n == 2 and m == 1:
        count += 1
        moves.append((1,0,0,0))
        return True
    if n == 2 and m == 2 and om > 2:
        count += 4
        moves.append((0,0,0,2))
        moves.append((0,2,1,2))
        moves.append((1,2,1,1))
        moves.append((1,0,1,2))
        return True
    if n == 2 and m == 2:
        return False
    if m == 2:
        traverse_col(0, n)
        count += 2
        moves.append((0,0,1,0))
        moves.append((0,1,0,0))
        traverse_col(1, n)
        count += 4
        moves.append((0,0,2,0))
        moves.append((0,1,0,0))
        moves.append((0,0,1,0))
        moves.append((2,0,0,0))
        return True
    elif n == 1:
        traverse_row(0, m)
        return True
    elif m == 1:
        traverse_col(0, n)
        return True
    else:
        for j in xrange(n):
            traverse_row(j,m)
            if j != n - 1:
                count += 2
                moves.append((j,0,j,1))
                moves.append((j+1,0,j,0))
        return solve(n, 2, n-1, 1, on, om)
    return True

for i in xrange(t):
    n, m = map(int, raw_input().strip().split(' '))
    moves = []
    count = 0
    for j in xrange(n):
        l = raw_input()
        if '.' in l:
            r = j
            c = l.index('.')
    possible = solve(n,m,r,c, n,m)
    
    if possible:
        print count
        for j in xrange(count):
            print moves[j][0]+1, moves[j][1]+1, moves[j][2]+1, moves[j][3]+1

    else:
        print -1