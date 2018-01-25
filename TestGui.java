import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;

public class TestGui extends JFrame implements ActionListener{

	JLabel nrLabel = new JLabel(" Insert Number: ");
	JLabel valueLabel = new JLabel(" Value In List:");
	JTextField insertNr = new JTextField();
	JTextField value = new JTextField();

	JButton insertFirst = new JButton("Insert First");
	JButton insertLast = new JButton("Insert Last");
	JButton insertBefore = new JButton("Insert Before Value");
	JButton insertAfter = new JButton("Insert After Value");
	JButton printList = new JButton("Print List");
	JButton countValue = new JButton("Count value of");
	JButton deleteList = new JButton("Delete List");
	JButton deleteFirst = new JButton("Delete First Value");
	JButton deleteLast = new JButton("Delete Last Value:");
	JButton deleteFirstValue = new JButton("Delete First Value Of");
	JButton deleteAllValues = new JButton("Delete All Values Of");

	static JTextArea textArea = new JTextArea("");

	static SingleLinkedList newList = new SingleLinkedList();

	public TestGui() {


		JPanel pText = new JPanel(new GridLayout(2,2));
		JPanel pWs= new JPanel(new GridLayout(5,1));
		JPanel pW = new JPanel(new BorderLayout());
		JPanel pC = new JPanel();
		JPanel pE = new JPanel(new GridLayout(6,1));
		JPanel pT = new JPanel(new BorderLayout());

		pT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pT.setBackground(Color.WHITE);
		pText.setBackground(Color.WHITE);

		pText.add(nrLabel);
		pText.add(insertNr);
		pText.add(valueLabel);
		pText.add(value);
		pWs.add(insertFirst);
		pWs.add(insertLast);
		pWs.add(insertBefore);
		pWs.add(insertAfter);
		pWs.add(printList);
		pW.add(pText, BorderLayout.NORTH);
		pW.add(pWs, BorderLayout.CENTER);

		pC.setBackground(new Color(255,255,255));
		pC.add(textArea);

		pE.add(countValue);
		pE.add(deleteFirst);
		pE.add(deleteLast);
		pE.add(deleteFirstValue);
		pE.add(deleteAllValues);
		pE.add(deleteList);

		pT.add(pW,BorderLayout.WEST);
		pT.add(pC,BorderLayout.CENTER);
		pT.add(pE, BorderLayout.EAST);

		add(pT);
		textArea.setEditable(false);

		insertFirst.addActionListener(this);
		insertLast.addActionListener(this);
		insertAfter.addActionListener(this);
		insertBefore.addActionListener(this);
		printList.addActionListener(this);
		countValue.addActionListener(this);
		deleteFirst.addActionListener(this);
		deleteLast.addActionListener(this);
		deleteFirstValue.addActionListener(this);
		deleteAllValues.addActionListener(this);
		deleteList.addActionListener(this);

		insertNr.addKeyListener(new KeyAdapter() {
		   public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_MINUS)) {
		         e.consume();  // ignore event
		      }
		   }
		});
		value.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			   char c = e.getKeyChar();
			   if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_MINUS)) {
			      e.consume();  // ignore event
			   }
			}
		});//Kopiert kode fra: http://stackoverflow.com/questions/4863850/disable-input-some-symbols-to-jtextfield

	}
	public void actionPerformed(ActionEvent e){

		if (insertNr.getText().length()!=0 && e.getSource() == insertFirst) {
			newList.insertFirst(Integer.parseInt(insertNr.getText()));
			textArea.setText(newList.printListTextArea(newList));
		}
		else if (insertNr.getText().length()!=0 && e.getSource() == insertLast) {
			newList.insertLast(Integer.parseInt(insertNr.getText()));
			textArea.setText(newList.printListTextArea(newList));
		}
		else if (value.getText().length()!=0 && insertNr.getText().length()!=0 && e.getSource() == insertBefore) {
			newList.insertBeforeValue(Integer.parseInt(insertNr.getText()),Integer.parseInt(value.getText()));
			textArea.setText(newList.printListTextArea(newList));
		}
		else if (value.getText().length()!=0 && insertNr.getText().length()!=0 && e.getSource() == insertAfter) {
			newList.insertAfterValue(Integer.parseInt(insertNr.getText()),Integer.parseInt(value.getText()));
			textArea.setText(newList.printListTextArea(newList));
		}
		else if (e.getSource() == printList) {
			textArea.setText(newList.printListTextArea(newList));
		}
		else if (value.getText().length()!=0 && e.getSource() == countValue) {
			textArea.setText(newList.printValueCountOf(Integer.parseInt(value.getText())));
		}
		else if (e.getSource() == deleteFirst) {
			newList.deleteFirst();
			textArea.setText(newList.printListTextArea(newList));
		}
		else if (e.getSource() == deleteLast) {
			newList.deleteLast();
			textArea.setText(newList.printListTextArea(newList));
		}
		else if (value.getText().length()!=0 && e.getSource() == deleteFirstValue) {
			newList.deleteFirstValueOf(Integer.parseInt(value.getText()));
			textArea.setText(newList.printListTextArea(newList));
		}
		else if (value.getText().length()!=0 && e.getSource() == deleteAllValues) {
			newList.deleteAllValuesOf(Integer.parseInt(value.getText()));
			textArea.setText(newList.printListTextArea(newList));
		}
		else if (e.getSource() == deleteList) {
			int deleteCount = newList.getElementCount();
			newList.deleteList();
			textArea.setText("Number of elements deleted: " + Integer.toString(deleteCount) + "\n" + newList.printListTextArea(newList));
		}


	}
	public static void main(String[] args) {
		TestGui frame = new TestGui();
		frame.setTitle("Linked List");
		frame.setSize(550,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}