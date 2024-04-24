package com.cpt202.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cpt202.demo.entity.monthlyMembers;
@Repository//连接到数据库
public interface ReportRepo extends JpaRepository<monthlyMembers,Long>{

}