/*Codigo de usuario*/
package com.jbrod.ide_sql.app.analyzer;
import java_cup.runtime.*;


%%


/* Declaraciones */
%public
%class SqlLexer
%cup
%line
%column

whitespace=[ \t\r\n\f]

relop=\=|<|>|<\=|>\=|<>
logicalop=AND|OR

eoinstr=;
allcolumns=\*
lcurlybrkt=\{
rcurlybrkt=\}
lpar=\(
rpar=\)
comma=,
dot=\.

filtrar=FILTRAR
seleccionar=SELECCIONAR
en=EN
insertar=INSERTAR
valores=VALORES
actualizar=ACTUALIZAR
asignar=ASIGNAR
eliminar=ELIMINAR

letter=[a-zA-Z]
digit=[0-9]+
identifier=[a-zA-Z][a-zA-Z0-9_]*
value=digit|letter|\"[a-zA-Z]+\"


/*%{
    private Symbol symbol(int type){
        return new Symbol(type, yyline+1, yycolumn+1);
    }
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
    private void error(String message){
         System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
    }
}%*/


%%



/* Reglas lexicas */

{whitespace} 	{/* ignorar */}

{relop}         { return new Symbol(sym.RELOP       , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{logicalop}     { return new Symbol(sym.LOGICALOP   , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}

{eoinstr}       { return new Symbol(sym.EOINSTR     , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{allcolumns}    { return new Symbol(sym.ALLCOLUMNS  , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{lcurlybrkt}    { return new Symbol(sym.LCURLYBRKT  , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{rcurlybrkt}    { return new Symbol(sym.RCURLYBRKT  , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{lpar}          { return new Symbol(sym.LPAR        , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{rpar}          { return new Symbol(sym.RPAR        , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{comma}         { return new Symbol(sym.COMMA       , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{dot}           { return new Symbol(sym.DOT         , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}

{filtrar}       { return new Symbol(sym.FILTRAR     , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{seleccionar}   { return new Symbol(sym.SELECCIONAR , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{en}            { return new Symbol(sym.EN          , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{insertar}      { return new Symbol(sym.INSERTAR    , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{valores}       { return new Symbol(sym.VALORES     , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{actualizar}    { return new Symbol(sym.ACTUALIZAR  , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{asignar}       { return new Symbol(sym.ASIGNAR     , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{eliminar}      { return new Symbol(sym.ELIMINAR    , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}


{digit}         { return new Symbol(sym.DIGIT        , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{identifier}    { return new Symbol(sym.IDENTIFIER   , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}
{value}         { return new Symbol(sym.VALUE        , yyline+1, yycolumn+1, new String(   yytext()   ))  ;}

.               { /* return new Symbol(sym.ERROR        , yyline+1, yycolumn+1, new String(   yytext()   ))  ;*/
                     System.out.println("Hubo un error lexico: " + yytext());} 