package com.mohannad.askfm.repository;

import com.mohannad.askfm.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * created by mohannad on 15/09/2019
 */
public interface UserRepository extends CrudRepository<User , Long> {
}
