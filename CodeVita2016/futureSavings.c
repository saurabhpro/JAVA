#include <stdio.h>
#include <math.h>
int Principal(int cashNeeded, int time_in_months, double rateInterest)
{
	int cashAtEnd = cashNeeded * time_in_months;
	
	
	while(time_in_months-- >1)
	{
		//printf("%d\n", cashAtEnd);
		cashAtEnd =  round(cashAtEnd*1200/(1200+rateInterest));
		//printf("%d\n", cashAtEnd);
	}
	
	printf("%d", cashAtEnd);
	
	return 0;
}
		
		
int main()
{
	int M, T;
	double R;
	scanf("%d", &M);
	scanf("%d", &T);
	scanf("%lf", &R);
	Principal(M, T, R);

	return 0;
}
		
