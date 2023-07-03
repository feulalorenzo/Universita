# -------------------------------
# 	LPS Example
#
# 	Exception
#
#	Language: MIPS32-MARS
#	Style: plain MIPS32
# 	Version: Ref-mips
# -------------------------------

#  Plain MIPS32 Original Code

# Questo esempio mostra
# 1) gestore delle eccezioni
# 2) gestione dell'eccezione causata da overflow:
#	viene restituito come risultato il massimo valore intero con segno
# 3) differenza tra add (che genera eccezione di overflow) e addu (che non lo fa)

# Questo esempio e' realizzato per l'assembler MARS
# Per eseguire il programma si possono usare i comandi della GUI

# Variabili
	.data
Result:	.word	0

# Programma
# La routine principale viene naturalemente eseguita in modalità user
	.text
inizio_codice:

# Istruzioni di somma eseguite senza che ci sia overflow
# In questo caso le istruzioni add e addu sono equivalenti
	li	$t0, 0x7000	# carica 0x7000
	
	li	$t1, 0x2000	# carica 0x2000

	add	$v0,$t0,$t1	# v0 contiene risultato di add
	addu	$v1,$t0,$t1	# v1 contiene risultato di addu

# se i risultati sono diversi terminerebbe il programma
# ma la condizione e' sempre falsa
	bne	$v0,$v1,fine_codice


# Istruzioni di somma che provocano un overflow
# In questo caso add genera un'eccezione mentre addu non lo fa
	li	$t0, 0x70000000	# carica 0x70000000, numero positivo grande 
	
	li	$t1, 0x20000000	# carica 0x20000000, numero positivo grande
	
	# 0x70000000 + 0x2000000 = 0x9000000
	# 0x90000000 interpretato in complemento a 2 e' negativo
	
	
	# genera eccezione
	add	$v0, $t0, $t1
	
	# non genera eccezione
	addu	$v1, $t0, $t1
	
	# verifica: confronta i due risultati, dovrebbero essere diversi
	# in quanto la add ha generato eccezione e il gestore ha inserito
	# in v0 il massimo valore intero positivo
	bne	$v0,$v1,risultati_diversi

	# viene eseguito questo codice se add e addu hanno prodotto risultati
	# uguali: non viene mai eseguito in quanto l'íntervento del gestore
	# di eccezione a seguito della add, modifica il valore di v0 
	li	$t0,0xDEADC0DE
	sw	$t0,Result

	j	fine_codice
	
risultati_diversi:
	# viene eseguito questo codice se add (con l'íntervento del
	# gestore di eccezione) e addu hanno prodotto risultati diversi
	li	$t0,0xBADADD
	sw	$t0,Result

	# Eccezione non gestita
	# L'istruzione seguente tenta un accesso in formato word ad un
	# indirizzo di memoria dispari. Come noto, in MIPS32 cio' non e'
	# possibile e viene generata un'eccezione.
	# Tale eccezione ha un codice identificativo diverso da quello 
	# dell'eccezione di overflow (in caso di accesso in lettura e' 4).
	# Il gestore di eccezione in questo caso si limita a ritornare
	# al programma, senza modificare EPC. Di conseguenza l'esecuzione
	# del programma riprende dalla STESSA istruzione che ha causato
	# l'eccezione, e quindi verra' nuovamente generata un'eccezione:
	# quindi si entra in una sequenza infinita di generazione di eccezioni 
	lw	$t0,0x10001001	# 0x10001001 e' un indirizzo DISPARI

	# L'istruzione seguente non verra' mai eseguita in quanto si genera
	# una sequenza infinita di tentativi di eseguire l'istruzione
	# precedente
	sub	$v0,$v0,$v1

fine_codice:

# Gestore di Eccezione
# Il gestore di eccezione viene eseguito in modalità Kernel
# Il codice va inserito in una sezione apposita, allocata in un'area
# di memoria riservata al codice che può essere eseguito in modalità Kernel
# Sezioni di questo tipo sono definite mediante la direttiva ktext

# In MIPS32 i gestori di eccezione hanno indirizzo fissi, definito in hardware
# In questo esempio, la routine principale genera un overflow che causa un
# eccezione; le eccezioni di overflow provocano l'esecuzione del gestore
# che ha indirizzo 0x80000180. Tale gestore viene eseguito a seguito di numerosi
# tipi di eccezione (nota storica: nelle versioni precedenti della famiglia MIPS,
# tale gestore era l'unico gestore esistente).
# Il registro CAUSE, ossia il registro $13 del coprocessore 0, contiene
# nel bit-field formato dai bit di posizione compresa tra 2 e 6 (estremi
# inclusi), il codice identificativo dell'eccezione
# L'indirizzo di ritorno, ossia l'indirizzo dell'istruzione da cui
# riprendere l'esecuzione al termine del gestore di eccezione, e'
# contenuto nel registro EPC, ossia il registro $14 del coprocessore 0
	.ktext	0x80000180
	
	# Si noti che il gestore di eccezione modifica i registri k0 e k1
	# Tali registri, per convenzione, dovrebbero essere usati 
	# esclusivamente da codice eseguito in modo kernel

	# Individua la causa dell'eccezione leggendo i bit
	# di posizione compresa tra 2 e 6 del registro CAUSE
	mfc0	$k0,$13		# copia CAUSE in k0
	srl	$k0,$k0,2	# elimina i bit che non servono	
	and	$k0,$k0,0x001f

	# Se l'eccezione e' un oveflow, va al codice che la gestisce
	# Altrimenti termina subito il gestore
	# Il codice identificativo dell'eccezione di overflow e' 12
	beq	$k0,12,gestione_overflow

	# Non gestisce altre eccezioni per non complicare l'esempio
	# Quindi in caso di eccezione diversa da overflow ritorna
	# ad eseguire l'istruzione che ha provocato l'eccezione
	eret

gestione_overflow:
	# L'istruzione add ha generato un overflow
	# Allora inserisce in v0, il registro che avrebbe dovuto contenere
	# il risultato di add, il massimo valore intero positivo
	li	$v0,0x7fffffff

	# Incrementa di 4 l'indirizzo di ritorno in modo che 
	# punti all'istruzione successiva rispetto a quella che ha
	# provocato l'eccezione (ossia la add)
	mfc0	$k0,$14		# copia EPC in k0
	addu	$k0,$k0,4	# incrementa di 4 l'indirizzo
	mtc0	$k0,$14		# copia l'indirizzo aggiornato in EPC

	# Termina gestore di eccezione e riprende l'esecuzione a partire
	# dall'istruzione puntata da EPC
	eret	
	
