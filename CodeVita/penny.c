#include <stdio.h>
#define SIZE 10000
int main()
{
	int arr[SIZE];
	int i , j, k, n, t;
	scanf("%d", &n);
	
	for(i=0; i<n; i++)
		scanf("%d", &arr[i]);
		
	scanf("%d", &t);
	for( i=0;i<n;i++)
    {
		for( j=0;j<n;j++)
		{
			for( k=0;k<n;k++)
			{
				if(arr[i]+arr[j]+arr[k]==t && i!=j && i!=k && j!=k)
				{
					printf("True");
					return 0;
				}
			}
		}
	}
    printf("False");
    
    return 0;
}
