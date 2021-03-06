package br.com.fiap.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "TB_BOT")
public class ChatbotModel {
	
	private long idBot;
	private String name;
	private String welcome_msg;
	private String farewell_msg;
	private int downtime;
	private String default_answer;
	private List<SegmentoModel> segmentos; 
	
	public ChatbotModel() {
		// TODO Auto-generated constructor stub
	}

	

	public ChatbotModel(long idBot, String name, String welcome_msg, String farewell_msg, int downtime,
			String default_answer, List<SegmentoModel> segmentos) {
		super();
		this.idBot = idBot;
		this.name = name;
		this.welcome_msg = welcome_msg;
		this.farewell_msg = farewell_msg;
		this.downtime = downtime;
		this.default_answer = default_answer;
		this.segmentos = segmentos;
	}

	@Id
	@Column(name = "ID_BOT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHATBOT_SEQ")
	@SequenceGenerator(name = "CHATBOT_SEQ", sequenceName = "CHATBOT_SEQ", allocationSize = 1)
	public long getIdBot() {
		return idBot;
	}



	public void setIdBot(long idBot) {
		this.idBot = idBot;
	}
	
	@Column(name = "NAME")
	@NotNull(message = "Nome obrigatorio")
	@Size(min = 2, max = 100, message = "NOME deve ser entre 20 e 50 caracteres")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "WELCOME_MSG")
	@NotNull(message = "Mensagem inicial obrigatorio")
	@Size(min = 2, max = 100, message = "WELCOME MESSAGE deve ser entre 2 e 100 caracteres")
	public String getWelcome_msg() {
		return welcome_msg;
	}

	public void setWelcome_msg(String welcome_msg) {
		this.welcome_msg = welcome_msg;
	}
	
	@Column(name = "FAREWELL_MSG")
	@NotNull(message = "Mensagem final obrigatorio")
	@Size(min = 2, max = 100, message = "Farewell message deve ser entre 20 e 100 caracteres")
	public String getFarewell_msg() {
		return farewell_msg;
	}

	public void setFarewell_msg(String farewell_msg) {
		this.farewell_msg = farewell_msg;
	}

	@Column(name = "DOWNTIME")
	@DecimalMin(value = "0", message = "tempo de resposta deve ser acima de 0")
	@NumberFormat(style = Style.CURRENCY)
	public int getDowntime() {
		return downtime;
	}

	public void setDowntime(int downtime) {
		this.downtime = downtime;
	}
	
	@Column(name = "DEFAULT_ANSWER")
	@NotNull(message = "default_answer final obrigatorio")
	@Size(min = 2, max = 100, message = "default_answer deve ser entre 20 e 100 caracteres")
	public String getDefault_answer() {
		return default_answer;
	}

	public void setDefault_answer(String default_answer) {
		this.default_answer = default_answer;
	}
	
	@OneToMany(mappedBy = "chatbot")
	public List<SegmentoModel> getSegmento() {
		return segmentos;
	}

	public void setSegmento(List<SegmentoModel> segmentos) {
		this.segmentos = segmentos;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.idBot + "as";
	}
	
}
