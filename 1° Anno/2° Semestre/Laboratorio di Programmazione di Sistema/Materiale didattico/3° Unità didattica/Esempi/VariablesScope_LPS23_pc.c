/*
	LPS Example

	Variables Scope

	Language: C99
	Style: plain C
	Version: LPS23-pc
*/

/*
	LPS23 Example
*/

#include <stdio.h>

int i = 4;

void f( void )
{	
	printf( "%d\n", i );
	i = 9;
	printf( "%d\n", i );
}

void g( void )
{
	int i = 15, j;
	
	printf( "%d\n", i );
	scanf( "%d", &j );

	if ( j > 0 ) {
		int i;
		i = 20;
		printf( "%d\n", i );
	}
	printf( "%d\n", i );
}

void h( void )
{
	printf( "%d\n", i );
	{ 
		int i;
		i = 29;
		printf( "%d\n", i );
	}
	printf( "%d\n", i );
}

int main( void )
{
	h();
	g();
	f();
	printf( "%d\n", i );
	return 0;
}

/* Previsione dell'output (se l'utente inserisce un numero >0)
	4
	29
	4
	15
	20
	15
	4
	9
	9
*/
