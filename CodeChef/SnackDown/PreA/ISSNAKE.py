t = int(raw_input())


def is_possible(row1, row2, num_columns):
    if row1 == row2 and num_columns % 2 == 0:
        return True
    if row1 != row2 and num_columns % 2 == 1:
        return True
    return False

for i in xrange(t):
    n = int(raw_input())
    c = []
    c.append(raw_input())
    c.append(raw_input())
    hash_found = False
    divider_found = False
    possible = True
    dot_found_at = None
    num_columns = 0
    for j in xrange(n):
        if c[0][j] == '.' and c[1][j] == '.':
            if hash_found:
                divider_found = True
            continue
        if c[0][j] == '#' or c[1][j] == '#':
            if hash_found and divider_found:
                possible = False
                break
        if c[0][j] == '#' and c[1][j] == '#':
            hash_found = True
            num_columns += 1
            continue
        current_dot_at = None
        if c[0][j] == '.' :
            current_dot_at = 0
        else:
            current_dot_at = 1

        if dot_found_at is not None:    
            if not is_possible(dot_found_at, current_dot_at, num_columns):
                possible = False
                break
        dot_found_at = current_dot_at
        num_columns = 0
        continue


    if possible:
        print 'yes'
    else:
        print 'no'