package com.example.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INPUTMATRIX")
public class InputMatrix {
	@Id
	 @Column(name = "Id", length = 64, nullable = true)
	  private final Long Id;
	 @Column(name = "Full_Name", length = 64, nullable = true)
	  private final String name;
	 @Column(name = "Email", length = 64, nullable = true)
	    private final String email;
	 @Column(name = "Mobile", length = 64, nullable = true)
	    private final String mobile;
	 public InputMatrix() {
		 this.Id=System.currentTimeMillis();
		 this.name = "abc";
		 
			this.email = "momk";
			this.mobile = "fgdff";
	 }
		public InputMatrix(Long Id,String name, String email, String mobile) {
			super();
			this.Id=Id;
			this.name = name;
			this.email = email;
			this.mobile = mobile;
		}
		public String getName() {
			return name;
		}
		public String getEmail() {
			return email;
		}
		public String getMobile() {
			return mobile;
		}

}
