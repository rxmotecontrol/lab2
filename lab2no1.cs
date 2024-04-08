using System;

class Program
{
    static void Main()
    {
        int m = 0, n = 0;
        int? mStart = null;
        int? nStart = null;

        Console.Write("Enter m: ");
        if (int.TryParse(Console.ReadLine(), out int mValue))
        {
            m = mValue;
        }

        Console.Write("Enter n: ");
        if (int.TryParse(Console.ReadLine(), out int nValue))
        {
            n = nValue;
        }

        Console.Write("Enter line: ");
        string line = Console.ReadLine();

        int mCurr = 1;
        int nCurr = 1;

        foreach (char i in line)
        {
            switch (i)
            {
                case 'L':
                    mCurr -= 1;
                    break;
                case 'R':
                    mCurr += 1;
                    break;
                case 'U':
                    nCurr -= 1;
                    break;
                case 'D':
                    nCurr += 1;
                    break;
                default:
                    break;
            }
        }

        if (m < 1 || n < 1)
        {
            Console.WriteLine("Error");
        }
        else
        {
            if (mCurr > m || nCurr > n)
            {
                Console.WriteLine("Error");
            }
            else if (mCurr < 1 || nCurr < 1)
            {
                if (mCurr < 1)
                {
                    mStart = 2 + Math.Abs(mCurr);
                }
                if (nCurr < 1)
                {
                    nStart = 2 + Math.Abs(nCurr);
                }

                if (mStart.HasValue && nStart.HasValue)
                {
                    Console.WriteLine($"{mStart} {nStart}");
                }
            }
            else
            {
                Console.WriteLine("1 1");
            }
        }
    }
}