package br.com.appflix.register.user.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class RegisterUserView {

	private JFrame frameUserRegister;
	private JTextField textFieldUserRegister_Name;
	private JLabel lblUserRegister_Username;
	private JTextField textFieldUserRegister_Username;
	private JPanel panelRegisterUser_DataUser;
	private JLabel lblUserRegister_Email;
	private JTextField textFieldUserRegister_Email;
	private JLabel lblUserRegister_Password;
	private JPasswordField passwordFieldUserRegister_Password;
	private JLabel lblUserRegister_ConfirmPassword;
	private JPasswordField passwordFieldUserRegister_ConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUserView window = new RegisterUserView();
					window.frameUserRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterUserView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUserRegister = new JFrame();
		frameUserRegister.setTitle("Appflix · Cadastro de Usuário");
		frameUserRegister.setBounds(100, 100, 590, 296);
		frameUserRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUserRegister.getContentPane().setLayout(null);
		
		JPanel panelRegisterUser = new JPanel();
		panelRegisterUser.setBounds(0, 0, 574, 259);
		frameUserRegister.getContentPane().add(panelRegisterUser);
		panelRegisterUser.setLayout(null);
		
		panelRegisterUser_DataUser = new JPanel();
		panelRegisterUser_DataUser.setBackground(new Color(240, 240, 240));
		panelRegisterUser_DataUser.setBounds(10, 83, 554, 165);
		panelRegisterUser.add(panelRegisterUser_DataUser);
		panelRegisterUser_DataUser.setLayout(null);
		
		JLabel lblUserRegister_Name = new JLabel("Nome:");
		lblUserRegister_Name.setBounds(13, 25, 50, 14);
		panelRegisterUser_DataUser.add(lblUserRegister_Name);
		lblUserRegister_Name.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserRegister_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserRegister_Name.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		
		textFieldUserRegister_Name = new JTextField();
		textFieldUserRegister_Name.setBounds(76, 22, 187, 20);
		panelRegisterUser_DataUser.add(textFieldUserRegister_Name);
		textFieldUserRegister_Name.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		textFieldUserRegister_Name.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		textFieldUserRegister_Name.setBackground(new Color(240, 240, 240));
		textFieldUserRegister_Name.setColumns(10);
		
		lblUserRegister_Username = new JLabel("Usuário:");
		lblUserRegister_Username.setBounds(276, 25, 61, 14);
		panelRegisterUser_DataUser.add(lblUserRegister_Username);
		lblUserRegister_Username.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserRegister_Username.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserRegister_Username.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		
		textFieldUserRegister_Username = new JTextField();
		textFieldUserRegister_Username.setBounds(350, 22, 187, 20);
		panelRegisterUser_DataUser.add(textFieldUserRegister_Username);
		textFieldUserRegister_Username.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		textFieldUserRegister_Username.setColumns(10);
		textFieldUserRegister_Username.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		textFieldUserRegister_Username.setBackground(UIManager.getColor("Button.background"));
		
		lblUserRegister_Password = new JLabel("Senha:");
		lblUserRegister_Password.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserRegister_Password.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserRegister_Password.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblUserRegister_Password.setBounds(13, 71, 50, 14);
		panelRegisterUser_DataUser.add(lblUserRegister_Password);
		
		passwordFieldUserRegister_Password = new JPasswordField();
		passwordFieldUserRegister_Password.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		passwordFieldUserRegister_Password.setBackground(new Color(240, 240, 240));
		passwordFieldUserRegister_Password.setBounds(76, 68, 155, 20);
		panelRegisterUser_DataUser.add(passwordFieldUserRegister_Password);
		
		lblUserRegister_ConfirmPassword = new JLabel("Confirme a Senha:");
		lblUserRegister_ConfirmPassword.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserRegister_ConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserRegister_ConfirmPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblUserRegister_ConfirmPassword.setBounds(254, 71, 117, 14);
		panelRegisterUser_DataUser.add(lblUserRegister_ConfirmPassword);
		
		passwordFieldUserRegister_ConfirmPassword = new JPasswordField();
		passwordFieldUserRegister_ConfirmPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		passwordFieldUserRegister_ConfirmPassword.setBackground(UIManager.getColor("Button.background"));
		passwordFieldUserRegister_ConfirmPassword.setBounds(382, 68, 155, 20);
		panelRegisterUser_DataUser.add(passwordFieldUserRegister_ConfirmPassword);
		
		lblUserRegister_Email = new JLabel("E-mail:");
		lblUserRegister_Email.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserRegister_Email.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserRegister_Email.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblUserRegister_Email.setBounds(13, 119, 50, 14);
		panelRegisterUser_DataUser.add(lblUserRegister_Email);
		
		textFieldUserRegister_Email = new JTextField();
		textFieldUserRegister_Email.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		textFieldUserRegister_Email.setColumns(10);
		textFieldUserRegister_Email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		textFieldUserRegister_Email.setBackground(UIManager.getColor("Button.background"));
		textFieldUserRegister_Email.setBounds(76, 116, 235, 20);
		panelRegisterUser_DataUser.add(textFieldUserRegister_Email);
	}
}
