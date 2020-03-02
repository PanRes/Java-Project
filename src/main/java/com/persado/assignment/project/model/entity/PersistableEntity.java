package com.persado.assignment.project.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
abstract public class PersistableEntity implements Persistable<UUID>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false, length = 16, columnDefinition = "uniqueidentifier")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	protected UUID id;

	@Override
	@Transient
	@JsonIgnore
	public boolean isNew() {
		return id == null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof PersistableEntity && !this.isNew() && !((PersistableEntity) obj).isNew()) {
			return ((PersistableEntity) obj).getId().equals(this.id);
		}
		return super.equals(obj);
	}
}
