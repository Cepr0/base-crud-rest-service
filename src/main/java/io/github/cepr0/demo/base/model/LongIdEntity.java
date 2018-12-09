package io.github.cepr0.demo.base.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "longId")
public abstract class LongIdEntity extends BaseElement<Long> {

	@Id
	@GeneratedValue
	private Long id;
}
