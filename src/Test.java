import java.util.*;

import model.Classe;
import view.MainFrame;
/**
 * 
 */

/**
 * @author Admin
 *
 */
public final class Test {

	
	/**
	 * @param args
	 */
		public static void main(String args[]) {
			List<Classe> school = new ArrayList<Classe>();
			MainFrame fp = new MainFrame(school);
			fp.setVisible(true);
		}
	}

