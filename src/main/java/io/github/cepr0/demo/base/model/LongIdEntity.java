package io.github.cepr0.demo.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@MappedSuperclass
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "longId")
public abstract class LongIdEntity extends BaseEntity<Long> {

	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnore
	@Version
	private Long version;
}
