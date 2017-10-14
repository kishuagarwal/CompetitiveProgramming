t = int(input())


def break_words(word, passwords):
    if word == '':
        return True, []
    for password in passwords:
        if word.startswith(password):
            possible, ans = break_words(word[len(password):], passwords)
            if possible:
                ans = [password] + ans
                return True, ans
    return False, None


for i in range(t):
    n = int(input())
    words = input().split(' ')
    attempt = input().strip()
    possible, break_out = break_words(attempt, words)
    if possible:
        print(' '.join(break_out))
    else:
        print('WRONG PASSWORD')
