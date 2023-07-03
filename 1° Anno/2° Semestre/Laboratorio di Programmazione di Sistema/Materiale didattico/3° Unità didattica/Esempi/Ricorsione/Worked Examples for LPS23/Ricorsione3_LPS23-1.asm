* -------------------------------
* 	LPS Example
*
* 	Ricorsione 3
*
*	Language: MC68K-ASM1
*	Style: plain MC68000
* 	Version: -m68k
* -------------------------------

* Plain MC68000 Solution

* Questo esempio mostra la traduzione in ASM di un programma C
* contenente una funzione ricorsiva. Nella funzione ricorsiva:
* - prima di fare la successiva chiamata ricorsiva è necessario
*	modificare il parametro per calcolare l'argomento di tale chiamata
* - dopo il ritorno dalla successiva chiamata ricorsiva è necessario
*	il valore originale del parametro
* Di conseguenza, in ogni attivazione della funzione ricorsiva,
* prima di eseguire ricorsivamente la successiva attivazione, è
* necessario salvare il valore del parametro per poi ripristinarlo
* al ritorno da tale attivazione. Il salvataggio deve essere fatto
* necessariamente nello stack; altrimenti se si usasse memoria allocata
* staticamente, il valore salvato verrebbe sovrascritto dalle
* attivazioni successive.
* Vengono realizzate 2 traduzioni ASM:
* 1)	il parametro e il risultato vengono passati attraverso registri.
*	Nonostante tale semplicità, è comunque necessario usare lo stack
*	per salvare e ripristinare:
*	- l'indirizzo di ritorno della routine (gestito automaticamente 
*		in MC68000)
*	- il valore del parametro della attivazione corrente
* 2)	il parametro e il risultato vengono passati attraverso lo stack

* Questo esempio e' realizzato per l'assembler ASM-One V1.48

* Variabili
; il tipo int viene memorizzato con word
	org	$1000

; la word seguente contiene il valore che la versione Plain C
; legge da standard input
t:	dc.w	10

; la word seguente, al termine del programma contiene il
; valore che la versione Plain C stampa su standard output
r:	dc.w	0

* Programma
	org	$2000

inizio_codice:

* Routine main
main:
	* input
	; la lettura mediante scanf della versione Plain C
	; viene simulata dalla lettura della word a indirizzo t
	
	* calcolo
	move.w	t,d0
	bsr		f
	move.w 	d0,r

	* output
	; la scrittura mediante printf della versione Plain C
	; viene simulata dalla scrittura della word a indirizzo r

fine_main:

	* fine programma
	bra	fine_codice

* Routine f
; Input
;	d0 (word) - parametro x
; Output
;	d0 (word) - risultato
; Registri modificati
;	??
; Stack frame
; offset da indirizzo	| contenuto		| note
; area stack frame		|				|
;						| 				|
;	0					| pc di ritorno	| allocato da chiamata
;						| 				|
;----------------------------------------------------------------------
; dimensione stack frame: ?
f:
	cmp.w	#1,d0		; confronta parametro con 1
	blt		f_base

	; push di d0 nello stack
	move.w 	d0,-(sp)

	ext.l 	d0		; sign-extension per dividendo
	divs	#3,d0	; x / 3 in d0 word

	bsr		f
	; d0 contiene il risultato

	; termina calcolo
	move.w 	(sp)+,d1
	sub.w 	d1,d0
	; in alternativa posso fare direttmente la sub dalla cima dello stack
	; sub.w	(sp)+,d0

	rts

f_base:
	move.w	#1,d0
	rts

fine_codice:


**	Test Cases
*
*	Test 1
*	input: 0
*	output: 1
*
*	Test 2
*	input: 1
*	output: 0
*
*	Test 3
*	input: 2
*	output: -1
*
*	Test 4
*	input: 10
*	output: -13
*
*	Test 5
*	input: 35
*	output: -49
*
*	Test 6
*	input: 64
*	output: -93
*
*	Test 7
*	input: 320
*	output: -475
*
*	Test 8
*	input: 4096
*	output: -6138



* ---METADATA--- do not write below here
* {
*     "version": 1,
*     "description": "",
*     "name": "Ricorsione3_LPS23-1",
*     "language": "M68K",
*     "createdAt": 1685951370213,
*     "updatedAt": 1685960392394,
*     "id": "BtoxMDv"
* }