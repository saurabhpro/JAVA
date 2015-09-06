#include <stdio.h>

int  main()
{
	int N = 0, F=0, B=0,T=0, FD = 0, BD = 0, Time =0;
	int totaldistancetravel =0;
	int distancefrominitialpoint=0;
//	int Temp;
	scanf("%d", &N);
	for(;N>0; N--)
	{
		totaldistancetravel =0;
		distancefrominitialpoint=0;
		
		scanf("%d %d %d %d %d", &F, &B, &T, &FD, &BD);
		while(1)
		{
			if(F==B && (FD>F || BD >B))
			{
				printf("No Ditch");
				break;
			}
			else
			{
				distancefrominitialpoint +=F;
				if(distancefrominitialpoint >=FD)
				{
					Time = (totaldistancetravel + (F-(distancefrominitialpoint -FD)))*T;
					printf("%d F", Time);
					break;
				}
				
				totaldistancetravel +=F;
				distancefrominitialpoint -=B;
				
				if(distancefrominitialpoint <= -BD)
				{
					Time = (totaldistancetravel + (B-(distancefrominitialpoint +BD)))*T;
					printf("%d B", Time);
					break;
				}
				
				totaldistancetravel +=B;
			}
		}
		
		
	}
	
	return 0;
}
