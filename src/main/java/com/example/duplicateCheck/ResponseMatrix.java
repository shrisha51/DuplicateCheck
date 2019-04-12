package com.example.duplicateCheck;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "RESPONSEMATRIX")
public class ResponseMatrix {

	
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
	    private  long id;
    
    @Column(name = "Name", length = 64, nullable = true)
	    private  String name;
    @Column(name = "Email", length = 64, nullable = true)
	    private  String email;
    @Column(name = "Mobile", length = 64, nullable = true)
	    private  String mobile;
    @Column(name = "Source", length = 64, nullable = true)
	    private  String source;
    @Column(name = "NetworkId", length = 64, nullable = true)
    private String networkId;
    @Column(name = "MatchedOn", length = 64, nullable = true)
	    private  String matchedOn;
    @Column(name = "Strength", length = 64, nullable = true)
	    private Integer strength;

	   public ResponseMatrix() {
		   this.id = 0000;
			this.name = "";
			this.email = "";
			this.mobile = "";
			this.source = "";
			this.matchedOn = "";
			this.networkId = "";
			this.strength = 0;
	   }

	    public ResponseMatrix(long id, String name, String email, String mobile, String source,String networkId,
				String matchedOn, Integer strength) {
			super();
			this.id = id;
			this.networkId = networkId;
			this.name = name;
			this.email = email;
			this.mobile = mobile;
			this.source = source;
			this.matchedOn = matchedOn;
			this.strength = strength;
		}

		public void setId(long id) {
			this.id = id;
		}
		
		public void setName(String name) {
			this.name=name;
		}

		public void setNetworkId(String content) {
			this.networkId = content;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public void setMatchedOn(String matchedOn) {
			this.matchedOn = matchedOn;
		}

		public void setStrength(Integer strength) {
			this.strength = strength;
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

		public String getSource() {
			return source;
		}

		public String getMatchedOn() {
			return matchedOn;
		}

		public Integer getStrength() {
			return strength;
		}

		public long getId() {
	        return id;
	    }

	    public String getNetworkId() {
	        return networkId;
	    }
	

}
