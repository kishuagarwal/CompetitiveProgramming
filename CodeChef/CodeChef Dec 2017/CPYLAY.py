while True:
    try:
        n = input().strip()
        first_gains = [0]
        second_gains = [0]
        found = False
        for i in range(5):
            first_gains.append(first_gains[-1] + (1 if n[2 * i] == '1' else 0))
            if first_gains[-1] > second_gains[-1] + 5 - i:
                print('TEAM-A', i * 2 + 1)
                found = True
                break
            if second_gains[-1] > first_gains[-1] + 4 - i:
                print('TEAM-B', i * 2 + 1)
                found = True
                break
            second_gains.append(second_gains[-1] + (1 if n[i * 2 + 1] == '1' else 0))
            if first_gains[-1] > second_gains[-1] + 4 - i:
                print('TEAM-A', i * 2 + 2)
                found = True
                break
            if second_gains[-1] > first_gains[-1] + 4 - i:
                print('TEAM-B', i * 2 + 2)
                found = True
                break
        if found:
            continue
        if first_gains[-1] > second_gains[-1]:
            print('TEAM-A', 10)
            continue
        for i in range(5, 10):
            first_gains.append(first_gains[-1] + (1 if n[i * 2] == '1' else 0))
            second_gains.append(second_gains[-1] + (1 if n[i * 2 + 1] == '1' else 0))
            if first_gains[-1] > second_gains[-1]:
                print('TEAM-A', (i + 1) * 2)
                break
            elif second_gains[-1] > first_gains[-1]:
                print('TEAM-B', (i + 1) * 2)
                break
        if first_gains[-1] == second_gains[-1]:
            print('TIE')
    except EOFError:
        break

