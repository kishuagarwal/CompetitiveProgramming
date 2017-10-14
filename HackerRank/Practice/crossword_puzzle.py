grid = []

for i in range(10):
    line = input()
    grid.append(list(line))

words = input().split(';')


def length(grid, row, col, direction):
    count = 0
    atleast_one_blank = False
    # horizontal
    if direction == 1:
        for i in range(col, 10):
            if grid[row][i] != '+':
                count += 1
                if grid[row][i] == '-':
                    atleast_one_blank = True
            else:
                break
    # vertical
    else:
        for i in range(row, 10):
            if grid[i][col] != '+':
                count += 1
                if grid[i][col] == '-':
                    atleast_one_blank = True
            else:
                break

    if atleast_one_blank:
        return count
    return 0


def fill_word(grid, word, row, col, direction):
    prev_state = []
    if direction == 1:
        for i in range(len(word)):
            if grid[row][col + i] != '-' and grid[row][col + i] != word[i]:
                # Restore state
                for i in range(len(prev_state)):
                    grid[row][col +i] = prev_state[i]
                return False, None
            prev_state.append(grid[row][col + i])
            grid[row][col + i] = word[i]
    else:
        for i in range(len(word)):
            if grid[row + i][col] != '-' and grid[row + i][col] != word[i]:
                for i in range(len(prev_state)):
                    grid[row + i][col] = prev_state[i]
                return False, None
            prev_state.append(grid[row + i][col])
            grid[row + i][col] = word[i]

    return True, prev_state


def remove_word(grid, prev_state, row, col, direction):
    if direction == 1:
        for i in range(len(prev_state)):
            grid[row][col + i] = prev_state[i]
    else:
        for i in range(len(prev_state)):
            grid[row + i][col] = prev_state[i]


def fill(grid, words_left):
    is_filled = True
    # Try horizontal
    for row in range(10):
        prev = '+'
        for col in range(10):
            if grid[row][col] == '-' and prev != '-':
                is_filled = False
                words_copy = words_left[:]
                void = length(grid, row, col, 1)
                for word in words_left:
                    if len(word) == void:
                        valid_word, prev_state = fill_word(grid, word, row, col, 1)
                        if not valid_word:
                            continue
                        words_copy.remove(word)
                        is_filled = fill(grid, words_copy)
                        if is_filled:
                            return True
                        words_copy.append(word)
                        remove_word(grid, prev_state, row, col, 1)
            prev = grid[row][col]
    # Try vertical
    for col in range(10):
        prev = '+'
        for row in range(10):
            if grid[row][col] == '-' and prev != '-':
                is_filled = False
                words_copy = words_left[:]
                void = length(grid, row, col, 0)
                for word in words_left:
                    if len(word) == void:
                        valid_word, prev_state = fill_word(grid, word, row, col, 0)
                        if not valid_word:
                            continue
                        words_copy.remove(word)
                        is_filled = fill(grid, words_copy)
                        if is_filled:
                            return True
                        words_copy.append(word)
                        remove_word(grid, prev_state, row, col, 0)
            prev = grid[row][col]
    return is_filled


fill(grid, words)
for row in range(10):
    print(''.join(grid[row]))