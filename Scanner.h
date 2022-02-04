#ifndef SCANNER

#define SCANNER

#include <iostream>
#include <fstream>
using namespace std;

enum TokenType { ERROR, LBRACE, RBRACE, SEMI, NUMBER, PLUS, EQL, LPAREN, RPAREN, EE, GRE, GR, MULTIPLY, DIVIDE, MINUS, MOD, EOL, COMMA, DOT, AND, OR, POWER, IDEN, CONSTANT, NONE /*this is for if the file is empty*/ };

class Scanner
{
public:
	Scanner(string filename);

	TokenType currentTokenType();
	TokenType nextTokenType();
	string currentTokenString();
	string nextTokenString();

	void advance();

	int getLine();
private:
	ifstream filestream;
	string currents;
	string nexts;
	TokenType currenttt;
	TokenType nexttt;

	int linenext;
	int linecurrent;
};

#endif // !