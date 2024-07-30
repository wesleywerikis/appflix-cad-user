package br.com.appflix.register.user.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.text.NumberFormatter;

import br.com.appflix.register.user.controller.UserController;
import br.com.appflix.register.user.entity.User;

import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JButton btnUserRegister_Left;
	private JButton btnUserRegister_Right;
	private JButton btnUserRegister_Edit;
	private JButton btnUserRegister_Delete;
	private JButton btnUserRegister_Save;
	private JButton btnUserRegister_Add;
	private JFormattedTextField formattedTextFieldUserRegister_Search;

	private UserController userController;
	private JButton btnUserRegister_Clean;

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
		userController = new UserController();
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
		panelRegisterUser.setBackground(new Color(240, 240, 240));
		panelRegisterUser.setBounds(0, 0, 574, 259);
		frameUserRegister.getContentPane().add(panelRegisterUser);
		panelRegisterUser.setLayout(null);

		JPanel panelRegisterUser_Buttons = new JPanel();
		panelRegisterUser_Buttons.setBackground(new Color(240, 240, 240));
		panelRegisterUser_Buttons.setBounds(10, 11, 507, 63);
		panelRegisterUser.add(panelRegisterUser_Buttons);
		panelRegisterUser_Buttons.setLayout(null);

		formattedTextFieldUserRegister_Search = new JFormattedTextField();
		formattedTextFieldUserRegister_Search.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String idUser = formattedTextFieldUserRegister_Search.getText();
				loadUserInfoFromID(idUser);
			}
		});
		formattedTextFieldUserRegister_Search.setForeground(new Color(57, 62, 70));
		formattedTextFieldUserRegister_Search.setFont(new Font("Tahoma", Font.BOLD, 12));
		formattedTextFieldUserRegister_Search.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(215, 215, 215)));
		formattedTextFieldUserRegister_Search.setBackground(new Color(240, 240, 240));
		formattedTextFieldUserRegister_Search.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldUserRegister_Search.setBounds(13, 11, 47, 41);
		panelRegisterUser_Buttons.add(formattedTextFieldUserRegister_Search);

		btnUserRegister_Add = new JButton("");
		btnUserRegister_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formattedTextFieldUserRegister_Search.setEnabled(false);

				disableAndEnableButtonsLeftRightAndSave();

				enableTextFieldDataUser();
			}
		});
		btnUserRegister_Add.setIcon(new ImageIcon(RegisterUserView.class.getResource("/resources/img/button/add.png")));
		btnUserRegister_Add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUserRegister_Add.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnUserRegister_Add.setBackground(new Color(240, 240, 240));
		btnUserRegister_Add.setBounds(77, 11, 47, 41);
		panelRegisterUser_Buttons.add(btnUserRegister_Add);

		btnUserRegister_Left = new JButton("");
		btnUserRegister_Left.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUserRegister_Left
				.setIcon(new ImageIcon(RegisterUserView.class.getResource("/resources/img/button/left.png")));
		btnUserRegister_Left.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnUserRegister_Left.setBackground(new Color(240, 240, 240));
		btnUserRegister_Left.setBounds(139, 11, 47, 41);
		panelRegisterUser_Buttons.add(btnUserRegister_Left);

		btnUserRegister_Right = new JButton("");
		btnUserRegister_Right.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUserRegister_Right
				.setIcon(new ImageIcon(RegisterUserView.class.getResource("/resources/img/button/right.png")));
		btnUserRegister_Right.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnUserRegister_Right.setBackground(new Color(240, 240, 240));
		btnUserRegister_Right.setBounds(201, 11, 47, 41);
		panelRegisterUser_Buttons.add(btnUserRegister_Right);

		btnUserRegister_Edit = new JButton("");
		btnUserRegister_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableTextFieldDataUser();
				btnUserRegister_Save.setEnabled(true);
			}
		});
		
		btnUserRegister_Clean = new JButton("");
		btnUserRegister_Clean.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearFieldsAndFocusOnIdTextField();
			}
		});
		btnUserRegister_Clean.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUserRegister_Clean.setIcon(new ImageIcon(RegisterUserView.class.getResource("/resources/img/button/clean.png")));
		btnUserRegister_Clean.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnUserRegister_Clean.setBackground(new Color(240, 240, 240));
		btnUserRegister_Clean.setBounds(263, 11, 47, 41);
		panelRegisterUser_Buttons.add(btnUserRegister_Clean);
		btnUserRegister_Edit.setEnabled(false);
		btnUserRegister_Edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUserRegister_Edit
				.setIcon(new ImageIcon(RegisterUserView.class.getResource("/resources/img/button/edit.png")));
		btnUserRegister_Edit.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnUserRegister_Edit.setBackground(new Color(240, 240, 240));
		btnUserRegister_Edit.setBounds(325, 11, 47, 41);
		panelRegisterUser_Buttons.add(btnUserRegister_Edit);

		btnUserRegister_Delete = new JButton("");
		btnUserRegister_Delete.setEnabled(false);
		btnUserRegister_Delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUserRegister_Delete
				.setIcon(new ImageIcon(RegisterUserView.class.getResource("/resources/img/button/delete.png")));
		btnUserRegister_Delete.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnUserRegister_Delete.setBackground(new Color(240, 240, 240));
		btnUserRegister_Delete.setBounds(387, 11, 47, 41);
		panelRegisterUser_Buttons.add(btnUserRegister_Delete);

		btnUserRegister_Save = new JButton("");
		btnUserRegister_Save.setEnabled(false);
		btnUserRegister_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = textFieldUserRegister_Name.getText();
				String username = textFieldUserRegister_Username.getText();
				String password = new String(passwordFieldUserRegister_Password.getPassword());
				String confirmPassword = new String(passwordFieldUserRegister_ConfirmPassword.getPassword());
				String email = textFieldUserRegister_Email.getText();

				System.out.println("Dados do Usuário: " + name + " | " + username + " | " + password + " | "
						+ confirmPassword + " | " + email);

				validateAndFocusField(name, textFieldUserRegister_Name, username, textFieldUserRegister_Username,
						password, passwordFieldUserRegister_Password, confirmPassword,
						passwordFieldUserRegister_ConfirmPassword, email, textFieldUserRegister_Email);

				if (!password.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(frameUserRegister, "As senhas não coincidem.", "Erro",
							JOptionPane.ERROR_MESSAGE);
					passwordFieldUserRegister_Password.setText("");
					passwordFieldUserRegister_ConfirmPassword.setText("");
					passwordFieldUserRegister_Password.requestFocus();
					return;
				}
				
				User user = new User();
		        user.setName(name);
		        user.setUsername(username);
		        user.setPassword(password);
		        user.setEmail(email);

		        int userId = userController.addUser(user);

		        if (userId != -1) {
		            JOptionPane.showMessageDialog(frameUserRegister, "Usuário cadastrado com sucesso! ID: " + userId, " Sucesso",
		                    JOptionPane.INFORMATION_MESSAGE);
		            clearFieldsAndFocusOnIdTextField();
		        } else {
		            JOptionPane.showMessageDialog(frameUserRegister, "Falha ao cadastrar o usuário.", "Erro",
		                    JOptionPane.ERROR_MESSAGE);
		        }

			}
		});
		btnUserRegister_Save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUserRegister_Save
				.setIcon(new ImageIcon(RegisterUserView.class.getResource("/resources/img/button/save.png")));
		btnUserRegister_Save.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnUserRegister_Save.setBackground(new Color(240, 240, 240));
		btnUserRegister_Save.setBounds(449, 11, 47, 41);
		panelRegisterUser_Buttons.add(btnUserRegister_Save);

		panelRegisterUser_DataUser = new JPanel();
		panelRegisterUser_DataUser.setBackground(new Color(240, 240, 240));
		panelRegisterUser_DataUser.setBounds(10, 83, 554, 165);
		panelRegisterUser.add(panelRegisterUser_DataUser);
		panelRegisterUser_DataUser.setLayout(null);

		JLabel lblUserRegister_Name = new JLabel("Nome:");
		lblUserRegister_Name.setBackground(new Color(240, 240, 240));
		lblUserRegister_Name.setBounds(13, 25, 50, 14);
		panelRegisterUser_DataUser.add(lblUserRegister_Name);
		lblUserRegister_Name.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserRegister_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserRegister_Name.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));

		textFieldUserRegister_Name = new JTextField();
		textFieldUserRegister_Name.setEnabled(false);
		textFieldUserRegister_Name.setBounds(76, 22, 187, 20);
		panelRegisterUser_DataUser.add(textFieldUserRegister_Name);
		textFieldUserRegister_Name.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		textFieldUserRegister_Name.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		textFieldUserRegister_Name.setBackground(new Color(240, 240, 240));
		textFieldUserRegister_Name.setColumns(10);

		lblUserRegister_Username = new JLabel("Usuário:");
		lblUserRegister_Username.setBackground(new Color(240, 240, 240));
		lblUserRegister_Username.setBounds(276, 25, 61, 14);
		panelRegisterUser_DataUser.add(lblUserRegister_Username);
		lblUserRegister_Username.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserRegister_Username.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserRegister_Username.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));

		textFieldUserRegister_Username = new JTextField();
		textFieldUserRegister_Username.setEnabled(false);
		textFieldUserRegister_Username.setBounds(350, 22, 187, 20);
		panelRegisterUser_DataUser.add(textFieldUserRegister_Username);
		textFieldUserRegister_Username.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		textFieldUserRegister_Username.setColumns(10);
		textFieldUserRegister_Username.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		textFieldUserRegister_Username.setBackground(new Color(240, 240, 240));

		lblUserRegister_Password = new JLabel("Senha:");
		lblUserRegister_Password.setBackground(new Color(240, 240, 240));
		lblUserRegister_Password.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserRegister_Password.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserRegister_Password.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblUserRegister_Password.setBounds(13, 71, 50, 14);
		panelRegisterUser_DataUser.add(lblUserRegister_Password);

		passwordFieldUserRegister_Password = new JPasswordField();
		passwordFieldUserRegister_Password.setEnabled(false);
		passwordFieldUserRegister_Password.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		passwordFieldUserRegister_Password.setBackground(new Color(240, 240, 240));
		passwordFieldUserRegister_Password.setBounds(76, 68, 155, 20);
		panelRegisterUser_DataUser.add(passwordFieldUserRegister_Password);

		lblUserRegister_ConfirmPassword = new JLabel("Confirme a Senha:");
		lblUserRegister_ConfirmPassword.setBackground(new Color(240, 240, 240));
		lblUserRegister_ConfirmPassword.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserRegister_ConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserRegister_ConfirmPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblUserRegister_ConfirmPassword.setBounds(254, 71, 117, 14);
		panelRegisterUser_DataUser.add(lblUserRegister_ConfirmPassword);

		passwordFieldUserRegister_ConfirmPassword = new JPasswordField();
		passwordFieldUserRegister_ConfirmPassword.setEnabled(false);
		passwordFieldUserRegister_ConfirmPassword
				.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		passwordFieldUserRegister_ConfirmPassword.setBackground(new Color(240, 240, 240));
		passwordFieldUserRegister_ConfirmPassword.setBounds(382, 68, 155, 20);
		panelRegisterUser_DataUser.add(passwordFieldUserRegister_ConfirmPassword);

		lblUserRegister_Email = new JLabel("E-mail:");
		lblUserRegister_Email.setBackground(new Color(240, 240, 240));
		lblUserRegister_Email.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserRegister_Email.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserRegister_Email.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblUserRegister_Email.setBounds(13, 119, 50, 14);
		panelRegisterUser_DataUser.add(lblUserRegister_Email);

		textFieldUserRegister_Email = new JTextField();
		textFieldUserRegister_Email.setEnabled(false);
		textFieldUserRegister_Email.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		textFieldUserRegister_Email.setColumns(10);
		textFieldUserRegister_Email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		textFieldUserRegister_Email.setBackground(new Color(240, 240, 240));
		textFieldUserRegister_Email.setBounds(76, 116, 235, 20);
		panelRegisterUser_DataUser.add(textFieldUserRegister_Email);
	}

	protected void clearFieldsAndFocusOnIdTextField() {
		formattedTextFieldUserRegister_Search.setText("");
		textFieldUserRegister_Name.setText("");
		textFieldUserRegister_Username.setText("");
		passwordFieldUserRegister_Password.setText("");
		passwordFieldUserRegister_ConfirmPassword.setText("");
		textFieldUserRegister_Email.setText("");
		
		formattedTextFieldUserRegister_Search.requestFocus();
		
		disableEditDeleteSaveButtonsAndEnableTextFieldId();
	}

	private void disableEditDeleteSaveButtonsAndEnableTextFieldId() {
		btnUserRegister_Edit.setEnabled(false);
		btnUserRegister_Delete.setEnabled(false);
		btnUserRegister_Save.setEnabled(false);
		btnUserRegister_Left.setEnabled(true);
		btnUserRegister_Right.setEnabled(true);
		formattedTextFieldUserRegister_Search.setEnabled(true);
		formattedTextFieldUserRegister_Search.requestFocus();
	}

	protected void disableAndEnableButtonsLeftRightAndSave() {
		btnUserRegister_Left.setEnabled(false);
		btnUserRegister_Right.setEnabled(false);
		btnUserRegister_Save.setEnabled(true);
	}

	protected void enableTextFieldDataUser() {

		textFieldUserRegister_Name.setEnabled(true);
		textFieldUserRegister_Username.setEnabled(true);
		passwordFieldUserRegister_Password.setEnabled(true);
		passwordFieldUserRegister_ConfirmPassword.setEnabled(true);
		textFieldUserRegister_Email.setEnabled(true);

		textFieldUserRegister_Name.requestFocus();
	}

	private void showErrorAndFocus(String message, JComponent component) {
		JOptionPane.showMessageDialog(frameUserRegister, message, "Erro", JOptionPane.ERROR_MESSAGE);
		component.requestFocus();
	}

	private void validateAndFocusField(String name, JTextField nameField, String username, JTextField usernameField,
			String password, JPasswordField passwordField, String confirmPassword, JPasswordField confirmPasswordField,
			String email, JTextField emailField) {
		if (name.isEmpty()) {
			showErrorAndFocus("Por favor, preencha todos os campos obrigatórios. (O Nome é obrigatório)", nameField);
		} else if (username.isEmpty()) {
			showErrorAndFocus("Por favor, preencha todos os campos obrigatórios. (O Usuário é obrigatório)",
					usernameField);
		} else if (password.isEmpty()) {
			showErrorAndFocus("Por favor, preencha todos os campos obrigatórios. (A Senha é obrigatória)",
					passwordField);
		} else if (confirmPassword.isEmpty()) {
			showErrorAndFocus(
					"Por favor, preencha todos os campos obrigatórios. (A Confirmação da Senha é obrigatória)",
					confirmPasswordField);
		} else if (email.isEmpty()) {
			showErrorAndFocus("Por favor, preencha todos os campos obrigatórios. (O E-mail é obrigatório)", emailField);
		}
	}

	public void loadUserInfoFromID(String idUser) {
		if (!idUser.isEmpty()) {
			Long userId = Long.parseLong(idUser);

			User user = userController.getUserById(userId);
			if (user != null) {
				textFieldUserRegister_Name.setText(user.getName());
				textFieldUserRegister_Username.setText(user.getUsername());
				passwordFieldUserRegister_Password.setText(user.getPassword());
				textFieldUserRegister_Email.setText(user.getEmail());
				blocksTheFields();
				enableButtonsAddLeftRightEditAndSave();
			} else {
				textFieldUserRegister_Name.setText("");
				textFieldUserRegister_Username.setText("");
				passwordFieldUserRegister_Password.setText("");
				passwordFieldUserRegister_ConfirmPassword.setText("");
				textFieldUserRegister_Email.setText("");
				formattedTextFieldUserRegister_Search.setText("");
				formattedTextFieldUserRegister_Search.requestFocusInWindow();
				JOptionPane.showMessageDialog(frameUserRegister, "Usuário não encontrado!", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void blocksTheFields() {
		textFieldUserRegister_Name.setEnabled(false);
		textFieldUserRegister_Username.setEnabled(false);
		passwordFieldUserRegister_Password.setEnabled(false);
		passwordFieldUserRegister_ConfirmPassword.setEnabled(false);
		textFieldUserRegister_Email.setEnabled(false);
	}

	protected void enableButtonsAddLeftRightEditAndSave() {
		btnUserRegister_Add.setEnabled(true);
		btnUserRegister_Left.setEnabled(true);
		btnUserRegister_Right.setEnabled(true);
		btnUserRegister_Edit.setEnabled(true);
	}
}
