package io.github.cepr0.demo.base.repo;

import io.github.cepr0.demo.base.model.BaseElement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepo<ID extends Serializable, T extends BaseElement<ID>> extends JpaRepository<T, ID> {

	default Optional<T> findElementToUpdate(ID id) {
		return findById(id);
	}

	default void deleteElement(ID id) {
		deleteById(id);
	}

	default Page<T> findAllElements(Pageable pageable) {
		return findAll(pageable);
	}

	default Optional<T> findOneElement(ID id) {
		return findById(id);
	}
}
