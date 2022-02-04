package com.mypet.dto;

import java.sql.Timestamp;

public class MtmVO {
		private int qseq;
		private String title;
		private String content;
		private String reply;
		private String id;
		private String rep;
		private Timestamp indate;
		public int getQseq() {
			return qseq;
		}
		public void setQseq(int qseq) {
			this.qseq = qseq;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getReply() {
			return reply;
		}
		public void setReply(String reply) {
			this.reply = reply;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getRep() {
			return rep;
		}
		public void setRep(String rep) {
			this.rep = rep;
		}
		public Timestamp getIndate() {
			return indate;
		}
		public void setIndate(Timestamp indate) {
			this.indate = indate;
		}
		
		
}
