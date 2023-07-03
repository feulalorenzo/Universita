/*
	LPS Example

	Variables Lifetime

	Language: C99
	Style: plain C
	Version: LPS23-pc
*/

/*
	LPS23 Example
*/

#include <stdio.h>

void f( void )
{	
	int k = 1;
	static int h = 1;
	printf( "uno %d %d\n", k, h );
	k++, h++;
	printf( "due %d %d\n", k, h );
	k++, h++;
	printf( "tre %d %d\n", k, h );
	k++, h++;
}

int main( void )
{
	f();
	f();
	f();
	return 0;
}

/* 

Output previsto
1 1
2 2
3 3
1 4
2 5
3 6
1 7
2 8
3 9

*/
