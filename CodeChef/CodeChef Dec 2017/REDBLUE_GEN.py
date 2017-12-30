import random
file = open('input.txt', 'w')
t = 10
file.write(str(t))
file.write('\n')
for i in range(t):
    n, m = [random.randint(1, 300) for _ in range(2)]
    file.write('{0} {1}'.format(n, m))
    file.write('\n')
    for j in range(n + m):
        x, y = [random.randint(-10e9, 10e9) for _ in range(2)]
        file.write('{0} {1}'.format(x, y))
        file.write('\n')

file.flush()
file.close()
