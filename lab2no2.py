def illustration(banki, ostatok, count_steps):
    if count_steps == 0:
        print('Дано')
        print('F' * banki)
    elif count_steps % 2 != 0:
        print(count_steps, ' шаг')
        print('E' * banki)
    elif count_steps % 2 == 0:
        print(count_steps, ' шаг')
        print('F' * (banki - ostatok))
        print('E' * ostatok)

print('Введите количество банок: ')
banki = int(input())
print('Введите курс обмена: ')
obmen = int(input())
if banki <= 0 or obmen <= 0:
    print('Error')
else:
    count_empty = count_steps = ostatok = 0
    count_extra = count_banki = 0
    while banki >= obmen:
        if count_steps == 0: illustration(banki, ostatok, count_steps)
        count_steps += 1
        illustration(banki, ostatok, count_steps)
        count_empty += banki - ostatok
        ostatok = banki % obmen
        banki = (banki // obmen) + (ostatok)
        count_steps += 1
        illustration(banki, ostatok, count_steps)

    if banki < obmen:
        count_empty += banki - ostatok
        count_steps += 1
        illustration(banki, ostatok, count_steps)
        print('Количество выпитых банок: ', count_empty)
        print('Количество шагов: ', count_steps)