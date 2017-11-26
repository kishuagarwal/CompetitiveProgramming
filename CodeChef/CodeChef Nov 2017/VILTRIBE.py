t = int(input())

for i in range(t):
    s = input()
    a_count = 0
    b_count = 0
    last = -1
    temp = 0
    for c in s:
        if c == 'A':
            a_count += 1
            if last == c:
                a_count += temp
            temp = 0
            last = c
        elif c == 'B':
            b_count += 1
            if last == c:
                b_count += temp
            temp = 0
            last = c
        else:
            temp += 1
    print(a_count, b_count)




