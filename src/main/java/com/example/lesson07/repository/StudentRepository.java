package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

//@Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	
	// JPA vs Spring Data JPA
	// - JPA는 메소드를 따로따로 뼈대를 만들어야 함
	// - SD JPA는 JPA와 같이 작동하는데 자주 쓰는 뼈대가 이미 구현되어 있음
	// extends JpaRepository<받는 테이블 타입, pk 타임>
	
	// Spring data JPA 기본 제공 method
	// Entity : save(entity); = id가 null일 때는 insert, id가 있으면 update
	// Optional<Entity> : findById(id값);
	// void : delete(entity)
	// List<Entity> : findAll();
	
	// ex02/1 - JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContaining(String email);
	public List<StudentEntity> findByNameStartingWith(String name);
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	// ex02/2 - JPQL(Entity에 조회)
//	@Query(value = "select st from StudentEntity st where st.dreamJob =:dreamJob") // JPQL(Entity 조회) = query문과 비슷하지만 엄연히 다름
	@Query(value = "select * from new_student where dreamJob =:dreamJob", nativeQuery = true) // nativeQuery = SQL 조회
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob); // @Param import는 ibatis가 아닌!!! repository.query로
	
	
	// 아래는 순수 JPA
//	@PersistenceContext
//	private EntityManager em;
//	
//	public StudentEntity save(StudentEntity studentEntity) {
//		em.persist(studentEntity);
//		return studentEntity;
//	}
	
}
