package io.github.cepr0.demo.dictionary.base;

import io.github.cepr0.demo.base.repo.BaseRepo;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DictionaryRepo<T extends Dictionary> extends BaseRepo<String, T> {
}
