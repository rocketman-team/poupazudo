package poupazudo.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message.RecipientType;

import poupazudo.util.email.Email;
import poupazudo.util.email.Mailer;
import poupazudo.util.email.TransportStrategy;

public class Mail {

	public static boolean vericaEmail(String email) {
		Pattern pattern = Pattern
				.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = pattern.matcher(email);
		
		return matcher.find();
	}
	
	public static String enviarEmail(String destino, String nomeUsuario) {
		
		final Email email = new Email();
		final String novaSenha = gerarSenhaTemporaria();
		email.setFromAddress("Poupazudo beta", "poupazudo.info@gmail.com");
		email.addRecipient(nomeUsuario, destino, RecipientType.TO);
		email.setText("Recebemos sua requisição de troca de senha.");
		email.setTextHTML("<h3>Ol&aacute;, "+ nomeUsuario +"</h3>"
				+ "<p>Seguem abaixo seus novos dados de acesso. Recomendamos que mantenha esses dados em um local seguro.</p>"
				+ "<p><strong>Usu&aacute;rio &nbsp;&nbsp;</strong>"+ destino +"<br />"
				+ "<b style=\"font-family: arial, sans-serif; line-height: normal;\">"
				+ "<span>Senha &nbsp;&nbsp;</span></b><span style=\"font-family: arial, sans-serif; line-height: normal;\">"
				+ novaSenha + "</span></p>"
				+ "<p><br />"
				+ "Atenciosamente, Equipe Poupazudo<br />"
				+ "http://www.poupazudo.com/<br /><br />"
				+ "Este e-mail foi enviado automaticamente pelo sistema. Favor n&atilde;o responder.</p>"
				+ "<p>&nbsp;</p>"
				+ "<p>&nbsp;</p>");
		email.setSubject("Solicitação de nova senha");
		sendMail(email);
		
		return novaSenha;
	}
	
	private static void sendMail(final Email email) {
		
		final String host = "smtp.gmail.com";
		final int port = 465;
		final String username = "poupazudo";
		final String password = "tpkjduda1";
		new Mailer(host, port, username, password, TransportStrategy.SMTP_SSL).sendMail(email);
	}
	
	private static String gerarSenhaTemporaria() {
		Random rand = new Random();
		char[] abc = {'p', 'o', 'u','a', 'z', 'd', 'j', 'h', 'd'};
 		String tmp = String.valueOf(rand.nextInt(9));
 			tmp += abc[rand.nextInt(8)];
			tmp += String.valueOf(rand.nextInt(9));
			tmp += abc[rand.nextInt(8)];
			tmp += abc[rand.nextInt(8)];
			tmp += String.valueOf(rand.nextInt(5));
			
		return tmp;
	}
	
}
