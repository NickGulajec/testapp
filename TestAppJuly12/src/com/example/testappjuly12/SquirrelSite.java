package com.example.testappjuly12;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

@Table(name = "SquirrelSite")
public class SquirrelSite extends Model {
	
	@Column(name = "SiteName")
	public String siteName;
	
	@Column(name = "SiteDistance")
	public int siteDistance;
	
	@Column(name = "SquirrelCount")
	public int squirrelCount;
	
	
	public SquirrelSite() {
		super();
	}
	public SquirrelSite(String newSiteName){
		super();
		siteName = newSiteName;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("siteName=").append(siteName);
		sb.append(", ").append("squirrelCount=").append(squirrelCount);
		return sb.toString();
	}
	public static SquirrelSite getSquirrelSite(String siteName) {
		return new Select()
			.from(SquirrelSite.class)
			.where("SiteName = ?", siteName)
			.executeSingle();
	}
	public static List<SquirrelSite> getSiteList() {
		return new Select()
			.from(SquirrelSite.class)
			.execute();
	}
	public int getCount() {	
		return this.squirrelCount;
	}
	public void addSquirrel() {
		squirrelCount++;
	}
}
