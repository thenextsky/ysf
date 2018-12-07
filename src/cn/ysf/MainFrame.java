package cn.ysf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends Frame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.init();
	}

	private void init() {
		Font font = new Font("微软雅黑", Font.BOLD, 30);
		this.setTitle("约瑟夫环");
		this.setBounds(200, 100, 600, 400);

		this.setBackground(Color.WHITE);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setLayout(null);
		Panel panelMain = new Panel();
		panelMain.setBounds(0, 0, 400, 400);
		panelMain.setBackground(Color.BLUE);
		this.add(panelMain);
		Panel panelRightMenu = new Panel(new GridLayout(5, 2));
		panelRightMenu.setBounds(400, 20, 200, 380);
		// panelRightMenu.setBackground(Color.YELLOW);
		this.add(panelRightMenu);
		{// N
			JLabel label_n = new JLabel("n:");
			label_n.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			label_n.setHorizontalAlignment(JLabel.CENTER);
			label_n.setFont(font);
			panelRightMenu.add(label_n);
			//
			JTextField textField_n = new JTextField();
			textField_n.setText("10");
			textField_n.setFont(font);
			textField_n.setHorizontalAlignment(JTextField.CENTER);
			textField_n.addKeyListener(new NumberKeyListener());// 限制只能输入正整数&&不允许输入超过99
			panelRightMenu.add(textField_n);
		}
		{// K
			JLabel label_k = new JLabel("k:");
			label_k.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			label_k.setHorizontalAlignment(JLabel.CENTER);
			label_k.setFont(font);
			panelRightMenu.add(label_k);
			//
			JTextField textField_k = new JTextField();
			textField_k.setText("1");
			textField_k.setFont(font);
			textField_k.setHorizontalAlignment(JTextField.CENTER);
			textField_k.addKeyListener(new NumberKeyListener());// 限制只能输入正整数&&不允许输入超过99
			panelRightMenu.add(textField_k);
		}
		{// M
			JLabel label_m = new JLabel("m:");
			label_m.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			label_m.setHorizontalAlignment(JLabel.CENTER);
			label_m.setFont(font);
			panelRightMenu.add(label_m);
			//
			JTextField textField_m = new JTextField();
			textField_m.setText("5");
			textField_m.setFont(font);
			textField_m.setHorizontalAlignment(JTextField.CENTER);
			textField_m.addKeyListener(new NumberKeyListener());// 限制只能输入正整数&&不允许输入超过99
			panelRightMenu.add(textField_m);
		}

		this.setVisible(true);// 放最后，不然控件显示不出来
		new Thread(new PaintThread()).start();// 启动线程
	}

	private class NumberKeyListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			int keyChar = e.getKeyChar();
			if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {
				JTextField tf = (JTextField) e.getSource();
				if (tf.getText().length() > 1) {
					e.consume(); // 不允许输入超过99
				}
			} else {
				e.consume(); // 屏蔽掉非数字输入
			}
		}
	}

	private class PaintThread implements Runnable {// 线程类（重画用的）
		public void run() {
			while (true) {
				repaint();// 重绘
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					System.out.println("重绘异常");
				}
			}
		}
	}
}
