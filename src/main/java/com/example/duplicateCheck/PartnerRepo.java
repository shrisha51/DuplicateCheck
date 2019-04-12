package com.example.duplicateCheck;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARTNER_REPO")
public class PartnerRepo {
	@Id
	 @Column(name = "Id", length = 64, nullable = true)
	  private final Long Id;
	 @Column(name = "Full_Name", length = 64, nullable = true)
	  private final String name;
	 @Column(name = "Email", length = 64, nullable = true)
	    private final String email;
	 @Column(name = "Mobile", length = 64, nullable = true)
	    private final String mobile;
	 @Column(name = "NetworkId", length = 64, nullable = true)
	    private final String networkId;
	 public PartnerRepo() {
		 this.Id=System.currentTimeMillis();
		 this.name = "abc";
		 
			this.email = "momk";
			this.mobile = "fgdff";
			this.networkId="0101-0100-1101-1010";
	 }
		public PartnerRepo(Long Id,String name, String email, String mobile, String networkId) {
			super();
			this.Id=Id;
			this.name = name;
			this.email = email;
			this.mobile = mobile;
			this.networkId = networkId;
		}
		public String getNetworkId() {
			return networkId;
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

