package com.nerv828.repository;

import com.nerv828.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroupDao extends PagingAndSortingRepository<Group, Long>, JpaSpecificationExecutor<Group> {

	Page<Group> findByGroupId(Long id, Pageable pageRequest);

    Group findByName(String name);

	@Modifying
	@Query("delete from dm_group group where group.id=?1")
	void deleteByGroupId(Long id);
}
