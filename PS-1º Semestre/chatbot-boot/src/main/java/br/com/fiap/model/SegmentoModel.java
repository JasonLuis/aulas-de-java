package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_SEGMENT")
public class SegmentoModel {
	
	private long idSegment;
	private String name;
	private ChatbotModel chatbotModel;
	
	public SegmentoModel() {
		// TODO Auto-generated constructor stub
	}

	public SegmentoModel(long idSegment, String name, ChatbotModel chatbotModel) {
		super();
		this.setIdSegment(idSegment);
		this.name = name;
		this.chatbotModel = chatbotModel;
	}


	@Id
	@Column(name = "ID_SEGMENT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEGMENT_SEQ")
	@SequenceGenerator(name = "SEGMENT_SEQ", sequenceName = "SEGMENT_SEQ", allocationSize = 1)
	public long getIdSegment() {
		return idSegment;
	}

	public void setIdSegment(long idSegment) {
		this.idSegment = idSegment;
	}
	
	@Column(name = "NAME")
	@NotNull(message = "Nome obrigatorio")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 20 e 50 caracteres")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn(name = "ID_BOT", nullable = true)
	public ChatbotModel getChatbot() {
		return chatbotModel;
	}

	public void setChatbot(ChatbotModel chatbotModel) {
		this.chatbotModel = chatbotModel;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	
}
