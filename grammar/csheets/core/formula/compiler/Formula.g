grammar Formula;

options {
	language=Java;
	output=AST;
}


@parser::header {
package csheets.core.formula.compiler;
}

@lexer::header {
package csheets.core.formula.compiler;
}

// Alter code generation so catch-clauses get replace with
// this action.
@rulecatch {
	catch (RecognitionException e) {
		reportError(e);
		throw e;
	}
}

@members {
	protected void mismatch(IntStream input, int ttype, BitSet follow)
		throws RecognitionException
	{
    	throw new MismatchedTokenException(ttype, input);
	}

	public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
		throws RecognitionException
	{
		throw e;
	}

	@Override
  	protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
    	throw new MismatchedTokenException(ttype, input);
 	}
}

expression
	: (EQ! operation EOF!) | (CA! money EOF!) | (LCHA! EQ! function_call RCHA! EOF!)
	;

operation
	: comparison | forcicle
	;

money
    : (DOLLAR_WORD | EURO_WORD | POUND_WORD | YEN_WORD | WON_WORD | RUPEE_WORD)^ LCHA! money_value (PLUS | MINUS | MULTI | DIV) money_value RCHA!
    ;

money_value
          : NUMBER currency
          ;

currency
       : DOLLAR | EURO | POUND | YEN | WON | RUPEE
       ;

attribution
	: ( ARRAY | VARIABLE  | CELL_REF ) ATT^ comparison
	;

comparison
	: concatenation
		( ( EQ^ | NEQ^ | GT^ | LT^ | LTEQ^ | GTEQ^ ) concatenation )?
	;

concatenation
	: arithmetic_lowest
		( AMP^ arithmetic_lowest )*
	;

arithmetic_lowest
	:	arithmetic_low
		( ( PLUS^ | MINUS^ ) arithmetic_low )*
	;

arithmetic_low
	:	arithmetic_medium
		( ( MULTI^ | DIV^ ) arithmetic_medium )*
	;

arithmetic_medium
	:	arithmetic_high
		( POWER^ arithmetic_high )?
	;

arithmetic_high
	:	arithmetic_highest ( PERCENT^ )?
	;

arithmetic_highest
	:	( MINUS^ )? atom
	;

atom
	:	literal
	|	function_call
	|	reference
	|	LPAR! comparison RPAR!
	|	bloco
        |       attribution
        |       variables
		|		arrays
	;

function_call
	:	FUNCTION^ LPAR!
		( comparison ( SEMI! comparison )* )?
		RPAR!
	;
        

reference
	:	CELL_REF
		( ( COLON^ ) CELL_REF )?
	;

variables
	:  VARIABLE ( ( COLON^ ) VARIABLE )?
        ;

arrays
	:  ARRAY ( ( COLON^ ) ARRAY )?
        ;

literal
	:	NUMBER
	|	STRING
	|	ALPHA
	;

forcicle
	:	FOR^ LCHA! attribution SEMI! comparison (SEMI! operation)+ RCHA!
	;

bloco
	:	LCHA! operation ( SEMI^ operation )* RCHA!
	;

/* Currencies */
DOLLAR  : '$' ;
EURO    : '€' ;
POUND   : '£' ;
YEN     : '¥' ;
WON     : '₩' ; 
RUPEE   : '₹' ;

/* Currencies in words */
DOLLAR_WORD : 'dollar'  ;
EURO_WORD   : 'euro'    ;
POUND_WORD  : 'pound'   ;
YEN_WORD    : 'yen'     ;
WON_WORD    : 'won'     ;
RUPEE_WORD  : 'ruppe'   ;

/* FOR operators */
FOR		: 'FOR' ;

fragment LETTER: ('a'..'z'|'A'..'Z') ;

FUNCTION :
	  ( LETTER )+
	;


CELL_REF
	:
		( ABS )? LETTER ( LETTER )?
		( ABS )? ( DIGIT )+
	;

VARIABLE
        :
           VAR LETTER (DIGIT | LETTER)*
        ;

ARRAY
		:
		   VARIABLE (LSPAR (DIGIT)+ RSPAR)?
		;

ALPHA
		: (LETTER|DIGIT)*(LETTER|DIGIT)(LETTER|DIGIT)*
		;

/* String literals, i.e. anything inside the delimiters */

STRING	:	QUOT
		(options {greedy=false;}:.)*
		QUOT  { setText(getText().substring(1, getText().length()-1)); }
	;

QUOT: '"'
	;

/* Numeric literals */
NUMBER: ( DIGIT )+ ( COMMA ( DIGIT )+ )? ;

fragment
DIGIT : '0'..'9' ;

/* Atribution operators */
ATT		: ':=' ;

/* Variable reference */
VAR		: '@' ;

/* Comparison operators */
EQ		: '=' ;
CA              : '#' ;
NEQ		: '<>' ;
LTEQ	: '<=' ;
GTEQ	: '>=' ;
GT		: '>' ;
LT		: '<' ;

/* Text operators */
AMP		: '&' ;

/* Arithmetic operators */
PLUS	: '+' ;
MINUS	: '-' ;
MULTI	: '*' ;
DIV	: '/' ;
POWER	: '^' ;
PERCENT : '%' ;

/* Reference operators */
fragment ABS : '$' ;
fragment EXCL:  '!'  ;
COLON	: ':' ;

/* Miscellaneous operators */
COMMA	: ',' ;
SEMI	: ';' ;
LPAR	: '(' ;
RPAR	: ')' ;
LCHA	: '{' ;
RCHA	: '}' ;
LSPAR   : '[' ;
RSPAR	: ']' ;

/* White-space (ignored) */
WS: ( ' '
	| '\r' '\n'
	| '\n'
	| '\t'
	) {$channel=HIDDEN;}
	;
