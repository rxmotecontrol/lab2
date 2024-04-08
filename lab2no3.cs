using System;

class Program
{
    static bool CheckTimeFormat(int num)
    {
        if (num < 100)
        {
            return false;
        }
        int hours = num / 100;
        int minutes = num % 100;

        if (hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    static void Main()
    {
        int num, count;
        count = Convert.ToInt32(Console.ReadLine());

        for (int i = 0; i < count; i++)
        {
            num = Convert.ToInt32(Console.ReadLine());
            if (num == -1)
            {
                break;
            }
            if (CheckTimeFormat(num))
            {
                Console.WriteLine("YES");
            }
            else
            {
                Console.WriteLine("NO");
            }
        }
    }
}
