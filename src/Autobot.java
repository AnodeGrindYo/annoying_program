import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Autobot {
	private final int 	A = KeyEvent.VK_A,
						B = KeyEvent.VK_B,
						C = KeyEvent.VK_C,
						D = KeyEvent.VK_D,
						E = KeyEvent.VK_E,
						F = KeyEvent.VK_F,
						G = KeyEvent.VK_G,
						H = KeyEvent.VK_H,
						I = KeyEvent.VK_I,
						J = KeyEvent.VK_J,
						K = KeyEvent.VK_K,
						L = KeyEvent.VK_L,
						M = KeyEvent.VK_M,
						N = KeyEvent.VK_N,
						O = KeyEvent.VK_O,
						P = KeyEvent.VK_P,
						Q = KeyEvent.VK_Q,
						R = KeyEvent.VK_R,
						S = KeyEvent.VK_S,
						T = KeyEvent.VK_T,
						U = KeyEvent.VK_U,
						V = KeyEvent.VK_V,
						W = KeyEvent.VK_W,
						X = KeyEvent.VK_X,
						Y = KeyEvent.VK_Y,
						Z = KeyEvent.VK_Z,
						SUPER = KeyEvent.VK_WINDOWS,
						UP = KeyEvent.VK_UP,
						DOWN = KeyEvent.VK_DOWN,
						LEFT = KeyEvent.VK_LEFT,
						RIGHT = KeyEvent.VK_RIGHT,
						ENTER = KeyEvent.VK_ENTER,
						CTRL = KeyEvent.VK_CONTROL,
						ALT =KeyEvent.VK_ALT;
	
	private Robot robot;
	
	public Autobot()
	{
		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void lockSession() // it works !!
	{
		int[] shortcut = {SUPER, RIGHT, RIGHT, DOWN, DOWN, DOWN, ENTER};
		
		for(int i=0; i<shortcut.length; i++)
		{
			System.out.println(i);
			robot.keyPress(shortcut[i]);
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyRelease(shortcut[i]);
		}
	}
	public void barrelRoll()
	{
		int[] sequence = {RIGHT, DOWN, LEFT, UP};
		
		for(int i=0; i<sequence.length; i++)
		{
			System.out.println(i);
			robot.keyPress(CTRL);
			robot.keyPress(ALT);
			robot.keyPress(sequence[i]);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyRelease(sequence[i]);
			robot.keyRelease(CTRL);
			robot.keyRelease(ALT);
		}
	}
	
	public void rndmPointer(boolean click)
	{
		// 1. get screen dimensions
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)screenSize.getHeight();
		int width = (int)screenSize.getWidth();
		
		
		for (int i=0; i<40; i++)
		{
			int nextX = ThreadLocalRandom.current().nextInt(0, width + 1);
			int nextY = ThreadLocalRandom.current().nextInt(0, height + 1);
			robot.mouseMove(nextX, nextY);
			if (click) robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			try {
				Thread.sleep(250);
				if (click) robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static boolean run(String command)
	{
		// runs command
		Runtime run = Runtime.getRuntime();
		try {
			run.exec(command);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean containsExeExt(String str)
	{
		boolean exepresent = false;
		if(str.substring(str.length()-4).equals(".exe"))
		{
			exepresent = true;
		}
		return exepresent;
	}
	
	public void type(CharSequence characters) {
        int length = characters.length();
        for (int i = 0; i < length; i++) {
            char character = characters.charAt(i);
            type(character);
            try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    public void type(char character) {
        switch (character) {
        case 'a': doType(KeyEvent.VK_A); break;
        case 'b': doType(KeyEvent.VK_B); break;
        case 'c': doType(KeyEvent.VK_C); break;
        case 'd': doType(KeyEvent.VK_D); break;
        case 'e': doType(KeyEvent.VK_E); break;
        case 'f': doType(KeyEvent.VK_F); break;
        case 'g': doType(KeyEvent.VK_G); break;
        case 'h': doType(KeyEvent.VK_H); break;
        case 'i': doType(KeyEvent.VK_I); break;
        case 'j': doType(KeyEvent.VK_J); break;
        case 'k': doType(KeyEvent.VK_K); break;
        case 'l': doType(KeyEvent.VK_L); break;
        case 'm': doType(KeyEvent.VK_M); break;
        case 'n': doType(KeyEvent.VK_N); break;
        case 'o': doType(KeyEvent.VK_O); break;
        case 'p': doType(KeyEvent.VK_P); break;
        case 'q': doType(KeyEvent.VK_Q); break;
        case 'r': doType(KeyEvent.VK_R); break;
        case 's': doType(KeyEvent.VK_S); break;
        case 't': doType(KeyEvent.VK_T); break;
        case 'u': doType(KeyEvent.VK_U); break;
        case 'v': doType(KeyEvent.VK_V); break;
        case 'w': doType(KeyEvent.VK_W); break;
        case 'x': doType(KeyEvent.VK_X); break;
        case 'y': doType(KeyEvent.VK_Y); break;
        case 'z': doType(KeyEvent.VK_Z); break;
        case 'A': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_A); break;
        case 'B': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_B); break;
        case 'C': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_C); break;
        case 'D': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_D); break;
        case 'E': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_E); break;
        case 'F': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_F); break;
        case 'G': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_G); break;
        case 'H': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_H); break;
        case 'I': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_I); break;
        case 'J': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_J); break;
        case 'K': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_K); break;
        case 'L': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_L); break;
        case 'M': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_M); break;
        case 'N': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_N); break;
        case 'O': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_O); break;
        case 'P': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_P); break;
        case 'Q': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_Q); break;
        case 'R': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_R); break;
        case 'S': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_S); break;
        case 'T': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_T); break;
        case 'U': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_U); break;
        case 'V': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_V); break;
        case 'W': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_W); break;
        case 'X': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_X); break;
        case 'Y': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_Y); break;
        case 'Z': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_Z); break;
        case '`': doType(KeyEvent.VK_BACK_QUOTE); break;
        case '0': doType(KeyEvent.VK_0); break;
        case '1': doType(KeyEvent.VK_1); break;
        case '2': doType(KeyEvent.VK_2); break;
        case '3': doType(KeyEvent.VK_3); break;
        case '4': doType(KeyEvent.VK_4); break;
        case '5': doType(KeyEvent.VK_5); break;
        case '6': doType(KeyEvent.VK_6); break;
        case '7': doType(KeyEvent.VK_7); break;
        case '8': doType(KeyEvent.VK_8); break;
        case '9': doType(KeyEvent.VK_9); break;
        case '-': doType(KeyEvent.VK_MINUS); break;
        case '=': doType(KeyEvent.VK_EQUALS); break;
        case '~': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_BACK_QUOTE); break;
        case '!': doType(KeyEvent.VK_EXCLAMATION_MARK); break;
        case '@': doType(KeyEvent.VK_AT); break;
        case '#': doType(KeyEvent.VK_NUMBER_SIGN); break;
        case '$': doType(KeyEvent.VK_DOLLAR); break;
        case '%': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_5); break;
        case '^': doType(KeyEvent.VK_CIRCUMFLEX); break;
        case '&': doType(KeyEvent.VK_AMPERSAND); break;
        case '*': doType(KeyEvent.VK_ASTERISK); break;
        case '(': doType(KeyEvent.VK_LEFT_PARENTHESIS); break;
        case ')': doType(KeyEvent.VK_RIGHT_PARENTHESIS); break;
        case '_': doType(KeyEvent.VK_UNDERSCORE); break;
        case '+': doType(KeyEvent.VK_PLUS); break;
        case '\t': doType(KeyEvent.VK_TAB); break;
        case '\n': doType(KeyEvent.VK_ENTER); break;
        case '[': doType(KeyEvent.VK_OPEN_BRACKET); break;
        case ']': doType(KeyEvent.VK_CLOSE_BRACKET); break;
        case '\\': doType(KeyEvent.VK_BACK_SLASH); break;
        case '{': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_OPEN_BRACKET); break;
        case '}': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_CLOSE_BRACKET); break;
        case '|': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_BACK_SLASH); break;
        case ';': doType(KeyEvent.VK_SEMICOLON); break;
        case ':': doType(KeyEvent.VK_COLON); break;
        case '\'': doType(KeyEvent.VK_QUOTE); break;
        case '"': doType(KeyEvent.VK_QUOTEDBL); break;
        case ',': doType(KeyEvent.VK_COMMA); break;
        case '<': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_COMMA); break;
        case '.': doType(KeyEvent.VK_PERIOD); break;
        case '>': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_PERIOD); break;
        case '/': doType(KeyEvent.VK_SLASH); break;
        case '?': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_SLASH); break;
        case ' ': doType(KeyEvent.VK_SPACE); break;
        default: break;
