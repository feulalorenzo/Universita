/*
	LPS Example

	Ricorsione 3

	Language: C99
 	Style: plain C
 	Version: Ref-pc
 */

/*
	Original Plain C Code
*/

/*
	Questo esempio mostra la traduzione in ASM di un programma C
	contenente una funzione ricorsiva. Nella funzione ricorsiva:
	- prima di fare la successiva chiamata ricorsiva è necessario
		modificare il parametro per calcolare l'argomento di tale chiamata
	- dopo il ritorno dalla successiva chiamata ricorsiva è necessario
		il valore originale del parametro
	Di conseguenza, in ogni attivazione della funzione ricorsiva,
	prima di eseguire ricorsivamente la successiva attivazione, è
	necessario salvare il valore del parametro per poi ripristinarlo
	al ritorno da tale attivazione. Il salvataggio deve essere fatto
	necessariamente nello stack; altrimenti se si usasse memoria allocata
	staticamente, il valore salvato verrebbe sovrascritto dalle
	attivazioni successive.
	Vengono realizzate 2 traduzioni ASM:
	1)	il parametro e il risultato vengono passati attraverso registri.
		Nonostante tale semplicità, è comunque necessario usare lo stack
		per salvare e ripristinare:
		- l'indirizzo di ritorno della routine (gestito automaticamente 
			in MC68000)
		- il valore del parametro della attivazione corrente
	2)	il parametro e il risultato vengono passati attraverso lo stack
*/

#include <stdio.h>

int f( int x ) {
	if ( x < 1 ) return 1;
	else return f( x / 3 ) - x;
}

/* variabili esterne */
int r, t;

int main( void ) {

	/* input */
	scanf( "%d", &t );

	/* calcolo */
	r = f( t );

	/* output */
	printf( "%d\n", r );

	return 0;
}

/*
	Test Cases

	Test 1
	input: 0
	output: 1

	Test 2
	input: 1
	output: 0

	Test 3
	input: 2
	output: -1

	Test 4
	input: 10
	output: -13

	Test 5
	input: 35
	output: -49

	Test 6
	input: 64
	output: -93

	Test 7
	input: 320
	output: -475

	Test 8
	input: 4096
	output: -6138
*/
