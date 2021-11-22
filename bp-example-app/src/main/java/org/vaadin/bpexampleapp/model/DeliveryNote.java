package org.vaadin.bpexampleapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DeliveryNote {

	 @Id @GeneratedValue long id;
		public static DeliveryNote deliveryNote;
		
		private String name;
		private String partner;

		protected DeliveryNote() {
		}
		public DeliveryNote(String name, String partner) {
			this.name = name;
			this.partner = partner;
		}
		
		public long getId() {
			return id;
		}
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		public String getPartner() {
			return partner;
		}

		public void setPartner(String partner) {
			this.partner = partner;
		}
		
}