//        default:
//            throw new IllegalArgumentException("Cannot type character " + character);
        }
    }

    private void doType(int... keyCodes) {
        doType(keyCodes, 0, keyCodes.length);
    }

    private void doType(int[] keyCodes, int offset, int length) {
        if (length == 0) {
            return;
        }

        robot.keyPress(keyCodes[offset]);
        doType(keyCodes, offset + 1, length - 1);
        robot.keyRelease(keyCodes[offset]);
    }
    
    public void typeRandomStringInNotepad(int length)
    {
    	run("notepad.exe");
    	try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	type(rndmStr(length));
    }
    
    public String rndmStr(int length)
    {
//    	byte[] array = new byte[length];
//        new Random().nextBytes(array);
//        String generatedString = new String(array, Charset.forName("UTF-8"));
//    	return generatedString;
    	
    	int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
    	return generatedString;
    }
    

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

		
		
		Autobot bot = new Autobot();
		bot.barrelRoll();
		bot.rndmPointer(false);
//		bot.lockSession();
//		bot.typeRandomStringInNotepad(Integer.MAX_VALUE/8);
		
		
		// the annoying mix... uncomment this to get a really annoying program
//		Thread barrelRollThread = new Thread() {
//			public void run() {
//				while(true) {
//					bot.barrelRoll();
//				}
//			}
//		};
//		
//		Thread pointerThread = new Thread() {
//			public void run() {
//				while(true) {
//					bot.rndmPointer(true);
//				}
//			}
//		};
		
	}

}
