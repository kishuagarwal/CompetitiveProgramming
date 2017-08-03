from __future__ import print_function

t = int(raw_input())

for i in xrange(t):
    ops = []
    s = raw_input()
    for c in s:
        if c >= 'a' and c <='z':
            print(c, end='')
            continue
        if c == '(':
            ops.append(c)
            continue

        if c == ')':
            temp = ops.pop()
            while temp != '(':
                print(temp, end='')
                temp = ops.pop()
            continue
        temp = ops[-1]
        if c == '+':
            if temp in ('-','*','/','^'):
                print(ops.pop(),end='')
            ops.append(c)
        elif c == '-':
            if temp in ('*','/','^'):
                print(ops.pop(),end='')
            ops.append(c)
        elif c == '*':
            if temp in ('/','^'):
                print(ops.pop(),end='')
            ops.append(c)
        elif c == '/':
            if temp in ('/','^'):
                print(ops.pop(),end='')
            ops.append(c)
        else:
            ops.append(c)
    print()
