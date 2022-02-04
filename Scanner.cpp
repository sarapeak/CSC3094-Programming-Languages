#include "Scanner.h"

#include <string>
using namespace std;

//Defines the Token names
string toString(TokenType t)
{
	if (t == NONE)
		return "NONE";
	if (t == PLUS)
		return "PLUS";
	if (t == EQL)
		return "EQL";
	if (t == LPAREN)
		return "LPAREN";
	if (t == RPAREN)
		return "RPAREN";
	if (t == LBRACE)
		return "LBRACE";
	if (t == RBRACE)
		return "RBRACE";
	if (t == NUMBER)
		return "NUMBER";
	if (t == SEMI)
		return "SEMI";
	if (t == ERROR)
		return "error: ";
	if (t == EE)
		return "EE";
	if (t == GRE)
		return "GRE";
	if (t == GR)
		return "GR";
	if (t == MULTIPLY)
		return "MULTIPLY";
	if (t == DIVIDE)
		return "DIVIDE";
	if (t == MINUS)
		return "MINUS";
	if (t == MOD)
		return "MOD";
	if (t == EOL)
		return "EOL";
	if (t == COMMA)
		return "COMMA";
	if (t == DOT)
		return "DOT";
	if (t == AND)
		return "AND";
	if (t == OR)
		return "OR";
	if (t == POWER)
		return "POWER";
	if (t == IDEN)
		return "IDEN";
	if (t == CONSTANT)
		return "CONSTANT";
	return "ERROR in tostring";
}

string Scanner::currentTokenString()
{
	return currents;
}

string Scanner::nextTokenString()
{
	return nexts;
}

TokenType Scanner::currentTokenType()
{
	return currenttt;
}

TokenType Scanner::nextTokenType()
{
	return nexttt;
}
//The Scanner
Scanner::Scanner(string fname)
{
	filestream.open(fname);

	linenext = 1;

	if (!filestream.good())
	{
		cout << "Could not open file: "<< fname<<"\n";
		return;
	}

	advance(); //fill up first slot
	advance(); //fill up second slot

	while (currentTokenType() != NONE)
	{
		cout << toString(currentTokenType()) << " " << currentTokenString() << "\n";
		advance();
	}
}
//Adds an item to the buffer
void addToBuffer(string & buf, ifstream & stream)
{
	int next = stream.get();

	if (next == -1)
	{
		buf = buf + (char)0; //null signifies eof for today!
	}
	else
	{
		buf = buf + (char)next;
	}
	//cout << ":" << next << ":";
}
//Removes an item from the buffer
void removeFromBuffer(string & buf, ifstream & stream)
{
	char last = buf.back();
	stream.putback(last);
	buf = buf.substr(0, buf.size() - 1);
}
//Sees if there is a number
bool isNum(char test)
{
	return (test == '0' || test == '1' || test == '2' || test == '3' || test == '4' || test == '5' || test == '6' || test == '7' || test == '8' || test == '9');
}

