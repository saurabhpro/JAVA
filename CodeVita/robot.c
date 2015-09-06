#include <stdio.h>

int  main()
{
	int N = 0, F=0, B=0,T=0, FD = 0, BD = 0, POS =1000, Time =0;
	int Temp;
	scanf("%d", &N);
	for(;N>0; N--)
	{
		Time =0;
		scanf("%d %d %d %d %d", &F, &B, &T, &FD, &BD);
		if (F == B && (FD > F || BD > B))
		{
			printf("No Ditch");
			break;
		}
		else
		{
			FD = POS + FD;
			BD = POS - BD;
			while (1)
			{
				if ((FD - POS) >= F)
				{
					POS = POS + F;
					Time += F;
				}
				else
				{
					Temp = FD - POS;
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
					Temp = POS - B;
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
				printf("%d F", Time);
			else
				printf("%d B", Time);
		}
	}
	return 0;
}
	
