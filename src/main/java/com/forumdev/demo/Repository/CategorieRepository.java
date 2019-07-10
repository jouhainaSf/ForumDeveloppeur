package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
}
