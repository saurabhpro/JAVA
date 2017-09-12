class Program
    {
        static int Main()
        {
            int N=0, F=0, B=0, T=0, FD=0, BD=0, POS=1000, Time = 0;
            N = Convert.ToInt32(Console.ReadLine());
            if (N < 1 || N > 100)
                return;
            else
            {
                for(int i = 0; i < N; i++)
                {
                    String[] _Input = Console.ReadLine().Split(' ');
                    foreach (String Val in _Input)
                    {
                        if (Convert.ToInt32(Val) > 0)
                        {
                            F = Convert.ToInt32(_Input[0]);
                            B = Convert.ToInt32(_Input[1]);
                            T = Convert.ToInt32(_Input[2]);
                            FD = Convert.ToInt32(_Input[3]);
                            BD = Convert.ToInt32(_Input[4]);
                        }
                        else
                            return;
                    }
                    if (F == B && (FD > F || BD > B))
                        Console.WriteLine("No Ditch");
                    else
                    {
                        FD = POS + FD;
                        BD = POS - BD;
                        while (true)
                        {
                            if ((FD - POS) >= F)
                            {
                                POS = POS + F;
                                Time += F;
                            }
                            else
                            {
                                int Temp = FD - POS;
                                POS = POS + Temp;
                                Time += Temp;
                            }
                            if (FD == POS)
                                break;
                            if ((POS - BD) >= B)
                            {
                                POS = POS - B;
                                Time += B;
                            }
                            else
                            {
                                int Temp = POS - B;
                                POS = POS - Temp;
                                Time += Temp;
                            }
                            if (BD == POS)
                                break;
                        }
                    }
                    Time = Time * T;
                    if (Time != 0)
                    {
                        if (POS == FD)
                            Console.WriteLine("{0} F", Time);
                        else
                            Console.WriteLine("{0} B", Time);
                    }
                }
            }
         
			return 0;
        }
}

