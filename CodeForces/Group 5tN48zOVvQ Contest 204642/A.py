n = int(input())


def isValid(x):
    return len(set(list(str(x)))) == 4


n += 1
while not isValid(n):
    n += 1

print(n)
