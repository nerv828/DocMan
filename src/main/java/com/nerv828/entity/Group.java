package com.nerv828.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dm_group")
public class Group extends IdEntity {
	private String name;
	private String desc;
    private Date createDate;




    private Set<User> users = new HashSet<User>();


	public Group() {
	}

	public Group(Long id) {
		this.id = id;
	}


	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}






	// 设定JSON序列化时的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
    @ManyToMany
    @JoinTable(name="dm_group_user",joinColumns=@JoinColumn(name="group_id"),
            inverseJoinColumns=@JoinColumn(name="user_id"))
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}