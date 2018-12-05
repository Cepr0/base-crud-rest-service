package io.github.cepr0.demo.base.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

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
public abstract class LongIdEntity extends BaseElement<Long> {

	@Id
	@GeneratedValue
	private Long id;
}
