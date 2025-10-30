package com.jora.masterservice.main.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "operator")
@Data
public class Operator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operator_code")
	private int operatorCode;
	@Column(name = "operator_name", columnDefinition = "varchar(40) default ''")
	private String operatorName;
	@Column(name = "password", columnDefinition = "varchar(128) default ''")
	private String password;
	@Column(name = "active", columnDefinition = "varchar(1) default 'N' Check(active='N' or active='Y')")
	private String active;
	@Column(name = "pro_user", columnDefinition = "varchar(1) default 'N' Check(pro_user='N' or pro_user='Y')")
	private String proUser;
	@Column(name = "entry_mode", columnDefinition = "varchar(1) default 'N' Check(entry_mode='N' or entry_mode='Y')")
	private String entryMode;
	@Column(name = "view_mode", columnDefinition = "varchar(1) default 'N' Check(view_mode='N' or view_mode='Y')")
	private String viewMode;
	@Column(name = "edit_mode", columnDefinition = "varchar(1) default 'N' Check(edit_mode='N' or edit_mode='Y')")
	private String editMode;
	@Column(name = "delete_mode", columnDefinition = "varchar(1) default 'N' Check(delete_mode='N' or delete_mode='Y')")
	private String deleteMode;
	@Column(name = "cancel_access", columnDefinition = "varchar(1) default 'N' Check(cancel_access='N' or cancel_access='Y')")
	private String cancelAccess;
	@Column(name = "rate_entry", columnDefinition = "varchar(1) default 'N' Check(rate_entry='N' or rate_entry='Y')")
	private String rateEntry;
	@Column(name = "previous_date_entry", columnDefinition = "varchar(1) default 'N' Check(previous_date_entry='N' or previous_date_entry='Y')")
	private String previousDateEntry;
	@Column(name = "company_tag", length = 3, nullable = false)
	private String companyTag;
	@Column(name = "company_flag", length = 2, nullable = false)
	private String companyFlag;
	@Column(name = "auto_gen", columnDefinition = "varchar(1) default 'N' Check(auto_gen='N' or auto_gen='Y')")
	private String autoGen;
	@Column(name = "created_by", columnDefinition = "int default 1")
	private int createdBy;
	@Column(name = "created_date_time", insertable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
	private LocalDateTime createdDateTime;
	@Column(name = "modified_by", columnDefinition = "int default 0")
	private int modifiedBy;
	@Column(name = "modified_date_time")
	private LocalDateTime modifiedDate;
}
