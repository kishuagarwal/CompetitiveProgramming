n, k = input().split(' ')


def super_digit(a, b):
    if b == '0':
        if len(a) == 1:
            return a

    digit_sum = 0
    for i in a:
        digit_sum += ord(i) - ord('0')

    if b > '0':
        digit_sum = digit_sum * b

    return super_digit(str(digit_sum), '0')

print(super_digit(n,k))
