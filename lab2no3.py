def check_time_format(num):
    if num < 100:
        return False
    hours = num // 100
    minutes = num % 100

    return 0 <= hours <= 23 and 0 <= minutes <= 59

def main():
    case_count = int(input("Enter the number of test cases: "))
    i = 0

    while i < case_count:
        num = int(input("Enter time format (hhmm) or -1 to exit: "))
        if num == -1:
            break
        if check_time_format(num):
            print("YES")
        else:
            print("NO")
        i += 1

main()
