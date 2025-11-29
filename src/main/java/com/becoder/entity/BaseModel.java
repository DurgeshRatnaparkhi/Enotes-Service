package com.becoder.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@MappedSuperclass
public class BaseModel {
	
	 @Column(name = "is_active")
    private Boolean isActive;
	
	 @Column(name="is_deleted")
	private Boolean isDeleted;
	
	 @Column(name = "created_by")
	private Integer createdBy;
	
	 @Column(name = "created_on")
	private Date createdon;
	
	 @Column(name = "updated_by")
	private Integer updatedBy;
	
	 @Column(name = "updated_on")
	private Date updatedon;

}
