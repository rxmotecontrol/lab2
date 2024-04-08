using System;

class Program
{
    static void Illustration(int banki, int ostatok, int count_steps)
    {
        if (count_steps == 0)
        {
            Console.WriteLine("Jars");
            for (int i = 0; i < banki; i++)
            {
                Console.Write("F");
            }
            Console.WriteLine();
        }
        else if (count_steps % 2 != 0)
        {
            Console.WriteLine($"{count_steps} step");
            for (int i = 0; i < banki; i++)
            {
                Console.Write("E");
            }
            Console.WriteLine();
        }
        else
        {
            Console.WriteLine($"{count_steps} step");
            for (int i = 0; i < (banki - ostatok); i++)
            {
                Console.Write("F");
            }
            Console.WriteLine();
            for (int i = 0; i < ostatok; i++)
            {
                Console.Write("E");
            }
            Console.WriteLine();
        }
    }

    static void Main()
    {
        Console.WriteLine("Input jar quantity: ");
        int banki = int.Parse(Console.ReadLine());

        Console.WriteLine("Input exchange: ");
        int obmen = int.Parse(Console.ReadLine());

        if (banki <= 0 || obmen <= 0)
        {
            Console.WriteLine("Error");
        }
        else
        {
            int count_empty = 0;
            int count_steps = 0;
            int ostatok = 0;
            int new_banki = banki;

            while (new_banki >= obmen)
            {
                if (count_steps == 0)
                {
                    Illustration(new_banki, ostatok, count_steps);
                }
                count_steps++;
                Illustration(new_banki, ostatok, count_steps);
                count_empty += new_banki - ostatok;
                ostatok = new_banki % obmen;
                new_banki = (new_banki / obmen) + ostatok;
                count_steps++;
                Illustration(new_banki, ostatok, count_steps);
            }

            if (new_banki < obmen)
            {
                count_empty += new_banki - ostatok;
                count_steps++;
                Illustration(new_banki, ostatok, count_steps);
                Console.WriteLine($"Jars drunk: {count_empty}");
                Console.WriteLine($"Step count: {count_steps}");
            }
        }
    }
}
