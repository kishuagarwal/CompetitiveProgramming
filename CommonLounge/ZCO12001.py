n = int(raw_input().strip())

b = map(int, raw_input().strip().split(' '))

stack = []
max_depth = 0
max_depth_pos = 0
max_chars = 0
max_chars_pos = 0

stack_length = 0
for index, x in enumerate(b):
    if x == 1:
        if stack_length > 0:
            last = stack[-1]
            # With each (, the nesting depth increases
            # but the start pos remains the same
            # Number of chars increases by 1
            # Position also remains the same
            stack.append([last[0] + 1, 1 , index+1])
        else:
            stack.append([1,1,index+1])
        
        stack_length += 1

        if stack[-1][0] > max_depth:
            max_depth = stack[-1][0]
            max_depth_pos = index + 1
    else:
        last = stack.pop()
        stack_length -= 1
        if last[1] + 1 > max_chars:
            max_chars = last[1] + 1
            max_chars_pos = last[2]

        if stack_length > 0:
            stack[-1][1] += last[1] + 1
print max_depth, max_depth_pos, max_chars, max_chars_pos