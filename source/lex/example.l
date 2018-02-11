/* scanner for a toy Pascal-like language */
%{
#include <math.h> /* needed for call to atof() */
%}
DIG [0-9]
ID [a-z][a-z0-9]*
%%
{DIG}+ printf("Integer: %s (%d)\n", yytext, atoi(yytext));
{DIG}+"."{DIG}* printf("Float: %s (%g)\n", yytext, atof(yytext));
if|then|begin|end printf("Keyword: %s\n",yytext);
{ID} printf("Identifier: %s\n",yytext);
"+"|"-"|"*"|"/"|">" printf("Operator: %s\n",yytext);
"{"[^}\n]*"}" /* skip one-line comments */
[ \t\n]+ /* skip whitespace */
. printf("Unrecognized: %s\n",yytext);
%%
int main(){yylex();}