//advance places whatever is in the next variables into the current variables and finds what the next variables are supposed to be
void Scanner::advance()
{
	currents = nexts;
	currenttt = nexttt;
	linecurrent = linenext;

	string buffer;

	addToBuffer(buffer, filestream);

	//If the buffer is an equal character
	if (buffer[0] == '=')
	{
		addToBuffer(buffer, filestream);   //Adds to the buffer
		//If the second item is a =
		if (buffer[1] == '=')
		{
			//Equal Equal sign
			nexttt = EE;
			nexts = "==";
		}
		//Else is it a regular equal
		else
		{
			removeFromBuffer(buffer, filestream);   //Removes from the buffer
			nexttt = EQL;
			nexts = "=";
		}
	}
	//If the buffer is an greater than sign
	else if (buffer[0] == '>')
	{
		addToBuffer(buffer, filestream);   //Adds a new item to the buffer
		//If the second item is an equal
		if (buffer[1] == '=')
		{
			//It is a greater than and equal sign
			nexttt = GRE;
			nexts = ">=";
		}
		//Else it is only a greater sign
		else
		{
			removeFromBuffer(buffer, filestream);   //Removes an item form the list
			nexttt = GR;
			nexts = ">";
		}
	}
	//If the character is a multiply sign
	else if (buffer[0] == '*')
	{
		nexttt = MULTIPLY;
		nexts = "*";
	}
	//If the character is a divide sign
	else if (buffer[0] == '/')
	{
		nexttt = DIVIDE;
		nexts = "/";
	}
	//If the character is a plus sign
	else if (buffer[0] == '+')
	{
		nexttt = PLUS;
		nexts = "+";
	}
	//If the character is a minus sign
	else if (buffer[0] == '-')
	{
		int minusNum = 1;
		addToBuffer(buffer, filestream);   //Adds an item to the bufffer
		//If the second item in the buffer is a number
		if (isNum(buffer[1]))
		{
			//Loops
			while (true)
			{
				//If the buffer item is not a number
				if (!isNum(buffer[minusNum]))
				{
					removeFromBuffer(buffer, filestream);   //Removes from the buffer
					break;   //Breaks the loop
				}
				addToBuffer(buffer, filestream);   //Adds an item to the buffer
				minusNum++;   //Adds 1 to minusNum
			}
			//Says it is a constant
			nexttt = CONSTANT;
			nexts = buffer;
		}
		//Ohterwise it is a minus
		else
		{
			removeFromBuffer(buffer, filestream);   //Removes from the buffer
			//It is a minus
			nexttt = MINUS;
			nexts = "-";
		}
	}
	//If the buffer character is a left parenthesis
	else if (buffer[0] == '(')
	{
		nexttt = LPAREN;
		nexts = "(";
	}
	//If the character is a right parenthesis
	else if (buffer[0] == ')')
	{
		nexttt = RPAREN;
		nexts = ")";
	}
	//If the character is a left bracket
	else if (buffer[0] == '{')
	{
		nexttt = LBRACE;
		nexts = "{";
	}
	//If the character is a right bracket
	else if (buffer[0] == '}')
	{
		nexttt = RBRACE;
		nexts = "}";
	}
	//If the character is a semi-colon
	else if (buffer[0] == ';')
	{
		nexttt = EOL;
		nexts = ";";
	}
	//If the character is a comma
	else if (buffer[0] == ',')
	{
		nexttt = COMMA;
		nexts = ",";
	}
	//If the character is a dot
	else if (buffer[0] == '.')
	{
		nexttt = DOT;
		nexts = ".";
	}
	//If the character is a letter
	else if (0 != isalpha(buffer[0]))
	{
		int idenNum = 0;
		//Loops through
		while (true)
		{
			//If the buffer item is a number or letter
			if (isNum(buffer[idenNum]) || 0 != isalpha(buffer[idenNum]))
			{
				addToBuffer(buffer, filestream);   //Adds to the buffer
				idenNum++;   //Adds one to the idenNum
			}
			//If the buffer item is not a number or a letter
			else
			{
				removeFromBuffer(buffer, filestream);   //Removes an item from the buffer
				//If the idenNum is 3
				if (idenNum == 3)
				{
					//If it spells out mod
					if (buffer[0] == 'm' && buffer[1] == 'o' && buffer[2] == 'd')
					{
						//Becomes a MOD
						nexttt = MOD;
						nexts = buffer;
					}
					//If it spells out amp
					else if (buffer[0] == 'a' && buffer[1] == 'm' && buffer[2] == 'p')
					{
						//Becomes an AND
						nexttt = AND;
						nexts = buffer;
					}
					//If it spells out orr
					else if (buffer[0] == 'o' && buffer[1] == 'r' && buffer[2] == 'r')
					{
						//Becomes an OR
						nexttt = OR;
						nexts = buffer;
					}
					//If it spells out pow
					else if (buffer[0] == 'p' && buffer[1] == 'o' && buffer[2] == 'w')
					{
						//Becomes a POWER
						nexttt = POWER;
						nexts = buffer;
					}
					//If the three characters do not spell out anything
					else
					{
						//Becomes an IDEN
						nexttt = IDEN;
						nexts = buffer;
					}
				}
				//If the idenNum is greater than or less than 3
				else
				{
					nexttt = IDEN;
					nexts = buffer;
				}
				break;
			}
		}
	}
	//If the buffer is 0, there is nothing there
	else if (buffer[0] == 0)
	{
		nexttt = NONE;
		nexts = "eof";
	}
	else
	{
		//If the buffer item is a number
		if (isNum(buffer[0]))
		{
			//Loops through the buffer and adds to it
			while (isNum(buffer[buffer.size() - 1]))
			{
				addToBuffer(buffer, filestream);
			}
			//If there is an error in the reading
			if (buffer.size() > 1 && !isNum(buffer[buffer.size() - 2]))
			{
				removeFromBuffer(buffer, filestream);   //Removes from buffer
				nexttt = ERROR;
				nexts = "IT1: Invalid Token detected on line: " + to_string(linenext) + " [ " + buffer + " ]";
			}
			else
			{
				removeFromBuffer(buffer, filestream);   //Removes an item from the buffer
				//Makes it a constant
				nexttt = CONSTANT;
				nexts = buffer;
			}
		}
		//For errors in the textfile
		else
		{
			//white space
			bool temp = buffer[0] == ' ';
			if (temp || buffer[0] == '\n' || buffer[0] == '\t')
			{
				if (buffer[0] == '\n')
				{
					linenext++; 
				}
				advance();
			}
			else
			{
				nexttt = ERROR;
				bool check = true;
				int num = 0;
				//Loops through
				while (check)
				{
					//If the buffer contains a white space
					if (buffer[num] == ' ' || buffer[num] == '\n' || buffer[num] == '\t')
					{
						removeFromBuffer(buffer, filestream);   //Removes the white space
						nexts = "IT2: Invalid Token detected on line: " + to_string(linenext) + " [ " + buffer + " ] ";   //Print
						break;   //Break the loop
					}
					addToBuffer(buffer, filestream);   //Adds to the buffer
					num++;   //Increases the num
				}
			}
		}
	}
}

int Scanner::getLine()
{
	return linecurrent;
}