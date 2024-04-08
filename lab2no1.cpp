#include <iostream>
#include <string>

using namespace std;

int main()
{
    int m, n, mStart, nStart; // m и n - размер поля, mStart и nStart - начальная позиция фигуры
    bool isOver = 0; // 0 - фигура прошла путь нормально, 1 - вышла за пределы поля
    string line; // последовательность команд
    cout << "Enter m: \n"; // ввод значений
    cin >> m;
    cout << "Enter n: \n";
    cin >> n;
    cout << "Enter line: \n";
    cin >> line;
    int mCurr = 1, nCurr = 1; // текущее положение фигуры
    if (m < 1 or n < 1){ // проверка на правильность введенных значений
    cout << "Error";
    exit(0);
    }
    for (auto i : line){ // фигура выполняет заданные команды
        if (i == 'L'){
            mCurr -= 1;
        }
        else if (i == 'R'){
            mCurr += 1;
        }
        else if (i == 'D'){
            nCurr += 1;
        }
        else if (i == 'U'){
            nCurr -= 1;
        }
        else if (mCurr > m or nCurr > n){ // проверка на выход за пределы поля
        cout << "Error";
        isOver = 1;
        break;
        }
        else{
            cout << "Error";
            exit(0);
        }
    }
    if (mCurr < 1 or nCurr < 1){ // сдвиг начальной позиции, если фигура ушла налево/вверх
        if (mCurr < 1){
            mStart = 2 + abs(mCurr); 
        }
        if (nCurr < 1){
            nStart = 2 + abs(nCurr);
        }
        cout << mStart << " " << nStart;
    }
    else if (isOver == 0){  // если фигура не выходила за пределы доски из позиции (1 1), нач. позиция не меняется
        cout << "1 1";
    }
}