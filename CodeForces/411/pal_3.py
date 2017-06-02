n = int(raw_input())

ans = 'abba' * (n / 4)
rem = n % 4
ans += 'abba'[:rem]
print ans