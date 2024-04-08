#include <iostream>

using namespace std;

bool checkTimeFormat(int num) {
    if (num < 100) {
        return false;
    }
    int hours = num / 100;
    int minutes = num % 100;

    if (hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59) {
        return true;
    } 
    else {
        return false;
    } 
}

int main() {
    int num, count;
    cin >> count;
    
    for (int i = 0; i < count; i++) {
        cin >> num;
        if (num == -1){
            break;
        }
        if (checkTimeFormat(num)) {
            cout << "YES ";
        } else {
            cout << "NO ";
        }
    }

    return 0;
}