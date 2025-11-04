package com.jora.masterservice.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	private int productCode;

//	Create table Product(
//			Sno int identity,
//			Prono int primary key,
//			SaleType varchar(2) check(SaleType<>'' or SaleType<>null),
//			PurchaseType varchar(2) check(PurchaseType<>'' or PurchaseType<>null),
//			Unit Varchar(1) default '',
//			ProductGroup int default 0,
//			Catno int foreign key references Category(Catno),
//			ProductDesc varchar(50) check(ProductDesc<>'' or ProductDesc <> null),
//			Active varchar(1) check(Active='Y' or Active='N'),
//			Hsncode varchar(50) check(Hsncode<>'' or Hsncode<>null),
//			CompanyTag varchar(3) unique check(CompanyTag<>'' or CompanyTag<>null),
//			CompanyFlag varchar(2) unique check(CompanyFlag<>'' or CompanyFlag<>null),
//			Createdby int default 0,
//			CreatedDate date default getdate(),
//			CreatedTime datetime default getdate(),
//			ModifyBy int default 0,
//			ModifiedDate date,
//			ModifiedTime datetime
//		)

}
