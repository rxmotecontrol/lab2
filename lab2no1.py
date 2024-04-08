print('Введите m') 
m = int(input())
print('Введите n')
n = int(input())
mCurr = nCurr = nStart = mStart = 1 
print('Введите последовательность команд')
line = input()
for i in line:
    if m < 1 or n < 1:
        print('Error')
        break
    else:
        if i == 'L':
            mCurr -= 1
        elif i == 'R':
            mCurr += 1
        elif i == 'D':
            nCurr += 1
        elif i == 'U':
            nCurr -= 1
if mCurr > m or nCurr > n:
    print('Error')
elif mCurr < 1 or nCurr < 1:
    if mCurr < 1:
        mStart = 2 + abs(mCurr)
    if nCurr < 1:
        nStart = 2 + abs(nCurr)
    print(mStart, nStart)
else:
    print('1 1')
