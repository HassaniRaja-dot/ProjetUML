package model;

import java.time.LocalDateTime;

public class Logs {
	private int idLog;
	private String action;
	private LocalDateTime DateAction;
	private String description;
	
	Logs(){
		
		
	}
	Logs(int idLog,String action,String description,LocalDateTime DateAction){
		this.idLog = idLog;
		this.action = action;
		this.description = description;
		this.DateAction = LocalDateTime.now();
		
	}
	public int getIdlog() {
		return idLog;
	}
	public void setIdlog(int idLog) {
		this.idLog = idLog;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateAction() {
		return DateAction;
	}
	public void setDateAction(LocalDateTime DateAction) {
		this.DateAction = DateAction;
	}
	public void EnregistrerAction() {
		
	}

	
}
