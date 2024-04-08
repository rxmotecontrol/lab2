#include <iostream>
#include <string>

using namespace std;

void illustration(int banki, int ostatok, int count_steps) { // вывод иллюстрации
    if (count_steps == 0) { // дано
        cout << "Jars" << endl;
        for (int i = 0; i < banki; ++i) {
            cout << 'F';
        }
        cout << endl;
    } else if (count_steps % 2 != 0) { // для нечетных шагов
        cout << count_steps << " step" << endl;
        for (int i = 0; i < banki; ++i) {
            cout << 'E';
        }
        cout << endl;
    } else if (count_steps % 2 == 0) { // для четных шагов
        cout << count_steps << " step" << endl;
        for (int i = 0; i < banki - ostatok; ++i) {
            cout << 'F';
        }
        cout << endl;
        for (int i = 0; i < ostatok; ++i) {
            cout << 'E';
        }
        cout << endl;
    }
}

int main() {
    int banki, obmen; // ввод данных
    cout << "Input jar quantity: ";
    cin >> banki;
    cout << "Input exchange: ";
    cin >> obmen;

    if (banki <= 0 || obmen <= 0) { // проверка на правильность значений
        cout << "Error" << endl;
    } else {
        int count_empty = 0; // счетчик пустых банок, шагов, оставшихся пустых банок после обмена
        int count_steps = 0;
        int ostatok = 0;

        while (banki >= obmen) { // вывод дано -> +1 шаг -> выпить все банки -> добавить выпитые банки к счетки без учета выпитых ранее -> обмен банок -> +1 шаг 
            if (count_steps == 0) {
                illustration(banki, ostatok, count_steps);
            }
            count_steps++;
            illustration(banki, ostatok, count_steps);
            count_empty += banki - ostatok;
            ostatok = banki % obmen;
            banki = (banki / obmen) + ostatok;
            count_steps++;
            illustration(banki, ostatok, count_steps);
        }

        if (banki < obmen) { // последний шаг, когда нельзя обменять банки
            count_empty += banki - ostatok;
            count_steps++;
            illustration(banki, ostatok, count_steps);
            cout << "Jars drunk: " << count_empty << endl;
            cout << "Step count: " << count_steps << endl;
        }
    }

    return 0;
}